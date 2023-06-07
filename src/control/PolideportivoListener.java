package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import db.PolideportivoPersistencia;
import model.Clase;
import model.Pista;
import model.Usuario;
import view.PClases;
import view.PMiPerfil;
import view.PPistas;
import view.VLogin;
import view.VPrincipal;
import view.VRegistrar;

public class PolideportivoListener implements ActionListener {

	private VLogin vLogin;
	private VPrincipal vPrincipal;
	private VRegistrar vRegistrar;
	private PClases pClases;
	private PPistas pPistas;
	private PMiPerfil pMiPerfil;
	private PolideportivoPersistencia pPers;
	private Usuario usuario;
	
	public PolideportivoListener(VLogin vLogin, VPrincipal vPrincipal, VRegistrar vRegistrar, PClases pClases, PPistas pPistas, PMiPerfil pMiPerfil) {
		this.vLogin = vLogin;
		this.vPrincipal = vPrincipal;
		this.vRegistrar = vRegistrar;
		this.pClases = pClases;
		this.pPistas = pPistas;
		this.pMiPerfil = pMiPerfil;
		pPers = new PolideportivoPersistencia();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JMenuItem) {
			if(e.getActionCommand().equals(VPrincipal.MNTM_CLASES)) {
				vPrincipal.cargarPanel(pClases);
			}else if(e.getActionCommand().equals(VPrincipal.MNTM_PERFIL)) {
				vPrincipal.cargarPanel(pMiPerfil);
			}else if(e.getActionCommand().equals(VPrincipal.MNTM_PISTAS)) {
				vPrincipal.cargarPanel(pPistas);
			}else if(e.getActionCommand().equals(VPrincipal.MNTM_SALIR)) {
				System.exit(0);
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
			}else if(e.getActionCommand().equals("Mostrar Clases")) {
				mostrarClases();
			}else if(e.getActionCommand().equals("Apúntate")) {
				apuntarseClase();
			}else if(e.getActionCommand().equals("Mostrar Pistas")) {
				mostrarPistas();
			}else if(e.getActionCommand().equals("Reserva")) {
				reservarPista();
			}
		}
	}

	private void reservarPista() {
		String fecha = pPistas.obtenerFecha();
		String hora = pPistas.obtenerHora();
		int pos = pPistas.obtenerElementoSeleccionado();
		
		if (pos == -1) {
			pPistas.mostrarMensaje("Debe seleccionar una pista para poder reservarla", "Error de selección", JOptionPane.ERROR_MESSAGE);
		}else {
			String nombre = pPistas.getNombreFila(pos);
			
			String resultado = pPers.comprobarReserva(nombre, fecha, hora);
			
			if(resultado.equals("Pista reservada con éxito")) {
				pPers.addUsuarioPista(nombre, usuario.getDni(), fecha, hora);
		
				pClases.mostrarMensaje(resultado, "Resultado de Operación", JOptionPane.INFORMATION_MESSAGE);
			}else {
				pPistas.mostrarMensaje(resultado, "Resultado de Operación", JOptionPane.INFORMATION_MESSAGE);
			}	
		}
	}

	private void mostrarPistas() {
		String deporte = pPistas.obtenerDeporte();
		
		ArrayList<Pista> listaPistas = pPers.filtrarPista(deporte);
		
		if(listaPistas.isEmpty()) {
			pPistas.mostrarTabla(false);
			pPistas.mostrarMensaje("No se han encontrado datos para el deporte seleccionado", "Resultado de Operación", JOptionPane.INFORMATION_MESSAGE);
		}else {
			pPistas.mostrarTabla(true);
			pPistas.rellenarTabla(listaPistas);
		}
	}

	private void apuntarseClase() {
		int pos = pClases.obtenerElementoSeleccionado();
		
		if (pos == -1) {
			pClases.mostrarMensaje("Debe seleccionar una clase para apuntarse", "Error de selección", JOptionPane.ERROR_MESSAGE);
		}else {
			int opcion = JOptionPane.showConfirmDialog(null, "Va a apuntarse a una clase, ¿desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			
			if (opcion == JOptionPane.YES_OPTION) {
				String nombre = pClases.getNombreFila(pos);
				
				int res = pPers.addUsuarioClase(nombre, usuario.getDni());
				
				if (res == -1) {
					pClases.mostrarMensaje("No se ha podido apuntar a la clase correctamente debido a que usted ya está apuntado en esta clase", "Resultado de Operación", JOptionPane.ERROR_MESSAGE);
				}else {
					pClases.mostrarMensaje("Se ha apuntado a la clase correctamente", "Resultado de Operación", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	private void mostrarClases() {
		String deporte = pClases.obtenerDeporte();
		
		ArrayList<Clase> listaClases = pPers.filtrarClase(deporte);
		
		if(listaClases.isEmpty()) {
			pClases.mostrarTabla(false);
			pClases.mostrarMensaje("No se han encontrado datos para el deporte seleccionado", "Resultado de Operación", JOptionPane.INFORMATION_MESSAGE);
		}else {
			pClases.mostrarTabla(true);
			pClases.rellenarTabla(listaClases);
			
			if(!deporte.equals("Todos")) {
				pClases.rellenarCaja(listaClases);
			}			
		}
	}

	private void addUsuario() {
		Usuario usuarioNuevo = vRegistrar.obtenerDatos();
		
		if(usuarioNuevo != null) {
			int res = pPers.addUsuario(usuarioNuevo);
			
			if (res == 1) {
				vRegistrar.mostrarMensaje("El usuario se ha registrado con éxito", "Resultado de Operación", JOptionPane.INFORMATION_MESSAGE);
				vRegistrar.dispose();
				vLogin.hacerVisible();
				vLogin.cargarUsuario(usuarioNuevo.getDni());
			}else if (res == -1) {
				vRegistrar.mostrarMensaje("El usuario ya existe", "Error de registro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void verificarUsuario() {
		usuario = vLogin.obtenerDatos();
		
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
