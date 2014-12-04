/**
Chrissy Bolognino
CS 110
Card Class
**/

public class Card  
{      
    
    private int rank, suit;                                                                  
    public final static int SPADES = 1, HEARTS = 2, DIAMONDS = 3, CLUBS = 4; 
    public final static int JACK = 11, QUEEN = 12, KING = 13, ACE = 1; 
                              
     
    //@param suit 
    //@param rank 
     public Card(int rank, int suit)  
     { 
         this.rank = rank; 
         this.suit = suit;  
     } 
      
     
    //@param otherCard 
     public Card(Card otherCard)  
     { 
          this.rank = otherCard.rank; 
          this.suit = otherCard.suit; 
     } 
       
    //@return suit
     public int getSuit()  
     { 
       return suit; 
     } 
    
    //@return rank
     public int getRank()  
     {  
         return rank; 
     } 
       
    //@return the suit 
     public String getSuitString()  
     { 
             // Return a String representing the card's suit. 
             // (If the card's suit is invalid, "??" is returned.) 
         switch (suit) 
         { 
            case SPADES:   
            return "Spades"; 
            case HEARTS:   
            return "Hearts"; 
            case DIAMONDS: 
            return "Diamonds"; 
            case CLUBS:    
            return "Clubs"; 
            default:       
            return "invalid"; 
         } 
     } 
      
    //@return rank as string 
    
    public String getRankString()  
    { 
         switch (rank) 
         { 
            case 1:   
            return "ace"; 
            case 2:   
            return "2"; 
            case 3:   
            return "3"; 
            case 4:   
            return "4"; 
            case 5:   
            return "5"; 
            case 6:   
            return "6"; 
            case 7:   
            return "7"; 
            case 8:   
            return "8"; 
            case 9:   
            return "9"; 
            case 10:  
            return "10"; 
            case 11:  
            return "jack"; 
            case 12:  
            return "queen"; 
            case 13:  
            return "king"; 
            default:  
            return "-"; 
         } 
     } 
     
    //@return name
     public String toString()  
     { 
         String rankString = " "; 
         String suitString = " ";
          
         if(rank > 1 && rank <= 10) 
          rankString = "" + rank; 
         else if (rank == ACE) 
          rankString = "ace"; 
         else if (rank == JACK) 
          rankString = "jack"; 
         else if (rank == QUEEN) 
          rankString = "queen"; 
         else if (rank == KING) 
          rankString = "king"; 
          
         if(suit == SPADES) 
             suitString = "s"; 
         else if (suit == HEARTS) 
             suitString = "h"; 
         else if (suit == DIAMONDS) 
             suitString = "d"; 
         else if (suit == CLUBS) 
             suitString = "c"; 
              
         String str = rankString + suitString; 
         return str; 
     } 
      
    
    //@param card 
    //@return true 
    public int compareTo(Card otherCard )  
    { 
       if ( this.rank < otherCard.rank ) 
          return -1; 
       else if (rank > otherCard.rank) 
          return 1; 
       else 
          return 0; 
    } 
    
   
 } 
      
 
 