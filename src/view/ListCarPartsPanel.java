package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.ParteController;

public class ListCarPartsPanel extends JPanel implements IUIConstants{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JLabel carModelLabel;
	private JTextField carModelEntry;
	private JLabel yearLabel;
	private JTextField yearEntry;
	
	private JButton searchParts;
	
	private JTable table;
	private JScrollPane scrollPane;
	private JButton newSearchButton;

	private ParteController controller;
	private JLabel mensaje;

	public ListCarPartsPanel(JLabel pMessage) {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 280, 40));

		this.initComponents();
		this.controller = new ParteController();
		this.mensaje = pMessage;

		this.add(this.carModelLabel);
		this.add(this.carModelEntry);
		this.add(this.yearLabel);
		this.add(this.yearEntry);
		
		this.add(this.searchParts);
		this.add(this.newSearchButton);
		this.newSearchButton.setVisible(false);
	}
	
	private void initComponents(){	
		this.carModelLabel = new JLabel("Modelo");
		this.yearLabel = new JLabel("Año");
		this.carModelEntry = new JTextField(20);
		this.yearEntry = new JTextField(20);
		
		this.searchParts = new JButton("Consultar");
		this.searchParts.addActionListener(this.search());
		
		this.newSearchButton = new JButton("Nueva búsqueda");
		this.newSearchButton.addActionListener(this.newSearch());

		String[][] arr = {};
		this.table = new JTable(arr, PARTES_AUTOS);
	}
	
	private void showTable() {
        this.scrollPane = new JScrollPane(this.table); 
        this.add(this.scrollPane);
        
        this.newSearchButton.setVisible(true);
	}
	
	private void hideTable() {
		this.scrollPane.setVisible(false);
		this.newSearchButton.setVisible(false);
	}
	
	private void showSearch() {
		this.carModelLabel.setVisible(true);
		this.carModelEntry.setVisible(true);
		this.yearLabel.setVisible(true);
		this.yearEntry.setVisible(true);
		this.searchParts.setVisible(true);
	}
	
	private void hideSearch() {
		this.carModelLabel.setVisible(false);
		this.carModelEntry.setVisible(false);
		this.yearLabel.setVisible(false);
		this.yearEntry.setVisible(false);
		this.searchParts.setVisible(false);
	}
	
	public ActionListener search() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				hideSearch();
				String[][] partes = controller.listar(carModelEntry.getText(), yearEntry.getText());

				if (partes[0].length == 1){
					mensaje.setText(partes[0][0]);
					partes = new String[][] {};
				}
				table = new JTable(partes, PARTES_AUTOS);
				showTable();
			}
		};
		return action;
	}
	
	public ActionListener newSearch() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				hideTable();
				showSearch();
			}
		};
		return action;
	}
}
