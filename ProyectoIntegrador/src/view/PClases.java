package view;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import control.PolideportivoListener;

import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		dcbm = new DefaultComboBoxModel<String>(new String[] {"Tenis", "Padel", "Futbol", "Baloncesto", "Voleibol", 
				"Frontón", "Yoga", "Zumba", "Natación"});
		cmbDeportes.setModel(dcbm);
		
		cmbDeportes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbDeportes.setBounds(173, 47, 128, 26);
		add(cmbDeportes);
		
		JScrollPane scrpTabla = new JScrollPane();
		scrpTabla.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrpTabla.setBounds(32, 209, 472, 160);
		add(scrpTabla);
		
		tblDeportes = new JTable();
		
		configurarTabla();	
		
		scrpTabla.setViewportView(tblDeportes);
		
		btnApuntar = new JButton("Apúntate");
		btnApuntar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnApuntar.setBounds(32, 114, 95, 27);
		add(btnApuntar);
		
		JLabel lblDeportes = new JLabel("Seleccione un deporte:");
		lblDeportes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeportes.setBounds(20, 47, 143, 27);
		add(lblDeportes);
		
		JScrollPane scrpTextArea = new JScrollPane();
		scrpTextArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrpTextArea.setBounds(151, 83, 274, 58);
		add(scrpTextArea);
		
		JTextArea txtDescripcion = new JTextArea();
		scrpTextArea.setViewportView(txtDescripcion);
		
		JLabel lblListado = new JLabel("Listado de clases");
		lblListado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblListado.setBounds(32, 172, 143, 27);
		add(lblListado);
		
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
	}
}
