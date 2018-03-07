package ByComs.Amazon.OnlineAssessment;//package Amazon;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//
///**
// * Created by JMYE on 10/10/16.
// */
//
//class Connection {  // MARK
//    String city1;
//    String city2;
//    int cost;
//
//    Connection(String city1, String city2, int cost) {
//        this.city1 = city1;
//        this.city2 = city2;
//        this.cost = cost;
//    }
//
//    public void printConnection() {
//        System.out.println("{" + this.city1 + " , " + this.city2 + "} : " + this.cost);
//    }
//}
//public class MinimumSpanningTree {
//    public static List<Connection> findPath (List<Connection> list) {
//        List<Connection> rst = new ArrayList<>();
//        List<String> cityTree = new ArrayList<>();
//        if (list == null || list.size() == 0) {
//            return rst;
//        }
//
//        while (!list.isEmpty()) {
//            Connection tmp = findMin(list, cityTree);// O(ElogE)
//            if (tmp == null) break;
//
//            list.remove(tmp);
//            cityTree.add(tmp.city1);
//            cityTree.add(tmp.city2);
//            rst.add(tmp);
//        }
//
//        Comparator<Connection> cmp = new Comparator<Connection>() {
//            @Override
//            public int compare(Connection c1, Connection c2) {
//                if(c1.city1.equals(c2.city1)) {
//                    return c1.city2.compareTo(c2.city2);
//                }
//                return c1.city1.compareTo(c2.city1);
//            }
//        };
//        rst.sort(cmp);
//        return rst;
//    }
//
//    public static Connection findMin (List<Connection> list, List<String> cityTree) {
//        Connection rst = null;
//        int minCost = Integer.MAX_VALUE;
//
//        for (Connection con : list) {
//            if (con.cost <= minCost) {
//                if ((cityTree.contains(con.city1) && !cityTree.contains(con.city2))
//                   || (cityTree.contains(con.city2) && !cityTree.contains(con.city1))) {
//                    minCost = con.cost;
//                    rst = con;
//                }
//
//                if (cityTree.isEmpty()) {
//                    minCost = con.cost;
//                    rst = con;
//                }
//            }
//        }
//
//        return rst;
//    }
//
//    public static void main (String[] args) {
//        Connection[] citys = new Connection[3];
//        citys[0] = new Connection("A","B",6);
////        citys[1] = new Connection("A","D",1);
////        citys[2] = new Connection("A","E",5);
//        citys[1] = new Connection("B","C",3);
////        citys[4] = new Connection("B","D",5);
//        citys[2] = new Connection("C","D",6);
////        citys[6] = new Connection("C","F",6);
////        citys[7] = new Connection("D","F",4);
////        citys[8] = new Connection("D","E",5);
////        citys[3] = new Connection("E","F",2);
//        ArrayList<Connection> list = new ArrayList<Connection> ();
//        for (Connection temp : citys) {
//            list.add(temp);
//        }
//
////        for (Connection temp : findPath(list)){
////            temp.printConnection();
////        }
//
//    }
//}
