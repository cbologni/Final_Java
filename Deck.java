import java.util.Random; 
  
public class Deck  
{  
    private int ranks = 13; 
    private int suits = 4; 
 
    private ListArrayListBased deck = new ListArrayListBased(); 
    //constructor will include a for loop to assign a suit, a rank, then make card object with that suit and rank....then add it to the deck   
    public Deck() 
    { 
       for (int i=1; i <= ranks; i++) 
       { 
          for (int c=1; c <= suits; c++) 
          {     
             Card card = new Card(i,c);  
             deck.add(i,card); 
          } 
       } 
       //send to the shuffle method  
       shuffle();
    } 
     
    public void shuffle() 
    {  
       int randomCard; 
       int j = 51; 
       Card c, c2; 
       Random rand = new Random(); 
       //for loop to switch cards around 
       for (int i = 1; i < deck.size(); i++) 
       { 
        
         randCard = rand.nextInt(j)+1; 
         c = (Card)(deck.get(i)); 
         c2 = (Card)(deck.get(randCard)); 
           
          //removes card 
          deck.remove(i); 
          deck.remove(randomCard); 
          //adds card 
          deck.add(i,c2); 
          deck.add(randomCard,c); 
           
       }       
    } 
    //draw removes and returns card
    public Card draw() 
    {  
       Card card1; 
       int card2 = 1; 
       card1 = (Card)(deck.get(card2)); 
       deck.remove(card2);
       return card1; 
    } 
    //@return size 
    public int getSize() 
    { 
       return deck.size(); 
    }      
 } 
