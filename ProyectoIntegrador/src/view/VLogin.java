package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import control.PolideportivoListener;
import model.Usuario;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class VLogin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int ANCHO = 400;
	public static final int ALTO = 200;
	public static final String BTN_ACCEDER = "Acceder";
	public static final String BTN_REGISTRAR = "Registrar";
	
	private JTextField txtDni;
	private JPasswordField pwdPassword;
	private JButton btnAcceder;
	private JButton btnRegistrar;
	
	public VLogin() {
		super("Login");
		init();
	}

	private void init() {
		getContentPane().setLayout(null);
		
		JLabel lblDni = new JLabel("DNI: ");
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		lblDni.setBounds(28, 18, 60, 20);
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblDni);
		
		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setBounds(16, 80, 85, 20);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblPassword);
		
		txtDni = new JTextField();
		txtDni.setToolTipText("Introduce el usuario");
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDni.setBounds(105, 16, 160, 25);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwdPassword.setBounds(105, 78, 160, 25);
		getContentPane().add(pwdPassword);
		
		btnAcceder = new JButton(BTN_ACCEDER);
		btnAcceder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAcceder.setBounds(65, 120, 85, 30);
		getContentPane().add(btnAcceder);
		
		btnRegistrar = new JButton(BTN_REGISTRAR);
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrar.setBounds(170, 120, 95, 30);
		getContentPane().add(btnRegistrar);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setSize(ANCHO, ALTO);
		centrarVentana();
	}
	
	private void centrarVentana() {
		// Se obtienen las dimensiones en pixels de la pantalla.       
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               
		// Crear un objeto de tipo Dimension con las medidas en pixels de la ventana.       
		Dimension ventana = new Dimension(ANCHO, ALTO);               
		// Una cuenta para situar la ventana en el centro de la pantalla.       
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}

	public void setListener(PolideportivoListener l) {
		btnAcceder.addActionListener(l);
		btnRegistrar.addActionListener(l);
	}

	public Usuario obtenerDatos() {
		Usuario usuario = null;
			
		String dni = txtDni.getText().trim().toUpperCase();
			
		if(dni.isEmpty()) {
			mostrarMensaje("Debe introducir el usuario", "Error de Acceso", JOptionPane.INFORMATION_MESSAGE);
		}else {
			String contraseña = pwdPassword.getText().trim();
			
			if (contraseña.isEmpty()) {
				mostrarMensaje("Debe introducir la contraseña", "Error de Acceso", JOptionPane.INFORMATION_MESSAGE);
			}else {
				usuario = new Usuario(dni, null, null, 0, null, null, contraseña);
			}
		}
		
		return usuario;
	}

	public void mostrarMensaje(String mensaje, String titulo, int icono) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, icono);
	}

	public void cargarUsuario(String dni) {
		txtDni.setText(dni);
	}

}
