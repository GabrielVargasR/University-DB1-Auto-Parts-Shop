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
	private JLabel partBrandLabel;
	private JTextField partBrandEntry;
	private JLabel carModelLabel;
	private JTextField carModelEntry;
	private JLabel carYearLabel;
	private JTextField carYearEntry;

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
		this.add(this.partBrandLabel);
		this.add(this.partBrandEntry);
		this.add(this.carModelLabel);
		this.add(this.carModelEntry);
		this.add(this.carYearLabel);
		this.add(this.carYearEntry);
		this.add(this.linkCarButton);
	}
	
	private void initComponents(){
		this.partNameLabel = new JLabel("Nombre de la parte");
		this.partBrandLabel = new JLabel("Marca de la parte");
		this.carModelLabel = new JLabel("Modelo del carro");
		this.carYearLabel = new JLabel("Año del carro");
		this.partNameEntry = new JTextField(20);
		this.partBrandEntry = new JTextField(20);
		this.carModelEntry = new JTextField(20);
		this.carYearEntry = new JTextField(20);
		
		this.linkCarButton = new JButton("Asociar");
		this.linkCarButton.addActionListener(this.asociar());
	}
	
	public ActionListener asociar() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				mensaje.setText(controller.asociarAuto(partNameEntry.getText(), partBrandEntry.getText(), carModelEntry.getText(), carYearEntry.getText()));
			}
		};
		return action;
	}
}
