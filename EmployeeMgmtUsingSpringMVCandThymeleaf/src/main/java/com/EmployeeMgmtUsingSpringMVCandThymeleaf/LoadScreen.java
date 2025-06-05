package com.EmployeeMgmtUsingSpringMVCandThymeleaf;

import java.net.URL;
import javax.swing.*;
import java.awt.*;

public class LoadScreen extends JWindow {
	private JProgressBar progressBar;

	public LoadScreen() {
		// Set the size and position of the splash screen
		setSize(400, 300);
		setLocationRelativeTo(null);
		progressBar = new JProgressBar(0, 100);
		progressBar.setStringPainted(true);
		JLabel label = new JLabel("Employee Management Application", SwingConstants.CENTER);
		//label.setForeground(Color.BLACK);
		//label.setFont(new Font("Arial", Font.BOLD, 20));
		URL url = getClass().getResource("/9c3104985e567ab2095613a493ebbe84.jpg");
		ImageIcon img=new ImageIcon(url);
		JLabel imglab=new JLabel(img);
        imglab.setHorizontalAlignment(JLabel.CENTER); 

		JPanel panel = new JPanel(new BorderLayout());
		panel.add(label,BorderLayout.NORTH);
		panel.add(imglab, BorderLayout.CENTER);
		panel.add(progressBar, BorderLayout.SOUTH);
		getContentPane().add(panel);
		Timer timer = new Timer(500, e -> {
			int progress = progressBar.getValue();
			if (progress < 100) {
				progressBar.setValue(progress + 10);
			} else {
				((Timer) e.getSource()).stop();
				setVisible(false);
				dispose();
			}
		});
		timer.start();
	}
}