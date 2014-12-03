/**
Chrissy Bolognino
CS 110
Final Project
WarGame class to play the game
**/
public class GameOfWar
{
   private Deck d;
   private Pile p1, p2;
 
 //constructor
   public GameOfWar()
   {
      d = new Deck();
      p1 = new Pile(d);
      p2 = new Pile(d);
   }
   
   /**
      //draws card from deck
      @param int
      @return card
   */
   public Card draw(int i)
   {
     if (i==1)
     {
         return (Card)(p1.draw());
     }
     else
     {
         return (Card)(p2.draw());
     } 
   }
   
   /**
      //adds card to pile
      @param int i
      @param c
   */
   public void add(int i, Card c)
   {
      if(i==1)
      {
         p1.add(p1.size()+1,c);
      }
      else
      {
         p2.add(p2.size()+1,c);
      } 
   }
   
   /**
      //adds cards to pile
      @param int i
      @param c
   */
   public void add(int i, Card c1, Card c2)
   {
      if(i==1)
      {
      
         p1.add(p1.size()+1,c1);
         
         p1.add(p1.size()+1,c2);
         
      }
      else
      {
      
         p2.add(p2.size()+1,c1);
         
         p2.add(p2.size()+1,c2);
         
      }
   }
   /**
      //returns pile size in order to compare the sizes for the win
      @param int
      @return size
   */
   public int pileSize(int i)
   {
      if (i==1)
         return p1.size();
      else
         return p2.size();
   }
   /**
      total displays
      @param list
   */
   public void cardsWon(ListArrayListBased j)
   {
      System.out.println("The cards won was ");
      
      for(int i=1; i<=j.size();i++)
      {
         System.out.println(j.get(i));
      }
   }
   /**
      Method returns true if pile is empty
      @param i
      @return true or false
   */
   public boolean ifEmpty(int i)
   {
      if (i==1)
      {
         return p1.isEmpty();
      }
      else
      {
         return p2.isEmpty();
      }
   }
   
   /**
      //toString method
      @return string
   */
   public String toString()
   {
      String string1 = "Your score was " + p1.size();
      String string2 = "Computer score was " + p2.size();
      return string + "*********" + string2;
   }

   
}