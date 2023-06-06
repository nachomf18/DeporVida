package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import db.PolideportivoPersistencia;
import model.Usuario;
import view.PClases;
import view.VLogin;
import view.VPrincipal;
import view.VRegistrar;

public class PolideportivoListener implements ActionListener {

	private VLogin vLogin;
	private VPrincipal vPrincipal;
	private VRegistrar vRegistrar;
	private PClases pClases;
	private PolideportivoPersistencia pPers;
	
	public PolideportivoListener(VLogin vLogin, VPrincipal vPrincipal, VRegistrar vRegistrar, PClases pClases) {
		this.vLogin = vLogin;
		this.vPrincipal = vPrincipal;
		this.vRegistrar = vRegistrar;
		this.pClases = pClases;
		pPers = new PolideportivoPersistencia();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JMenuItem) {
			if(e.getActionCommand().equals(VPrincipal.MNTM_CLASES)) {
				vPrincipal.cargarPanel(pClases);
			}
		}else if (e.getSource() instanceof JButton) {
			if(e.getActionCommand().equals("Acceder")) {
				verificarUsuario();
			}else if(e.getActionCommand().equals("Registrar")) {
				vLogin.dispose();
				vRegistrar.hacerVisible();
			}else if(e.getActionCommand().equals("Guardar")) {
				addUsuario();
			}else if(e.getActionCommand().equals("Cancelar")) {
				vRegistrar.dispose();
				vLogin.hacerVisible();
			}
		}
	}

	private void addUsuario() {
		Usuario usuario = vRegistrar.obtenerDatos();
		
		if(usuario != null) {
			int res = pPers.addUsuario(usuario);
			
			if (res == 1) {
				vRegistrar.mostrarMensaje("El usuario se ha registrado con éxito", "Resultado de Operación", JOptionPane.INFORMATION_MESSAGE);
				vRegistrar.dispose();
				vLogin.hacerVisible();
				vLogin.cargarUsuario(usuario.getDni());
			}else if (res == -1) {
				vRegistrar.mostrarMensaje("El usuario ya existe", "Error de registro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void verificarUsuario() {
		Usuario usuario = vLogin.obtenerDatos();
		
		if (usuario != null) {
			String resultado = pPers.verficarUsuario(usuario);
			
			if (resultado.equals("Acceso permitido")) {
				vLogin.dispose();
				vPrincipal.hacerVisible();
			}else {
				vLogin.mostrarMensaje(resultado, "Resultado de Consulta", JOptionPane.ERROR_MESSAGE);
			}
		}	
	}
}
