/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stage2;

import java.util.ArrayList;

/**
 *
 * @author kinut
 */
public class Plane {
   private String id,name;
   private int capacity;
   private ArrayList<Customer> boarded=new ArrayList<>();

    public Plane(String id,String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean board(Customer cus){
        if(boarded.size()<capacity){
            boarded.add(cus);
            return true;
        }else{
            return false;
        }
    }

    public int getNumberBoarded(){
        return this.boarded.size();
    }
   
}
