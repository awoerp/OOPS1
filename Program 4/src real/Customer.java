/*
This class conatins all of the information related to a customer within
the simulation.  
 * @author SteveWoerpel
 */
public class Customer
{
 private static int numCustomer = 1;
 private int customerNo;
 private int timeStamp;
 private int timeOfService = 0;

 /**
  * This is the constructor for a new Customer object.
  * @param time the time at which the customer was created (typically,
  * the current time).
  */
 public Customer(int time)
 {
    timeStamp = time;
    customerNo = numCustomer++;
 }

 /**
  * This method returns the time at which a customer was created.
  * @return the time when the customer was created.
  */
 public int getTimestamp()
 {
    return timeStamp;
 }

 /**
  * This method returns the several aspects of the customer object as a string.
  * @return The customer number and arrival time as a string.
  */
 public String toString()
 {
    return ("Customer#" + customerNo + " arrived @time " + timeStamp);
 }
 
 /**
  * This method sets the time that the customer left the line 
  * and began to be served.
  * @param time the time to set the time of service to
  */
 public void setTimeOfService(int time)
 {
    timeOfService = time;
 }
 
 /**
  * This method returns the time that the customer left the line and began
  * being served
  * @return the time at which the customer began being served
  */
 public int getTimeOfService()
 {
    return timeOfService;
 }
 
} 
