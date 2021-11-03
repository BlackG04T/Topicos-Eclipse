package barraProgreso;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class barraProgreso extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean flagReiniciar = false;
	private JLabel lblFinalizado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					barraProgreso frame = new barraProgreso();
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
	public barraProgreso() {
		setTitle("Thread Progressbar Ciclo For");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 157);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JProgressBar pgbBarra = new JProgressBar();
		pgbBarra.setBounds(10, 82, 438, 25);
		contentPane.add(pgbBarra);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			     try {
			    	 if(!flagReiniciar) {
			         for(int i = 0; i <= 100; i++) {
			        	 Thread.sleep(500);
			             i += 10;
			             pgbBarra.setValue(i);
			         }
			         flagReiniciar = true;
			         lblFinalizado.setText("BUCLE FINALIZADO");
			         return;
			    	 }
			         if(flagReiniciar) {
			        	 pgbBarra.setValue(0);
			        	 flagReiniciar = false;
			        	 lblFinalizado.setText(" ");
			        	 return;
			         }
			        	 
			     }
			     catch (Exception ex) {
			         System.err.println( ex.getMessage() );
			     }
			}
		});
		btnIniciar.setBounds(174, 11, 129, 37);
		contentPane.add(btnIniciar);
		
		lblFinalizado = new JLabel(" ");
		lblFinalizado.setBounds(174, 44, 129, 37);
		contentPane.add(lblFinalizado);
	}
}
