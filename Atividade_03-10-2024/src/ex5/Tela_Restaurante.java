package ex5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_Restaurante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfPrecoK;
	private JTextField tfQuilo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Restaurante frame = new Tela_Restaurante();
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
	public Tela_Restaurante() {
		setTitle("Calculo e preço");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 364);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 242, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrecoKilo = new JLabel("Preço do quilo :");
		lblPrecoKilo.setForeground(new Color(0, 64, 0));
		lblPrecoKilo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPrecoKilo.setBounds(100, 98, 131, 21);
		contentPane.add(lblPrecoKilo);
		
		tfPrecoK = new JTextField();
		tfPrecoK.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		tfPrecoK.setBounds(241, 98, 110, 22);
		contentPane.add(tfPrecoK);
		tfPrecoK.setColumns(10);
		
		JLabel lblQuilo = new JLabel("Quilo do prato :");
		lblQuilo.setForeground(new Color(0, 64, 0));
		lblQuilo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblQuilo.setBounds(100, 149, 131, 21);
		contentPane.add(lblQuilo);
		
		tfQuilo = new JTextField();
		tfQuilo.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		tfQuilo.setColumns(10);
		tfQuilo.setBounds(241, 148, 110, 22);
		contentPane.add(tfQuilo);
		
		JLabel lblintro = new JLabel("Calculo o preço do seu prato por quilo !");
		lblintro.setHorizontalAlignment(SwingConstants.CENTER);
		lblintro.setForeground(new Color(128, 0, 64));
		lblintro.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblintro.setBounds(77, 36, 364, 28);
		contentPane.add(lblintro);
		
		JLabel lblResposta = new JLabel("");
		lblResposta.setForeground(new Color(128, 0, 64));
		lblResposta.setHorizontalAlignment(SwingConstants.CENTER);
		lblResposta.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblResposta.setBounds(77, 246, 353, 28);
		contentPane.add(lblResposta);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String precok = tfPrecoK.getText();
				String quilo = tfQuilo.getText();
				
				if (precok.isEmpty()) {
					lblResposta.setText("Insira todos os valores !");
				}
				if (quilo.isEmpty()) {
					lblResposta.setText("Insira todos os valores !");
				}
				
				try {
					double precoQuilo = Double.parseDouble(precok);
					double quiloPrato = Double.parseDouble(quilo);
					
					Double total = quiloPrato*precoQuilo;
					
					String resp = String.valueOf(total);
					
					lblResposta.setText("Total a ser pago : " + resp + " reais");
					
					} catch(NumberFormatException ex) {
						lblResposta.setText("Insira valores validos !");
					}
			}
		});
		btnCalcular.setForeground(new Color(128, 0, 64));
		btnCalcular.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCalcular.setBounds(192, 215, 122, 21);
		contentPane.add(btnCalcular);
	}

}
