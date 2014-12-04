import javax.swing.*;

/*
Chrissy Bolognino
CS 110
WarGameDemo
*/

public class WarGameDemo
{
   public static void main(String[] args) 
   {
      JFrame frame = new GUI();//new gui
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//EXIT_ON_CLOSE
      frame.setTitle("The Game of War");//set the frame title
      frame.setSize(10000,7000);//set frame size
      frame.validate();//frame validate
      frame.setVisible(true);//setVisible(true)
   }
}