package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controller.Control;

public class SelectRosterPilotButton extends JButton{
	
	//private Upgrade ViewUpgrade;
	private Control Controller;
	private int Index;
	
	public SelectRosterPilotButton(int index, Control controller)
	{
		super();
		//ViewUpgrade = upgrade;
		Controller = controller;
		Index = index;
		addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Controller.on_SelectRosterPilot(Index);
			}
		});
	}

}
