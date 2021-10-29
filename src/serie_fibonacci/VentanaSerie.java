package serie_fibonacci;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

public class VentanaSerie extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumero1;
	private JTextField txtNumero2;
	private JTextField txtCantidadNumeros;
	private JTextArea txtSerieOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		VentanaSerie frame = new VentanaSerie();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public VentanaSerie() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(10, 227, 65, 23);
		contentPane.add(btnSalir);
		
		txtNumero1 = new JTextField();
		txtNumero1.setBounds(112, 12, 86, 20);
		contentPane.add(txtNumero1);
		txtNumero1.setColumns(10);
		
		JLabel lblNumero1 = new JLabel("Numero Inicial 1");
		lblNumero1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumero1.setBounds(10, 14, 106, 14);
		contentPane.add(lblNumero1);
		
		JLabel lblNumero2 = new JLabel("Numero Inicial 2");
		lblNumero2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumero2.setBounds(10, 46, 106, 14);
		contentPane.add(lblNumero2);
		
		txtNumero2 = new JTextField();
		txtNumero2.setColumns(10);
		txtNumero2.setBounds(112, 44, 86, 20);
		contentPane.add(txtNumero2);
		
		JLabel lblCantidadNumeros = new JLabel("Cantidad de Numeros");
		lblCantidadNumeros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCantidadNumeros.setBounds(10, 77, 133, 14);
		contentPane.add(lblCantidadNumeros);
		
		txtCantidadNumeros = new JTextField();
		txtCantidadNumeros.setColumns(10);
		txtCantidadNumeros.setBounds(141, 75, 57, 20);
		contentPane.add(txtCantidadNumeros);
		
		JButton btnGenerarSerie = new JButton("Generar Serie");
		btnGenerarSerie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			int intNumero1 = Integer.parseInt(txtNumero1.getText());
			int intNumero2 = Integer.parseInt(txtNumero2.getText());
			int intCantidadNumeros = Integer.parseInt(txtCantidadNumeros.getText());
			int intSuma = 0;
			String strCadenaSerie = "";
			
				for(int x = 0; x <= intCantidadNumeros; x++) {
					intNumero1 = intNumero2;
					intNumero2 = intSuma;
					intSuma = intNumero1 + intNumero2;
					
					strCadenaSerie = strCadenaSerie + "\n" + intSuma;
					System.out.println(intNumero2);
			}
				txtSerieOutput.setText(strCadenaSerie);
			}
		});
		btnGenerarSerie.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGenerarSerie.setBounds(45, 106, 120, 23);
		contentPane.add(btnGenerarSerie);
		
		txtSerieOutput = new JTextArea();
		txtSerieOutput.setEditable(false);
		txtSerieOutput.setBounds(208, 10, 216, 240);
		contentPane.add(txtSerieOutput);
	}
}
	
