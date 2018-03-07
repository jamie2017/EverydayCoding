package ByComs.Amazon.OnlineAssessment;

import java.util.*;

/**
 * Created by JMYE on 10/10/16.
 */
class Order{
    String order = "";
    public Order(String string){
        this.order = string;
    }
}
class OrderDependency{
    Order cur;
    Order pre;
    public OrderDependency(Order o1, Order o2){
        cur = o1;
        pre = o2;
    }
}
public class Order_Dependency {
    //这个参数可能是数组，这里先摆个容器，反正一个意思。
//    public static List<Order> getOrderList(List<OrderDependency> orderDependencies){
//        List<Order> result = new ArrayList<>();
//        //建两个map,第一个是当前的order指向多少个order,就是先决条件
//        Map<Order, ArrayList<Order>> outDegreeMap = new HashMap<>();
//        //第二个是当前order被多少个order指,即为入度
//        Map<Order, Integer> inDegreeMap = new HashMap<>();
//        //把出现过的都记录下来
//        Set<Order> set = new HashSet<>();
//        for (OrderDependency od : orderDependencies){
//            Order cur = od.cur;
//            Order pre = od.pre;
//            set.add(cur);
//            set.add(pre);
//            //有则加一,无则设1
//            if (inDegreeMap.containsKey(cur)){
//                int indegree = inDegreeMap.get(cur);
//                inDegreeMap.put(cur, indegree+1);
//            }
//            else {
//                inDegreeMap.put(cur, 1);
//            }
//            //这里入度也要把pre加上,因为最后要找线头,就是入度为0的点。
//            if (!inDegreeMap.containsKey(pre)){
//                inDegreeMap.put(pre, 0);
//            }
//
//            if (outDegreeMap.containsKey(pre)){
//                outDegreeMap.get(pre).add(cur);
//            }
//            else {
//                outDegreeMap.put(pre, new ArrayList<>());
//                outDegreeMap.get(pre).add(cur);
//            }
//            //注意这里存的时候,map可以看成出度,出度为0也要存,或者在下面判断跳过null
//            if (!outDegreeMap.containsKey(cur)){
//                outDegreeMap.put(cur, new ArrayList<Order>());
//            }
//        }
//
//        Queue<Order> queue = new LinkedList<>();
//        int total = set.size();
//
//        for (Order od : inDegreeMap.keySet()){
//            if (inDegreeMap.get(od) == 0){
//                queue.offer(od);
//            }
//        }
//        //这里使用了BFS
//        while (!queue.isEmpty()){
//            Order order = queue.poll();
//            result.add(order);
//            for (Order odr : outDegreeMap.get(order)){
//                //这里查入度,类比剥洋葱,如果剥到了0,说明是最外层。
//                inDegreeMap.put(odr, inDegreeMap.get(odr) - 1);
//                if (inDegreeMap.get(odr) == 0){
//                    queue.offer(odr);
//                }
//            }
//        }
//        //这里如果有环的话,肯定是剥不出来的,那么set里面的个数和result里面的个数不一致。
//        if (result.size() != total) {
//            System.out.println("Detect Cycle!");
//            return new ArrayList<Order>();
//        }
//        return result;
//    }


    public List<Order> getOrderList(List<OrderDependency> orderDependencies) {
        List<Order> rst = new ArrayList<>();

        if (orderDependencies == null || orderDependencies.size() == 0) return rst;

        Map<Order, List<Order>> outDegrees = new HashMap<>();

        Map<Order, Integer> inDegree = new HashMap<>();

        Set<Order> set = new HashSet<>();

        for (OrderDependency oD : orderDependencies) {

            set.add(oD.cur);
            set.add(oD.pre);
            if( !outDegrees.containsKey(oD.pre)) {
                outDegrees.put(oD.pre, new ArrayList<>());
                outDegrees.get(oD.pre).add(oD.cur);
            } else {
                outDegrees.get(oD.pre).add(oD.cur);
            }

            if (!outDegrees.containsKey(oD.cur)) {
                outDegrees.put(oD.cur, new ArrayList<>());
            }

            if (!inDegree.containsKey(oD.cur)) {
                inDegree.put(oD.cur, 1);
            } else {
                inDegree.put(oD.cur, inDegree.get(oD.cur) + 1);
            }

            if (!inDegree.containsKey(oD.pre)) {
                inDegree.put(oD.pre, 0);
            }
        }

        Queue<Order> queue = new LinkedList<>();
        for (Order inKey : inDegree.keySet()) {
            if (inDegree.get(inKey) == 0) {
                queue.offer(inKey);
            }
        }

        int total = set.size();
        while (!queue.isEmpty()) {
            Order order = queue.poll();
            rst.add(order);
            for (Order odr : outDegrees.get(order)) {
                inDegree.put(odr, inDegree.get(odr) - 1);
                if (inDegree.get(odr) == 0) {
                    queue.offer(odr);
                }
            }
        }

        if (total != rst.size()) {
            System.out.println("!!!");
            return new ArrayList<Order>();
        }
        return rst;




    }





    //测试用例
    public static void main(String[] args) {
        Order_Dependency test = new Order_Dependency();
        Order o1 = new Order("A");
        Order o2 = new Order("B");
        Order o3 = new Order("C");
        Order o4 = new Order("D");
        OrderDependency od1 = new OrderDependency(o1, o2);
        OrderDependency od2 = new OrderDependency(o2, o3);
        //成环的情况就是把o4，改成o2，看看输出。
        OrderDependency od3 = new OrderDependency(o3, o4);
//        OrderDependency od4 = new OrderDependency(o1, o3);
//        OrderDependency od5 = new OrderDependency(o2, o4);
//        OrderDependency od6 = new OrderDependency(o1, o1);
        List<OrderDependency> list = new ArrayList<>();
        list.add(od1);
//        list.add(od2);
        list.add(od3);
//        list.add(od4);
//        list.add(od5);
//        list.add(od6);

        for (Order o : test.getOrderList(list)){
            System.out.println(o.order);
        }
    }
}
