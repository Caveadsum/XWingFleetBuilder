package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import Controller.Control;
import Model.UpgradeCount;

public class IndexedButton extends JButton implements Observer{
	
	protected Control Controller;
	protected int Index;
	//protected UpgradeCount UpgradeCount;
	
	public IndexedButton(int index, Control controller, UpgradeCount upgradeCount)
	{
		super();
		//ViewUpgrade = upgrade;
		Index = index;
		Controller = controller;
		upgradeCount.addObserver(this);
	}
	
	public IndexedButton(int index, Control controller)
	{
		super();
		//ViewUpgrade = upgrade;
		Index = index;
		Controller = controller;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		
	}
	

}
