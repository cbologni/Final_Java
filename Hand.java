public class Hand extends Deck
{

   private final int ALL = 26;
   private ListArrayListBased pile;
   
   /**
      adds card to pile
      @param deck
   */
   
   public Hand(Deck deck)
   {
      pile = new ListArrayListBased();
      
      for (int i=1; i<= ALL; i++)
      {
         Card card = deck.draw();
         
         pile.add(i,card);      
      } 
   }
   
   /**
      size() returns pile size
      @return pile.size
   */
   public int size()
   {
      return pile.size();
   }
   /**
      adds card to pile
      @param int 
      @param Card
   */
   public void add(int index, Card card)
   {
      pile.add(pile.size()+1,card);
   }
   
   /**
      draws card from pile
      @returns card
   */
   public Card draw()
   {
      Card card;
      
      card = (Card)(pile.get(1));
      pile.remove(1);
      return card;
   }
   
   /**
      determines if pile is empty
      @return true or false
   */
   public boolean isEmpty()
   {
      if (pile.isEmpty())
      {
         return true;
      }
      else
      {
         return false;
      }
   }
} 