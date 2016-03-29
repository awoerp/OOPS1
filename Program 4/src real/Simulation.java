/*
This class keeps track of and allows external interface with the
simulation data.
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
   
   
   /**
    * This is the constructor for the Simulation class.
    */
   public Simulation()
   {
      finished = nowait = waited = totalwait = clock = 0;
   }
   
   /**
    * This method adds a new customer to the simulation.
    * @return true if the new customer was successfully added, otherwise false
    */
   public boolean newCustomer()
   {
      Customer c1 = new Customer(getClock());
      if(being_served == null)
      {
         being_served = c1;
         c1.setTimeOfService(getClock());
         nowait++;
         return true;
      }
      
      return q.enqueue(c1);
   }
   
   /**
    * This method removes a customer who has just finished being served.
    * @return the customer that just completed being served of null if there
    * were no customers being served.
    */
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
         being_served.setTimeOfService(getClock());
         waited++;
         totalwait += temp.getTimeOfService() - 
                      temp.getTimestamp();
      }
      finished++;
      return departingCustomer;
   }
   
   /**
    * Returns the current value of the clock.
    * @return current clock value
    */
   public int getClock()
   {
      return clock;
   }
   
   /**
    * This method returns the number of customers who have been served.
    * @return the number of customers who have been served
    */
   public int getFinished()
   {
      return finished;
   }
   
   /**
    * The method returns the number of customers who did not need to wait
    * in line.
    * @return the number of customers who didn't have to wait
    */
   public int getNoWait()
   {
      return nowait;
   }
   
   /**
    * This method returns the number of customers who did have to wait
    * in line.
    * @return the number of customers who did wait
    */
   public int getWaited()
   {
      return waited;
   }
   
   /**
    * This method returns the total amount of time that customers have
    * had to wait in line.
    * @return the total amount of time that customers have had to wait in line.
    */
   public int getTotalWait()
   {
      return totalwait;
   }
   
   /**
    * This will increase the clock time by a desired value.
    * @param time the amount of time that the clock should be increased.
    */
   public void increaseClock(int time)
   {
      clock += time;
   }
   
   /**
    * This method returns the number of customers waiting in line.
    * @return The number of customers who are currently waiting in line
    */
   public int getCount()
   {
      return q.getSize();
   }
} 