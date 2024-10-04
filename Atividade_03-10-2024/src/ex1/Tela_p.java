package ex1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_p extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfFh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_p frame = new Tela_p();
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
	public Tela_p() {
		setTitle("Convertor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCel = new JLabel("Temperatura celcius :");
		lblCel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCel.setBounds(71, 133, 216, 32);
		contentPane.add(lblCel);
		
		JLabel lblFah = new JLabel("Temperatura farenheit :");
		lblFah.setHorizontalAlignment(SwingConstants.CENTER);
		lblFah.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblFah.setBounds(84, 71, 216, 32);
		contentPane.add(lblFah);
		
		tfFh = new JTextField();
		tfFh.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		tfFh.setBounds(301, 60, 96, 39);
		contentPane.add(tfFh);
		tfFh.setColumns(10);
		
		JLabel lblResposta = new JLabel("");
		lblResposta.setHorizontalAlignment(SwingConstants.CENTER);
		lblResposta.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblResposta.setBounds(273, 133, 110, 32);
		contentPane.add(lblResposta);
		
		JLabel lblAviso = new JLabel("");
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso.setFont(new Font("Tw Cen MT", Font.PLAIN, 17));
		lblAviso.setBounds(128, 219, 269, 13);
		contentPane.add(lblAviso);
		
		JButton btnCalc = new JButton("Calcular");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fah = tfFh.getText();
				
				if (fah.isEmpty()) 
				{
					lblAviso.setText("Insira uma temperatura !");
					return;
				}
				
				try {
				double tpFah = Double.parseDouble(fah);
				
				Convercao convercao = new Convercao();
				double rCel = convercao.resposta(tpFah);
				String resp = String.valueOf(rCel);
				
				lblResposta.setText(resp);
				
				} catch(NumberFormatException ex) {
					lblAviso.setText("Insira uma temperatura valida !");
				}
			}
		});
		btnCalc.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnCalc.setBounds(201, 255, 130, 32);
		contentPane.add(btnCalc);
		
	}

}


























