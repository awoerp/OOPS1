/*
This generic class contains the data and methods needed to implement a queue.
 */
//@author Andy Woerpel
public class Queue<E>
{
   private E [] elements;
   private int front, rear, count;
   
   /**
    * This is the only constructor for the queue class.  It requires that
    * the maximum size of the queue be provided.
    * @param capacity The capacity of the queue
    */
   public Queue(int capacity)
   {
      elements = (E[])new Object[capacity];
      front = rear = count = 0;
   }
   
   /**
    * This method adds and element to the queue.
    * @param obj The element that will be added to the queue.
    * @return true if the item was successfully added to the queue, otherwise
    *         false
    */
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
   
   /**
    * This method removes and returns the item at the front of the queue.
    * @return the first element in the queue if the queue is not empty,
    *         otherwise null
    */
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
   
   /**
    * This method determines whether the queue is empty.
    * @return true if the queue is empty, otherwise false
    */
   private boolean isEmpty()
   {
      return count == 0;
   }
   
   /**
    * This method determines if the queue is full.
    * @return true if the queue is full, otherwise false
    */
   private boolean isFull()
   {
      return count == elements.length;
   }
   
   /**
    * This method returns the number of elements that are currently in the
    * queue.
    * @return the number of elements in the queue.
    */
   public int getSize()
   {
      return count;
   }
}