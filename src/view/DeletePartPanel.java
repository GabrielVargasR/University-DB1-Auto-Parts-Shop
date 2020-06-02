package view;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

import controller.ParteController;

public class DeletePartPanel extends JPanel implements IUIConstants{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JLabel partNameLabel;
	private JTextField partNameEntry;
	private JLabel partBrandLabel;
	private JTextField partBrandEntry;	
	private JButton delete;

	private ParteController controller;

	public DeletePartPanel() {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 40));
		
		this.controller = new ParteController();

		this.partNameLabel = new JLabel("Nombre:");
		this.add(this.partNameLabel);
		
		this.partNameEntry = new JTextField(20);
		this.add(this.partNameEntry);

		this.partBrandLabel = new JLabel("Marca:");
		this.add(this.partBrandLabel);
		
		this.partBrandEntry = new JTextField(20);
		this.add(this.partBrandEntry);
		
		this.delete = new JButton("Borrar");
		this.delete.addActionListener(this.borrar());
		this.add(this.delete);
	}

	public ActionListener borrar() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				String mensaje = controller.borrarParte(partNameEntry.getText(), partBrandEntry.getText());
				System.out.println(mensaje);
			}
		};
		return action;
	}

}
