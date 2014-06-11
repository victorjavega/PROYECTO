import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Contacto extends JFrame {

	private JPanel contentPane;
	private JTextField numero;
	private JTextField txtId;
	private JTextField nombre;
	private JComboBox<Contactos> box;
	private Contactos contactos;
	private BD d;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contacto frame = new Contacto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Contacto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		box = new JComboBox<Contactos>();
		box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			contactos=box.getItemAt(box.getSelectedIndex());
			if(contactos!=null)
			{
				nombre.setText(String.valueOf(contactos.getNombre()));
				numero.setText(String.valueOf(contactos.getNumero()));
			
			}
			}
		});
		box.setBounds(200, 41, 177, 20);
		contentPane.add(box);
		
		numero = new JTextField();
		numero.setBounds(34, 128, 86, 20);
		contentPane.add(numero);
		numero.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("nombre");
		lblNewLabel.setBounds(51, 44, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("numero");
		lblNewLabel_1.setBounds(51, 107, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("GUARDAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contactos c=new Contactos();
				int ID=0;
				ID=d.insertarContacto(nombre.getText(), Integer.parseInt(numero.getText()));
				c.setNombre(String.valueOf(nombre.getText()));
				c.setNumero(Integer.parseInt(numero.getText()));
				c.setid(Integer.parseInt(txtId.getText()));
				box.addItem(c);
			}
		});
		btnNewButton.setBounds(42, 184, 89, 23);
		contentPane.add(btnNewButton);
		d=new BD(box);
		
		txtId = new JTextField();
		txtId.setText("0");
		txtId.setEnabled(false);
		txtId.setBounds(387, 41, 31, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(387, 16, 46, 14);
		contentPane.add(lblId);
		
		nombre = new JTextField();
		nombre.setBounds(34, 69, 86, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		d.leerContactos();
	}

}
