package expresion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;
import java.awt.Toolkit;

public class EvaluarExpresionVentana extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtExpresionInput;
	private JTextArea txtSalidaExpresion;
	private Stack<Character> pilaExpresion;
	String strExpresion;
	char chrCaracter;
	boolean bolError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EvaluarExpresionVentana frame = new EvaluarExpresionVentana();
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
	public EvaluarExpresionVentana() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EvaluarExpresionVentana.class.getResource("/expresion/parentesis.png")));
		setTitle("Evaluador de Par\u00E9ntesis");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblExpresionAEvaluar = new JLabel("Expresi\u00F3n a evaluar:");
		lblExpresionAEvaluar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExpresionAEvaluar.setBounds(10, 11, 131, 22);
		contentPane.add(lblExpresionAEvaluar);
		
		txtExpresionInput = new JTextField();
		txtExpresionInput.setToolTipText("Ingrese su expresi\u00F3n aqu\u00ED");
		txtExpresionInput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtExpresionInput.setBounds(137, 11, 287, 22);
		contentPane.add(txtExpresionInput);
		txtExpresionInput.setColumns(10);
		
		txtSalidaExpresion = new JTextArea();
		txtSalidaExpresion.setLineWrap(true);
		txtSalidaExpresion.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtSalidaExpresion.setToolTipText("Ventana de salida");
		txtSalidaExpresion.setBounds(10, 133, 414, 117);
		contentPane.add(txtSalidaExpresion);
		
		JButton btnEvaluarExpresion = new JButton("Evaluar");
		btnEvaluarExpresion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtSalidaExpresion.setText("");
				bolError = false;
				if (txtExpresionInput.getText().equals("")) {
					txtSalidaExpresion.setText("Campo de expresión vacío");
					return;
				}
				pilaExpresion = new Stack<Character>();
				strExpresion = txtExpresionInput.getText();
				
				for(int i = 0; i < strExpresion.length(); i++) {
					chrCaracter = strExpresion.charAt(i);
					
					if(chrCaracter == '(') {
						pilaExpresion.push(chrCaracter);
					}
					
					if(chrCaracter == ')') {
						if(pilaExpresion.empty()) {
							bolError = true;
							break;
						}
						pilaExpresion.pop();
					}
				}
				
				if (pilaExpresion.empty() && !bolError) {
					txtSalidaExpresion.setText(strExpresion + "\n" + "Expresión Correcta");
					return;
				}
				else {
					txtSalidaExpresion.setText(strExpresion + "\n" + "Expresión Incorrecta");
					return;
				}
			}
		});
		btnEvaluarExpresion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEvaluarExpresion.setBounds(10, 57, 166, 34);
		contentPane.add(btnEvaluarExpresion);
		
		JButton btnEliminarExpresion = new JButton("Eliminar ");
		btnEliminarExpresion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtExpresionInput.setText("");
				txtSalidaExpresion.setText("");
			}
		});
		btnEliminarExpresion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEliminarExpresion.setBounds(258, 57, 166, 34);
		contentPane.add(btnEliminarExpresion);
	}
}
