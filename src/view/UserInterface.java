package view;

//import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UserInterface extends JFrame implements IUIConstants{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 7892095287641077782L;
	private JMenuBar menu;
	private JMenu clientsMenu, partsMenu, ordersMenu;
	private JMenuItem newClientItem, modClientItem, suspendClientItem, listClientsItem;
	private JMenuItem newPartItem, deletePartItem, addProviderItem, addCarTypeItem, updatePriceItem, listCarPartsItem;
	private JMenuItem locateProviderItem, newOrderItem, providerDataItem;
	private JPanel current;
	private JPanel newClientPanel, modClientPanel, suspendClientPanel, listClientsPanel;
	private JPanel newPartPanel, deletePartPanel, addProviderPanel, addCarTypePanel, updatePricePanel, listCarPartsPanel;
	private JPanel locateProviderPanel, newOrderPanel, providerDataPanel;
	private JLabel messageLabel;
	
	public UserInterface() {
		super(WINDOW_NAME);
		super.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);  
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(null);
		super.setResizable(false);
		
		this.createPanels();
		this.createMenu();
		this.setJMenuBar(this.menu);
		
		this.messageLabel = new JLabel("Seleccione una opción del menú");
		this.messageLabel.setHorizontalAlignment(JLabel.CENTER);
		this.messageLabel.setVerticalAlignment(JLabel.CENTER);
		this.messageLabel.setBounds(MESSAGE_LABEL_X, MESSAGE_LABEL_Y, MESSAGE_LABEL_WIDTH, MESSAGE_LABEL_HEIGHT);
		this.add(this.messageLabel);
		
		super.setVisible(true);
	}
	
	private void createMenu() {
		this.menu = new JMenuBar();
		this.clientsMenu = new JMenu(CLIENTS_MENU_TITLE);
		this.partsMenu = new JMenu(PARTS_MENU_TITLE);
		this.ordersMenu = new JMenu(ORDERS_MENU_TITLE);
		
		// Client section
		this.newClientItem = new JMenuItem(NEW_CLIENT_ITEM_TEXT);
		this.modClientItem = new JMenuItem(MOD_CLIENT_ITEM_TEXT);
		this.suspendClientItem = new JMenuItem(SUSPEND_CLIENT_ITEM_TEXT);
		this.listClientsItem = new JMenuItem(LIST_CLIENTS_ITEM_TEXT);
		
		this.newClientItem.addActionListener(this.menuItemListener(this.current, this.newClientPanel));
		this.modClientItem.addActionListener(this.menuItemListener(this.current, this.modClientPanel));
		this.suspendClientItem.addActionListener(this.menuItemListener(this.current, this.suspendClientPanel));
		this.listClientsItem.addActionListener(this.menuItemListener(this.current, this.listClientsPanel));
		
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
		
		this.newPartItem.addActionListener(this.menuItemListener(this.current, this.newPartPanel));
		this.deletePartItem.addActionListener(this.menuItemListener(this.current, this.deletePartPanel));
		this.addProviderItem.addActionListener(this.menuItemListener(this.current, this.addProviderPanel));
		this.addCarTypeItem.addActionListener(this.menuItemListener(this.current, this.addCarTypePanel));
		this.updatePriceItem.addActionListener(this.menuItemListener(this.current, this.updatePricePanel));
		this.listCarPartsItem.addActionListener(this.menuItemListener(this.current, this.listCarPartsPanel));
		
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
		
		this.locateProviderItem.addActionListener(this.menuItemListener(this.current, this.locateProviderPanel));
		this.newOrderItem.addActionListener(this.menuItemListener(this.current, this.newOrderPanel));
		this.providerDataItem.addActionListener(this.menuItemListener(this.current, this.providerDataPanel));
		
		this.ordersMenu.add(this.locateProviderItem);
		this.ordersMenu.add(this.newOrderItem);
		this.ordersMenu.add(this.providerDataItem);
		
		this.menu.add(clientsMenu);
		this.menu.add(partsMenu);
		this.menu.add(ordersMenu);
	}
	
	public ActionListener menuItemListener(JPanel pCurrent, JPanel pNew) {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				if (pCurrent != null) {
					pCurrent.setVisible(false);
				}
				messageLabel.setText("");
				pNew.setVisible(true);
			}
		};
		this.current = pNew;
		return action;
	}
	
	private void createPanels() {
		// Client-related panels
		this.newClientPanel = new NewClientPanel();
		this.modClientPanel = new ModClientPanel();
		this.suspendClientPanel = new SuspendClientPanel();
		this.listClientsPanel = new ListClientsPanel();
		
		this.add(this.newClientPanel);
		this.add(this.modClientPanel);
		this.add(this.suspendClientPanel);
		this.add(this.listClientsPanel);
		
		this.newClientPanel.setVisible(false);
		this.modClientPanel.setVisible(false);
		this.suspendClientPanel.setVisible(false);
		this.listClientsPanel.setVisible(false);
		
		// Parts-related panels
		this.newPartPanel = new NewPartPanel();
		this.deletePartPanel = new DeletePartPanel();
		this.addProviderPanel = new AddProviderPanel();
		this.addCarTypePanel = new AddCarTypePanel();
		this.updatePricePanel = new UpdatePricePanel();
		this.listCarPartsPanel = new ListCarPartsPanel();
		
		this.add(this.newPartPanel);
		this.add(this.deletePartPanel);
		this.add(this.addProviderPanel);
		this.add(this.addCarTypePanel);
		this.add(this.updatePricePanel);
		this.add(this.listCarPartsPanel);
		
		this.newPartPanel.setVisible(false);
		this.deletePartPanel.setVisible(false);
		this.addProviderPanel.setVisible(false);
		this.addCarTypePanel.setVisible(false);
		this.updatePricePanel.setVisible(false);
		this.listCarPartsPanel.setVisible(false);
		
		// Orders-related panels
		this.locateProviderPanel = new LocateProviderPanel();
		this.newOrderPanel = new NewOrderPanel();
		this.providerDataPanel = new ProviderDataPanel();
		
		this.add(this.locateProviderPanel);
		this.add(this.newOrderPanel);
		this.add(this.providerDataPanel);
		
		this.locateProviderPanel.setVisible(false);
		this.newOrderPanel.setVisible(false);
		this.providerDataPanel.setVisible(false);
	}
	
	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
	}
}
