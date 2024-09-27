import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Teste1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtIdade;
	private JTextField txtNome;
	private JLabel lblResposta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teste1 frame = new Teste1();
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
	public Teste1() {
		getContentPane().setForeground(new Color(0, 0, 0));
		getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 15));
		setTitle("Validador");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNome.setBounds(64, 50, 70, 14);
		getContentPane().add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade :");
		lblIdade.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdade.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblIdade.setBounds(74, 104, 46, 14);
		getContentPane().add(lblIdade);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(133, 102, 86, 20);
		getContentPane().add(txtIdade);
		txtIdade.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(133, 48, 202, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblResposta = new JLabel("");
		lblResposta.setHorizontalAlignment(SwingConstants.CENTER);
		lblResposta.setBounds(10, 201, 414, 50);
		getContentPane().add(lblResposta);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.setForeground(new Color(0, 51, 153));
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String nome = txtNome.getText();
				
				if (nome.isEmpty()) 
				{
					lblResposta.setText("Insira um nome!");
					return;
				}
				
				String idadeStr = txtIdade.getText();
				
				try
				{
				int idade = Integer.parseInt(idadeStr);
				
				if( idade < 0)
				{
					lblResposta.setText("Idade invaida !");
					return;
				}
				
				String mensagem = "Nome : " + nome + ", Idade : " + idade;
				
				if (idade < 18 )
				{
					mensagem += " (Menor de idade)";
				}
				else
				{
					mensagem += " (Maior de idade)";
				}
					
				
				lblResposta.setText(mensagem);
				} catch(NumberFormatException ex)
				{
					lblResposta.setText("Insira uma idade valida!");
				
				}
				
			}
		});
		btnValidar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnValidar.setBounds(166, 167, 89, 23);
		getContentPane().add(btnValidar);
		
	}
	
}






















