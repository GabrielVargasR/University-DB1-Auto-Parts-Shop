package view;

import java.awt.FlowLayout;

import javax.swing.*;

public class NewOrderPanel extends JPanel implements IUIConstants{
	
	private JLabel clientNameLabel;
	private JLabel DateLabel;
	private JTextField clientNameEntry;
	private JTextField DateEntry;
	
	private JButton registerOrder;

	public NewOrderPanel() {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 280, 40));

		this.initComponents();

		this.add(this.clientNameLabel);
		this.add(this.clientNameEntry);
		this.add(this.DateLabel);
		this.add(this.DateEntry);
		this.add(this.registerOrder);
	}
	
	private void initComponents(){

		this.clientNameLabel = new JLabel("Nombre del cliente");
		this.DateLabel = new JLabel("Fecha de la orden");
		this.clientNameEntry = new JTextField(20);
		this.DateEntry = new JTextField(20);
		
		this.registerOrder = new JButton("Agregar");	
	}
}
