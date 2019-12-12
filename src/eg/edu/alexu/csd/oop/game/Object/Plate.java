package eg.edu.alexu.csd.oop.game.Object;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import eg.edu.alexu.csd.oop.game.GameObject;

public abstract class Plate extends JPanel implements GameObject  {
	int x=400;
	int y=500;
	BufferedImage[] SpriteImages; 
	int color;
	boolean isVisible=true;
	String type;
	//X and Y 
	
	Plate() throws IOException
	{
		
	}
	Plate(int X,int Y) throws IOException
	{
		this.x=X;
		this.y=Y;
		this.SetSpriteImages();
	}
	public void setType(String type)
	{
		 this.type=type;
	}
	public String getType()
	{
		return type;
	}
	
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public void setX(int x) {
		this.x=x;
		
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y=y;
		
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		int Width=SpriteImages[0].getWidth();
		return Width;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		int Height=SpriteImages[0].getHeight();
		return Height;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return isVisible;
	}
	public void setVisible(boolean Visible)
	{
		this.isVisible=Visible;
	}
	/**
	 * 
	 * @param color
	 * number 0 is the black one 
		//number 1 is the blue one 
		// number 2 is the cyan one
		// number 3 is the darkred one
		// number 4 is the gold one
		// number 5 is the green one
		// number 6 is the orange one 
		// number 7 is the pink
		//number 8 is purple
		// number 9 is red
		// number 10 is yellow
	 */
	public void setColor(int color)
	{
		this.color=color;
		
	}
	public int getColor()
	{
		return color;
	}
	public BufferedImage getImage()
	{
		return SpriteImages[color];
	}

	@Override
	public BufferedImage[] getSpriteImages() {
		// TODO Auto-generated method stub
		return SpriteImages;
	}
	
	public void draw(Graphics g)
	{
		if(isVisible==false)
		{
			return;
		}
		BufferedImage img=this.getImage();
		g.drawImage(img, getX(), getY(), this);
	}
	public  void SetSpriteImages() throws IOException
	{
		BufferedImage[] out=new BufferedImage[11];
		File file;
		String path="plates";
		//System.out.println(type+ " ff");
		String []color= {"black","blue","cyan","darkred"
				,"gold","green","orange","pink","purple","red","yellow"};
		for(int i=0;i<11;i++)
		{
			file=new File(path+"\\"+color[i]+type+".png");
			out[i]=ImageIO.read(file);
		}
		this.SpriteImages=out;
	
	}

}
