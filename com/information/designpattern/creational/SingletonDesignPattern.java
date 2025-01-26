package com.information.designpattern.creational;

/**
 *  It is used when we want single instances in all over places
 */
public class SingletonDesignPattern {

    /*
    * 4 ways of achieve this
    *   1. Eager ---> popular
    *   2. Lazy
    *       a. Synchronized method
    *       B. Double locking --> popular
    * */
    public static void main(String[] args) {

    }
}

/*
* we create the instance of the class at the time of declaring the static data member,
* so instance of the class is created at the time of classloading
* */
class EagerSingleton {
    private static EagerSingleton obj = new EagerSingleton();//Early, instance will be created at load time
    private EagerSingleton(){}

    public static EagerSingleton getEagerSingleton(){
        return obj;
    }
}

/*
* Creation of instance when required.
* Problem with lazy is : if 2 threads concurrently call the getLazySingleton method (this solves synchronized method)
* */
class LazySingleton {
        private static LazySingleton obj;
        private LazySingleton(){}

        public static LazySingleton getLazySingleton(){
            if (obj == null){
                obj = new LazySingleton();//instance will be created at request time
            }
            return obj;
        }
}

/*
* It solves the above issue, if 2 threads calling method concurrently but synchronized blocks other thread
* and whenever multiple threads are calling this method to get the instance it will lock everytime that's
* synchronized method is not preferred
* */
class LazySingletonWithSynchronization {
    private static LazySingletonWithSynchronization obj;
    private LazySingletonWithSynchronization(){}

    synchronized public static LazySingletonWithSynchronization getLazySingletonWithSynchronization(){
        if (obj == null){
            obj = new LazySingletonWithSynchronization(); //instance will be created at request time
        }
        return obj;
    }
}

/* Most optimized and best Lazy Singleton solution (only 1st time lock) */
class LazySingletonWithDoubleLocking {
    private static LazySingletonWithDoubleLocking obj;
    private LazySingletonWithDoubleLocking(){}

    public static LazySingletonWithDoubleLocking getLazySingletonWithDoubleLocking(){

        if (obj == null){
            synchronized (LazySingletonWithDoubleLocking.class){
                obj = new LazySingletonWithDoubleLocking(); //instance will be created at request time
            }
        }
        return obj;
    }
}