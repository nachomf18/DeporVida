package main;

import java.awt.EventQueue;
import control.PolideportivoListener;
import view.VLogin;
import view.VPrincipal;
import view.VRegistrar;

public class Inicio {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VLogin vLogin = new VLogin();
				VRegistrar vRegistrar = new VRegistrar();
				VPrincipal vPrincipal = new VPrincipal();
				
				PolideportivoListener listener = new PolideportivoListener(vLogin, vPrincipal, vRegistrar);
				
				vPrincipal.setListener(listener);
				vLogin.setListener(listener);
				vRegistrar.setListener(listener);
				
				vLogin.hacerVisible();
			}
		});
	}

}
