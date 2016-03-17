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
   Simulation simulation = new Simulation();
   Scanner stdin = new Scanner(System.in);
   void run()
   {
      String command = stdin.next();
      while(!command.equals("Q"))
      {
         String originalCommand = command;
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
            default: System.out.println(originalCommand + " is NOT a valid command!");
               stdin.nextLine();
         }
         //System.out.println();
         command = stdin.next();
      }
      quit();
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
         System.out.println("Number of customers waiting in the line: " + simulation.getCount());
      }
   }
   
   void departure()
   {
      Customer temp = simulation.departure();
      if(temp == null)
      {
         System.out.println("Nobody is being served @time " + simulation.getClock() + ".");
      }
      else
      {
         System.out.print(temp.toString() + " finished @time " + simulation.getClock() + ". ");
         System.out.println("Number of customers waiting in the line: " + simulation.getCount() + ".");
      }
   }
   
   void forwardTime()
   {
      int time = stdin.nextInt();
      if(time > 0)
      {
         simulation.increaseClock(time);
         System.out.println("Time updated by " + time + " units; current time is " 
                            + simulation.getClock() + ".");
      }
      else
         System.out.println("Time NOT updated with " + time + ".");
   }
   
   void statistics()
   {
      System.out.println();
      int finished = simulation.getFinished();
      int totalWait = simulation.getTotalWait();
      int waited = simulation.getWaited();
      int noWait = simulation.getNoWait();
      if(waited == 0)
      {
         System.out.println("The average wait time for the customers who finished waiting: 0.0");
      }
      else
      {
         System.out.println("The average wait time for the customers who finished waiting: "
                            + ((float)totalWait / (waited)) + ".");
      }
         
      System.out.println("The total wait time is " + totalWait + ".");
      System.out.println("The number of customers finished: " + finished + ".");
      System.out.println("The number of customers who did not have to wait: " + noWait + ".");
      System.out.println();
   }
   
   private void quit()
   {
      System.out.print("Simulation statistics:");
      statistics();
   }
}
