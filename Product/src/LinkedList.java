
   public class LinkedList implements List
   {
      
      Node header;
      int size;
   
      LinkedList ()
      {
         header = null;
         size = 0;
      }
   
   
      private Node traverse (int i)
      {
         Node n = header;
      
         if (i < 0)
            return null;
      
         for (int j = 0 ; j < i ; j++)
         {
            if (n == null)
               return null;
            n = n.getNext ();
         }
         return n;
      }
   
   
      public boolean insert (int i, Object item)
      {
         Node prev;
         Node newNode = new Node (item);
      
         if (i == 0)
         {
            if (!isEmpty ())
               newNode.setNext (header);
            header = newNode;
         }
         else
         {
            prev = traverse (i - 1);
            if (prev == null)
               return false;
            newNode.setNext (prev.getNext ());
            prev.setNext (newNode);
         }
         size++;
         return true;
      }
   
   
      public int size ()
      {
         return size;
      }
   
   
      public boolean isEmpty ()
      {
         return header == null;
      }
   
   
      public Object lookUp (int i)
      {
         Node n = traverse (i);
         if (n == null)
            return null;
         return n.getData ();
      }
   
   
      public boolean delete (int i)
      {
         Node prev;
      
         if (isEmpty ())
            return false;
      
         if (i == 0)
            header = header.getNext ();
         else
         {
            prev = traverse (i - 1);
            if (prev.getNext () == null)
               return false;
            prev.setNext (prev.getNext ().getNext ());
         }
         size--;
         return true;
      }
   
   
      public boolean replace (int i, Object item)
      {
         Node n = traverse (i);
         if (n == null)
            return false;
         n.setData (item);
         return true;
      }
   
   
      public void displayReverse ()
      {
         printReverse (header);
      }
   
   
      private void printReverse (Node head)
      {
         if (head == null)
         {
         }
         else
         {
            printReverse (head.getNext ());
            System.out.println ((String) head.getData ());
         }
      }
   }


