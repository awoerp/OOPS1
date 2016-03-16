/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Woerpel
 */
public class Simulation
{
   private static final int MAX_CUSTOMER = 5; //capacity of the line
   private Queue<Customer> q = new Queue<>(MAX_CUSTOMER);
   private int clock;
   private Customer being_served = null; //the customer being served

   private int finished; //number of customers finished
   private int nowait; //number of customers that didn’t have to wait
   private int waited; //number of customers waited
   private int totalwait; //total wait time for customers that had waited in the queue

   public boolean newCustomer()
   {
      Customer c1 = new Customer(getClock());
      if(being_served == null)
      {
         being_served = c1;
         return true;
      }
      
      return q.enqueue(c1);
   }
   
   public Customer departure()
   {
      if(being_served == null)
      {
         return null;
      }
      
      Customer temp = q.dequeue();
      Customer departingCustomer = being_served;
      if(temp == null)
      {
         being_served = null;
      }
      else
      {
         being_served = temp;
      }
      int waitTime = clock - departingCustomer.getTimestamp();
      if(waitTime > 0)
      {
         waited++;
      }
      else
      {
         nowait++;
      }
      totalwait += waitTime;
      finished++;
      return departingCustomer;
   }
   
   public int getClock()
   {
      return clock;
   }
   
   public int getFinished()
   {
      return finished;
   }
   
   public int getNoWait()
   {
      return nowait;
   }
   
   public int getWaited()
   {
      return waited;
   }
   
   public int getTotalWait()
   {
      return totalwait;
   }
   
   void increaseClock(int time)
   {
      clock += time;
   }
} 