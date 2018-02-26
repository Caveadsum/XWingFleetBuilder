package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controller.Control;
import Model.UpgradeCount;

public class SelectPilotButton extends IndexedButton{
	//private Upgrade ViewUpgrade;
	private Control Controller;
	private int PilotIndex;
	private int TypeIndex;  //for ship type or 0 for AssignedPilots
	
	public SelectPilotButton(int typeIndex, int pilotIndex, Control controller){
		super(pilotIndex, controller);
		//ViewUpgrade = upgrade;
		Controller = controller;
		PilotIndex = pilotIndex;
		TypeIndex = typeIndex;
		addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Controller.on_SelectPilot(TypeIndex, PilotIndex);
			}
		});
	}
	
	public SelectPilotButton(int typeIndex, int pilotIndex, Control controller, UpgradeCount upgradeCount)
	{
	super (pilotIndex, controller, upgradeCount);
	PilotIndex = pilotIndex;
	TypeIndex = typeIndex;
	Controller = controller;
	upgradeCount.addObserver(this);
	addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent event)
		{
			Controller.on_SelectPilot(TypeIndex, Index);
		}
	});
	}
}
