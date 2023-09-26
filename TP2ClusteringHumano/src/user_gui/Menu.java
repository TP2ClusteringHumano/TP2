package user_gui;

import logic.Persona;
import logic.Grafo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
//import javax.swing.JScrollBar;
//import java.awt.Color;
//import java.awt.Rectangle;

public class Menu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JTextField nameInput;
	private List<Persona> personas;
	private JComboBox<String> comboBoxDeportes;
	private JComboBox<String> comboBoxMusica;
	private JComboBox<String> comboBoxEspectaculos;
	private JComboBox<String> comboBoxCiencias;
	private static DefaultListModel<String> listModel;
	//private DefaultTableModel modelTable;

	public Menu() {
		setTitle("TP2: Clustering Humano");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 450);
		String[] niveles = { "1", "2", "3", "4", "5" };
		personas = new ArrayList<Persona>();

		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Aguilar, Pardo, Roca Vilte");
		lblNewLabel_5.setBounds(218, 386, 169, 14);
		panelPrincipal.add(lblNewLabel_5);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(62, 35, 85, 14);
		panelPrincipal.add(lblNewLabel);
		nameInput = new JTextField();
		nameInput.setBounds(164, 32, 86, 20);
		panelPrincipal.add(nameInput);
		nameInput.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Interes en Deportes");
		lblNewLabel_1.setBounds(62, 66, 122, 14);
		panelPrincipal.add(lblNewLabel_1);
		comboBoxDeportes = new JComboBox<>(niveles);
		comboBoxDeportes.setBounds(218, 63, 32, 20);
		panelPrincipal.add(comboBoxDeportes);

		JLabel lblNewLabel_2 = new JLabel("Interes en Musica");
		lblNewLabel_2.setBounds(62, 99, 122, 14);
		panelPrincipal.add(lblNewLabel_2);
		comboBoxMusica = new JComboBox<>(niveles);
		comboBoxMusica.setBounds(218, 96, 32, 20);
		panelPrincipal.add(comboBoxMusica);

		JLabel lblNewLabel_3 = new JLabel("Interes en Espectaculos");
		lblNewLabel_3.setBounds(62, 134, 146, 14);
		panelPrincipal.add(lblNewLabel_3);
		comboBoxEspectaculos = new JComboBox<>(niveles);
		comboBoxEspectaculos.setBounds(218, 164, 32, 20);
		panelPrincipal.add(comboBoxEspectaculos);

		JLabel lblNewLabel_4 = new JLabel("Interes en Ciencias");
		lblNewLabel_4.setBounds(62, 167, 122, 14);
		panelPrincipal.add(lblNewLabel_4);
		comboBoxCiencias = new JComboBox<>(niveles);
		comboBoxCiencias.setBounds(218, 131, 32, 20);
		panelPrincipal.add(comboBoxCiencias);

		JButton calcularGruposButton = new JButton("Calcular Grupos");
		calcularGruposButton.setBounds(62, 280, 200, 56);
//		calcularGruposButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (personas.size() < 2) {
//					JOptionPane.showMessageDialog(null, "Por favor agregue mas personas para calcular los grupos",
//							"Error al generar grupos ", JOptionPane.INFORMATION_MESSAGE);
//				} else {
//
//					Grafo grafo = new Grafo(0);
//					for (Persona p : personas) {
//						grafo.agregarPersona(p);
//					dispose();
//					Display display = new Display(grafo);
//					display.setResizable(false);
//					display.setVisible(true);
//					display.setLocationRelativeTo(null);
//					}
//				}
//			}
//		});
		calcularGruposButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelPrincipal.add(calcularGruposButton);

		listModel = new DefaultListModel<>();
		for (Persona per : personas) {
			listModel.addElement(per.consultarNombre());
		}
		JList<String> listaNombres = new JList<>(listModel);
		listaNombres.setBounds(355, 23, 200, 323);
		panelPrincipal.add(listaNombres);
//		JScrollPane scrollPane = new JScrollPane(listaNombres);
//		add(scrollPane);
//		
//		JTable table = new JTable();
//		JScrollPane scrollPane = new JScrollPane(table);
//		scrollPane.setBounds(360, 35, 200, 304);
//		panelPrincipal.add(scrollPane);
//		table.setModel(modelTable);
//		table.setDefaultEditor(Object.class, null);
//		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
//		table.setDefaultRenderer(Object.class, centerRenderer);

		JButton agregarPersonaButton = new JButton("Agregar persona");
		agregarPersonaButton.setBounds(62, 227, 142, 42);
		agregarPersonaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!validateName(nameInput.getText(), personas)) {
					JOptionPane.showMessageDialog(null,
							"El nombre no puede ser vacio, mayor a 10 caracteres o ya estar registrado",
							"Error al agregar persona ", JOptionPane.INFORMATION_MESSAGE);
				} else if (personas.size() == 18) {
					JOptionPane.showMessageDialog(null, "Maximo de personas alcanzado", "Error al agregar persona ",
							JOptionPane.INFORMATION_MESSAGE);

				} else {
					Persona nuevaPersona = new Persona(nameInput.getText(),
							Integer.parseInt((String) comboBoxDeportes.getSelectedItem()),
							Integer.parseInt((String) comboBoxMusica.getSelectedItem()),
							Integer.parseInt((String) comboBoxEspectaculos.getSelectedItem()),
							Integer.parseInt((String) comboBoxCiencias.getSelectedItem()));
					personas.add(nuevaPersona);
					listModel.addElement(nuevaPersona.toString());
					nameInput.setText("");
				}
			}

			private boolean validateName(String nombre, List<Persona> lista) {
				if (nombre.length() > 10 || nombre == null || nombre.trim().isEmpty()) {
					return false;
				}
				for (Persona elemento : lista) {
					if (elemento.consultarNombre().toLowerCase().equals(nombre.toLowerCase())) {
						return false;
					}
				}
				return true;
			}
		});
		panelPrincipal.add(agregarPersonaButton);
		
	}
}