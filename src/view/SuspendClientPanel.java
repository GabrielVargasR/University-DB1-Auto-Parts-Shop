package view;

import java.awt.FlowLayout;

import javax.swing.*;

public class SuspendClientPanel extends JPanel implements IUIConstants{
	
	private JLabel cedulaLabel;
	private JTextField cedulaEntry;
	private JButton suspendButton;
	
	public SuspendClientPanel() {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 40));
		
		this.cedulaLabel = new JLabel("Cédula:");
		this.cedulaEntry = new JTextField(20);
		this.suspendButton = new JButton("Suspender");
		
		this.add(this.cedulaLabel);
		this.add(cedulaEntry);
		this.add(this.suspendButton);
	}
}
