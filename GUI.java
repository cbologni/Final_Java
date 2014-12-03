import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame
{
   private Card c1, c2;
   private War war;
   private ListArrayListBased list;
   
   private static final int TWO = 2;
   
   //labels and variables for images
   private JLabel play1, play2;
   private JLabel l1, l2, l3, l4;
   private ImageIcon frontOne, frontTwo, back;
      
   //sections, buttons, and main title and game
   private JPanel p1, p2, p3, p4, p5, p6;
   private JButton b1, b2;
   private JLabel main, game; 
  
   //constructor
   public GUI()
   {
      //new war game class object
      war = new War();
      //new ArrayListBased list
      list = new ListArrayListBased();
      
      //create GUI set up using gridLayout
      setLayout(new GridLayout(2,3));
      //war = new War();
      
      p1 = new JPanel(new FlowLayout(FlowLayout.CENTER,45,45));//set this panel's location
      p1.setBackground(Color.BLACK);//color black
      
      p2 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,45));//set this panel's location
      p2.setBackground(Color.BLACK);//color black
      
      p3 = new JPanel(new FlowLayout(FlowLayout.CENTER,45,45));//set this panel's location
      p3.setBackground(Color.BLACK);//color black
      
      p4 = new JPanel(new FlowLayout(FlowLayout.CENTER,45,45));//set this panel's location
      p4.setBackground(Color.BLACK);//color black
      
      p5 = new JPanel(new FlowLayout(FlowLayout.CENTER,45,10));//set this panel's location
      p5.setBackground(Color.BLACK);//color black
      
      p6 = new JPanel(new FlowLayout(FlowLayout.CENTER,45,45));//set this panel's location
      p6.setBackground(Color.BLACK);//color black
      
      //main title piece  
      main = new JLabel(war.toString());//the main title will be gotten via the war toString method
      game = new JLabel();
      
      main.setFont(new Font("Serif",Font.ITALIC,24));//set font to serif, italic
      
      p2.add(main);//add it
      p2.add(game);//add it
      
      //button 1
      b1 = new JButton("Draw Card?");
      b1.addActionListener(new ButtonListener());
      p5.add(b1);
      //button 2
      b2 = new JButton("Play War?");
      b2.addActionListener(new ButtonListener2());
      p5.add(b2);
      b2.setEnabled(false);
      
      //images set to back
      back = new ImageIcon("cardPics/back.jpg");
      11 = new JLabel(back);
      12 = new JLabel(back);
      13 = new JLabel(back);
      14 = new JLabel(back);
      
      //add these
      p1.add(l1);
      p3.add(l2);
      p4.add(l3);
      p6.add(l4);
      add(p1);
      add(p2);
      add(p3);
      add(p4);
      add(p5);
      add(p6);

   }
   /**
   method to flip the first card
   */
   public void flipIt()
   {
      //cards
      c1 = game.draw(1);
      c2 = game.draw(2);
      
      //compares battle scores
      if(c1.compareTo(c2) == 1)
      {
         war.add(1,c1,c2);//add card to u pile
        
         main.setText(war.toString());//use toString
         game.setText("you win a battle");//print reults                   
      }
      
      else if(c1.compareTo(c2) == -1)
      {
        war.add(2,c1,c2);//add card to comp pile

        main.setText(war.toString());//use toString
        game.setText("you lose the battle");//print results
      }
      
      else if(c1.compareTo(c2) == 0)//else if they are the same
      {
         game.setText("WAR");//go to war
         
         list.add(1, c1);//add c1
         list.add(2, c2);//add c2
         
         //war button, set to enabled
         b1.setEnabled(false);
         b2.setEnabled(true);
      }
   }
   
   /**
      method for button(play)
   */
   private class ButtonListener implements ActionListener
   {
      //actionPerformed method
      public void actionPerformed(ActionEvent e)
      {
         if(!war.ifEmpty(1) && !war.isEmpty(2))//if not empty
         {
            //go to flip method
            flipIt();
            //set images
            String string = "cardPics/"+c1+".jpg";
            front1 = new ImageIcon(string);
            front2 = new ImageIcon("cardPics/"+c2+".jpg");
  
            l1.setIcon(front1);//display image
            l2.setIcon(front2);//display image

         }
         else if (war.isEmpty(1))//if user out of cards
         {
            //diplay loss message
            game.setText("You lost, computer wins");
 
            b1.setEnabled(false);//disable b1
            b2.setEnabled(false);//disable b2
         }
         else if (war.isEmpty(2))//if comp out of cards
         {
            //display message
            game.setText("Computer lost, you win");
            
            //disable buttons
            b1.setEnabled(false);
            b2.setEnabled(false);
         }
         main.setText(war.toString());//set main title text to the war toString
      }
      
   }
  /**
   war button method
   */
   private class ButtonListener2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)//what to do if pressed
      {
         b1.setEnabled(true);//set b1 to enabled
         b2.setEnabled(false);//set b2 to enabled
     
         int w = 0;//w will be used in a do while loop for determining the following
         
         if(war.size(1) >= TWO && war.size(2) >= TWO)//if pile greater than 2 for both
         {
            do
            {        
               if(war.size(1) >= TWO && war.size(2) >= TWO)
               {
                  Card c3, c4;     
                  for (int i = 1; i<= TWO; i++)//loop for war
                  {
                     c3 = war.draw(1);//add cards to list
                     list.add(1,c3);
                     c4 = war.draw(2);
                     list.add(2,c4);      
                  }
                 c3 = (Card)(list.get(2));//remove (get) last card from list
                 c4 = (Card)(list.get(1));
                 
                 //if user card is greater than comp card, user wins
                 if(c3.compareTo(c4) == 1)
                 {
                     //find and set images
                     front1 = new ImageIcon("cardPics/"+c3+".jpg");
                     front2 = new ImageIcon("cardPics/"+c4+".jpg");
                     l1.setIcon(front1);
                     l2.setIcon(front2);
                    
                     Card c5;//temporary object to use
                     
                     for(int i=1; i<=list.size(); i++)//for loop to go through list
                     {
                        c5 = (Card)(war.get(i));
                        war.add(1, c5);//add temporary Card
                     }
                     list.removeAll();//removeAll
                     
                     main.setText(war.toString());//toString
                     game.setText("YOU WON");//print YOUWON
                    
                     w = 1;//w=1 will end the do while loop
                 }
                 
                 //in order for comp to win:
                 if(c3.compareTo(c4) == -1)
                 {
                     front1 = new ImageIcon("cardPics/"+c3+".jpg");
                     front2 = new ImageIcon("cardPics/"+c4+".jpg");
                     l1.setIcon(front1);
                     l2.setIcon(front2);
                     
                     Card c5;//temporary object
                     
                     for(int i=1; i<=list.size(); i++)//for loop to loop through list
                     {
                        c5 = (Card)(list.get(i));
                        war.add(2, c5);//adds temporary card
                     }
                     
                     list.removeAll();//removeAll
                     
                     w = 1;//w=1 will end the do while loop
                     
                     main.setText(war.toString());//toString
                     game.setText("You lose");//print youlose
                 }
                 else//if same
                 {
                     front1 = new ImageIcon("cardPics/"+c3+".jpg");
                     front2 = new ImageIcon("cardPics/"+c4+".jpg");
                     l1.setIcon(front1);
                     l2.setIcon(front2);
                     
                     w = 0;//w=0 continues the do while loop
                     
                     main.setText(war.toString());//toString
                     game.setText("Sorry, you must go to war again");//war again   
                 }
               }
               else if (war.size(1) > war.size(2))//comp runs out of cards?
               {
                  b1.setEnabled(false);//disable b1
                  b2.setEnabled(false);//disable b2
 
                  game.setText("Computer out of cards. YOU WON");//print youwin
               }
               else if (war.size(2) > war.size(1))//user runs out?
               {
                  b1.setEnabled(false);//disable b1
                  b2.setEnabled(false);//disable b2
    
                  game.setText("You've got no cards left. Computer wins.");//print comp wins
               }  
         }while (w < 1); //do while continues while w < 1
      }
   }
  }
}