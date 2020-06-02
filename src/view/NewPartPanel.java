package view;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

import controller.ParteController;

public class NewPartPanel extends JPanel implements IUIConstants{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JLabel nombreParteLabel;
	private JLabel marcaParteLabel;
	private JLabel nombreFabricanteLabel;
	
	private JTextField nombreParteEntry;
	private JTextField marcaParteEntry;
	private JTextField nombreFabricanteEntry;
	
	private JButton registerPart;

	private ParteController controller;
	
	
	public NewPartPanel() {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 280, 40));
		
		this.initComponents();
		this.controller = new ParteController();

		this.add(this.nombreParteLabel);
		this.add(this.nombreParteEntry);
		this.add(this.marcaParteLabel);
		this.add(this.marcaParteEntry);
		this.add(this.nombreFabricanteLabel);
		this.add(this.nombreFabricanteEntry);
		this.add(this.registerPart);
		
	}
	
	private void initComponents() {
		this.nombreParteLabel = new JLabel("Nombre:");
		this.marcaParteLabel = new JLabel("Marca:");
		this.nombreFabricanteLabel = new JLabel("Nombre del Fabricante:");
		
		this.nombreParteEntry = new JTextField(20);
		this.marcaParteEntry = new JTextField(20);
		this.nombreFabricanteEntry = new JTextField(20);
		
		this.registerPart = new JButton("Registrar");
		this.registerPart.addActionListener(this.insertar());
	}

	public ActionListener insertar() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				String mensaje = controller.insertarParte(nombreParteEntry.getText(), marcaParteEntry.getText(), nombreFabricanteEntry.getText());
				System.out.println(mensaje);
			}
		};
		return action;
	}

}
