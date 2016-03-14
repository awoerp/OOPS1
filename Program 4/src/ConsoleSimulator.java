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
            default: print();
         }
         command = stdin.next();
      }
   }
   
   void arrival()
   {
      if(line.isFull())
         System.out.println("Queue is full.");
      else
      {
         Customer temp = new Customer();
         line.add(temp);
         System.out.println();
      }
   }
   
   void departure()
   {
      if(line.isEmpty())
         System.out.println("Queue is empty.");
      else
      {
         line.remove();
         System.out.println();
      }
      
   }
   
   void forwardTime()
   {
      int time = stdin.nextInt();
      
   }
   
   void print()
   {
      
   }
}
