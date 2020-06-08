package view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import controller.OrdenController;

public class ReadOrderPanel extends JPanel implements IUIConstants{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel consecutivoOrdenLabel;
    private JTextField consecutivoOrdenEntry;
    private JLabel clienteLabel;
    private JLabel fechaLabel;
    private JLabel montoLabel;
    private JLabel ivaLabel;
    private JLabel totalLabel;

    private JLabel clienteDisplay;
    private JLabel fechaDisplay;
    private JLabel montoDisplay;
    private JLabel ivaDisplay;
    private JLabel totalDisplay;
    
    private JButton search;

	private OrdenController controller;
    private JLabel mensaje;

	public ReadOrderPanel(JLabel pMessage) {
		super();
		super.setBounds(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT);
		super.setOpaque(true);
		super.setLayout(new FlowLayout(FlowLayout.CENTER, 280, 40));

		this.initComponents();
		this.controller = new OrdenController();
		this.mensaje = pMessage;
	}
	
	private void initComponents(){

        this.consecutivoOrdenLabel = new JLabel("Consecutivo de la orden");
        this.consecutivoOrdenEntry = new JTextField(20);
        this.search = new JButton("Buscar");
        this.search.addActionListener(search());

        this.clienteLabel = new JLabel("Cliente:");
        this.fechaLabel = new JLabel("Fecha:");
        this.montoLabel = new JLabel("Monto:");
        this.ivaLabel = new JLabel("IVA:");
        this.totalLabel = new JLabel("Total");
    
        this.clienteDisplay = new JLabel("-------------");
        this.fechaDisplay = new JLabel("-------------");
        this.montoDisplay = new JLabel("-------------");
        this.ivaDisplay = new JLabel("-------------");
        this.totalDisplay = new JLabel("-------------");

        this.add(this.consecutivoOrdenLabel);
        this.add(this.consecutivoOrdenEntry);
        this.add(this.clienteLabel);
        this.add(this.clienteDisplay);
        this.add(this.fechaLabel);
        this.add(this.fechaDisplay);
        this.add(this.montoLabel);
        this.add(this.montoDisplay);
        this.add(this.ivaLabel);
        this.add(this.ivaDisplay);
        this.add(this.totalLabel);
        this.add(this.totalDisplay);
        this.add(this.search);
    }
    
    public ActionListener search() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e){  
                String[] valores = controller.leerOrden(consecutivoOrdenEntry.getText());
                if (valores.length != 1) {
                    clienteDisplay.setText(valores[0]);
                    fechaDisplay.setText(valores[1]);
                    montoDisplay.setText(valores[2]);
                    ivaDisplay.setText(valores[3]);
                    totalDisplay.setText(valores[4]);
                } else mensaje.setText(valores[0]);
			}
		};
		return action;
	}
}