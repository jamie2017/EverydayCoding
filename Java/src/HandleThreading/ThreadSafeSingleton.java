package HandleThreading;

/**
 * Created by JMYE on 3/15/17.
 */
/*

Use synchronized block inside the if loop
Pros:

Thread safety is guaranteed
Client application can pass arguments
Lazy initialization achieved
Synchronization overhead is minimal and applicable only for first few threads when the variable is null.
Cons:

Extra if condition
 */

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance = null;
    private static Object mutex = new Object();
    private ThreadSafeSingleton() {

    }

    public static ThreadSafeSingleton getInstance(){
        if (instance == null) {
            synchronized(mutex) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}


/*
Thread unsafe singleton
In general we follow below steps to create a singleton class:

Override the private constructor to avoid any new object creation with new operator.
Declare a private static instance of the same class
Provide a public static method that will return the singleton class instance variable.
If the variable is not initialized then initialize it or else simply return the instance variable.

public class ASingleton {

	private static ASingleton instance = null;

	private ASingleton() {
	}

	public static ASingleton getInstance() {
		if (instance == null) {
			instance = new ASingleton();
		}
		return instance;
	}

}


 */