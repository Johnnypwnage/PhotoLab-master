package pixLab.classes;
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.zeroRed();
    beach.explore();
  }
 
    /** Method to test keepOnlyGreen */
    public static void testKeepOnlyGreen()
    {
      Picture beach = new Picture("beach.jpg");
      beach.explore();
      beach.zeroBlue();
      beach.zeroRed();
      beach.explore();
    }
    
    /** Method to test keepOnlyRed */
    public static void testKeepOnlyRed()
    {
    	Picture beach = new Picture("beach.jpg");
    	beach.explore();
    	beach.zeroBlue();
    	beach.zeroGreen();
    	beach.explore();
    }
    
    /** Method to test keepOnlyBlue */
    public static void testKeepOnlyBlue()
    {
    	Picture beach = new Picture ("beach.jpg");
    	beach.explore();
    	beach.zeroGreen();
    	beach.zeroRed();
    	beach.explore();
    }
   
    /** Method to test the zeroRed method */
  public static void testZeroRed()
  {
	  Picture redBeach = new Picture("beach.jpg");
	  redBeach.explore();
	  redBeach.zeroRed();
	  redBeach.explore();
  }

  /** Method to test the ClassFilter */
  public static void testSepiaTone()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.classFilter();
	  beach.explore();
  }
  
  /** Method to test negateFilter */
  public static void testNegateFilter()
  {
	Picture beach = new Picture("beach.jpg");
	beach.explore();
	beach.negateFilter();
	beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  public static void testMirrorHorizontal()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.mirrorHorizontal();
	  beach.explore();
  }
  
  /** Method to test mirrorTemple */ 
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Method to test greyscaleFilter */
  public static void testGreyscale()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.greyscaleFilter();
	  beach.explore();
  }
  
  public static void testRandomChange()
  {
	  Picture temple = new Picture("temple.jpg");
	  temple.explore();
	  temple.randomChange();
	  temple.explore();
  }
  
  public static void testFixUnderwater()
  {
	  Picture underwater = new Picture("water.jpg");
	  underwater.explore();
	  underwater.fixUnderwater();
	  underwater.explore();
  }
  
  public static void testMirrorDiagnal()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.mirrordiagnal();
	  beach.explore();
  }
  
  public static void testMirrorArms()
  {
	  Picture arms = new Picture("snowman.jpg");
	  arms.explore();
	  arms.mirrorArms();
	  arms.explore();
  }
  
  public static void testCopy()
  {
	  Picture beach = new Picture("beach.jpg");
	  Picture beachCopy = new Picture("beach2.jpg");
	  beach.explore();
	  beach.copy(beach,0,0);
	  beach.write("beach2.jpg");
	  beachCopy.explore();
  }

  public static void testEdgeDetection2()
  {
	  Picture swan = new Picture("swan.jpg");
	  swan.edgeDetection2(10);
	  swan.explore();
  }
  
  public static void collageImage()
  {
	  Picture gull = new Picture("seagull.jpg");
	  gull.explore();
	  gull.greyscaleFilter();
	  gull.mirrorGull();
	  gull.negateFilter();
	  gull.mirrorHorizontal();
	  gull.explore();
	  gull.write("collage.jpg");	  
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
	//collageImage();
	//fixUnderwater();
    //testZeroBlue();
    //testZeroRed();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
	//testSepiaTone();
    //testNegateFilter();
	//testRandomChange();
    //testGreyscale();
	//testFixUnderwater();
    //testMirrorVertical();
    //testMirrorHorizontal();
    testMirrorDiagnal();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}