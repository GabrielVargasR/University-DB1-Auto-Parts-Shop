package view;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

import controller.ClienteController;

public class SuspendClientPanel extends JPanel implements IUIConstants{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JLabel cedulaLabel;
	private JTextField cedulaEntry;
	private JButton suspendButton;
	private ClienteController controller;
	private JLabel mensaje;
	
	public SuspendClientPanel(JLabel pMessage) {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 40));
		
		this.controller = new ClienteController();
		this.mensaje = pMessage;

		this.cedulaLabel = new JLabel("Cédula:");
		this.cedulaEntry = new JTextField(20);
		this.suspendButton = new JButton("Suspender");
		this.suspendButton.addActionListener(this.suspender());
		
		this.add(this.cedulaLabel);
		this.add(cedulaEntry);
		this.add(this.suspendButton);
	}

	public ActionListener suspender() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String cedula = cedulaEntry.getText();
				String cedulaJ = cedula;
				String tipo = PERSONA;
				if (cedula.length() == 10) tipo = ORGANIZACION;

				mensaje.setText(controller.suspenderCliente(tipo, cedula, cedulaJ));
			}
		};
		return action;
	}
}
