import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List;

/**
   Aakash Pany
   3/18/2021
   
   Picture Class that modifies an image by changing color and vibrancy.
   
 */
 
public class Picture extends SimplePicture
{
   ///////////////////// constructors //////////////////////////////////

   /**
    * Constructor that takes no arguments
    */
   public Picture ()
   {
      /* not needed but use it to show students the implicit call to super()
       * child constructors always call a parent constructor
       */
      super();
   }

   /**
    * Constructor that takes a file name and creates the picture
    * @param fileName the name of the file to create the picture from
    */
   public Picture(String fileName)
   {
      // let the parent class handle this fileName
      super(fileName);
   }

   /**
    * Constructor that takes the height and width
    * @param height the height of the desired picture
    * @param width the width of the desired picture
    */
   public Picture(int height, int width)
   {
      // let the parent class handle this width and height
      super(width,height);
   }

   /**
    * Constructor that takes a picture and creates a
    * copy of that picture
    * @param copyPicture the picture to copy
    */
   public Picture(Picture copyPicture)
   {
      // let the parent class do the copy
      super(copyPicture);
   }

   /**
    * Constructor that takes a buffered image
    * @param image the buffered image to use
    */
   public Picture(BufferedImage image)
   {
      super(image);
   }
   ////////////////////// methods ///////////////////////////////////////

   /**
    * Method to return a string with information about this picture.
    * @return a string with information about the picture such as fileName,
    * height and width.
    */
   public String toString()
   {
      String output = "Picture, filename " + getFileName() +
         " height " + getHeight()
         + " width " + getWidth();
      return output;
   
   }

   /**
     zeroBlue() method sets the blue values at all pixels to zero
  */
   public void zeroBlue()
   {
      Pixel[][] pixels = this.getPixels2D();
   
      for (Pixel[] rowArray : pixels)
      {
         for (Pixel p : rowArray)
         {
            p.setBlue(0);
         }
      }
   }


  /* Add new methods here.
     keepOnlyBlue() method sets the red and green values at all pixels to zero.
     switchColors() method swaps the color values of pixels.
  */
   public void keepOnlyBlue() 
   {
      Pixel[][] pixels = this.getPixels2D();
      
      for(Pixel[] rowArray : pixels) 
      {
         for(Pixel p : rowArray) 
         {
            p.setRed(0);
            p.setGreen(0);
         }
      }  
   }
   
   public void switchColors() 
   {
      Pixel[][] pixels = this.getPixels2D();
      
      for(Pixel[] rowArray : pixels) 
      {
         for(Pixel p : rowArray) 
         {
         
            p.setRed(p.getGreen());      
         }
      }      
   }
   
   public void negate() 
   {
      Pixel[][] pixels = this.getPixels2D();
      
      for(Pixel[] rowArray : pixels) 
      {
         for(Pixel p : rowArray) 
         {
            p.setRed(255 - p.getRed());
            p.setGreen(255 - p.getGreen());
            p.setBlue(255 - p.getBlue());      
         }
      }      
   }   
   
   public void grayScale() 
   {
      Pixel[][] pixels = this.getPixels2D();
      
      for(Pixel[] rowArray : pixels) 
      {
         for(Pixel p : rowArray) 
         {
            p.setRed((p.getRed() + p.getGreen() + p.getBlue())/3);
            p.setGreen((p.getRed() + p.getGreen() + p.getBlue())/3);
            p.setBlue((p.getRed() + p.getGreen() + p.getBlue())/ 3);      
         }
      }      
   }
  
   
   public void mirrorVertical() 
   {
      Pixel[][] pixels = this.getPixels2D();
      for(Pixel[] rowArray: pixels) 
      {
         for(int col = 0; col < pixels.length/2; col++) 
         {
            rowArray[rowArray.length - 1 - col].setRed(rowArray[col].getRed());  
            rowArray[rowArray.length - 1 - col].setGreen(rowArray[col].getGreen());
            rowArray[rowArray.length - 1 - col].setBlue(rowArray[col].getBlue()); 
            rowArray[rowArray.length - 1 - col].setAlpha(rowArray[col].getAlpha());  
         }
      }
   }    


   /* Main method for testing
    */
   public static void main(String[] args)
   {
      Picture arch = new Picture("arch.jpg");
      System.out.println("Original picture:");
      arch.show();
      
      System.out.println("Zero blue:");
      Picture arch1 = new Picture("arch.jpg");
      arch1.zeroBlue();
      arch1.show();
   
      //Uncomment the follow code to test your keepOnlyBlue method.

      Picture arch2 = new Picture("arch.jpg");
      System.out.println("Keep only blue:");
      arch2.keepOnlyBlue();// using new method
      arch2.show();

      
      //Uncomment the follow code to test your swithColors method.

      Picture arch3 = new Picture("arch.jpg");
      System.out.println("Switch colors, set red same as green:");
      arch3.switchColors();// using new method
      arch3.show();
      
      Picture arch4 = new Picture("arch.jpg");
      System.out.println("negate all pixels");
      arch4.negate();
      arch4.show();
      
      Picture arch5 = new Picture("arch.jpg");
      System.out.println("turn the picture into shades of gray");
      arch5.grayScale();
      arch5.show();
      
      Picture arch6 = new Picture("arch.jpg");
      System.out.println("mirror the picture vertically");
      arch6.mirrorVertical();
      arch6.show();      

   }
}