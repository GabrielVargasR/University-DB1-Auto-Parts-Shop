package view;

import javax.swing.*;
import model.IConstants;

public class UserInterface implements IConstants{
	
	private JFrame frame;
	private JMenuBar menu;
	private JMenu clientsMenu, partsMenu, ordersMenu;
	
	public UserInterface() {
		this.frame = new JFrame(WINDOW_NAME);
		this.frame.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);  
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.menu = new JMenuBar();
		this.clientsMenu = new JMenu(CLIENTS_MENU_TITLE);
		this.partsMenu = new JMenu(PARTS_MENU_TITLE);
		this.ordersMenu = new JMenu(ORDERS_MENU_TITLE);
		
		this.menu.add(clientsMenu);
		this.menu.add(partsMenu);
		this.menu.add(ordersMenu);
		this.frame.setJMenuBar(this.menu);
		
		this.frame.setLayout(null);  
		this.frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
	}
}
