package Alerts;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RobotScreenshot {
	
	public static void screenShot(String fileName) throws IOException, AWTException {
		
		//creating robot instance
		Robot robot=new Robot();
		Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect=new Rectangle(dimension);
		BufferedImage bufferedImage=robot.createScreenCapture(rect);
		
		String filePath=System.getProperty("user.dir")+"\\Screenshots\\"+fileName+".png";
		ImageIO.write(bufferedImage,"png",new File(filePath));
	}	

}
