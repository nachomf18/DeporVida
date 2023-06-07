package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import control.PolideportivoListener;
import db.PolideportivoPersistencia;
import model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JFormattedTextField;

public class VRegistrar extends JFrame {
	
	public static final int ANCHO = 680;
	public static final int ALTO = 380;
	
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JTextField txtTlf;
	private JTextField txtEmail;
	private JPasswordField pwdPwd;
	private JPasswordField pwdConfirm;
	private JSpinner spnAnio;
	private JButton btnGuardar;
	private JButton btnCancelar;
	
	public VRegistrar() {
		super("Registrar");
		init();
	}

	private void init() {
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(28, 72, 59, 18);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBounds(97, 70, 158, 23);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(287, 72, 61, 18);
		getContentPane().add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(358, 70, 275, 23);
		getContentPane().add(txtApellidos);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(40, 124, 36, 18);
		getContentPane().add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDni.setColumns(10);
		txtDni.setBounds(97, 122, 109, 23);
		getContentPane().add(txtDni);
		
		JLabel lblAnioNac = new JLabel("Año de nacimiento:");
		lblAnioNac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnioNac.setBounds(252, 124, 122, 18);
		getContentPane().add(lblAnioNac);
		
		spnAnio = new JSpinner();
		spnAnio.setModel(new SpinnerNumberModel(2023, 1930, 2023, 1));
		spnAnio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spnAnio.setBounds(384, 122, 73, 22);
		getContentPane().add(spnAnio);
		
		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefono.setBounds(28, 184, 61, 18);
		getContentPane().add(lblTelefono);
		
		txtTlf = new JTextField();
		txtTlf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTlf.setColumns(10);
		txtTlf.setBounds(97, 182, 137, 23);
		getContentPane().add(txtTlf);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(269, 184, 44, 18);
		getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(323, 182, 275, 23);
		getContentPane().add(txtEmail);
		
		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(58, 242, 85, 18);
		getContentPane().add(lblPassword);
		
		pwdPwd = new JPasswordField();
		pwdPwd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwdPwd.setBounds(153, 239, 160, 25);
		getContentPane().add(pwdPwd);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar contraseña:");
		lblConfirmarContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmarContrasea.setBounds(28, 283, 140, 20);
		getContentPane().add(lblConfirmarContrasea);
		
		pwdConfirm = new JPasswordField();
		pwdConfirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwdConfirm.setBounds(178, 281, 160, 25);
		getContentPane().add(pwdConfirm);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardar.setBounds(398, 236, 85, 30);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(393, 278, 95, 30);
		getContentPane().add(btnCancelar);
		
		JLabel lblRegistro = new JLabel("Registro de Usuario");
		lblRegistro.setForeground(new Color(0, 0, 0));
		lblRegistro.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblRegistro.setBounds(28, 10, 224, 39);
		getContentPane().add(lblRegistro);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setSize(ANCHO, ALTO);
		centrarVentana();
	}

	public void hacerVisible() {
		setVisible(true);
	}
	
	private void centrarVentana() {
		// Se obtienen las dimensiones en pixels de la pantalla.       
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               
		// Crear un objeto de tipo Dimension con las medidas en pixels de la ventana.       
		Dimension ventana = new Dimension(ANCHO, ALTO);               
		// Una cuenta para situar la ventana en el centro de la pantalla.       
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2);
	}
	
	public Usuario obtenerDatos() {
		Usuario usuario = null;
		
		String nombre = txtNombre.getText();
		
		if(nombre.isEmpty()) {
			mostrarMensaje("Debe introducir el nombre", "Error de datos", JOptionPane.ERROR_MESSAGE);
		}else {
			String apellidos = txtApellidos.getText();
			
			if (apellidos.isEmpty()) {
				mostrarMensaje("Debe introducir los apellidos", "Error de datos", JOptionPane.ERROR_MESSAGE);
			}else {
				String dni = txtDni.getText().toUpperCase().trim();
				
				if (dni.isEmpty()) {
					mostrarMensaje("Debe introducir su DNI", "Error de datos", JOptionPane.ERROR_MESSAGE);
				}else if (dni.length() != 9 || Character.isLetter(dni.charAt(8)) == false) {
					mostrarMensaje("El DNI debe contener 9 caracteres (8 dígitos y 1 letra)", "Error de datos", JOptionPane.ERROR_MESSAGE);
				}else {
					int anio = (int) spnAnio.getValue();
					
					if (anio > 2007) {
						mostrarMensaje("Debe ser mayor de 15 años para registrarse", "Error de datos", JOptionPane.ERROR_MESSAGE);
					}else {
						String email = txtEmail.getText().trim().toLowerCase();
						String tlf = txtTlf.getText().trim();
						
						String pwd = pwdPwd.getText().trim();
						String pwd2 = pwdConfirm.getText().trim();
						
						if (pwd.isEmpty()) {
							mostrarMensaje("Debe introducir la contraseña", "Error de datos", JOptionPane.ERROR_MESSAGE);
						}else if (pwd2.isEmpty()) {
							mostrarMensaje("Debe introducir la confirmación de contraseña", "Error de datos", JOptionPane.ERROR_MESSAGE);
						}else if (!pwd.equals(pwd2)) {
							mostrarMensaje("Las contraseñas no coinciden", "Error de datos", JOptionPane.ERROR_MESSAGE);
						}else {
							usuario = new Usuario(dni, nombre, apellidos, anio, tlf, email, pwd);
						}
					}
				}
			}
		}
		return usuario;
	}
	
	public void setListener(PolideportivoListener listener) {
		btnGuardar.addActionListener(listener);
		btnCancelar.addActionListener(listener);
	}
	
	public void mostrarMensaje(String texto, String titulo, int icono) {
		JOptionPane.showMessageDialog(this, texto, titulo, icono);
	}
}
