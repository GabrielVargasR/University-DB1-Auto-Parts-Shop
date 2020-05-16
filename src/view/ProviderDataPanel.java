package view;

import java.awt.FlowLayout;

import javax.swing.*;

public class ProviderDataPanel extends JPanel implements IUIConstants{
	
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
	private JLabel providerNameLabel;
	private JTextField providerNameEntry;

	private JButton associateAmount;


	public ProviderDataPanel() {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 280, 40));

		this.initComponents();

		this.add(this.orderIDLabel);
		this.add(this.orderIDEntry);
		this.add(this.amountLabel);
		this.add(this.amountEntry);
		this.add(this.partNameLabel);
		this.add(this.partNameEntry);
		this.add(this.providerNameLabel);
		this.add(this.providerNameEntry);
		this.add(this.associateAmount);
	}
	
	private void initComponents(){
		this.orderIDLabel = new JLabel("Consecutivo de orden");
		this.amountLabel = new JLabel("Cantiad");
		this.partNameLabel = new JLabel("Nombre de la parte");
		this.providerNameLabel = new JLabel("Nombre del proveedor");
		this.orderIDEntry = new JTextField(20);
		this.amountEntry = new JTextField(20);
		this.partNameEntry = new JTextField(20);
		this.providerNameEntry = new JTextField(20);
		
		this.associateAmount = new JButton("Asociar");
	}
}
