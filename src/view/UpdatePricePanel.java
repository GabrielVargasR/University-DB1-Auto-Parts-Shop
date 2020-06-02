package view;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

import controller.ParteController;

public class UpdatePricePanel extends JPanel implements IUIConstants{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
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
	private JLabel mensaje;

	public UpdatePricePanel(JLabel pMessage) {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 280, 40));

		this.initComponents();
		this.controller = new ParteController();
		this.mensaje = pMessage;

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
		
		this.addProviderButton = new JButton("Actualizar");
		this.addProviderButton.addActionListener(this.actualizar());
	}

	public ActionListener actualizar() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				mensaje.setText(controller.actualizarPrecio(partNameEntry.getText(), providerNameEntry.getText(), providerPriceEntry.getText(), shopPriceEntry.getText()));
			}
		};
		return action;
	}
}
