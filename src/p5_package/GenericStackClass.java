package p5_package;


public class GenericStackClass<GenericData extends Comparable<GenericData>>
   {

   private static final int DEFAULT_CAPACITY = 10;
   private static final char SPACE = ' ';

   private Object[] stackArray;

   private int stackSize;
   private int stackCapacity;

   public GenericStackClass()
      {
      stackArray = new Object[DEFAULT_CAPACITY];
      stackCapacity = DEFAULT_CAPACITY;
      stackSize = 0;
      }

   public GenericStackClass(int capacity)
      {
      stackArray = new Object[capacity];
      stackCapacity = capacity;
      stackSize = 0;
      }

   public void clear()
      {
      stackSize = 0;
      }

   public void displayStack()
      {
      int index, spaceIndex = 1;

      if (stackSize == 0) ;
      else if (stackSize == 1)
         {
         System.out.format("Stack Top: Stack Bottom: %s\n",
               stackArray[0].toString());
         }
      else
         {
         System.out.format("Stack Top: %s\n",
                 stackArray[stackSize - 1].toString());

         for (index = stackSize - 2; index > 0; index--)
            {
            printChars(11 + spaceIndex * 2, SPACE);
            System.out.format("%s\n", stackArray[index].toString());
            spaceIndex++;
            }
         printChars(11 + ((stackSize-1) * 2), SPACE);
         System.out.format("Stack Bottom: %s\n", stackArray[0].toString());
         }
      }

   public boolean isEmpty()
      {
      return stackSize == 0;
      }

   public GenericData peekTop()
      {
      return (GenericData) stackArray[stackSize];
      }

   public GenericData pop()
      {
      stackSize--;
      return (GenericData) stackArray[stackSize];
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

   public void push(GenericData newValue)
      {
      if (stackSize == stackCapacity)
         {
         resize();
         }

      stackArray[stackSize] = newValue;
      stackSize++;
      }

   public void resize()
      {
      int index;

      Object[] temp = new Object[stackCapacity];

      for (index = 0; index < stackSize; index++)
         {
         temp[index] = stackArray[index];
         }

      stackArray = new Object[stackCapacity * 2];

      for (index = 0; index < stackSize; index++)
         {
         stackArray[index] = temp[index];
         }
      }
   }
