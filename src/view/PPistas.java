package view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import control.PolideportivoListener;
import model.Pista;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PPistas extends JPanel {
	public static final String COL1 = "NOMBRE";
	public static final String COL2 = "DEPORTE";
	
	private JButton btnReservar;
	private JComboBox<String> cmbDeportes;
	private JComboBox<String> cmbHoras;
	private JTable tblPistas;
	private DefaultComboBoxModel<String> dcbmDeportes;
	private DefaultComboBoxModel<String> dcbmHoras;
	private DefaultTableModel dtm;
	private JButton btnMostrar;
	private JLabel lblListado;
	private JScrollPane scrpTabla;
	private JLabel lblHoras;
	private JLabel lblFecha;
	private JComboBox<String> cmbFecha;
	private DefaultComboBoxModel<String> dcbmFecha;
	
	public PPistas() {
		init();
	}

	private void init() {
		setLayout(null);
		
		setSize(VPrincipal.ANCHO - 35, VPrincipal.ALTO - 15);
		
		JLabel lblClases = new JLabel("Reservar Pistas");
		lblClases.setForeground(new Color(0, 0, 0));
		lblClases.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblClases.setBounds(10, 10, 183, 22);
		add(lblClases);
		
		cmbDeportes = new JComboBox<String>();
		
		dcbmDeportes = new DefaultComboBoxModel<String>(new String[] {"Todos", "Tenis", "Pádel", "Fútbol", "Baloncesto", "Voleibol", 
				"Frontón", "Yoga", "Zumba", "Natación"});
		
		cmbDeportes.setModel(dcbmDeportes);
		
		cmbDeportes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbDeportes.setBounds(173, 47, 128, 26);
		add(cmbDeportes);
		
		scrpTabla = new JScrollPane();
		scrpTabla.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrpTabla.setBounds(32, 263, 392, 160);
		add(scrpTabla);
		
		tblPistas = new JTable();
		
		configurarTabla();	
		
		scrpTabla.setViewportView(tblPistas);
		
		btnReservar = new JButton("Reserva");
		btnReservar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReservar.setBounds(32, 433, 95, 27);
		add(btnReservar);
		
		JLabel lblDeportes = new JLabel("Seleccione un deporte:");
		lblDeportes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeportes.setBounds(20, 47, 143, 27);
		add(lblDeportes);
		
		lblListado = new JLabel("Listado de pistas");
		lblListado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblListado.setBounds(32, 226, 143, 27);
		add(lblListado);
		
		btnMostrar = new JButton("Mostrar Pistas");
		btnMostrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMostrar.setBounds(342, 47, 128, 27);
		add(btnMostrar);
		
		lblHoras = new JLabel("Seleccione la hora:");
		lblHoras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoras.setBounds(32, 100, 118, 27);
		add(lblHoras);
		
		cmbHoras = new JComboBox<String>();
		
		dcbmHoras = new DefaultComboBoxModel<String>(new String[] {"8:30 - 9:30", "9:30 - 10:30", "10:30 - 11:30", "11:30 - 12:30",
				"12:30 - 13:30", "16:30 - 17:30", "17:30 - 18:30", "18:30 - 19:30", "19:30 - 20:30", "20:30 - 21:30"});
		
		cmbHoras.setModel(dcbmHoras);
		
		cmbHoras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbHoras.setBounds(173, 100, 128, 26);
		add(cmbHoras);
		
		lblFecha = new JLabel("Seleccione una fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(20, 148, 143, 27);
		add(lblFecha);
		
		cmbFecha = new JComboBox<String>();
		
		dcbmFecha = new DefaultComboBoxModel<>();
		
		rellenarModelFecha();
		
		cmbFecha.setModel(dcbmFecha);
		
		cmbFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbFecha.setBounds(173, 149, 128, 26);
		add(cmbFecha);
		
		lblListado.setVisible(false);
		scrpTabla.setVisible(false);
		tblPistas.setVisible(false);
		btnReservar.setVisible(false);
		cmbHoras.setVisible(false);
		lblHoras.setVisible(false);
		lblFecha.setVisible(false);
		cmbFecha.setVisible(false);
	}

	private void configurarTabla() {
		dtm = new DefaultTableModel() {
			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		
		dtm.addColumn(COL1);
		dtm.addColumn(COL2);
		
		tblPistas.setModel(dtm);	
	}
	
	public void mostrarTabla(boolean visible) {
		lblListado.setVisible(visible);
		scrpTabla.setVisible(visible);
		tblPistas.setVisible(visible);
		btnReservar.setVisible(visible);
		cmbHoras.setVisible(visible);
		lblHoras.setVisible(visible);
		lblFecha.setVisible(visible);
		cmbFecha.setVisible(visible);
	}
	
	public void mostrarMensaje(String mensaje, String titulo, int icono) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, icono);
	}
	
	public void setListener(PolideportivoListener listener) {
		btnMostrar.addActionListener(listener);
		btnReservar.addActionListener(listener);
	}

	public String obtenerDeporte() {
		return (String) cmbDeportes.getSelectedItem();
	}

	public String obtenerHora() {
		return (String) cmbHoras.getSelectedItem();
	}
	
	public String obtenerFecha() {
		return (String) cmbFecha.getSelectedItem();
	}
	
	public void rellenarModelFecha() {
		String[] fechas = new String[30];
		LocalDate fechaActual = LocalDate.now().plusDays(1);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		for (int i = 0; i < fechas.length; i++) {
			fechas[i] = fechaActual.plusDays(i).format(formato);
			
			dcbmFecha.addElement(fechas[i]);
		}
	}

	public void rellenarTabla(ArrayList<Pista> listaPistas) {
		dtm.setRowCount(0);
		
		Object[] fila = new Object[2];
		
		for (Pista pista : listaPistas) {
			
			fila[0] = pista.getNombre();
			
			fila[1] = pista.getDeporte();
			
			dtm.addRow(fila);
		}	
	}

	public int obtenerElementoSeleccionado() {
		return tblPistas.getSelectedRow();
	}

	public String getNombreFila(int pos) {
		return (String) dtm.getValueAt(pos, 0);
	}
}
