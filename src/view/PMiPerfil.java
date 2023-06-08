package view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import control.PolideportivoListener;
import model.Clase;
import model.Pista;
import model.Usuario;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
	private JButton btnCancelar;
	private JButton btnDesapuntar;
	private JPasswordField pwdConfirm;
	private DefaultTableModel dtmReservas;
	private DefaultTableModel dtmClases;
	private JTable tblReservas;
	private JTable tblClases;

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
		btnModificar.setBounds(167, 179, 103, 30);
		add(btnModificar);
		
		JScrollPane scrpTablaR = new JScrollPane();
		scrpTablaR.setBounds(10, 219, 561, 86);
		add(scrpTablaR);
		
		tblReservas = new JTable();
		scrpTablaR.setViewportView(tblReservas);
		
		JScrollPane scrpTablaC = new JScrollPane();
		scrpTablaC.setBounds(10, 352, 561, 86);
		add(scrpTablaC);
		
		tblClases = new JTable();
		scrpTablaC.setViewportView(tblClases);
		
		JLabel lblListadoR = new JLabel("Tus reservas:");
		lblListadoR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListadoR.setBounds(10, 191, 96, 18);
		add(lblListadoR);
		
		JLabel lblListadoC = new JLabel("Tus clases:");
		lblListadoC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListadoC.setBounds(10, 324, 76, 18);
		add(lblListadoC);
		
		btnCancelar = new JButton("Cancelar reserva");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(434, 312, 137, 30);
		add(btnCancelar);
		
		btnDesapuntar = new JButton("Desapuntarse");
		btnDesapuntar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDesapuntar.setBounds(449, 445, 122, 30);
		add(btnDesapuntar);
		
		btnTerminado = new JButton("Ya he terminado");
		btnTerminado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTerminado.setBounds(286, 312, 137, 30);
		add(btnTerminado);
		
		JLabel lblConfirm = new JLabel("Confirmar contraseña:");
		lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirm.setBounds(327, 151, 147, 18);
		add(lblConfirm);
		
		pwdConfirm = new JPasswordField();
		pwdConfirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwdConfirm.setBounds(468, 148, 160, 25);
		add(pwdConfirm);
		
		configurarTablas();
	}

	public void mostrarMensaje(String mensaje, String titulo, int icono) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, icono);
	}
	
	public void setListener(PolideportivoListener listener) {
		btnCancelar.addActionListener(listener);
		btnDesapuntar.addActionListener(listener);
		btnModificar.addActionListener(listener);
		btnTerminado.addActionListener(listener);
	}

	public String obtenerPwd() {
		String pwd1 = pwdModPwd.getText();
		String pwd2 = pwdConfirm.getText();
		
		if(pwd1.length() < 9) {
			pwd1 = null;
			mostrarMensaje("La contraseña debe tener mínimo 9 caracteres", "Error de datos", JOptionPane.ERROR_MESSAGE);
		}else if(pwd1.isEmpty() ) {
			pwd1 = null;
			mostrarMensaje("Debe introducir la contraseña", "Error de datos", JOptionPane.ERROR_MESSAGE);
		}else if(pwd2.isEmpty()) {
			pwd1 = null;
			mostrarMensaje("Debe introducir la confirmación de contraseña", "Error de datos", JOptionPane.ERROR_MESSAGE);
		}else if(!pwd1.equals(pwd2)) {
			pwd1 = null;
			mostrarMensaje("Las contraseñas no coinciden", "Error de datos", JOptionPane.ERROR_MESSAGE);
		}
		return pwd1;
	}

	public void cargarDatos(Usuario usuario) {
		txtNombre.setText(usuario.getNombre());
		txtApellidos.setText(usuario.getApellidos());
		txtAnio.setText("" + usuario.getAnio_nac());
		txtDni.setText(usuario.getDni());
		txtEmail.setText(usuario.getEmail());
		txtTlf.setText(usuario.getTelefono());
	}
	
	private void configurarTablas() {
		dtmClases = new DefaultTableModel() {
			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		
		dtmClases.addColumn("NOMBRE");
		dtmClases.addColumn("DEPORTE");
		dtmClases.addColumn("DÍAS");
		dtmClases.addColumn("HORAS");
		
		tblClases.setModel(dtmClases);	
		
		dtmReservas = new DefaultTableModel() {
			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		
		dtmReservas.addColumn("NOMBRE");
		dtmReservas.addColumn("DEPORTE");
		dtmReservas.addColumn("FECHA");
		dtmReservas.addColumn("HORAS");
		
		tblReservas.setModel(dtmReservas);
	}

	public void rellenarTablaClases(ArrayList<Clase> listaClasesUsuario) {
		dtmClases.setRowCount(0);
		
		Object[] fila = new Object[4];
		
		for (Clase clase : listaClasesUsuario) {
			fila[0] = clase.getNombre();
			
			fila[1] = clase.getDeporte();
			
			fila[2] = clase.getDia1() + " y " + clase.getDia2();
			
			fila[3] = clase.getHoraDesde() + " a " + clase.getHoraHasta();
			
			dtmClases.addRow(fila);
		}
	}

	public void rellenarTablaPistas(ArrayList<Pista> listaPistasUsuario) {
		dtmReservas.setRowCount(0);
		
		Object[] fila = new Object[4];
		
		for (Pista pista : listaPistasUsuario) {
			
			fila[0] = pista.getNombre();
			
			fila[1] = pista.getDeporte();
			
			fila[2] = pista.getFecha();
			
			fila[3] = pista.getHoraDesde() + " a " + pista.getHoraHasta();
			
			dtmReservas.addRow(fila);
		}
	}

	public int obtenerElementoSeleccionadoClases() {
		return tblClases.getSelectedRow();
	}

	public String getNombreFilaClases(int pos) {
		return (String) dtmClases.getValueAt(pos, 0);
	}

	public void eliminarFilaClases(int pos) {
		dtmClases.removeRow(pos);	
	}

	public int obtenerElementoSeleccionadoReservas() {
		return tblReservas.getSelectedRow();
	}

	public String getNombreFilaReservas(int pos) {
		return (String) dtmReservas.getValueAt(pos, 0);
	}

	public void eliminarFilaReservas(int pos) {
		dtmReservas.removeRow(pos);
	}
}
