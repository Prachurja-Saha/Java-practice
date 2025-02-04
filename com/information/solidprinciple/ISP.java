package com.information.solidprinciple;

/* Not following ISP */
// Here Interface has so many abstract method so client/implemented class needs to implement all by force
interface RestRoomEmployee{
    void washDishes();
    void cookFood();
    void serveCustomer();
}

class Waiter implements RestRoomEmployee{

    @Override
    public void washDishes() {} // Unnecessary method implementation not following ISP

    @Override
    public void cookFood() {}

    @Override
    public void serveCustomer() {
        System.out.println("Serving Customer");
    }
}

/* Following ISP  [breaking interface]*/
interface WaiterInterface{
    void serveCustomer();
    void takeOrder();
}

interface CookInterface{
    void cookFood();
}

// No unnecessary method implementation
class Waiter2 implements WaiterInterface{

    @Override
    public void serveCustomer() {} // all related to waiter no unnecessary method implementation (Following ISP)

    @Override
    public void takeOrder() {}
}

public class ISP {
}
