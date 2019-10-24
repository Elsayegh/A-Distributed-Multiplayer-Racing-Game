import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

   class AFrame extends JFrame{
      
     public AFrame(){
     this.setTitle("Go-Karte"); // set the form title
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
     this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
     this.setResizable(false); //unable the resize window
    
     //calling the drawcars  
     Container cp = this.getContentPane();
     DrawCars mypanel = new DrawCars();
     cp.add(mypanel);
   }   
   
   public static void main(String[] args){
      AFrame w = new AFrame();
      w.setVisible(true);

   }

}