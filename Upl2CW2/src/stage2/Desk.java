/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stage2;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author kinut
 */
public class Desk extends Thread{
    private String desk;
    private JTextArea display;
    Thread t;
    public Desk(String desk,JTextArea disp) {
        this.desk = desk;
        this.display=disp;
    }

    public String getDesk() {
        return desk;
    }
    public void processCustomer(Customer cus){
        int price=0;
        StringBuilder sb=new StringBuilder();
        sb.append("\t\t"+desk+"\n");
        sb.append(cus.getName()+" is dropping off 1 bag of "+cus.getLuggage()+"kg.");
        if(cus.getLuggage()>20){
            price=35;
            sb.append("\nA luggage fee of "+price+" is due");
        }
        sb.append("\nCleared from security.");
        display.setText(sb.toString());
    }
    
    @Override
    public void run(){
        boolean status = Airport.customerQueue.isEmpty();
        //System.out.print(status);
        while (true) {
            Customer customer = Airport.customerQueue.dequeue();
            if (customer != null) {
                processCustomer(customer);
                Airport.board(customer);
            }
            try {
                Thread.sleep(15000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Desk.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
    }
    @Override
    public void start(){
        if(t==null){
            t=new Thread(this,desk);
            t.start();
        }
    }

}
