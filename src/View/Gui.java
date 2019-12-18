package View;
 import java.awt.Color;
 import java.awt.Dimension;

 import java.awt.Toolkit;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;

 import java.io.IOException;

 import java.util.LinkedList;
 import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JMenu;
 import javax.swing.JMenuBar;
 import javax.swing.JMenuItem;

import Logger.LoggerSingle;
import Score.*;
import SnapShot.Memento;
import SnapShot.Originator;
import Objects.*;
 import Players.*;
 import eg.edu.alexu.csd.oop.game.GameEngine;
 import eg.edu.alexu.csd.oop.game.GameObject;
 import eg.edu.alexu.csd.oop.game.World;
 import eg.edu.alexu.csd.oop.game.GameEngine.GameController;
 
 
 public class  Gui implements World {
	 
 	
	Score score = Score.getInstance();
	private static List<GameObject> constant = new LinkedList<GameObject>();
	private static List<GameObject> moving = new LinkedList<GameObject>();
	private static List<GameObject> control = new LinkedList<GameObject>();
	private  List<Memento> mementos = new LinkedList<Memento>();
	//private static List<GameObject> temp = new LinkedList<GameObject>();
	 private static Logger log = LoggerSingle.getInstance();
 	
	private int create=0,iterator=0;
	private int movingObjectsSpeed=50;
	//private boolean caught=false;
	private boolean gameover=false;
	private boolean win=false;
 	

	private PlateFactory pf= PlateFactory.getUniqueInstance();
	private Context context=new Context();
 	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 	private final double width = screenSize.getWidth();
 	private final double height = screenSize.getHeight();
 	
 	
 	  public static void main(String[]agrs) throws IOException {
	  
 			JMenuBar  menuBar = new JMenuBar();
 			JMenu menu = new JMenu("File");
 			JMenuItem newMenuItem = new JMenuItem("New");
 			JMenuItem pauseMenuItem = new JMenuItem("Pause");
 			JMenuItem resumeMenuItem = new JMenuItem("Resume");
 			menu.add(newMenuItem);
 			menu.addSeparator();
 			menu.add(pauseMenuItem);
 			menu.add(resumeMenuItem);
 			menuBar.add(menu);
 			final GameController gameController = GameEngine.start("Circus of plates", new View.Gui(), menuBar, Color.BLACK);
 			newMenuItem.addActionListener(new ActionListener() {
 			@Override public void actionPerformed(ActionEvent e) {
 					gameController.changeWorld(new View.Gui());
 	 				log.setLevel(Level.ALL);
 	 				log.info("game start");
 				}
 			});
 			pauseMenuItem.addActionListener(new ActionListener() {
 			@Override public void actionPerformed(ActionEvent e) {
 					gameController.pause();
 	 				log.setLevel(Level.ALL);
 	 				log.info("game paused");
 				}
 			});
 			resumeMenuItem.addActionListener(new ActionListener() {
 				@Override public void actionPerformed(ActionEvent e) {
 					gameController.resume();
 	 				log.setLevel(Level.ALL);
 	 				log.info("game resumed");
 				}
 			});
 		
 		
 			
 		  
 	  }
 	  public  Gui()  {
 	  constant.clear();
 	  control.clear();
 	  moving.clear();
 	  mementos.clear();
 			try {
 				 
 				//moving.add(new NonBasedPlate(-150,75));
 				
 				 moving.add(pf.GenerateRandomPlate("left"));
 				 moving.add(pf.GenerateRandomPlate("right"));
 			} catch (IOException e) {
 				Logger log = LoggerSingle.getInstance();
 				log.setLevel(Level.ALL);
 				log.severe(e.getMessage());
 				e.printStackTrace();
 			}
 			try {
 				
 				Player clown =new Player("");
 				//Ayman Set Dimensions 
 				//clown.setX(150);
 				//clown.setY(600);
 				//1536  864
 				//Dimensions for screen suitability
 				clown.setX((int)screenSize.getWidth()/2);
 				clown.setY(564*(int)screenSize.getHeight()/864);
 				
 				// Mlhash Lzma now
 				//System.out.println((int)Math.random()*8);
 				//clown.ChoosePlayerCharacter(2);		
 				//clown.SetScaleImage(1, 1);
 				clown.setSpriteImages();
 				//clown.SetScaleImage(100, 100);
 				control.add(clown);
 				
 			} catch (IOException e) {
 				Logger log = LoggerSingle.getInstance();
 				log.setLevel(Level.ALL);
 				log.severe(e.getMessage());
 				e.printStackTrace();
 			}
 		    
 			//Adding two sticks to the clown
 			//670
 			//540
 			control.add(new Stick((int)screenSize.getWidth()*776/1536,(int)screenSize.getHeight()*614/864,0));
			control.add(new Stick((int)screenSize.getWidth()*906/1536,(int)screenSize.getHeight()*614/864,1));
 			
 		 
 		  try {
 			constant.add(new ConstantBar(0,75*(int)screenSize.getHeight()/864));
 			constant.add(new ConstantBar((int)screenSize.getWidth()-constant.get(0).getWidth(),75*(int)screenSize.getHeight()/864));
 			
 			
 			
 			
 		} catch (IOException e) {
 			Logger log = LoggerSingle.getInstance();
			log.setLevel(Level.ALL);
			log.severe(e.getMessage());
 			e.printStackTrace();
 		}
 			  
 	  }
 	
 	@Override
 	public List<GameObject> getConstantObjects() {

 		return constant;
 	}
 
 	@Override
 	public List<GameObject> getMovableObjects() {

 		return moving;
 	}
 
 	@Override
 	public List<GameObject> getControlableObjects() {

 		return control;
 	}
 
 	@Override
 	public int getWidth() {

 		return (int) this.width;
 	}
 
 	@Override
 	public int getHeight() {

 		return (int) this.height-100;
 	}
 
 	@Override
 	public  boolean refresh() {
 		
// 		movingObjectsSpeed=movingObjectsSpeed-(score.getScore()/25);
// 		System.out.println(movingObjectsSpeed);
 		if(!gameover) {
 			Originator originator = new Originator(moving,control);
 			mementos.add(originator.createMemento());
 			
 		}
 		
       if(gameover) {
        	control.clear();
      
        	if(iterator==mementos.size()) {
        		return false;
        	}
      
        	moving= mementos.get(iterator++).getAll();
     
     	   System.out.println("GAMEOVER!");
     	
 
     	  return true;
        }
 		
		  create++;
 		  if(create%15==0) {
 			  try {
 				 moving.add(pf.GenerateRandomPlate("left"));
 				 moving.add(pf.GenerateRandomPlate("right"));
 				
 				  
 			} catch (IOException e) {
				// TODO Auto-generated catch block
 				Logger log = LoggerSingle.getInstance();
 				log.setLevel(Level.ALL);
 				log.severe(e.getMessage());
 				e.printStackTrace();
 			}
 			  create=0;
 		  }


 		  context.SetLists(constant, moving, control);
 		  
 		  moving=context.getmoving();
 		  
 		  control=context.getcontrol();
 		  
 		  win=context.isWin();
 		  
 		  gameover=context.gameOver();
 		  
 		  

         
 		return true;
 	}
 
 	@Override
 	public String getStatus() {

 		return "Score "+ score.getScore();
 	}
 
 	@Override
 	public int getSpeed() {
	
// 		int p = movingObjectsSpeed-(score.getScore()/25);
 		System.out.println("game speeed " );
	return movingObjectsSpeed;
	
 	}
 
 	@Override
 	public int getControlSpeed() {
		return 40;
 	}
 	

 
 }