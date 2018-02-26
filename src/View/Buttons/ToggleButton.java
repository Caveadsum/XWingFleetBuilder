package View.Buttons;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ToggleButton extends JButton{

	private Component ComponentToToggle;
	
	public ToggleButton(String text, Component comp)
	{
		ComponentToToggle = comp;
		setText(text);		
		addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ComponentToToggle.setVisible(!ComponentToToggle.isVisible());
			}
		});
	}
}
