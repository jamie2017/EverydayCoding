package ByComs.Amazon.OA2;



import java.util.*;

/**
 * Created by JMYE on 10/10/16.
 */


public class Order_Dependency {
    static class Order{
        String order = "";
        public Order(String s) {this.order = s;}
    }

    static class OrderDependency {
        Order cur;
        Order pre;
        public OrderDependency(Order o1, Order o2) {
            cur = o1;
            pre = o2;
        }
    }

    public static List<Order> getOrderList(List<OrderDependency> orderDependencies) {
        if (orderDependencies == null || orderDependencies.size() == 0) {
            return new ArrayList<>();
        }

        List<Order> rst = new ArrayList<>();
        Map<Order, List<Order>> outDegreeMap = new HashMap<>();
        Map<Order, Integer> inDegreeMap = new HashMap<>();
        Set<Order> set = new HashSet<>();

        for (OrderDependency od : orderDependencies) {
            Order cur = od.cur;
            Order pre = od.pre;
            set.add(cur);
            set.add(pre);

            if (!outDegreeMap.containsKey(pre)) {
                outDegreeMap.put(pre, new ArrayList<>());
                outDegreeMap.get(pre).add(cur);
            } else {
                outDegreeMap.get(pre).add(cur);
            }

            if (!outDegreeMap.containsKey(cur)) {
                outDegreeMap.put(cur, new ArrayList<>());
            }

            if (!inDegreeMap.containsKey(cur)) {
                inDegreeMap.put(cur, 1);
            } else {
                inDegreeMap.put(cur, inDegreeMap.get(cur) + 1);
            }
            if (!inDegreeMap.containsKey(pre)) {
                inDegreeMap.put(pre, 0);
            }
        }

        Queue<Order> queue = new LinkedList<>();

        for (Order od : inDegreeMap.keySet()) {
            if (inDegreeMap.get(od) == 0) {
                queue.offer(od);
            }
        }

        while (!queue.isEmpty()) {
            Order tmp = queue.poll();
            rst.add(tmp);
            for (Order od : outDegreeMap.get(tmp)) {
                inDegreeMap.put(od, inDegreeMap.get(od) - 1);
                if (inDegreeMap.get(od) == 0) {
                    queue.offer(od);
                }
            }
        }
        if (set.size() != rst.size()) return new ArrayList<>();
        return rst;
    }





    //测试用例
    public static void main(String[] args) {
        Order o1 = new Order("A");
        Order o2 = new Order("B");
        Order o3 = new Order("C");
        Order o4 = new Order("D");
        OrderDependency od1 = new OrderDependency(o1, o2);
        OrderDependency od2 = new OrderDependency(o2, o3);
        OrderDependency od3 = new OrderDependency(o3, o4);
       // OrderDependency od4 = new OrderDependency(o1, o3);
       // OrderDependency od5 = new OrderDependency(o2, o4);/
         OrderDependency od6 = new OrderDependency(o1, o1);
        List<OrderDependency> list = new ArrayList<>();
        list.add(od1);
        list.add(od2);
        list.add(od3);
       // list.add(od4);
       // list.add(od5);
         list.add(od6);

       for (Order o : getOrderList(list)){
           System.out.println(o.order);
       }

    }
}
