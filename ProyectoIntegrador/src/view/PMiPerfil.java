package view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import control.PolideportivoListener;
import model.Usuario;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class PMiPerfil extends JPanel {
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JTextField txtTlf;
	private JTextField txtEmail;
	private JTextField txtAnio;
	private JPasswordField pwdModPwd;
	private JButton btnModificar;
	private JButton btnTerminado;
	private JButton btnCancelarR;
	private JButton btnDesapuntar;

	public PMiPerfil() {
		init();
	}

	private void init() {
		setLayout(null);
		
		setSize(VPrincipal.ANCHO - 35, VPrincipal.ALTO - 15);
		
		JLabel lblTitulo = new JLabel("Mi Perfil");
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitulo.setBounds(10, 10, 96, 22);
		add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(10, 44, 59, 18);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		txtNombre.setBounds(79, 42, 158, 23);
		add(txtNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(269, 44, 61, 18);
		add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setEnabled(false);
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(340, 42, 275, 23);
		add(txtApellidos);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(20, 74, 36, 18);
		add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setEnabled(false);
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDni.setColumns(10);
		txtDni.setBounds(79, 72, 109, 23);
		add(txtDni);
		
		JLabel lblAnioNac = new JLabel("Año de nacimiento:");
		lblAnioNac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnioNac.setBounds(232, 74, 122, 18);
		add(lblAnioNac);
		
		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefono.setBounds(10, 104, 61, 18);
		add(lblTelefono);
		
		txtTlf = new JTextField();
		txtTlf.setEnabled(false);
		txtTlf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTlf.setColumns(10);
		txtTlf.setBounds(79, 102, 137, 23);
		add(txtTlf);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(242, 104, 44, 18);
		add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(296, 102, 275, 23);
		add(txtEmail);
		
		txtAnio = new JTextField();
		txtAnio.setEnabled(false);
		txtAnio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAnio.setColumns(10);
		txtAnio.setBounds(364, 72, 59, 23);
		add(txtAnio);
		
		JLabel lblModPwd = new JLabel("Modificar contraseña:");
		lblModPwd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModPwd.setBounds(10, 151, 137, 18);
		add(lblModPwd);
		
		pwdModPwd = new JPasswordField();
		pwdModPwd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwdModPwd.setBounds(157, 148, 160, 25);
		add(pwdModPwd);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setBounds(364, 145, 103, 30);
		add(btnModificar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 219, 561, 86);
		add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 352, 561, 86);
		add(scrollPane_1);
		
		JLabel lblListadoR = new JLabel("Tus reservas:");
		lblListadoR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListadoR.setBounds(10, 191, 96, 18);
		add(lblListadoR);
		
		JLabel lblListadoC = new JLabel("Tus clases:");
		lblListadoC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListadoC.setBounds(10, 324, 76, 18);
		add(lblListadoC);
		
		btnCancelarR = new JButton("Cancelar ");
		btnCancelarR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelarR.setBounds(468, 312, 103, 30);
		add(btnCancelarR);
		
		btnDesapuntar = new JButton("Desapuntarse");
		btnDesapuntar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDesapuntar.setBounds(449, 445, 122, 30);
		add(btnDesapuntar);
		
		btnTerminado = new JButton("Ya he terminado");
		btnTerminado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTerminado.setBounds(321, 312, 137, 30);
		add(btnTerminado);
	}

	public void mostrarMensaje(String mensaje, String titulo, int icono) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, icono);
	}
	
	public void setListener(PolideportivoListener listener) {
		btnCancelarR.addActionListener(listener);
		btnDesapuntar.addActionListener(listener);
		btnModificar.addActionListener(listener);
		btnTerminado.addActionListener(listener);
	}
}
