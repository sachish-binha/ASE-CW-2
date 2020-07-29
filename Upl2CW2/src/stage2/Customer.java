/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stage2;

/**
 *
 * @author kinut
 */
public class Customer implements Comparable<Customer>{
    private String customerNo,name;
    private int luggage;
    private int baggageDimension = BagDim.getInstance().makeRan1();
    private String destination;

    public Customer(String customerNo, String name, int luggage,String destination) {
        this.customerNo = customerNo;
        this.name = name;
        this.luggage = luggage;
        this.destination=destination;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLuggage() {
        return luggage;
    }

    public void setLuggage(int luggage) {
        this.luggage = luggage;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    @Override
    public String toString(){
        return customerNo+"     "+name+"     "+luggage+"kg     "+baggageDimension+" units";
    }

    @Override
    public int compareTo(Customer o) {
        return this.customerNo.compareTo(o.customerNo);
    }
}
