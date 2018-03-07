package Design;

/**
 * Created by JMYE on 5/10/17.
 */

import java.util.HashMap;
import java.util.Map;

///**
// * Definition of Trip:
class Trip {
      public int id; // trip's id, primary key
      public int driver_id, rider_id; // foreign key
      public double lat, lng; // pick up location
      public Trip(int rider_id, double lat, double lng){
          this.rider_id = rider_id;
          this.lat = lat;
          this.lng = lng;
      }
 }
// Definition of Helper
class Helper {
      public static double get_distance(double lat1, double lng1, double lat2, double lng2) {
          // return distance between (lat1, lng1) and (lat2, lng2)
          return 0.0;
      }
 }


class Location {
    public double lat, lng;
    public Location(double _lat, double _lng) {
        lat = _lat;
        lng = _lng;
    }
}
public class MiniUber {
    Map<Integer, Trip> driver2Trip = null;
    Map<Integer, Location> driver2Location = null;
    public MiniUber(){
        driver2Trip = new HashMap<>();
        driver2Location = new HashMap<>();
    }

    // @param driver_id an integer
    // @param lat, lng driver's location
    // return matched trip information if there have matched rider or null
    public Trip report (int driver_id, double lat, double lng) {
        if (driver2Trip.containsKey(driver_id))
            return driver2Trip.get(driver_id);
        if (driver2Location.containsKey(driver_id)) {
            driver2Location.get(driver_id).lat = lat;
            driver2Location.get(driver_id).lng = lng;
        } else {
            driver2Location.put(driver_id, new Location(lat, lng));
        }
        return null;
    }

    // @param rider_id an integer
    // @param lat, lng driver's location
    // return a trip
    public Trip request(int rider_id, double lat, double lng) {
        Trip trip = new Trip(rider_id, lat, lng);
        double distanc = -1;
        int driver_id = -1;
        for (Map.Entry<Integer, Location> entry: driver2Location.entrySet()) {
            Location location = entry.getValue();
            double dist = Helper.get_distance(location.lat, location.lng, lat, lng);
            if (distanc < 0 || distanc > dist) {
                driver_id = entry.getKey();
                distanc = dist;
            }
        }
        if (driver_id != -1)
            driver2Location.remove(driver_id);
        trip.driver_id = driver_id;
        driver2Trip.put(driver_id,trip);
        return trip;
    }
}
