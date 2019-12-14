package Players;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Stick extends JPanel implements GameObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private int type; // 0 --> left , 1 --> right
	
	public Stick( int x , int y , int type  ){
		this.x=x-this.getWidth();
		this.y=y-this.getHeight();
		this.type= type ;
		setX(this.x);
		setY(this.y);
	}
	@Override

	public int getX() {

		return x;
	}

	@Override
	public void setX(int x) {

		this.x=x;
	}

	@Override
	public int getY() {

		return y;
	}

	@Override
	public void setY(int y) {

		this.y=y;
	}

	@Override
	public int getWidth() {

		return getSpriteImages()[0].getWidth();
	}

	@Override
	public int getHeight() {

		return getSpriteImages()[0].getHeight();
	}

	@Override
	public boolean isVisible() {

		return true;
	}

	@Override
	public BufferedImage[] getSpriteImages() {

		File file =new File("sticks\\"+type+"stick-resized.png");
		BufferedImage img[]=new BufferedImage[1];
		try {
			img[0]=ImageIO.read(file);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return img;
		
		
	}

}
