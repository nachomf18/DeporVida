package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import control.PolideportivoListener;

import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class VPrincipal extends JFrame {

	public static final String MNTM_CLASES = "Apuntarse a una clase";
	public static final String MNTM_PERFIL = "Mi Perfil";
	public static final String MNTM_PISTAS = "Reservar una pista";
	public static final String MNTM_SALIR = "Salir";
	public static final String MNTM_INFO = "Más información";
	
	public static final int ANCHO = 700;
	public static final int ALTO = 500;
	private JScrollPane scrpContenedor;
	private JMenuItem mntmClases;
	private JMenuItem mntmReservar;
	private JMenuItem mntmPerfil;
	private JMenuItem mntmInfo;
	private JMenuItem mntmSalir;
	
	public VPrincipal() {
		super("Polideportivo");
		init();
	}
	
	private void init() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		scrpContenedor = new JScrollPane();
		scrpContenedor.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrpContenedor.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scrpContenedor, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);
		
		mntmClases = new JMenuItem(MNTM_CLASES);
		mnOpciones.add(mntmClases);
		
		mntmReservar = new JMenuItem(MNTM_PISTAS);
		mnOpciones.add(mntmReservar);
		
		mntmPerfil = new JMenuItem(MNTM_PERFIL);
		mnOpciones.add(mntmPerfil);
		
		mntmInfo = new JMenuItem(MNTM_INFO);
		menuBar.add(mntmInfo);
		
		mntmSalir = new JMenuItem(MNTM_SALIR);
		menuBar.add(mntmSalir);
		
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
	
	public void cargarPanel(JPanel panel) {
		scrpContenedor.setViewportView(panel);
	}
	
	public void setListener(PolideportivoListener listener) {
		mntmClases.addActionListener(listener);
		mntmInfo.addActionListener(listener);
		mntmPerfil.addActionListener(listener);
		mntmReservar.addActionListener(listener);
		mntmSalir.addActionListener(listener);
	}
}


