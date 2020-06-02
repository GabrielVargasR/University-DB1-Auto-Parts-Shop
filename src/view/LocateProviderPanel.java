package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import controller.OrdenController;

public class LocateProviderPanel extends JPanel implements IUIConstants{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JLabel partName;
	private JTextField partNameEntry;

	private JLabel partBrand;
	private JTextField partBrandEntry;
	
	private JButton search;
	private JButton newSearchButton;
	
	private JTable table;
	private JScrollPane scrollPane;

	private OrdenController controller;
	private JLabel mensaje;

	public LocateProviderPanel(JLabel pMessage) {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 280, 40));

		this.initComponents();
		this.controller = new OrdenController();
		this.mensaje = pMessage;
		
		this.add(this.partName);
		this.add(this.partNameEntry);
		this.add(this.partBrand);
		this.add(this.partBrandEntry);
		this.add(this.search);
		this.add(this.newSearchButton);
		this.newSearchButton.setVisible(false);
	}
	
	private void initComponents() {
		this.partName = new JLabel("Nombre de la parte");
		this.partNameEntry = new JTextField(20);

		this.partBrand = new JLabel("Marca de la parte");
		this.partBrandEntry = new JTextField(20);
		
		this.search = new JButton("Buscar");
		this.search.addActionListener(this.search());
		
		this.newSearchButton = new JButton("Nueva búsqueda");
		this.newSearchButton.addActionListener(this.newSearch());

		String[][] arr = {};
		this.table = new JTable(arr, LOCATE_PROVIDERS);
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
		this.partName.setVisible(true);
		this.partNameEntry.setVisible(true);
		this.partBrand.setVisible(true);
		this.partBrandEntry.setVisible(true);
		this.search.setVisible(true);
	}
	
	private void hideSearch() {
		this.partName.setVisible(false);
		this.partNameEntry.setVisible(false);
		this.partBrand.setVisible(false);
		this.partBrandEntry.setVisible(false);
		this.search.setVisible(false);
	}
	
	public ActionListener search() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				hideSearch();
				String[][] proveedores = controller.localizarProveedores(partNameEntry.getText(), partBrandEntry.getText());

				if (proveedores[0].length == 1){
					mensaje.setText(proveedores[0][0]);
					proveedores = new String[][] {};
				}

				table = new JTable(proveedores, LOCATE_PROVIDERS);
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
