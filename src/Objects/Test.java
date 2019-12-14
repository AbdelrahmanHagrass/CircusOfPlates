package Objects;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JPanel {
int x=20;
int ads=(int) ((Math.random()*11));
ArrayList<Plate> list=new ArrayList<Plate>();
public Test() throws IOException
{
	this.setFocusable(true);
    this.requestFocusInWindow();
    Image img = createImageWithText();
    PlateFactory b=new PlateFactory().getInstance();
   // System.out.println(System.identityHashCode(b));
    b.setSupportedColors(11);
    list.add(b.GenerateRandomPlate());
 
   // g.drawImage(img,50,50,this);
	
	  final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
	    executorService.scheduleAtFixedRate(new Runnable() {
	        @Override
	        public void run() {	
	        	
	       x++;
	       
	          repaint();
	          
	        }
	    }, 2000, 80, TimeUnit.MILLISECONDS);
}
   public void paint(Graphics g) {
	   super.paint(g);
      Image img = createImageWithText();
<<<<<<< Upstream, based on origin/ayman
    
      Plate a = null;
	try {
		a = new NonBasedPlate(50,50);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//System.out.println("sd");
	
	
	
	
	   a.setColor(2);
	   img=a.getImage();
	  // System.out.println();
	  //a.draw(g);
	   a.setX(60+x*10);
       
  //g.drawImage(img, 50-100,50, this);
	  // g.drawImage(img, 50,50, this);
	   a.draw(g);
	   g.drawLine(0, 10+x*10, 20, 30);
=======
      for(int i=0;i<list.size();i++)
      {
    	  Plate a=list.get(i);
    	  a.setX(50+i*20);
    	  a.setY(50+i*20);
    	//  a.draw(g);
    	  BufferedImage[]out=a.getSpriteImages();
    	  g.drawImage(out[0], 50+i*20,50+i*20, this);
    	  
      }
  /*
     Plate a = null;
	try {
		a = b.GenerateRandomPlate();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  	
  	a.setX(50);
  	a.setY(50);
  //	a.draw(g);
  	//System.out.println("sd");
  	
  	 //g.drawImage(img, 50,50, this);
  	
  	
  	   //img=a.getImage();
  	  // System.out.println();
  	  //a.draw(g);
  	   a.setX(60+x*10);
   
    //g.drawImage(img, 50-100,50, this);
  	  // g.drawImage(img, 50,50, this);
  	   a.draw(g);
  	   */
>>>>>>> 0d885cf jkk
	   repaint();
        

      //g.drawImage(img,50,50,this);
   }
	public static final int SPRITE_WIDTH = 40;
   private Image createImageWithText() {
      BufferedImage bufferedImage =new BufferedImage(200, 200,	BufferedImage.TYPE_INT_ARGB);
      Graphics g = bufferedImage.getGraphics();
      int a=1;
      File file;
      if(a==1)
     file =new File("C:\\Users\\OWNER\\git\\circusofplates6\\plates\\goldplatewithdeepbase.png");
      else
      {
    	  file=new File("C:\\Users\\OWNER\\git\\circusofplates6\\plates\\blackplatewithdeepbase.png");
      }
      BufferedImage bufferedImage2=null;
      try {
		 bufferedImage2 =ImageIO.read(file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
	//Graphics g2=bufferedImage2.getGraphics();
	//g2.drawImage(bufferedImage2, 0, 0, 200, 200, null);
	/*
      g.drawString("www.tutorialspoint.com", 20,20);
      g.drawString("www.tutorialspoint.com", 20,40);
      g.drawString("www.tutorialspoint.com", 20,60);
      g.drawString("www.tutorialspoint.com", 20,80);
      g.drawString("www.tutorialspoint.com", 20,100);
      
      */
      //System.out.println(bufferedImage2.getWidth()+ "dd");
      return bufferedImage2;
   }
   
   public static void main(String[] args) throws IOException {
	 
      JFrame frame = new JFrame();
      frame.getContentPane().add(new Test());

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400, 400);
      frame.setVisible(true);
      
   }
}