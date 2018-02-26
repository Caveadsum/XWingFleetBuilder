	import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

import Controller.Control;
import Model.FleetManager;
import Model.FleetStorage;
import View.Viewer;
public class FleetBuilder {
	public static void main (String[] args)
	{
		//FleetStorage FleetStorage;
		//if (args.length < 1)
		//{
		//FleetStorage = new FleetStorage();
		//}
		//else
		//{
		//	String filename = args[0];
		//	Manager = new FleetManager(filename);
			//drawModel = new DrawingModel();
		//}
			FleetManager FleetManager = new FleetManager();
			Viewer Viewer = new Viewer(FleetManager);
			FleetManager.FleetStorage().SetView(Viewer);
			
		/*
		JFrame frame = new JFrame ("Drawing Pad");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		//DrawingModel.Test();
		frame.getContentPane().add(new DrawingView(drawModel));
		
		//JMenuBar bar = new JMenuBar();
		//Menu topMenu = new Menu("TOPTEST");
		//bar.add(topMenu);
		//frame.setJMenuBar(bar);

		
		frame.pack();
		frame.setVisible(true);
		*/
	}
}
