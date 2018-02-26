package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.Control;
import Model.UpgradeCount;

public class AddUpgradeButton extends IndexedButton{

	public AddUpgradeButton(int index, Control controller) {
		super(index, controller);
		// TODO Auto-generated constructor stub
		addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Controller.on_ApplyUpgrade(Index);
			}
		});
	}
}
