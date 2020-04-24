package view;

import java.awt.FlowLayout;

import javax.swing.*;

public class AddCarTypePanel extends JPanel implements IUIConstants{
	
	private JLabel partNameLabel;
	private JTextField partNameEntry;
	private JLabel carModelLabel;
	private JTextField carModelEntry;
	private JLabel yearLabel;
	private JTextField yearEntry;

	private JButton linkCarButton;
	
	public AddCarTypePanel() {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 280, 40));

		this.initComponents();

		this.add(this.partNameLabel);
		this.add(this.partNameEntry);
		this.add(this.carModelLabel);
		this.add(this.carModelEntry);
		this.add(this.yearLabel);
		this.add(this.yearEntry);
		this.add(this.linkCarButton);
	}
	
	private void initComponents(){
		this.partNameLabel = new JLabel("Nombre de la parte");
		this.carModelLabel = new JLabel("Modelo del carro");
		this.yearLabel = new JLabel("Año del carro");
		this.partNameEntry = new JTextField(20);
		this.carModelEntry = new JTextField(20);
		this.yearEntry = new JTextField(20);
		
		this.linkCarButton = new JButton("Asociar");
	}
}
