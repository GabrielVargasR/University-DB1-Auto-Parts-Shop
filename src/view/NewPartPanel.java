package view;

import java.awt.FlowLayout;

import javax.swing.*;

public class NewPartPanel extends JPanel implements IUIConstants{
	
	private JLabel nombreParteLabel;
	private JLabel marcaParteLabel;
	private JLabel nombreFabricanteLabel;
	private JLabel modeloAutoLabel;
	private JLabel anoAutoLabel;
	
	private JTextField nombreParteEntry;
	private JTextField marcaParteEntry;
	private JTextField nombreFabricanteEntry;
	private JTextField modeloAutoEntry;
	private JTextField anoAutoEntry;
	
	private JButton registerPart;
	
	
	public NewPartPanel() {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 280, 40));
		
		this.initComponents();
		
		this.add(this.nombreParteLabel);
		this.add(this.nombreParteEntry);
		this.add(this.marcaParteLabel);
		this.add(this.marcaParteEntry);
		this.add(this.nombreFabricanteLabel);
		this.add(this.nombreFabricanteEntry);
		this.add(this.modeloAutoLabel);
		this.add(this.modeloAutoEntry);
		this.add(this.anoAutoLabel);
		this.add(this.anoAutoEntry);
		this.add(this.registerPart);
		
	}
	
	private void initComponents() {
		this.nombreParteLabel = new JLabel("Nombre:");
		this.marcaParteLabel = new JLabel("Marca:");
		this.nombreFabricanteLabel = new JLabel("Nombre del Fabricante:");
		this.modeloAutoLabel = new JLabel("Modelo del auto de la parte:");
		this.anoAutoLabel = new JLabel("Año del automóvil:");
		
		this.nombreParteEntry = new JTextField(20);
		this.marcaParteEntry = new JTextField(20);
		this.nombreFabricanteEntry = new JTextField(20);
		this.modeloAutoEntry = new JTextField(20);
		this.anoAutoEntry = new JTextField(20);
		
		this.registerPart = new JButton("Registrar");
	}

}
