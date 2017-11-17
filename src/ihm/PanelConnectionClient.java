package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelConnectionClient extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7673958598150022247L;
	
	private JButton buttonConnection;
	
	private JLabel labelStatus;
	
	private JTextField textFieldIP;
	
	public PanelConnectionClient() {
		this.setLayout(new BorderLayout());
		this.add(getLabelStatus(), BorderLayout.WEST);
		this.add(getTextFieldIP(), BorderLayout.CENTER);
		this.add(getButtonConnection(), BorderLayout.EAST);
		this.setPreferredSize(new Dimension(400, 20));
		this.setBorder(new TitledBorder( "Client"));
	}
	
	private JButton getButtonConnection() {
		if(buttonConnection == null) {
			buttonConnection = new JButton();
			buttonConnection.setText("Connect");
			buttonConnection.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		return buttonConnection;
	}

	private JLabel getLabelStatus() {
		if(labelStatus == null) {
			labelStatus = new JLabel();
			labelStatus.setText("KO");
			labelStatus.setOpaque(true);
			labelStatus.setBackground(Color.red);
		}
		return labelStatus;
	}

	private JTextField getTextFieldIP() {
		if(textFieldIP == null) {
			textFieldIP = new JTextField();
		}
		return textFieldIP;
	}


}
