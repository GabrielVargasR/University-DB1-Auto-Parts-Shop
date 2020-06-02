package view;

import javax.swing.*;
import java.awt.event.*;

import controller.ClienteController;

public class ListClientsPanel extends JPanel implements IUIConstants{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton refresh;
	
	private ClienteController controller;

	public ListClientsPanel() {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);

		this.controller = new ClienteController();
		
		this.refresh = new JButton("Listar");
		this.refresh.addActionListener(this.refreshTable());
		this.add(this.refresh);
		String[][] arr = {};
		this.table = new JTable(arr, CLIENTS);
        this.showTable();
		
	}

	private void showTable() {
        this.scrollPane = new JScrollPane(this.table); 
		this.add(this.scrollPane);
		this.revalidate();
		this.repaint();
	}

	public ActionListener refreshTable() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				scrollPane.setVisible(false);
				String[][] arr = controller.listarClientes();
				table = new JTable(arr, CLIENTS);
				showTable();
			}
		};
		return action;
	}
}
