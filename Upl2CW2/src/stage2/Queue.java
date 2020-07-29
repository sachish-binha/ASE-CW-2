/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stage2;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author kinut
 */
public class Queue extends Thread{
    int size,capacity;
    PriorityQueue<Customer> queue;
    JList display;
    Thread t;
    DefaultListModel dlm;
    
    public Queue(int capacity,JList qi){
        this.queue = new PriorityQueue<Customer>();
        this.capacity=capacity;
        this.size=0;
        this.display=qi;
        this.dlm=new DefaultListModel();
    }
    public boolean queue (Customer cus){
        if(size<capacity){
            queue.add(cus);
            size++;
            dlm.addElement(cus.toString());
            display.setModel(dlm);
            return true;
        }else{
            return false;
        }
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    public Customer dequeue(){
        if(!dlm.isEmpty()){
            dlm.remove(0);
            display.setModel(dlm);
            return this.queue.remove();
        }else{
            return null;
        }
        
    }
    private ArrayList loadData(){
        ArrayList<Customer> data=new ArrayList<>();
        Loader loader=new Loader();
        String[] customers=loader.readFile("customers.txt");
        for(int i=0;i<customers.length;i++){
            String[] temp=customers[i].split(":");
            data.add(new Customer(temp[0],temp[1],Integer.parseInt(temp[2]),temp[3]));
        }
        return data;
    }
    
    @Override
    public void run(){
        ArrayList<Customer> data=loadData();
        for (int i=0;i<data.size();i++){
            queue(data.get(i));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Queue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @Override
    public void start(){
        if(t==null){
            t=new Thread(this,"customers queue");
            t.start();
        }
    }
    
}
