import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class DrawCars extends JPanel implements ActionListener, KeyListener
{
   //JButton restartb = new JButton("Restart");
   //JButton startb = new JButton("Start"); 
   //JTextField firstWinner = new JTextField("");
   //setLayout(null);
   //JLabel label = new JLabel("label");
   JButton quitb = new JButton("Quit");

   
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
   int blackCarX = 500, blackCarY = 500;
   int redCarX = 500, redCarY = 550;
   int dsplmnt = 3;
   boolean[] keyArray = new boolean[8];
   
   
   
   // constructor initializes cars by loading images
   public DrawCars()
   {
         
         this.add(quitb); // Add the quit button to the panel.
         quitb.setBounds(20, 0, 80, 60); // Set the location and size of the quit button.
         quitb.addActionListener(this);
         //this.add(label);
         
         //animationTimer.start();
         addKeyListener(this);
         setFocusable(true);
         setFocusTraversalKeysEnabled(false);
         
         images = new ImageIcon[ TOTAL_IMAGES ];
         redImages = new ImageIcon[ TOTAL_IMAGES ];

      // load 16 images
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
            
      Color c1 = Color.green;
      g.setColor( c1 );
      g.fillRect( 150, 200, 550, 300 ); //grass
      
      Color c2 = Color.black;
      g.setColor( c2 );
      g.drawRect(50, 100, 750, 500);  // outer edge
      g.drawRect(150, 200, 550, 300); // inner edge
      
      Color c3 = Color.yellow;
      g.setColor( c3 );
      g.drawRect( 100, 150, 650, 400 ); // mid-lane marker
      
      Color c4 = Color.white;
      g.setColor( c4 );
      g.drawLine( 425, 500, 425, 600 ); // start lin

    } // end method paintComponent

    
 
    
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
    
   //this method to prevent the cars to go out of the track
   public boolean outBound(int c_x, int c_y){

  
            if (c_x < 50){
            
            return true;
            }
            
             else if(c_x > 695 && c_x < 700 && c_y > 170 && c_y < 480)
            {
               return true;
            }
            
            else if(c_x > 125 && c_x < 665 && c_y > 495 && c_y < 500)
            {
               return true;
            }   
            else if(c_x > 30 && c_x < 750 && c_y < 95)
            {
               return true;
            }
            
            else if(c_x > 750){
            return true;
            }
            else if(c_x > 105 && c_x < 110 && c_y > 167 && c_y < 470){
            return true;
            }
            else if(c_y > 550){
            return true;
            }
            else if(c_x > 130 && c_x < 665 && c_y < 160  && c_y > 155)
            {
               return true;
            }

               
    return false;
   } 
   
    public void actionPerformed(ActionEvent e)
    {    //label for testing
         // label.setText("X: "+String.valueOf(blackCarX)+" Y: "+ String.valueOf(blackCarY));
  
         if(e.getSource() == quitb) // If source is the quit button, then continue.
             System.exit(0); // Exit the program. 
             
          
          if(blackCarX == redCarX && blackCarY == redCarY )
          {
            blackCarX = 500; blackCarY = 500;
            redCarX = 500; redCarY = 550;
          }     

             repaint(); // repaint animator   
     }
      
      //key pressed event method, storing the keys into array and set the keys for true when they are clicked which
      //allow events work seperately when there is more than one key clicked.
      public void keyPressed(KeyEvent e)
      {
         int c = e.getKeyCode();
         
         if(c == KeyEvent.VK_LEFT){
            keyArray[0] = true;
         }
         if(c == KeyEvent.VK_UP){
            keyArray[1] = true;
         }

         if(c == KeyEvent.VK_DOWN){
            keyArray[2] = true;
            }

         if(c == KeyEvent.VK_RIGHT){
            keyArray[3] = true;
          }

          if(c == KeyEvent.VK_A){
            keyArray[4] = true;
          }

         if(c == KeyEvent.VK_W){
            keyArray[5] = true;
            }

         if(c == KeyEvent.VK_D){
            keyArray[6] = true;
            }

         if(c == KeyEvent.VK_X){
            keyArray[7] = true;
          }

         
         if(keyArray[0])
         {
            currentBlackImage = 12;
            blackCarX  -= dsplmnt;
            
            if(outBound(blackCarX, blackCarY)){
            blackCarX += dsplmnt;
            }
            if(outBound(blackCarX, blackCarY))
            {
               blackCarX += dsplmnt;
            }
          }

         if(keyArray[1])
        {
           currentBlackImage = 0;
            blackCarY -= dsplmnt; 
                  
                  if(outBound(blackCarX, blackCarY))
                  {
                     blackCarY += dsplmnt;
                  }
                  else if(outBound(blackCarX, blackCarY))
                  {
                     blackCarY += dsplmnt;
                  }
         }
         
          if(keyArray[3])
         { 
            if(currentBlackImage == 15)
               currentBlackImage = 0;
            else
               currentBlackImage++;
               
            moveGoKart(currentImageBlack, );
               
            blackCarX  += dsplmnt;
            if(outBound(blackCarX, blackCarY))
            {
               blackCarX -= dsplmnt;
            }
            else if(outBound(blackCarX, blackCarY))
            {
               blackCarX -= dsplmnt;
            }
         }
           if(keyArray[2])
          {
              currentBlackImage = 8; 
              blackCarY += dsplmnt;
               if(outBound(blackCarX, blackCarY)){
               blackCarY -= dsplmnt;    
           }
           else if(outBound(blackCarX, blackCarY))
           {
            blackCarY -= dsplmnt;
           }
         }
         
         if(keyArray[4])
         {  
         
            currentRedImage = 12;
            redCarX -= dsplmnt;
            if (outBound(redCarX, redCarY)){
            //blackCarX += dsplmnt;
            redCarX += dsplmnt;
            }
            else if(outBound(redCarX, redCarY))
            {
               redCarX += dsplmnt;
            }
         }
         if(keyArray[5])
         {
            currentRedImage = 0;
            redCarY -= dsplmnt;
            if(outBound(redCarX, redCarY))
                  {
                     redCarY += dsplmnt;
                  }
                  else if(outBound(redCarX, redCarY))
                  {
                     redCarY += dsplmnt;
                  }

         }
         if(keyArray[6])
         {
            currentRedImage = 4;
            redCarX += dsplmnt;
            if(outBound(redCarX, redCarY))
            {
               redCarX -= dsplmnt;
            }
            else if(outBound(redCarX, redCarY))
            {
               redCarX -= dsplmnt;
            }
        }
         if(keyArray[7])
         {
            currentRedImage = 9;
            redCarY += dsplmnt;
            if(outBound(redCarX, redCarY)){
               redCarY -= dsplmnt;    
           }
           else if(outBound(redCarX, redCarY))
           {
            redCarY -= dsplmnt;
           }
        }           
   } 
   

    public void keyTyped(KeyEvent e)
    {
      
    }
    //set the keys to false in the array when it's released.
    public void keyReleased(KeyEvent e)
    {
    int c = e.getKeyCode();
         
         if(c == KeyEvent.VK_LEFT){
            keyArray[0] = false;
         }
         if(c == KeyEvent.VK_UP){
            keyArray[1] = false;
         }

         if(c == KeyEvent.VK_DOWN){
            keyArray[2] = false;
            }

         if(c == KeyEvent.VK_RIGHT){
            keyArray[3] = false;
          }

          if(c == KeyEvent.VK_A){
            keyArray[4] = false;
          }

         if(c == KeyEvent.VK_W){
            keyArray[5] = false;
            }

         if(c == KeyEvent.VK_D){
            keyArray[6] = false;
            }

         if(c == KeyEvent.VK_X){
            keyArray[7] = false;
          }

    }
}
      
