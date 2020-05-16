package view;

import javax.swing.*;

public class ListClientsPanel extends JPanel implements IUIConstants{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTable table;
	JScrollPane scrollPane;
	
	public ListClientsPanel() {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		
		String[][] arr = {};
		this.table = new JTable(arr, COLUMN_NAMES);
        this.scrollPane = new JScrollPane(this.table); 
        this.add(this.scrollPane); 
		
	}
}
