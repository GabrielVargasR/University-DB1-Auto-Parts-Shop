package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LocateProviderPanel extends JPanel implements IUIConstants{
	
	private JLabel partName;
	private JTextField partNameEntry;
	
	private JButton search;
	private JButton newSearchButton;
	
	private JTable table;
	private JScrollPane scrollPane;

	public LocateProviderPanel() {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 280, 40));

		this.initComponents();
		
		this.add(this.partName);
		this.add(this.partNameEntry);
		this.add(this.search);
		this.add(this.newSearchButton);
		this.newSearchButton.setVisible(false);
	}
	
	private void initComponents() {
		this.partName = new JLabel("Nombre de la parte");
		this.partNameEntry = new JTextField(20);
		
		this.search = new JButton("Buscar");
		this.search.addActionListener(this.search());
		
		this.newSearchButton = new JButton("Nueva búsqueda");
		this.newSearchButton.addActionListener(this.newSearch());
		
	}
	
	private void showTable() {
		String[][] arr = {};
		this.table = new JTable(arr, LOCATE_PROVIDERS);
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
		this.search.setVisible(true);
	}
	
	private void hideSearch() {
		this.partName.setVisible(false);
		this.partNameEntry.setVisible(false);
		this.search.setVisible(false);
	}
	
	public ActionListener search() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				hideSearch();
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
