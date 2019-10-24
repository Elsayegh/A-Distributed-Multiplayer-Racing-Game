import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class DrawCars extends JPanel implements ActionListener
{
   //Add the first Car
   private final static String IMAGE_NAME = "\\goBlack"; //base image name 
   protected ImageIcon images[]; // array of images
   private int currentBlackImage = 12; // current image index
     
   
   //Add Second car
   private final static String RED_CAR = "\\goRed";
   protected ImageIcon redImages[];
   private int currentRedImage = 12;
   
   private final int TOTAL_IMAGES = 16; // number of images
   private final int ANIMATION_DELAY = 50; // millisecond delay
   private int width; // image width
   private int height; // image height

   private Timer animationTimer; // Timer drives animation
   int blackCarX = 50, blackCarY = 50;
   int redCarX = 50, redCarY = 55;


   // constructor initializes cars by loading images
   public DrawCars()
   {
      images = new ImageIcon[ TOTAL_IMAGES ];
      redImages = new ImageIcon[ TOTAL_IMAGES ];
      setFocusable(true);
      
      // load 16 images for each car
      for ( int count = 0; count < images.length; count++ ){
            images[ count ] = new ImageIcon( getClass().getResource
            ("blackCar" + IMAGE_NAME + count + ".png" ) );
            //  all images have the same width and height
            width = images[0].getIconWidth(); // get icon width
            height = images[0].getIconHeight(); // get icon height
            }
            for(int count = 0; count < redImages.length; count++){
            redImages[count] = new ImageIcon( getClass().getResource
            ("redCar" + RED_CAR + count + ".png" ) ); 
            width = images[0].getIconWidth(); // get icon width
            height = images[0].getIconHeight(); // get icon height
         }
         
       animationTimer = new Timer( ANIMATION_DELAY, this);
       animationTimer.start(); // start Timer
       
       }// end LogoAnimatorJPanel constructor
      
       
      public void paintComponent( Graphics g )
      {
      super.paintComponent( g ); // call superclass paintComponent
            
      images[currentBlackImage].paintIcon( this, g, blackCarX, blackCarY );
      redImages[currentRedImage].paintIcon( this, g, redCarX, redCarY );
      }
    
    // return minimum size of animation
    public Dimension getMinimumSize()
    {
      return getPreferredSize(); 
    }
    
    // return preferred size of animation
    public Dimension getPreferredSize()
    {
      return new Dimension( width, height );
    }
    
     public void actionPerformed(ActionEvent e){
      repaint(); // repaint animator
     } 
  }


            

