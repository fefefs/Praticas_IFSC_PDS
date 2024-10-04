package ex4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ex1.Convercao;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_Gasolina extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfPreco;
	private JTextField tfPago;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Gasolina frame = new Tela_Gasolina();
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
	public Tela_Gasolina() {
		setTitle("Calcular gasolina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPreco = new JLabel("Preço por litro :");
		lblPreco.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPreco.setBounds(107, 87, 152, 19);
		contentPane.add(lblPreco);
		
		tfPreco = new JTextField();
		tfPreco.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		tfPreco.setBounds(240, 87, 96, 19);
		contentPane.add(tfPreco);
		tfPreco.setColumns(10);
		
		JLabel lblPagamento = new JLabel("Preço pago  :");
		lblPagamento.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPagamento.setBounds(130, 134, 119, 19);
		contentPane.add(lblPagamento);
		
		tfPago = new JTextField();
		tfPago.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		tfPago.setColumns(10);
		tfPago.setBounds(240, 134, 96, 19);
		contentPane.add(tfPago);
		
		JLabel lblTotal = new JLabel("");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setForeground(new Color(128, 0, 64));
		lblTotal.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblTotal.setBounds(96, 238, 309, 29);
		contentPane.add(lblTotal);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String gasP = tfPreco.getText();
				String pag = tfPago.getText();
				
				if (gasP.isEmpty()) {
					lblTotal.setText("Insira todos os valores !");
				}
				if (pag.isEmpty()) {
					lblTotal.setText("Insira todos os valores !");
				}
				
				try {
					double gaspreco = Double.parseDouble(gasP);
					double pago = Double.parseDouble(pag);
					
					Double total = pago/gaspreco;
					
					String resp = String.valueOf(total);
					
					lblTotal.setText("Total de litros : " + resp + " L");
					
					} catch(NumberFormatException ex) {
						lblTotal.setText("Insira valores validos !");
					}
			}
		});
		btnCalcular.setForeground(new Color(255, 0, 128));
		btnCalcular.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCalcular.setBounds(187, 198, 119, 19);
		contentPane.add(btnCalcular);
	}

}
