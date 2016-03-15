/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SteveWoerpel
 */

import java.util.*;

public class ConsoleSimulator 
{
   static int initialCapacity = 10;
   Queue line = new Queue(initialCapacity);
   Simulation simulation = new Simulation();
   Scanner stdin = new Scanner(System.in);
   void run()
   {
      String command = stdin.next();
      while(!command.equals("Q"))
      {
         command = command.toUpperCase();
         switch(command)
         {
            case "A": arrival();
               break;
            case "L": departure();
               break;
            case "C": forwardTime();
               break;
            case "S": statistics();
               break;
            default: System.out.println(command + "is NOT a valid command!");
               stdin.nextLine();
         }
         command = stdin.next();
      }
      System.out.print("Simulation Terminated");
   }
   
   void arrival()
   {
      if(!simulation.newCustomer())
      {
         System.out.println("A customer couldn" + "'" 
                            + "t get in line @time " 
                            + simulation.getClock()
                            + " because the line was full.");
      }
      else
      {
         System.out.print("A customer has arrived @time " + simulation.getClock() + ". ");
         System.out.println(numCustomersToString());
      }
   }
   
   void departure()
   {
      Customer temp = simulation.departure();
      if(temp == null)
      {
         System.out.println("error");
      }
      else
      {
         System.out.print(temp.toString() + " finished @time " + simulation.getClock() + ". ");
         System.out.println(numCustomersToString());
      }
   }
   
   void forwardTime()
   {
      int time = stdin.nextInt();
      if(time > 0)
      {
         simulation.increaseClock(time);
         System.out.println("Time updated by " + time + " units; current time is" + simulation.getClock());
      }
      else
         System.out.println("Time NOT updated with " + time);
      
   }
   
   void statistics()
   {
      int finished = simulation.getFinished();
      int totalWait = simulation.getTotalWait();
      //int waited = simulation.getWaited();
      int noWait = simulation.getNoWait();
      if(totalWait > 0)
      {
         System.out.println("The average wait time for the customers who finished waiting: "
                            + (finished / totalWait) + ".");
      }
      System.out.println("The total wait time is " + totalWait + ".");
      System.out.println("The number of customers finished: " + finished + ".");
      System.out.println("The number of customers who did not have to wait: " + noWait + ".");
      System.out.println();
   }
   
   String numCustomersToString()
   {
      return ("Number of customers waiting in the line: " + line.getSize());
   }
}
