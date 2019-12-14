package Levels;

import java.awt.Image;
import java.io.File;
import java.io.IOError;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Level  {
	int currentLevel;
	int PlatesSpeed=1;
	int PlayerSpeed=1;
	int SupportedColors;
	String BackgroundURl;
	Image BackgroundImg;
	public Level(int currentLevel)
	{
		this.currentLevel=currentLevel;
	}
	public int getPlatesSpeed()
	{
		return PlatesSpeed;
	}
	public void setPlatesSpeed(int newPlatesSpeed)
	{
		this.PlatesSpeed=newPlatesSpeed;
	}
	public int getPlayerSpeed()
	{
		return PlayerSpeed;
	}
	public void setPlayerSpeed(int newPlayerSpeed)
	{
		this.PlayerSpeed=newPlayerSpeed;
	}
	public void setBackgroundURl(String Backgroundpath) throws IOException
	{
		
		this.BackgroundURl=Backgroundpath;
		File file=new File(BackgroundURl);
		BackgroundImg=ImageIO.read(file);
	}
	public String getBackgroundURL()
	{
		return BackgroundURl;
	}
	public Image getBackgroundImg()
	{
		return BackgroundImg;
	}
	
	/**
	 * if you want to have a diff background in diff levels
	 * @param colorNumbers
	 */
	public  void setSupportedColors(int colorNumbers)
	{
		SupportedColors=colorNumbers;
	}
	public int getSupportedColors()
	{
		return SupportedColors;
	}
	

}

