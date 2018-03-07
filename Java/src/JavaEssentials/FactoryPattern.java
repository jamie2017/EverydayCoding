package JavaEssentials;
import java.util.*;
import java.security.*;
/**
 * Created by JMYE on 3/15/17.
 * 特点：Abstract; 继承
 * 优点：在内部对昌平进行约束
 * 使用场景：不知道创建类，子类需要具体实现
 */

interface Food {
    public String getType();
}

class Pizza implements  Food {
    public String getType() {
        return "Someone ordered a Fast Food!";
    }
}
class Cake implements  Food {
    public String getType() {
        return "Someone ordered a Dessert!";
    }
}
class FoodFactory {
    public Food getFood(String order) {
        if (order.equalsIgnoreCase("cake"))
            return new Cake();
        else
            return new Pizza();
    }
}


public class FactoryPattern {

    public static void main(String args[]){
        Do_Not_Terminate.forbidExit();

        try{

            Scanner sc=new Scanner(System.in);
            //creating the factory
            FoodFactory foodFactory = new FoodFactory();

            //factory instantiates an object
            Food food = foodFactory.getFood(sc.nextLine());


            System.out.println("The factory returned "+food.getClass());
            System.out.println(food.getType());
        }
        catch (Do_Not_Terminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }

}
class Do_Not_Terminate {

    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1L;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}
