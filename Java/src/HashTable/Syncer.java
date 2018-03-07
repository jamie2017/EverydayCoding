package HashTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JMYE on 3/24/17.
 */
class ServerObject {
    private String mUuid;
    public String getUuid(){
        return mUuid;
    }
}
class LocalObject {
    private String mUuid;
    public LocalObject(String uuid) {
        mUuid = uuid;
    }
    public String getUuid() {
        return mUuid;
    }
    public void persist() {
        System.out.println("LocalObject uuid: " + mUuid + " persisted.");
    }
    public void delete() {
        System.out.println("LocalObject uuid: " + mUuid + " deleted.");
    }
}
public class Syncer {
    public void sync(List<ServerObject> serverData, List<LocalObject> localData) {
        Map<String, ServerObject> serverMap = new HashMap<>();
        for (ServerObject sobj: serverData) {
            String k = sobj.getUuid();
            serverMap.put(k, sobj);
        }
        for (LocalObject lobj: localData) {
            String k = lobj.getUuid();
            if (!serverMap.containsKey(k)) {
                lobj.delete();
            } else {
                serverMap.remove(k);
            }
        }
        for (String k : serverMap.keySet()) {
            LocalObject tmp = new LocalObject(k);
            tmp.persist();
        }
    }

    public static void main(String[] args) {
        Syncer test  = new Syncer();

//        test.sync({{"uuid": 1},{"uuid": 2},{"uuid": 3},{"uuid": 4}},{new LocalObject(1),new LocalObject(2)});
    }
}
