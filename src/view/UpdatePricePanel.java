package view;

import java.awt.FlowLayout;

import javax.swing.*;

public class UpdatePricePanel extends JPanel implements IUIConstants{

	private JLabel partNameLabel;
	private JLabel providerNameLabel;
	private JLabel providerPriceLabel;
	private JLabel shopPriceLabel;
	private JLabel profitLabel;
	private JTextField partNameEntry;
	private JTextField providerNameEntry;
	private JTextField providerPriceEntry;
	private JTextField shopPriceEntry;
	private JTextField profitEntry;
	
	private JButton addProviderButton;

	public UpdatePricePanel() {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 280, 40));

		this.initComponents();

		this.add(this.partNameLabel);
		this.add(this.partNameEntry);
		this.add(this.providerNameLabel);
		this.add(this.providerNameEntry);
		this.add(this.providerPriceLabel);
		this.add(this.providerPriceEntry);
		this.add(this.shopPriceLabel);
		this.add(this.shopPriceEntry);
		this.add(this.profitLabel);
		this.add(this.profitEntry);
		
		this.add(this.addProviderButton);
	}
	
	private void initComponents(){

		this.partNameLabel = new JLabel("Nombre de parte");
		this.providerNameLabel = new JLabel("Nombre de proveedor");
		this.providerPriceLabel = new JLabel("Precio proveedor");
		this.shopPriceLabel = new JLabel("Precio tienda");
		this.profitLabel = new JLabel("Porcentaje de ganancia");
		this.partNameEntry = new JTextField(20);
		this.providerNameEntry = new JTextField(20);
		this.providerPriceEntry = new JTextField(20);
		this.shopPriceEntry = new JTextField(20);
		this.profitEntry = new JTextField(20);
		
		this.addProviderButton = new JButton("Actualizar");
	}
}
