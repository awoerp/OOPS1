/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//@author Andy Woerpel
public class Queue<E>
{
   private E [] elements;
   private int front, rear, count;
   public Queue(int capacity)
   {
      elements = (E[])new Object[capacity];
      front = rear = count = 0;
   }
   
   public boolean enqueue(E obj)
   {
      if(isFull())
      {
         return false;
      }
      elements[rear] = obj;
      rear = (rear + 1) % elements.length;
      count++;
      return true;
   }
   
   public E dequeue()
   {
      if(isEmpty())
      {
         return null;
      }
      E temp = elements[front];
      front = (front + 1) % elements.length;
      count--;
      return temp;
   }
   
   private boolean isEmpty()
   {
      return count == 0;
   }
   
   private boolean isFull()
   {
      return count == elements.length;
   }
   
   public int getSize()
   {
      return count;
   }
}