package SnapShot;

import java.util.LinkedList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;

public class Originator {

		private  List<GameObject> constant = new LinkedList<GameObject>();
		private  List<GameObject> moving = new LinkedList<GameObject>();
		private  List<GameObject> control = new LinkedList<GameObject>();
	     
	    public Originator(List<GameObject> constant,List<GameObject> moving,List<GameObject> control) {
	        super();
	        this.constant =constant;
	        this.moving = moving;
	        this.control=control;
	    }
	     
	    //Setters and getters
	     
	    public Memento createMemento() 
	    { 
//	    	System.out.println("bnsyev");
	        Memento m = new Memento(constant,moving, control);
	        return m;
	    }
	     
	    public void restore(Memento m) {
	    	this.constant =m.getConstant();
	        this.moving =m.getMoving() ;
	        this.control=m.getControl();
	    }
	 
//	    @Override
//	    public String toString() {
//	        return "Article [id=" + id + ", title=" + title + ", content=" + content + "]";
//	    }
	
}