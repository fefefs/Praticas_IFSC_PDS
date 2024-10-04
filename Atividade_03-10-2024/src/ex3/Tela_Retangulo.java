package ex3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ex1.Convercao;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_Retangulo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfBase;
	private JTextField tfAltura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Retangulo frame = new Tela_Retangulo();
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
	public Tela_Retangulo() {
		setTitle("Calculador triangulo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBase = new JLabel("Base :");
		lblBase.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblBase.setBounds(156, 72, 77, 13);
		contentPane.add(lblBase);
		
		JLabel lblAltura = new JLabel("Altura :");
		lblAltura.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAltura.setBounds(145, 133, 77, 13);
		contentPane.add(lblAltura);
		
		tfBase = new JTextField();
		tfBase.setHorizontalAlignment(SwingConstants.CENTER);
		tfBase.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		tfBase.setBounds(222, 69, 96, 19);
		contentPane.add(tfBase);
		tfBase.setColumns(10);
		
		tfAltura = new JTextField();
		tfAltura.setHorizontalAlignment(SwingConstants.CENTER);
		tfAltura.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		tfAltura.setBounds(222, 130, 96, 19);
		contentPane.add(tfAltura);
		tfAltura.setColumns(10);
		
		JLabel lblPerimetro = new JLabel("");
		lblPerimetro.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerimetro.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblPerimetro.setBounds(111, 242, 301, 32);
		contentPane.add(lblPerimetro);
		
		JLabel lblArea = new JLabel("");
		lblArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblArea.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblArea.setBounds(111, 284, 301, 32);
		contentPane.add(lblArea);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String alt = tfAltura.getText();
				String bs = tfBase.getText();
				
				if (alt.isEmpty()) 
				{
					lblPerimetro.setText("Insira valores !");
					return;
				}
				if (bs.isEmpty()) 
				{
					lblPerimetro.setText("insira valores !");
					return;
				}
				
				try {
				int altura = Integer.valueOf(alt);
				int base = Integer.valueOf(bs);
				
				Retangulo retangulo = new Retangulo();
				int perimetro = retangulo.perimetro(altura, base);
				String periResp = String.valueOf(perimetro);
				
				lblPerimetro.setText("Perimetro : "+periResp);
				

				int area = retangulo.Area(altura, base);
				String areaResp = String.valueOf(area);
				
				lblArea.setText("Area : "+areaResp);
				
				} catch(NumberFormatException ex) {
					lblPerimetro.setText("Insira uma valor valido !");
				}
			}
		});
		btnCalcular.setForeground(new Color(128, 0, 64));
		btnCalcular.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCalcular.setBounds(210, 211, 108, 21);
		contentPane.add(btnCalcular);
		
		
	}

}
