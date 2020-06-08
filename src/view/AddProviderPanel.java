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
	private JLabel partBrandLabel;
	private JLabel providerNameLabel;
	private JLabel providerPriceLabel;
	private JLabel profitLabel;
	private JTextField partNameEntry;
	private JTextField partBrandEntry;
	private JTextField providerNameEntry;
	private JTextField providerPriceEntry;
	private JTextField profitEntry;
	
	private JButton addProviderButton;

	private ParteController controller;
	private JLabel mensaje;

	public AddProviderPanel(JLabel pMensaje) {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 280, 40));

		this.initComponents();
		this.controller = new ParteController();
		this.mensaje = pMensaje;

		this.add(this.partNameLabel);
		this.add(this.partNameEntry);
		this.add(this.partBrandLabel);
		this.add(this.partBrandEntry);
		this.add(this.providerNameLabel);
		this.add(this.providerNameEntry);
		this.add(this.providerPriceLabel);
		this.add(this.providerPriceEntry);
		this.add(this.profitLabel);
		this.add(this.profitEntry);
		
		this.add(this.addProviderButton);
	}
	
	private void initComponents(){

		this.partNameLabel = new JLabel("Nombre de parte");
		this.partBrandLabel = new JLabel("Marca de parte");
		this.providerNameLabel = new JLabel("Nombre de proveedor");
		this.providerPriceLabel = new JLabel("Precio proveedor");
		this.profitLabel = new JLabel("Porcentaje de ganancia");
		this.partNameEntry = new JTextField(20);
		this.partBrandEntry = new JTextField(20);
		this.providerNameEntry = new JTextField(20);
		this.providerPriceEntry = new JTextField(20);
		this.profitEntry = new JTextField(20);
		
		this.addProviderButton = new JButton("Asociar");
		this.addProviderButton.addActionListener(this.asociar());
	}

	public ActionListener asociar() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				mensaje.setText(controller.asociarProveedor(partNameEntry.getText(), partBrandEntry.getText(), providerNameEntry.getText(), providerPriceEntry.getText(), profitEntry.getText()));
			}
		};
		return action;
	}
}
