package view;

//import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;

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
	private JPanel container;
	private JPanel newClientPanel, modClientPanel, suspendClientPanel, listClientsPanel;
	private JPanel newPartPanel, deletePartPanel, addProviderPanel, addCarTypePanel, updatePricePanel, listCarPartsPanel;
	private JPanel locateProviderPanel, newOrderPanel, providerDataPanel;
	private JLabel messageLabel;
	private CardLayout layout;
	
	public UserInterface() {
		super(WINDOW_NAME);
		super.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);  
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(null);
		super.setResizable(false);
		
		this.createContainer();
		this.createPanels();
		this.createMenu();
		this.setJMenuBar(this.menu);
		this.createMessageLabel();
	}

	private void createContainer(){
		this.container = new JPanel();
		this.layout = new CardLayout();
		this.container.setLayout(this.layout);
		this.container.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		this.container.setOpaque(true);
		this.container.add(new JPanel(), "0");
		super.add(container);
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
		
		this.newClientItem.addActionListener(this.menuItemListener("1"));
		this.modClientItem.addActionListener(this.menuItemListener("2"));
		this.suspendClientItem.addActionListener(this.menuItemListener("3"));
		this.listClientsItem.addActionListener(this.menuItemListener("4"));
		
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
		
		this.newPartItem.addActionListener(this.menuItemListener("5"));
		this.deletePartItem.addActionListener(this.menuItemListener("6"));
		this.addProviderItem.addActionListener(this.menuItemListener("7"));
		this.addCarTypeItem.addActionListener(this.menuItemListener("8"));
		this.updatePriceItem.addActionListener(this.menuItemListener("9"));
		this.listCarPartsItem.addActionListener(this.menuItemListener("10"));
		
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
		
		this.locateProviderItem.addActionListener(this.menuItemListener("11"));
		this.newOrderItem.addActionListener(this.menuItemListener("12"));
		this.providerDataItem.addActionListener(this.menuItemListener("13"));
		
		this.ordersMenu.add(this.locateProviderItem);
		this.ordersMenu.add(this.newOrderItem);
		this.ordersMenu.add(this.providerDataItem);
		
		this.menu.add(clientsMenu);
		this.menu.add(partsMenu);
		this.menu.add(ordersMenu);
	}	
	
	private void createMessageLabel(){
		this.messageLabel = new JLabel("Seleccione una opción del menú");
		this.messageLabel.setHorizontalAlignment(JLabel.CENTER);
		this.messageLabel.setVerticalAlignment(JLabel.CENTER);
		this.messageLabel.setBounds(MESSAGE_LABEL_X, MESSAGE_LABEL_Y, MESSAGE_LABEL_WIDTH, MESSAGE_LABEL_HEIGHT);
		this.add(this.messageLabel);
	}

	private void createPanels() {
		// Client-related panels
		this.newClientPanel = new NewClientPanel();
		this.modClientPanel = new ModClientPanel();
		this.suspendClientPanel = new SuspendClientPanel();
		this.listClientsPanel = new ListClientsPanel();
		
		this.container.add(this.newClientPanel, "1");
		this.container.add(this.modClientPanel, "2");
		this.container.add(this.suspendClientPanel, "3");
		this.container.add(this.listClientsPanel, "4");
		
		// Parts-related panels
		this.newPartPanel = new NewPartPanel();
		this.deletePartPanel = new DeletePartPanel();
		this.addProviderPanel = new AddProviderPanel();
		this.addCarTypePanel = new AddCarTypePanel();
		this.updatePricePanel = new UpdatePricePanel();
		this.listCarPartsPanel = new ListCarPartsPanel();
		
		this.container.add(this.newPartPanel, "5");
		this.container.add(this.deletePartPanel, "6");
		this.container.add(this.addProviderPanel, "7");
		this.container.add(this.addCarTypePanel, "8");
		this.container.add(this.updatePricePanel, "9");
		this.container.add(this.listCarPartsPanel, "10");
		
		// Orders-related panels
		this.locateProviderPanel = new LocateProviderPanel();
		this.newOrderPanel = new NewOrderPanel();
		this.providerDataPanel = new ProviderDataPanel();
		
		this.container.add(this.locateProviderPanel, "11");
		this.container.add(this.newOrderPanel, "12");
		this.container.add(this.providerDataPanel, "13");
	}

	public void display(){
		super.setVisible(true);
	}
	
	public ActionListener menuItemListener(String pIndex) {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				layout.show(container, pIndex);
				messageLabel.setText("");
			}
		};
		return action;
	}

	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		ui.display();
	}
}
