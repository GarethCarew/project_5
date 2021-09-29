package p5_package;

public class GenericQueueClass<GenericData extends Comparable<GenericData>>
   {
   private static final int DEFAULT_CAPACITY = 10;
   private static final char SPACE = ' ';

   private Object[] queueArray;
   private int queueSize;
   private int queueCapacity;
   private int frontIndex;
   private int rearIndex;


   public GenericQueueClass()
      {
      queueArray = new Object[DEFAULT_CAPACITY];
      queueCapacity = DEFAULT_CAPACITY;
      queueSize = 0;
      frontIndex = 0;
      rearIndex = 0;
      }

   public GenericQueueClass(int capacity)
      {
      queueArray = new Object[capacity];
      queueCapacity = capacity;
      queueSize = 0;
      frontIndex = 0;
      rearIndex = 0;
      }

   public void clear()
      {
      queueSize = 0;
      frontIndex = 0;
      rearIndex = 0;
      }

   public GenericData dequeue()
      {
      rearIndex++;
      queueSize--;
      Object returnVal = queueArray[rearIndex - 1];
      rearIndex %= queueCapacity;
      return (GenericData) returnVal;
      }

   public void displayQueue()
      {
      int loopIndex, workingIndex = rearIndex + 1, spaceIndex = 1;

      if (queueSize == 0) ;
      else if (queueSize == 1)
         {
         System.out.format("Queue Front: Queue Rear: %s\n",
               queueArray[rearIndex].toString());
         }
      else
         {
         System.out.format("Queue Front: %s\n",
               queueArray[rearIndex].toString());

         for (loopIndex = 1; loopIndex < queueSize - 1; loopIndex++)
            {
            workingIndex %= queueCapacity;

            printChars(13 + spaceIndex * 2, SPACE);
            System.out.format("%s\n", queueArray[workingIndex].toString());

            spaceIndex++;
            workingIndex++;
            }

         printChars(13 + ((queueSize-1) * 2), SPACE);
         System.out.format("Queue Rear: %s\n",
               queueArray[queueSize-1].toString());

         }
      }

   public void enqueue(GenericData newValue)
      {
      if (queueSize == queueCapacity)
         {
         resize();
         }

      queueArray[frontIndex] = newValue;
      frontIndex++;
      queueSize++;
      frontIndex %= queueCapacity;
      }

   public boolean isEmpty()
      {
      return queueSize == 0;
      }

   public GenericData peekFront()
      {
      if (queueSize == 0)
         return null;
      return (GenericData) queueArray[frontIndex];
      }

   public void printChars(int numChars, char outChar)
      {
      if(numChars > 1)
         {
         System.out.print(outChar);
         printChars(numChars - 1, outChar);
         }
      else
         System.out.print(outChar);
      }

   public void resize()
      {
      int index;

      Object[] temp = new Object[queueCapacity];

      for (index = 0; index < queueSize; index++)
         {
         temp[index] = queueArray[index];
         }

      queueArray = new Object[queueCapacity * 2];

      for (index = 0; index < queueSize; index++)
         {
         queueArray[index] = temp[index];
         }
      }
   }
