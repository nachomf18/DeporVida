package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import control.PolideportivoListener;
import model.Clase;
import javax.swing.ScrollPaneConstants;
import java.util.ArrayList;

public class PClases extends JPanel  {
	public static final String COL1 = "NOMBRE";
	public static final String COL2 = "DEPORTE";
	public static final String COL3 = "DÍAS";
	public static final String COL4 = "HORAS";
	
	private JButton btnApuntar;
	private JComboBox<String> cmbDeportes;
	private JTable tblDeportes;
	private DefaultComboBoxModel<String> dcbm;
	private DefaultTableModel dtm;
	private JButton btnMostrar;
	private JLabel lblListado;
	private JTextArea txtDescripcion;
	private JScrollPane scrpTabla;
	private JScrollPane scrpTextArea;
	
	public PClases() {
		init();
	}
	
	private void init() {
		setLayout(null);
		
		setSize(VPrincipal.ANCHO - 35, VPrincipal.ALTO - 15);
		
		JLabel lblClases = new JLabel("Clases");
		lblClases.setForeground(new Color(0, 0, 0));
		lblClases.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblClases.setBounds(10, 10, 85, 22);
		add(lblClases);
		
		cmbDeportes = new JComboBox<String>();
		
		dcbm = new DefaultComboBoxModel<String>(new String[] {"Todos", "Tenis", "Pádel", "Fútbol", "Baloncesto", "Voleibol", 
				"Frontón", "Yoga", "Zumba", "Natación"});
		
		cmbDeportes.setModel(dcbm);
		
		cmbDeportes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbDeportes.setBounds(173, 47, 128, 26);
		add(cmbDeportes);
		
		scrpTabla = new JScrollPane();
		scrpTabla.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrpTabla.setBounds(32, 209, 472, 160);
		add(scrpTabla);
		
		tblDeportes = new JTable();
		
		configurarTabla();	
		
		scrpTabla.setViewportView(tblDeportes);
		
		btnApuntar = new JButton("Apúntate");
		btnApuntar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnApuntar.setBounds(32, 379, 95, 27);
		add(btnApuntar);
		
		JLabel lblDeportes = new JLabel("Seleccione un deporte:");
		lblDeportes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeportes.setBounds(20, 47, 143, 27);
		add(lblDeportes);
		
		scrpTextArea = new JScrollPane();
		scrpTextArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrpTextArea.setBounds(173, 83, 274, 58);
		add(scrpTextArea);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setLineWrap(true);
		scrpTextArea.setViewportView(txtDescripcion);
		
		lblListado = new JLabel("Listado de clases");
		lblListado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblListado.setBounds(32, 172, 143, 27);
		add(lblListado);
		
		btnMostrar = new JButton("Mostrar Clases");
		btnMostrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMostrar.setBounds(32, 114, 128, 27);
		add(btnMostrar);
		
		lblListado.setVisible(false);
		scrpTabla.setVisible(false);
		tblDeportes.setVisible(false);
		txtDescripcion.setVisible(false);
		scrpTextArea.setVisible(false);
		btnApuntar.setVisible(false);
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
		dtm.addColumn(COL3);
		dtm.addColumn(COL4);
		
		tblDeportes.setModel(dtm);	
	}
	
	public void setListener(PolideportivoListener listener) {
		btnApuntar.addActionListener(listener);
		btnMostrar.addActionListener(listener);
	}
	
	public String obtenerDeporte() {
		String deporte = (String) cmbDeportes.getSelectedItem();
		
		return deporte;
	}
	
	public void mostrarMensaje(String mensaje, String titulo, int icono) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, icono);
	}
	
	public void rellenarTabla(ArrayList<Clase> listaClases) {
		dtm.setRowCount(0);
		
		Object[] fila = new Object[4];
		
		for (Clase clase : listaClases) {
			
			fila[0] = clase.getNombre();
			
			fila[1] = clase.getDeporte();
			
			fila[2] = clase.getDia1() + " y " + clase.getDia2();
			
			fila[3] = clase.getHoraDesde() + " a " + clase.getHoraHasta();
			
			dtm.addRow(fila);
		}
	}
	
	public void mostrarTabla(boolean visible) {
		lblListado.setVisible(visible);
		scrpTabla.setVisible(visible);
		tblDeportes.setVisible(visible);
		txtDescripcion.setVisible(visible);
		scrpTextArea.setVisible(visible);
		btnApuntar.setVisible(visible);
	}

	public void rellenarCaja(ArrayList<Clase> listaClases) {
		for (Clase clase : listaClases) {
			txtDescripcion.setText(clase.getDescripcion());
		}
		
	}

	public int obtenerElementoSeleccionado() {
		return tblDeportes.getSelectedRow();
	}

	public String getNombreFila(int pos) {
		return (String) dtm.getValueAt(pos, 0);
	}
}
