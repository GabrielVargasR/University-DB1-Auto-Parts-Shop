package view;

import java.awt.FlowLayout;

import javax.swing.*;

public class DeletePartPanel extends JPanel implements IUIConstants{
	
	private JLabel partNameLabel;
	private JTextField partNameEntry;
	private JButton delete;

	public DeletePartPanel() {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 40));
		
		this.partNameLabel = new JLabel("Nombre:");
		this.add(this.partNameLabel);
		
		this.partNameEntry = new JTextField(20);
		this.add(this.partNameEntry);
		
		this.delete = new JButton("Borrar");
		this.add(this.delete);
	}

}
