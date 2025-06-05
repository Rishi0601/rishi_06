package com.EmployeeMgmtUsingSpringMVCandThymeleaf;

import java.io.IOException;
import javax.swing.SwingUtilities;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@EnableScheduling
public class EmployeeMgmtUsingSpringMvCandThymeleafApplication {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			LoadScreen loadScreen = new LoadScreen();
			loadScreen.setVisible(true);
});

		SpringApplication.run(EmployeeMgmtUsingSpringMvCandThymeleafApplication.class, args);
		
	}
}
