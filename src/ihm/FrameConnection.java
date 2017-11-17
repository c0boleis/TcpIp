package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrameConnection extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4891593274452416295L;
	
	private WindowAdapter windowAdapter;
	
	private PanelConnectionServer panelConnectionServer;
	
	private PanelConnectionClient panelConnectionClient;
	
	private JPanel panelConversation;
	
	private JTextArea textAreaConversation;
	
	private JTextArea textAreaSendMessage;
	
	private JButton buttonSend;

	public static void main(String[] args) {
		try {
			InetAddress adr = InetAddress.getLocalHost();
			System.out.println(adr.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FrameConnection frame = new FrameConnection();
		frame.setVisible(true);

	}
	
	public FrameConnection() {
		super();
		this.setTitle("TcpIp");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.addWindowListener(getWindowAdapter());
		JPanel panelConnection = new JPanel();
		panelConnection.setLayout(new BoxLayout(panelConnection, BoxLayout.Y_AXIS));
		panelConnection.add(getPanelConnectionServer());
		panelConnection.add(getPanelConnectionClient());
		this.add(panelConnection, BorderLayout.CENTER);
		this.add(getPanelConversation(),BorderLayout.SOUTH);
	}

	private PanelConnectionServer getPanelConnectionServer() {
		if(panelConnectionServer == null) {
			panelConnectionServer = new PanelConnectionServer();
		}
		return panelConnectionServer;
	}

	private PanelConnectionClient getPanelConnectionClient() {
		if(panelConnectionClient == null) {
			panelConnectionClient = new PanelConnectionClient();
		}
		return panelConnectionClient;
	}
	
	private void close() {
		//TODO
		System.exit(0);
	}

	private WindowAdapter getWindowAdapter() {
		if(windowAdapter == null) {
			windowAdapter = new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent e) {
					close();
				}

				@Override
				public void windowClosed(WindowEvent e) {
					close();
				}
				
			};
		}
		return windowAdapter;
	}

	private JTextArea getTextAreaConversation() {
		if(textAreaConversation == null) {
			textAreaConversation = new JTextArea();
		}
		return textAreaConversation;
	}

	private JTextArea getTextAreaSendMessage() {
		if(textAreaSendMessage == null) {
			textAreaSendMessage = new JTextArea();
		}
		return textAreaSendMessage;
	}

	private JButton getButtonSend() {
		if(buttonSend == null) {
			buttonSend = new JButton();
			buttonSend.setText("Send");
			buttonSend.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		return buttonSend;
	}

	public JPanel getPanelConversation() {
		if(panelConversation == null) {
			panelConversation = new JPanel();
			panelConversation.setLayout(new BorderLayout());
			JScrollPane paneConv = new JScrollPane(getTextAreaConversation());
			paneConv.setPreferredSize(new Dimension(400, 150));
			panelConversation.add(paneConv, BorderLayout.CENTER);
			JScrollPane paneSend= new JScrollPane(getTextAreaSendMessage());
			paneSend.setPreferredSize(new Dimension(400, 20));
			panelConversation.add(paneSend, BorderLayout.SOUTH);
			panelConversation.add(getButtonSend(), BorderLayout.EAST);
		}
		return panelConversation;
	}

}
