package ex2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ex1.Convercao;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NomeComp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfSobrenome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NomeComp frame = new NomeComp();
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
	public NomeComp() {
		setTitle("Nome completo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNome.setBounds(56, 61, 97, 13);
		contentPane.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Monospaced", Font.PLAIN, 17));
		tfNome.setBounds(121, 60, 322, 19);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome :");
		lblSobrenome.setHorizontalAlignment(SwingConstants.LEFT);
		lblSobrenome.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSobrenome.setBounds(56, 138, 120, 13);
		contentPane.add(lblSobrenome);
		
		tfSobrenome = new JTextField();
		tfSobrenome.setFont(new Font("Monospaced", Font.PLAIN, 16));
		tfSobrenome.setBounds(161, 137, 278, 19);
		contentPane.add(tfSobrenome);
		tfSobrenome.setColumns(10);
		
		JLabel lblNomeCompleto = new JLabel("");
		lblNomeCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeCompleto.setForeground(new Color(128, 0, 64));
		lblNomeCompleto.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNomeCompleto.setBounds(56, 251, 387, 30);
		contentPane.add(lblNomeCompleto);
		
		JButton btnMostrarNome = new JButton("Mostrar nome completo");
		btnMostrarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nomeComp = tfNome.getText()+" "+tfSobrenome.getText();
				
				if (tfNome.getText().isEmpty()) 
				{
					lblNomeCompleto.setText("Insira nome !");
					return;
				}
				
				lblNomeCompleto.setText(nomeComp);
				
			}
		});
		btnMostrarNome.setForeground(new Color(255, 0, 128));
		btnMostrarNome.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		btnMostrarNome.setBounds(123, 205, 235, 21);
		contentPane.add(btnMostrarNome);
		
		
	}
}
