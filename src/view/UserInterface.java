package view;

import javax.swing.*;
import model.IConstants;

public class UserInterface implements IConstants{
	
	private JFrame frame;
	
	public UserInterface() {
		this.frame = new JFrame(WINDOW_NAME);
		this.frame.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);  
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLayout(null);  
		this.frame.setVisible(true); 
	}
	
	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
	}
}
