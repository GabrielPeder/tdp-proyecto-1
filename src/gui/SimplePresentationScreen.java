package gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	
	private int lu=0;
	private String apellido="";
	private String nombre="";
	private String email = "";
	private String github= "";
	private String photo = "";
	

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 285));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 16, 430, 211);
		tabbedPane.setToolTipText("");
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		
		lu=studentData.getId();
		nombre=studentData.getFirstName();
		apellido=studentData.getLastName();
		email=studentData.getMail();
		github=studentData.getGithubURL();
		photo= studentData.getPathPhoto();
		
		JLabel lbllu = new JLabel("LU");
		lbllu.setBounds(10, 12, 73, 16);
		lbllu.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblapellido = new JLabel("Apellido");
		lblapellido.setBounds(10, 42, 73, 16);
		lblapellido.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblnombre = new JLabel("Nombre");
		lblnombre.setBounds(10, 74, 73, 16);
		lblnombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setBounds(10, 105, 73, 19);
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblgithub = new JLabel("Github URL");
		lblgithub.setBounds(10, 136, 73, 20);
		lblgithub.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JTextField Lu = new JTextField();
		Lu.setText(""+ lu);
		Lu.setBounds(101, 11, 314, 20);
		Lu.setColumns(10);
		
		JTextField Apellido = new JTextField();
		Apellido.setBounds(101, 42, 314, 20);
		Apellido.setColumns(10);
		Apellido.setText(apellido);
		
		JTextField Nombre = new JTextField();
		Nombre.setBounds(101, 73, 314, 20);
		Nombre.setColumns(10);
		Nombre.setText(nombre);
		
		JTextField Email = new JTextField();
		Email.setBounds(101, 105, 314, 20);
		Email.setColumns(10);
		Email.setText(email);
		
		JTextField Url = new JTextField();
		Url.setBounds(101, 136, 314, 20);
		Url.setColumns(10);
		Url.setText(github);
		
		tabInformation.setLayout(null);
		tabInformation.add(lblgithub);
		tabInformation.add(Url);
		tabInformation.add(lblnombre);
		tabInformation.add(Nombre);
		tabInformation.add(lblemail);
		tabInformation.add(Email);
		tabInformation.add(lblapellido);
		tabInformation.add(Apellido);
		tabInformation.add(lbllu);
		tabInformation.add(Lu);
		
		
		JLabel Imagen = new JLabel("");
		Imagen.setBounds(439, 42, 165, 158);
		Imagen.setBackground(UIManager.getColor("Button.background"));
		Imagen.setHorizontalAlignment(SwingConstants.CENTER);
		Imagen.setIcon(new ImageIcon(SimplePresentationScreen.class.getResource(photo)));
		contentPane.setLayout(null);
		contentPane.add(tabbedPane);
		contentPane.add(Imagen);

		DateTimeFormatter fechayhora = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
	    String horayfechaFormateada = fechayhora.format(LocalDateTime.now());
	    
		JLabel generada = new JLabel("");
		generada.setFont(new Font("Tahoma", Font.BOLD, 12));
		generada.setBounds(0, 226, 513, 14);
		generada.setText("Esta ventana fue generada el "+horayfechaFormateada);

		contentPane.add(generada);
	}
}
