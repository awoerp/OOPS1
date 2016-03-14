/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//@author SteveWoerpel
public class Queue<E>
{
   private E [] elements;
   private int front, rear, count;
   public Queue(int capacity)
   {
      elements = (E[])new Object[capacity];
   }
}