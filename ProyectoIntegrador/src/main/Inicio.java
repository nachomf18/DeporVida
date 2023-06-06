package main;

import java.awt.EventQueue;
import control.PolideportivoListener;
import view.PClases;
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
				PClases pClases = new PClases();
				
				PolideportivoListener listener = new PolideportivoListener(vLogin, vPrincipal, vRegistrar, pClases);
				
				vPrincipal.setListener(listener);
				vLogin.setListener(listener);
				vRegistrar.setListener(listener);
				pClases.setListener(listener);
				
				vLogin.hacerVisible();
			}
		});
	}

}
