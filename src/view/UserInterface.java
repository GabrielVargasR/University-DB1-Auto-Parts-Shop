package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import model.IConstants;

public class UserInterface implements IConstants{
	
	private JFrame frame;
	private JMenuBar menu;
	private JMenu clientsMenu, partsMenu, ordersMenu;
	private JMenuItem newClientItem, modClientItem, suspendClientItem, listClientsItem;
	private JMenuItem newPartItem, deletePartItem, addProviderItem, addCarTypeItem, updatePriceItem, listCarPartsItem;
	private JMenuItem locateProviderItem, newOrderItem, providerDataItem;
	
	public UserInterface() {
		this.frame = new JFrame(WINDOW_NAME);
		this.frame.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);  
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.createMenu();
		this.frame.setJMenuBar(this.menu);
		
		this.frame.setLayout(null);  
		this.frame.setVisible(true);
	}
	
	public void createMenu() {
		this.menu = new JMenuBar();
		this.clientsMenu = new JMenu(CLIENTS_MENU_TITLE);
		this.partsMenu = new JMenu(PARTS_MENU_TITLE);
		this.ordersMenu = new JMenu(ORDERS_MENU_TITLE);
		
		// Client section
		this.newClientItem = new JMenuItem(NEW_CLIENT_ITEM_TEXT);
		this.modClientItem = new JMenuItem(MOD_CLIENT_ITEM_TEXT);
		this.suspendClientItem = new JMenuItem(SUSPEND_CLIENT_ITEM_TEXT);
		this.listClientsItem = new JMenuItem(LIST_CLIENTS_ITEM_TEXT);
		
		this.newClientItem.addActionListener(this.newClientMenuListener());
		
		this.clientsMenu.add(this.newClientItem);
		this.clientsMenu.add(this.modClientItem);
		this.clientsMenu.add(this.suspendClientItem);
		this.clientsMenu.add(this.listClientsItem);
		
		// Parts section
		this.newPartItem = new JMenuItem(NEW_PART_ITEM_TEXT);
		this.deletePartItem = new JMenuItem(DELETE_PART_ITEM_TEXT);
		this.addProviderItem = new JMenuItem(ADD_PROVIDER_ITEM_TEXT);
		this.addCarTypeItem = new JMenuItem(ADD_CAR_TYPE_ITEM_TEXT);
		this.updatePriceItem = new JMenuItem(UPDATE_PRICE_ITEM_TEXT);
		this.listCarPartsItem = new JMenuItem(LIST_CAR_PARTS_ITEM_TEXT);
		
		this.partsMenu.add(this.newPartItem);
		this.partsMenu.add(this.deletePartItem);
		this.partsMenu.add(this.addProviderItem);
		this.partsMenu.add(this.addCarTypeItem);
		this.partsMenu.add(this.updatePriceItem);
		this.partsMenu.add(this.listCarPartsItem);
		
		// Orders section
		this.locateProviderItem = new JMenuItem(LOCATE_PROVIDER_ITEM_TEXT);
		this.newOrderItem = new JMenuItem(NEW_ORDER_ITEM_TEXT);
		this.providerDataItem = new JMenuItem(PROVIDER_DATA_ITEM_TEXT);
		
		this.ordersMenu.add(this.locateProviderItem);
		this.ordersMenu.add(this.newOrderItem);
		this.ordersMenu.add(this.providerDataItem);
		
		this.menu.add(clientsMenu);
		this.menu.add(partsMenu);
		this.menu.add(ordersMenu);
	}
	
	public ActionListener newClientMenuListener() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				System.out.println("lskauf");
			}
		};
		return action;
	}
	
	
	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
	}
}
