package pixLab.classes;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
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
   * Constructor that takes the width and height
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
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method to set the red to 0 */
  public void zeroRed()
  {
  	Pixel [][] pixels = this.getPixels2D();
  	for (Pixel[] rowArray : pixels)
  	{
  		for(Pixel pixelObj: rowArray)	
  		{
  			pixelObj.setRed(0);
  		}
  	}
  }
  
  /** Method to set the red to 0 */
  public void zeroGreen()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray: pixels)
		  for (Pixel pixelObj : rowArray)
		  {
			  pixelObj.setGreen(0);
		  }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

  /** Method created as a class to mimic the greyscale method
   *  then set it to brown
   *  mimics a sepia filter*/
  public void classFilter()
  {
	  Pixel[][] imageMatrix = this.getPixels2D();
	  for (int row = 0; row < imageMatrix.length; row++)
		  for(int col = 0; col < imageMatrix[0].length; col++)
		  {
			  Pixel sepiaPixel = imageMatrix[row][col];
			  int averageColor = (sepiaPixel.getRed() + sepiaPixel.getBlue() + sepiaPixel.getGreen()) /3;
		
			  
			  if(averageColor < 80)
			  {
			sepiaPixel.setRed(112);
			sepiaPixel.setGreen(sepiaPixel.getRed()/2);
			sepiaPixel.setBlue(sepiaPixel.getGreen()/3);
			  }
			  else
			  {
				  sepiaPixel.setRed((int) (sepiaPixel.getRed()*.9)); 
				  sepiaPixel.setGreen((int) (sepiaPixel.getRed()*.8 ));
				  sepiaPixel.setBlue((int) (sepiaPixel.getRed()*.4));
				  
			  }
		  }
  }
  
  /** Method created to negate the image. */
  public void negateFilter()
  {
	  Pixel[][] pixel = this.getPixels2D();
	  for(int row = 0; row < pixel.length; row++)
		  for(int col = 0; col < pixel[0].length; col++)
		  {
			  Pixel currentPixel = pixel[row][col];
			  currentPixel.setRed(255 - currentPixel.getRed());
			  currentPixel.setBlue(255 - currentPixel.getBlue());
			  currentPixel.setGreen(255 - currentPixel.getGreen());
		  }
	  
  }

  /** Method to greyscale the image. */
  public void greyscaleFilter()
  {
	  Pixel[][] pixel = this.getPixels2D();
	  
	for(int row = 0; row < pixel.length; row++)
		  for(int col = 0; col < pixel[0].length; col++)
		  {
			  Pixel currentPixel = pixel[row][col];	
			  int averageColor = (currentPixel.getRed() + currentPixel.getGreen() + currentPixel.getBlue()) /3; 
			  currentPixel.setRed(averageColor);
			  currentPixel.setGreen(averageColor);
			  currentPixel.setBlue(averageColor);
		  }
  }
  
  public void fixUnderwater()
  {
	  Pixel[][] pixel = this.getPixels2D();
	  
	for(int row = 0; row < pixel.length; row++)
		  for(int col = 0; col < pixel[0].length; col++)
		  {
			  Pixel currentPixel = pixel[row][col];	  
			  currentPixel.setRed((currentPixel.getRed()) *3);
			  }
		  }
  
  public void randomChange()
  {
	  Pixel[][] imageMatrix = this.getPixels2D();
	  for(int row = 0; row < imageMatrix.length; row+=2)
		  for(int col = 0; col< imageMatrix[0].length; col++)
		  {
			  int randomRed = (int) (Math.random() * 256);
			  int randomBlue = (int) (Math.random() * 256);
			  int randomGreen = (int) (Math.random() * 256);
			  imageMatrix[row][col].setRed(randomRed);
			  imageMatrix[row][col].setBlue(randomBlue);
			  imageMatrix[row][col].setGreen(randomGreen);
		  }
  }
  
/** Method that mirrors the picture around a 
   *  horizontal mirror in the center of the picture 
   *  from top to bottom */
 
public void mirrorHorizontal()
	  {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int height = pixels.length;
		for (int col = 0; col < pixels[0].length; col++)
			{
			  for (int row = 0; row < height / 2; row++)
			  {
				  leftPixel = pixels[row][col];
				  rightPixel = pixels[height - 1 - row][col];
				  rightPixel.setColor(leftPixel.getColor());
			  }
			} 
	}
	  
 public void mirrordiagnal()
 {
Pixel[][] pixels = this.getPixels2D();
Pixel leftPixel = null;
Pixel rightPixel = null;
int height = pixels[0].length;
for (int row = 0; row < pixels.length ; row++)
 {
   for (int col = 0; col < pixels[0].length; col++)
   {
    if ((col < (pixels[0].length)) && (row < (pixels.length - row)))
    {  
   leftPixel = pixels[row][col];
     rightPixel = pixels[col][row];  
     leftPixel.setColor(rightPixel.getColor());
    }
   }
 }
   
 }
 
 public void mirrorArms()
 {
	 Pixel [][] pixels = this.getPixels2D();
			 Pixel leftPixel = null;
			 Pixel rightPixel = null;
			 int height = pixels[0].length;
			 int width = pixels.length;
			 for(int row = 0; row < (pixels.length); row++)
			 {
				 for(int col = 0; col < (pixels[0].length); col++)
				 {
					 if((col <170) && (col > 110) && (row > 155) &&(row <195))
					 {
						leftPixel = pixels[row][col];
						rightPixel = pixels[row+40][col];
						rightPixel.setColor(leftPixel.getColor());				
					 }
				 }
				 
			 }
	 
 }
 
 
 public void mirrorTemple()	  
  /** Mirror just part of a picture of a temple */
  {
	  
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }

  public void edgeDetection2(int edgeDist)
  {
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  Pixel [][] pixels = this.getPixels2D();
	  Color rightColor = null;
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < pixels[0].length-1; col++)
		  {
			  leftPixel = pixels [row][col];
			  rightPixel = pixels [row][col+1];
			  rightColor = rightPixel.getColor();
			  if(leftPixel.colorDistance(rightColor) > edgeDist)
			  {
				  leftPixel.setColor(Color.white);
			  }
			  else
			  {
				  leftPixel.setColor(Color.BLACK);
			  }
		  }
	  }
  }
  
  public void mirrorGull()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  for(int row = 230; row < 330; row++)
	  {
		  for(int col = 230; col < 340; col++)
		  {
			  leftPixel = pixels[row][col];
			  rightPixel = pixels [row] [col + 120];
			  rightPixel.setColor(leftPixel.getColor());
		  }
	  }
  }
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }


  
  
		
	// TODO Auto-generated method stub
	
}
  
 // this } is the end of class Picture, put all new methods before this
