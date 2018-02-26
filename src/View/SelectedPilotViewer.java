package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import Controller.Control;
import Model.FleetManager;
import Model.FleetStorage;
import Model.Upgrade;
import Model.UpgradeCount;
import Model.UpgradeSlot;

public class SelectedPilotViewer extends JPanel implements Observer{
	
	FleetStorage Model;
	FleetManager Manager;
	Control Controller;
	JPanel PilotInfo;
	JPanel PilotName;
	JLabel PilotNameLabel;
	JPanel PilotEffect;
	JLabel PilotEffectLabel;
	JLabel PilotCard;
	JPanel PilotUpgrades;
	JButton AssignSelectedPilot;
	JButton RemoveSelectedPilot;
	
	public SelectedPilotViewer(FleetManager manager, Control control)
	{
		Manager = manager;
		Manager.addObserver(this);
		Manager.SelectedPilot().addObserver(this);
		Manager.SelectedUpgrade().addObserver(this);
		Manager.GetRoster().addObserver(this);
		Controller = control;
					
		//move logic to create this to Controller?
		TitledBorder border = BorderFactory.createTitledBorder("Selected Pilot");
		border.setTitleJustification(TitledBorder.RIGHT);
		setBorder(border);
		setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
		
		JPanel assignPilotPanel = new JPanel();
		//assignPilotPanel.setLayout(new BorderLayout());
		RemoveSelectedPilot = new JButton("Remove Pilot from Roster");
		RemoveSelectedPilot.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Controller.on_RemovePilotFromRoster();
			}
		});
		
		AssignSelectedPilot = new JButton("Add Pilot to Roster");
		AssignSelectedPilot.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Controller.on_AddPilotToRoster();
			}
		});
		
		assignPilotPanel.add (RemoveSelectedPilot);
		assignPilotPanel.add (AssignSelectedPilot);
		
		add(assignPilotPanel);
		
		//JPanel with Pilot name and Effect
		PilotInfo = new JPanel();
		PilotInfo.setBorder(BorderFactory.createEtchedBorder());
		PilotInfo.setLayout(new BoxLayout (PilotInfo, BoxLayout.Y_AXIS));
		
		PilotNameLabel = new JLabel(Manager.SelectedPilot().GetSelectedPilot().Name());
		PilotEffectLabel = new JLabel(Manager.SelectedPilot().GetSelectedPilot().Effect());
		UpdatePilotInfo();
		
		PilotName = new JPanel();
		PilotName.add(PilotNameLabel);
		//PilotInfo.add(Box.createRigidArea (new Dimension (0, 10)));
		PilotEffect = new JPanel();
		PilotEffect.add(PilotEffectLabel);

		PilotInfo.add(PilotName);
		PilotInfo.add(PilotEffect);
		add(PilotInfo);
		add(Box.createRigidArea(new Dimension(0, 20)));
		//Buttons for each of the pilot's UpgradeSlots
		PilotUpgrades = new JPanel();
		PilotUpgrades.setLayout (new BoxLayout (PilotUpgrades, BoxLayout.Y_AXIS));
		
		UpdatePilotUpgrades();
		add(PilotUpgrades);

	}
	
	//Updates the Pilot info Panel
	private void UpdatePilotInfo()
	{
		PilotNameLabel.setText(Manager.SelectedPilot().GetSelectedPilot().Name());
		PilotEffectLabel.setText(Manager.SelectedPilot().GetSelectedPilot().Effect());
		//ImageIcon image = new ImageIcon ("View.Images.270px-Han_Solo.png");
		ImageIcon image = new ImageIcon (getClass().getResource("/View/Images/RookiePilot_180px.png"));
		PilotEffectLabel.setIcon(image);
		//ImageIcon ii = new ImageIcon(getClass().getResource("/myFile.gif"));
		//PilotEffect.add(new JLabel(Manager.SelectedPilot().Effect()));
		//JTextArea pilotEffect = new JTextArea(5,5);
		//pilotEffect.setText(Manager.SelectedPilot().Effect());
		//pilotEffect.setEditable(false);
		//PilotEffect.add(pilotEffect);
	}
	
	//Updates the SelectedPilot's upgrade area
	private void UpdatePilotUpgrades()
	{
		PilotUpgrades.removeAll();
		UpgradeSlot[] upgrades = Manager.SelectedPilot().GetSelectedPilot().Upgrades();
		if (upgrades.length > 0)
		{
			for (int i = 0; i < upgrades.length; i++)
			{
				UpgradeCount inList = upgrades[i].Upgrade;
				JPanel upgrade = new JPanel();
				RemoveUpgradeButton remove = new RemoveUpgradeButton(i, Controller);
				remove.setText(Manager.GetRemoveUpgradeButtonText(i));
				remove.setEnabled(Manager.ShouldEnableRemoveUpgradeButton(i));
				upgrade.add(remove);

				upgrade.add(new JLabel(inList.Upgrade().Type().toString() + " : " + inList.Upgrade().Name()));
				
				
				AddUpgradeButton apply = new AddUpgradeButton(i, Controller);//buttons initiate ApplyUpgrade
				apply.setText(Manager.GetApplyUpgradeButtonText(i));
				apply.setEnabled(Manager.ShouldEnableApplyUpgradeButton(i));
				upgrade.add(apply);
				
				PilotUpgrades.add(upgrade);
			}
			validate();
			//super.repaint();
		}
	}
	
	//Enables or Disables Add/Remove Pilot buttons
	private void UpdateRosterButtons()
	{
		AssignSelectedPilot.setText(Manager.GetAddPilotButtonText());
		AssignSelectedPilot.setEnabled(Manager.CanPilotBeAdded());
	}

	@Override
	public void update(Observable o, Object arg) {
		UpdatePilotInfo();
		UpdatePilotUpgrades();
		UpdateRosterButtons();
	}
}
