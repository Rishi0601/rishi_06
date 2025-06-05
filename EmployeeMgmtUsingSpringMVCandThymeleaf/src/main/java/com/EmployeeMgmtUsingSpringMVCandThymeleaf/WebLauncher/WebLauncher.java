package com.EmployeeMgmtUsingSpringMVCandThymeleaf.WebLauncher;

import java.awt.Desktop;
import java.net.URI;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class WebLauncher {

	@EventListener(ApplicationReadyEvent.class)
	public void launchBrowser() {
		System.setProperty("java.awt.headless", "false");
		Desktop desktop = Desktop.getDesktop();
		try {
			desktop.browse(new URI("http://localhost:8080/loginpage"));
		} catch (Exception e) {
		}
	}
}