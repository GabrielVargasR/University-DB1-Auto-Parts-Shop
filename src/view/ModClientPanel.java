package view;

//import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ModClientPanel extends JPanel implements IUIConstants{
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
	private JLabel telefonoContactoLabel;
	
	private JComboBox<String> tipoCombo;
	private JTextField nombreEntry;
	private JTextField cedulaEntry;
	private JTextField telefonoEntry;
	private JTextField direccionEntry;
	private JTextField ciudadEntry;
	private JTextField telefonoContactoEntry;
	
	private JButton modInfo;
	
	
	public ModClientPanel() {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 40));
		
		this.initComponents();
		
		this.add(this.cedulaLabel);
		this.add(this.cedulaEntry);
		this.add(this.tipoLabel);
		this.add(this.tipoCombo);
		this.add(this.nombreLabel);
		this.add(this.nombreEntry);
		this.add(this.telefonoLabel);
		this.add(this.telefonoEntry);
		this.add(this.direccionLabel);
		this.add(this.direccionEntry);
		this.add(this.ciudadLabel);
		this.add(this.ciudadEntry);
		this.add(this.telefonoContactoLabel);
		this.add(this.telefonoContactoEntry);
		this.add(this.modInfo);
	}
	
	private void initComponents() {
		this.tipoLabel = new JLabel(TIPO_LABEL);
		this.nombreLabel = new JLabel(NOMBRE_LABEL);
		this.cedulaLabel = new JLabel("Cédula:");
		this.telefonoLabel = new JLabel("Teléfono:");
		this.direccionLabel = new JLabel("Dirección:");
		this.ciudadLabel = new JLabel("Ciudad:");
		this.telefonoContactoLabel = new JLabel("Teléfono de contacto:");
		
		this.nombreEntry = new JTextField(20);
		this.cedulaEntry = new JTextField(20);
		this.telefonoEntry = new JTextField(20);
		this.direccionEntry = new JTextField(20);
		this.ciudadEntry = new JTextField(20);
		this.telefonoContactoEntry = new JTextField(20);
		
		this.modInfo = new JButton("Modificar");
		
		this.tipoCombo = new JComboBox<String>(TIPOS_CLIENTE);
		this.tipoCombo.addActionListener(this.comboListener());
	}
	
	public ActionListener comboListener() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				JComboBox<String> combo = (JComboBox<String>) e.getSource();
		        String tipo = (String)combo.getSelectedItem();
		        System.out.println(tipo);
			}
		};
		return action;
	}
}
