/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SteveWoerpel
 */
public class Customer
{
 private static int numCustomer = 1;
 private int customerNo;
 private int timeStamp;

 public Customer(int time)
 {
    timeStamp = time;
<<<<<<< HEAD
    customerNo = numCustomer++;
=======
    customerNo = numCustomer;
    numCustomer++;
>>>>>>> origin/master
 }

 public int getTimestamp()
 {
    return timeStamp;
 }

 public String toString()
 {
    return ("Customer#" + customerNo + "arrived @time " + timeStamp);
 }
} 
