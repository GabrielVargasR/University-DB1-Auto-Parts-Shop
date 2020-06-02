package view;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

import controller.ParteController;

public class AddProviderPanel extends JPanel implements IUIConstants{
	
	/**
	 *
	 */
	private static final long serialVersionUID = -3862319816807643977L;
	private JLabel partNameLabel;
	private JLabel providerNameLabel;
	private JLabel providerPriceLabel;
	private JLabel shopPriceLabel;
	private JTextField partNameEntry;
	private JTextField providerNameEntry;
	private JTextField providerPriceEntry;
	private JTextField shopPriceEntry;
	
	private JButton addProviderButton;

	private ParteController controller;

	public AddProviderPanel() {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 280, 40));

		this.initComponents();
		this.controller = new ParteController();

		this.add(this.partNameLabel);
		this.add(this.partNameEntry);
		this.add(this.providerNameLabel);
		this.add(this.providerNameEntry);
		this.add(this.providerPriceLabel);
		this.add(this.providerPriceEntry);
		this.add(this.shopPriceLabel);
		this.add(this.shopPriceEntry);
		
		this.add(this.addProviderButton);
	}
	
	private void initComponents(){

		this.partNameLabel = new JLabel("ID de parte");
		this.providerNameLabel = new JLabel("ID de proveedor");
		this.providerPriceLabel = new JLabel("Precio proveedor");
		this.shopPriceLabel = new JLabel("Precio tienda");
		this.partNameEntry = new JTextField(20);
		this.providerNameEntry = new JTextField(20);
		this.providerPriceEntry = new JTextField(20);
		this.shopPriceEntry = new JTextField(20);
		
		this.addProviderButton = new JButton("Asociar");
		this.addProviderButton.addActionListener(this.asociar());
	}

	public ActionListener asociar() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				String mensaje = controller.asociarProveedor(partNameEntry.getText(), providerNameEntry.getText(), providerPriceEntry.getText(), shopPriceEntry.getText());
				System.out.println(mensaje);
			}
		};
		return action;
	}
}
