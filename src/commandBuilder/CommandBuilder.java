package commandBuilder;

//import packages
import java.awt.event.*;
import javax.swing.*;

//create class that inherits JFrame and implements the Item and Action Listener interfaces
public class CommandBuilder extends JFrame implements ActionListener, ItemListener {
	
	
	private static final long serialVersionUID = 1L;
	
	//create the objects required
	JTextField cmd, inputIP, inputPck, inputIFace; JLabel IP, ping; JCheckBox pck, iFace, forceProtocol, IPv4, IPv6; JButton btn;
	
	//create the window
	public CommandBuilder(){
		
		//create and configure the text fields
		cmd = new JTextField();
		inputIP = new JTextField();
		inputPck = new JTextField();
		inputIFace = new JTextField();
		
		cmd.setBounds(50, 70, 150, 20);
		inputIP.setBounds(200, 200, 100, 20);
		inputPck.setBounds(200, 250, 100, 20);
		inputIFace.setBounds(200, 300, 100, 20);
		
		inputPck.setEnabled(false);
		inputIFace.setEnabled(false);
		
		//create and configure the label
        IP = new JLabel("IP"); 
        ping = new JLabel("Ping");
        
        IP.setBounds(50, 200, 40, 20);
        ping.setBounds(50, 25, 150, 20);
        
        //create and configure checkboxes
        pck = new JCheckBox("Packet count");
        iFace = new JCheckBox("Interface");
        forceProtocol = new JCheckBox("Force Protocol");
        IPv4 = new JCheckBox("IPv4");
        IPv6 = new JCheckBox("IPv6");
        
        pck.setBounds(50, 250, 100, 20);
        iFace.setBounds(50, 300, 100, 20);
        forceProtocol.setBounds(50, 350, 130, 20);
        IPv4.setBounds(65, 400, 60, 20);
        IPv6.setBounds(135, 400, 60, 20);
        
        pck.addItemListener(this);
        iFace.addItemListener(this);
        forceProtocol.addItemListener(this);
        IPv4.addItemListener(this);
        IPv6.addItemListener(this);
              
        pck.setFocusPainted(false);
        iFace.setFocusPainted(false);
        forceProtocol.setFocusPainted(false);
        IPv4.setFocusPainted(false);
        IPv6.setFocusPainted(false);
        
        IPv4.setEnabled(false);
        IPv6.setEnabled(false);
		
		//create and configure the build button
		btn = new JButton("Build!");
		btn.setBounds(50, 120, 100, 20);
		btn.setFocusPainted(false);
		btn.addActionListener(this);
		
		//init objects on frame
		add(ping);add(btn);add(cmd);add(IP);add(pck);add(iFace);add(forceProtocol);add(IPv4);add(IPv6);add(inputIP);add(inputPck);add(inputIFace);
		
		//init frame
		setTitle("Command Builder");
		setSize(400,500);
		setLayout(null);
		setVisible(true);
		
	}
	
	//write the function for the build button
	
	public void actionPerformed(ActionEvent e) {
		try {
			String ip="", pack="", iface="", ipv4="", ipv6="";
			
			if(pck.isSelected()) {
				pack = "-c "+inputPck.getText()+" ";
			}
			if(iFace.isSelected()) {
				iface = "-I "+inputIFace.getText()+" ";
			}
			if(IPv4.isSelected()) {
				ipv4 = "-4 ";
			}
			if(IPv6.isSelected()) {
				ipv6 = "-6 ";
			}
			
			ip = inputIP.getText();
			cmd.setText("ping "+pack+iface+ipv4+ipv6+ip);
			
		}catch(Exception ex){System.out.println(ex);}
	}
	
	//write the functions for the checkboxes
	@Override
	public void itemStateChanged(ItemEvent e) {
		try {
			if(e.getSource()==pck) {
				if(pck.isSelected()) {
					inputPck.setEnabled(true);
				}else {
					inputPck.setEnabled(false);
					inputPck.setText("");
				}
			}
			if(e.getSource()==iFace) {
				if(iFace.isSelected()) {
					inputIFace.setEnabled(true);
				}else {
					inputIFace.setEnabled(false);
					inputIFace.setText("");
				}
			}
			if(e.getSource()==forceProtocol) {
				if(forceProtocol.isSelected()) {
					IPv4.setEnabled(true);
					IPv6.setEnabled(true);
				}else {
					IPv4.setEnabled(false);
					IPv6.setEnabled(false);
					IPv4.setSelected(false);
					IPv6.setSelected(false);
				}
			}
			if(e.getSource()==IPv4) {
				if(IPv4.isSelected()) {
					IPv6.setSelected(false);
				}
			}
			if(e.getSource()==IPv6) {
				if(IPv6.isSelected()) {
					IPv4.setSelected(false);
				}
			}
			
		}catch(Exception ex){System.out.println(ex);}
	}

	public static void main(String[] args) {
		new CommandBuilder();
		
	}
}