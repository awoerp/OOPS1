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
   int customerNumber = 1;
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
   }
   
   void arrival()
   {
      Customer temp = new Customer(simulation.getClock());
      if(!line.enqueue(temp))
      {
         System.out.println("queue full");
      }
      else
         System.out.println("Customer#" + customerNumber + "arrived @time" + simulation.getClock() +
                            ". Number of customers waiting: " + line.getSize());
      customerNumber++;
   }
   
   void departure()
   {
      if(line.dequeue() != null)
         System.out.println();
      else
         System.out.println();
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
      int waited = simulation.getWaited();
      int noWait = simulation.getNoWait();
      System.out.println("The average wait time for the customers who finished waiting: "
                          + (finished / totalWait) + ".");
      System.out.println("The total wait time is " + totalWait + ".");
      System.out.println("The number of customers finished: " + finished + ".");
      System.out.println("The number of customers who did not have to wait: " + noWait + ".");
      System.out.println();
   }
}
