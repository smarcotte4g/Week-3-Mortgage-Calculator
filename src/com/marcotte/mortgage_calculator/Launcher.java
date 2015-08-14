package com.marcotte.mortgage_calculator;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Launcher {

	public static void main(String[] args) 
	{
		// launch the main form
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() 
			{
				MortgageFrame app = new MortgageFrame();
				//app.setBounds(400, 400, 200, 300);
				app.setPreferredSize(new Dimension(200,300));
				app.pack();
				app.setLocationRelativeTo(null);
				app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				app.setVisible(true);
			} 
		});

	}

}
