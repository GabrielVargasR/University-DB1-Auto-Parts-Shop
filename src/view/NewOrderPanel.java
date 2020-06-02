package view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import controller.OrdenController;

public class NewOrderPanel extends JPanel implements IUIConstants{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JLabel clientIDLabel;
	private JLabel DateLabel;
	private JTextField clientIDEntry;
	private JTextField DateEntry;
	
	private JButton registerOrder;

	private OrdenController controller;

	public NewOrderPanel() {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 280, 40));

		this.initComponents();
		this.controller = new OrdenController();

		this.add(this.clientIDLabel);
		this.add(this.clientIDEntry);
		this.add(this.DateLabel);
		this.add(this.DateEntry);
		this.add(this.registerOrder);
	}
	
	private void initComponents(){

		this.clientIDLabel = new JLabel("Cedula del cliente");
		this.DateLabel = new JLabel("Fecha de la orden");
		this.clientIDEntry = new JTextField(20);
		this.DateEntry = new JTextField(20);
		
		this.registerOrder = new JButton("Agregar");
		this.registerOrder.addActionListener(this.add());
	}

	public ActionListener add() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				String cedula = clientIDEntry.getText();
				String tipo = PERSONA;
				if (cedula.length() == 10) tipo = ORGANIZACION;

				String message = controller.insertarNueva(cedula, tipo, DateEntry.getText());
				System.out.println(message);
			}
		};
		return action;
	}
}
