package JavaEssentials;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.Permission;



/**
 * Created by JMYE on 3/15/17.
 */
public class CheckInnerClassCreation {
    public static void main(String[] args)  throws Exception {
        DoNotTerminate.forbidExit();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine().trim());
            Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private
            o = new Inner().new Private();
            System.out.println(num + " is " + ((CheckInnerClassCreation.Inner.Private) o).powerof2(num));

            System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
        } // end of try
        catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Terminatiotn!!");
        }
    }

    static class Inner {
        private class  Private {
            private  String powerof2(int num) {
                return ((num & (num -1)) == 0) ? "power of 2" : "not a power of 2";
            }
        }
    }
}

class DoNotTerminate { // This class prevents exit(0)
    public static class ExitTrappedException extends SecurityException {
        private static final long serialVersonUID = 1L;
    }
    public static void forbidExit() {
        final  SecurityManager securityManager = new SecurityManager()
        {
            @Override
            public void checkPermission (Permission permission){
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }

}
