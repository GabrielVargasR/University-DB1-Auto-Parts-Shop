package view;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

import controller.ParteController;

public class AssociateCarPanel extends JPanel implements IUIConstants{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JLabel partNameLabel;
	private JTextField partNameEntry;
	private JLabel carModelLabel;
	private JTextField carModelEntry;

	private JButton linkCarButton;

	private ParteController controller;
	private JLabel mensaje;
	
	public AssociateCarPanel(JLabel pMesagge) {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 280, 40));

		this.initComponents();
		this.controller = new ParteController();
		this.mensaje = pMesagge;

		this.add(this.partNameLabel);
		this.add(this.partNameEntry);
		this.add(this.carModelLabel);
		this.add(this.carModelEntry);
		this.add(this.linkCarButton);
	}
	
	private void initComponents(){
		this.partNameLabel = new JLabel("ID de la parte");
		this.carModelLabel = new JLabel("ID del carro");
		this.partNameEntry = new JTextField(20);
		this.carModelEntry = new JTextField(20);
		
		this.linkCarButton = new JButton("Asociar");
		this.linkCarButton.addActionListener(this.asociar());
	}
	
	public ActionListener asociar() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				mensaje.setText(controller.asociarAuto(partNameEntry.getText(), carModelEntry.getText()));
			}
		};
		return action;
	}
}
