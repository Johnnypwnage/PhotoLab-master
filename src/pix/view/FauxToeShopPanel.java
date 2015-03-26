package pix.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import pix.controller.FauxToeShopController;
import pixLab.classes.ImageDisplay;
import pixLab.classes.Picture;

public class FauxToeShopPanel extends JPanel
{

	private FauxToeShopController baseController;
	private JComboBox filterBox;
	private JScrollPane imagePane;
	private JButton filterButton;
	private SpringLayout baseLayout;
	private Picture basePicture;

	private  void FauxToeShopPanel(FauxToeShopController baseController)
	{
	 this.baseController = baseController;
	 
	 imagePane = new JScrollPane();
	 basePicture = new Picture("beach.jpg");
	 baseLayout = new SpringLayout();
	 
	 setupPicture();
	 setupComboBox();
	 setupPanel();
	 setupLayout();
	 setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(filterBox);
		this.add(imagePane);
	}
	
	private void setupComboBox()
	{
		String [] filterArray = {
				
				"testZeroRed",
				"testZeroBlue",
				"testZeroGreen",						
		};
		
		filterBox = new JComboBox(filterArray);
	}
	
	private void setupPicture()
	{
		BufferedImage bufferedPic = basePicture.getBufferedImage();
		ImageDisplay picDisplay = new ImageDisplay(bufferedPic);
		imagePane.setViewportView(picDisplay);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		 imageBox.addItemListener(new ItemListener()
		 {
			public void itemStateChanged(ItemEvent currentImageEvent)
			{
				loadPicture();
			}
		 
		 });
	
		 filterBox.addItemListener(ItemEvent currentEvent);
		 {
			 if(filterBox.getSelectedIndex() == 1)
			 {
				 loadPicture();
				 basePicture.sepiaTone();
				 setupPicture(); 
			 }
			 else if(filterBox.getSelectedIndex() == 2)
			 {
				 loadPicture();
				 basePicture.greyscaleFilter();
				 setupPicture();
			 }
		 }
		 
	}	 
	
}
