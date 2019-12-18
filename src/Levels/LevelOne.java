package Levels;

import java.awt.Color;

import Objects.PlateFactory;

public class LevelOne extends Level
{
	
	public Color lvlColor = Color.white;
	public static Level L1=null;
	public LevelOne()
	{
		setcurrentLevel(1);
		setPlatesSpeed(50);
		setSupportedColors(3);
		setLevelLimits();
	}
	public static  Level getInstance() {
		if(L1==null)
		{
			L1=new LevelOne();
		}
		return L1;
	}

	@Override
	public Level getMylevel() {
		// TODO Auto-generated method stub
		return getInstance();
	}
	@Override
	public Level UpgradeLevel() {
		// TODO Auto-generated method stub
		return LevelTwo.getInstance();
	}
	@Override
	public void setLevelLimits() {
		this.begin=0;
		this.end=50;
		
	}
	@Override
	public Color getBackground()
	{
		return this.lvlColor;
	}
	@Override
	public int getPlatesSpeed()
	{
		return 10;
	}
	
	

}
