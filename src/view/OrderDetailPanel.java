package view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

import controller.OrdenController;

public class OrderDetailPanel extends JPanel implements IUIConstants{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JLabel orderIDLabel;
	private JTextField orderIDEntry;
	private JLabel amountLabel;
	private JTextField amountEntry;
	private JLabel partNameLabel;
	private JTextField partNameEntry;
	private JLabel partBrandLabel;
	private JTextField partBrandEntry;
	private JLabel providerNameLabel;
	private JTextField providerNameEntry;

	private JButton associateAmount;

	private OrdenController controller;
	private JLabel mensaje;

	public OrderDetailPanel(JLabel pMessage) {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 280, 40));

		this.initComponents();
		this.mensaje = pMessage;

		this.add(this.orderIDLabel);
		this.add(this.orderIDEntry);
		this.add(this.amountLabel);
		this.add(this.amountEntry);
		this.add(this.partNameLabel);
		this.add(this.partNameEntry);
		this.add(this.partBrandLabel);
		this.add(this.partBrandEntry);
		this.add(this.providerNameLabel);
		this.add(this.providerNameEntry);
		this.add(this.associateAmount);
	}
	
	private void initComponents(){
		this.orderIDLabel = new JLabel("Consecutivo de orden");
		this.amountLabel = new JLabel("Cantiad");
		this.partNameLabel = new JLabel("Nombre de la parte");
		this.partBrandLabel = new JLabel("Marca de la parte");
		this.providerNameLabel = new JLabel("Nombre del proveedor");
		this.orderIDEntry = new JTextField(20);
		this.amountEntry = new JTextField(20);
		this.partNameEntry = new JTextField(20);
		this.partBrandEntry = new JTextField(20);
		this.providerNameEntry = new JTextField(20);
		
		this.associateAmount = new JButton("Asociar");
		this.associateAmount.addActionListener(this.associate());

		this.controller = new OrdenController();
	}

	public ActionListener associate() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				mensaje.setText(controller.asociarDetalle(orderIDEntry.getText(), partNameEntry.getText(), partBrandEntry.getText(), providerNameEntry.getText(), amountEntry.getText()));
			}
		};
		return action;
	}
}
