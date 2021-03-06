package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.ClienteController;

public class NewClientPanel extends JPanel implements IUIConstants{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JLabel tipoLabel;
	private JLabel nombreLabel;
	private JLabel cedulaLabel;
	private JLabel telefonoLabel;
	private JLabel direccionLabel;
	private JLabel ciudadLabel;
	private JLabel nombreContactoLabel;
	private JLabel telefonoContactoLabel;
	private JLabel cargoContactoLabel;
	
	private JComboBox<String> tipoCombo;
	private JTextField nombreEntry;
	private JTextField cedulaEntry;
	private JTextField telefonoEntry;
	private JTextField direccionEntry;
	private JTextField ciudadEntry;
	private JTextField nombreContactoEntry;
	private JTextField telefonoContactoEntry;
	private JTextField cargoContactoEntry;
	
	private JButton enterInfo;

	private ClienteController controller;
	private String tipoCliente;
	private JLabel mensaje;
	
	
	public NewClientPanel(JLabel pMessage) {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 30));
		
		this.initComponents();
		this.controller = new ClienteController();
		this.mensaje = pMessage;
		
		this.add(this.tipoLabel);
		this.add(this.tipoCombo);
		this.add(this.nombreLabel);
		this.add(this.nombreEntry);
		this.add(this.cedulaLabel);
		this.add(this.cedulaEntry);
		this.add(this.telefonoLabel);
		this.add(this.telefonoEntry);
		this.add(this.direccionLabel);
		this.add(this.direccionEntry);
		this.add(this.ciudadLabel);
		this.add(this.ciudadEntry);
		this.add(this.nombreContactoLabel);
		this.add(this.nombreContactoEntry);
		this.add(this.telefonoContactoLabel);
		this.add(this.telefonoContactoEntry);
		this.add(this.cargoContactoLabel);
		this.add(this.cargoContactoEntry);
		this.add(this.enterInfo);
	}
	
	private void initComponents() {
		this.tipoLabel = new JLabel(TIPO_LABEL);
		this.nombreLabel = new JLabel(NOMBRE_LABEL);
		this.cedulaLabel = new JLabel("Cédula:");
		this.telefonoLabel = new JLabel("Teléfono:");
		this.direccionLabel = new JLabel("Dirección:");
		this.ciudadLabel = new JLabel("Ciudad:");
		this.nombreContactoLabel = new JLabel("Nombre de contacto:");
		this.telefonoContactoLabel = new JLabel("Teléfono de contacto:");
		this.cargoContactoLabel = new JLabel("Cargo de contacto:");
		
		this.nombreEntry = new JTextField(20);
		this.cedulaEntry = new JTextField(20);
		this.telefonoEntry = new JTextField(20);
		this.direccionEntry = new JTextField(20);
		this.ciudadEntry = new JTextField(20);
		this.nombreContactoEntry = new JTextField(20);
		this.telefonoContactoEntry = new JTextField(20);
		this.cargoContactoEntry = new JTextField(20);
		
		this.enterInfo = new JButton("Registrar");
		this.enterInfo.addActionListener(this.insertar());
		
		this.tipoCombo = new JComboBox<String>(TIPOS_CLIENTE);
		this.tipoCombo.addActionListener(this.comboListener());
	}
	
	public ActionListener comboListener() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				JComboBox<String> combo = (JComboBox<String>)e.getSource();
		        String tipo = (String)combo.getSelectedItem();
		        if (tipo.compareTo("Persona") == 0){
					tipoCliente = PERSONA;
				} else tipoCliente = ORGANIZACION;
			}
		};
		return action;
	}

	public ActionListener insertar() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String contacto;
				if (tipoCliente == PERSONA){
					contacto = "0";
				} else contacto = telefonoContactoEntry.getText();
				mensaje.setText(controller.insertarCliente(tipoCliente, nombreEntry.getText(), direccionEntry.getText(), ciudadEntry.getText(), 
								cedulaEntry.getText(), telefonoEntry.getText(), nombreContactoEntry.getText(), contacto, cargoContactoEntry.getText()));
			}
		};
		return action;
	}
}
