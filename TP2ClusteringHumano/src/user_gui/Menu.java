package user_gui;

import logic.Persona;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Menu extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JTextField nameInput;
	private HashSet<Persona> personas;
	private ArrayList<String> nombres;
	private JComboBox<String> comboBoxDeportes;
	private JComboBox<String> comboBoxMusica;
	private JComboBox<String> comboBoxFarandula;
	private JComboBox<String> comboBoxCiencias;
	
	public Menu() {
		setTitle("TP2: Clustering Humano");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,200,600,450);
		String[] niveles = {"1", "2", "3", "4", "5"};
		//ArrayList<String> nombres = new ArrayList<>();
		personas = new HashSet<>();
		nombres = new ArrayList<String>();
		
		
		panelPrincipal=new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(32, 14, 120, 14);
		panelPrincipal.add(lblNewLabel);
		
		nameInput = new JTextField();
		nameInput.setBounds(162, 11, 86, 20);
		panelPrincipal.add(nameInput);
		nameInput.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Interes en Deportes");
		lblNewLabel_1.setBounds(32, 46, 127, 14);
		panelPrincipal.add(lblNewLabel_1);
		comboBoxDeportes = new JComboBox<>(niveles);
		comboBoxDeportes.setBounds(204, 42, 44, 22);
		panelPrincipal.add(comboBoxDeportes);

		JLabel lblNewLabel_2 = new JLabel("Interes en Musica");
		lblNewLabel_2.setBounds(32, 79, 127, 14);
		panelPrincipal.add(lblNewLabel_2);
		comboBoxMusica = new JComboBox<>(niveles);
		comboBoxMusica.setBounds(204, 75, 44, 22);
		panelPrincipal.add(comboBoxMusica);

		JLabel lblNewLabel_3 = new JLabel("Interes en Farandula");
		lblNewLabel_3.setBounds(32, 112, 127, 14);
		panelPrincipal.add(lblNewLabel_3);
		comboBoxFarandula = new JComboBox<>(niveles);
		comboBoxFarandula.setBounds(204, 108, 44, 22);
		panelPrincipal.add(comboBoxFarandula);

		JLabel lblNewLabel_4 = new JLabel("Interes en Ciencias");
		lblNewLabel_4.setBounds(32, 145, 127, 14);
		panelPrincipal.add(lblNewLabel_4);
		comboBoxCiencias = new JComboBox<>(niveles);
		comboBoxCiencias.setBounds(204, 141, 44, 22);
		panelPrincipal.add(comboBoxCiencias);
		
		JButton calcularGruposButton = new JButton("Calcular Grupos");
		calcularGruposButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (String nombre : nombres) {
		            System.out.println("\n"+nombre);
		        }
			}
		});
		calcularGruposButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		calcularGruposButton.setBounds(32, 287, 216, 74);
		panelPrincipal.add(calcularGruposButton);

        JList<String> listaNombres = new JList<>(nombres.toArray(new String[nombres.size()]));
		listaNombres.setBounds(372, 27, 183, 314);
		panelPrincipal.add(listaNombres);
		
		JButton agregarPersonaButton = new JButton("Agregar persona");
		agregarPersonaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!validateName(nameInput.getText(),nombres)) {
					JOptionPane.showMessageDialog(null, "El nombre no puede ser vacio, mayor a 10 caracteres o ya estar registrado", 
												"Error al iniciar ", JOptionPane.INFORMATION_MESSAGE);
				}else {
				Persona nuevaPersona = new Persona(nameInput.getText(),
						Integer.parseInt((String) comboBoxDeportes.getSelectedItem()),
						Integer.parseInt((String) comboBoxMusica.getSelectedItem()),
						Integer.parseInt((String) comboBoxFarandula.getSelectedItem()),
						Integer.parseInt((String) comboBoxCiencias.getSelectedItem()));
				personas.add(nuevaPersona);
				nombres.add(nuevaPersona.consultarNombre());
				panelPrincipal.revalidate();
				panelPrincipal.repaint();
				}
			}
			private boolean validateName(String nombre, ArrayList<String> lista) {
				if (nombre.length() > 10 || nombre == null || nombre.trim().isEmpty()) {
					return false;
				}
				for (String elemento : lista) {
		            if (elemento.equals(nombre)) {
		                return false;
		            }
		        }
				return true;
			}
		});
		agregarPersonaButton.setBounds(32, 212, 139, 23);
		panelPrincipal.add(agregarPersonaButton);
		
		
	}
}