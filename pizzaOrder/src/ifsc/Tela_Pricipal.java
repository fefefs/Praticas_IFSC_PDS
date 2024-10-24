package ifsc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_Pricipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	ButtonGroup  btns = new ButtonGroup();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Pricipal frame = new Tela_Pricipal();
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
	public Tela_Pricipal() {
		setTitle("Pedido de Pizza");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 549);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 220, 185));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 202, 228));
		panel.setBounds(9, 10, 756, 67);
		contentPane.add(panel);
		
		JLabel lblPedido = new JLabel("Faça aqui o seu pedido !!");
		panel.add(lblPedido);
		lblPedido.setForeground(new Color(217, 0, 108));
		lblPedido.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedido.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JPanel pnlSabores = new JPanel();
		pnlSabores.setBackground(new Color(255, 202, 228));
		pnlSabores.setBounds(9, 131, 188, 300);
		contentPane.add(pnlSabores);
		pnlSabores.setLayout(null);
		
		JCheckBox chckbxPortuguesa = new JCheckBox("Portuguêsa");
		chckbxPortuguesa.setForeground(new Color(255, 128, 0));
		chckbxPortuguesa.setBackground(new Color(255, 238, 221));
		chckbxPortuguesa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxPortuguesa.setBounds(17, 55, 159, 38);
		chckbxPortuguesa.setHorizontalAlignment(SwingConstants.LEFT);
		pnlSabores.add(chckbxPortuguesa);
		
		
		
		JLabel lblSabores = new JLabel("Sabor(es)");
		lblSabores.setForeground(new Color(240, 0, 120));
		lblSabores.setHorizontalAlignment(SwingConstants.CENTER);
		lblSabores.setBounds(2, 18, 159, 21);
		lblSabores.setBackground(new Color(255, 200, 227));
		pnlSabores.add(lblSabores);
		lblSabores.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		JCheckBox chckbxQuatroQueijos = new JCheckBox("Quatro queijos");
		chckbxQuatroQueijos.setForeground(new Color(255, 128, 0));
		chckbxQuatroQueijos.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxQuatroQueijos.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxQuatroQueijos.setBackground(new Color(255, 238, 221));
		chckbxQuatroQueijos.setBounds(15, 102, 161, 38);
		pnlSabores.add(chckbxQuatroQueijos);
		
		
		
		JCheckBox chckbxCalabresa = new JCheckBox("Calabresa");
		chckbxCalabresa.setForeground(new Color(255, 128, 0));
		chckbxCalabresa.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxCalabresa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxCalabresa.setBackground(new Color(255, 238, 221));
		chckbxCalabresa.setBounds(15, 151, 161, 38);
		pnlSabores.add(chckbxCalabresa);
		
		
		
		JCheckBox chckbxVegetariana = new JCheckBox("Vegetariana");
		chckbxVegetariana.setForeground(new Color(255, 128, 0));
		chckbxVegetariana.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxVegetariana.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxVegetariana.setBackground(new Color(255, 238, 221));
		chckbxVegetariana.setBounds(14, 198, 162, 38);
		pnlSabores.add(chckbxVegetariana);
		
		
		
		JCheckBox chckbxFrango = new JCheckBox("Frango");
		chckbxFrango.setForeground(new Color(255, 128, 0));
		chckbxFrango.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxFrango.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxFrango.setBackground(new Color(255, 238, 221));
		chckbxFrango.setBounds(14, 248, 162, 38);
		pnlSabores.add(chckbxFrango);
		
		
		
		JPanel pnlOpcionais = new JPanel();
		pnlOpcionais.setBackground(new Color(255, 202, 228));
		pnlOpcionais.setBounds(207, 131, 225, 260);
		contentPane.add(pnlOpcionais);
		pnlOpcionais.setLayout(null);
		
		JLabel lblOpcionais = new JLabel("Opcionais");
		lblOpcionais.setBounds(16, 10, 192, 30);
		lblOpcionais.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpcionais.setForeground(new Color(240, 0, 120));
		lblOpcionais.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblOpcionais.setBackground(new Color(255, 200, 227));
		pnlOpcionais.add(lblOpcionais);
		
		JCheckBox chckbxPPepperoni = new JCheckBox("Pepperoni ");
		chckbxPPepperoni.setForeground(new Color(255, 128, 0));
		chckbxPPepperoni.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxPPepperoni.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxPPepperoni.setBackground(new Color(255, 238, 221));
		chckbxPPepperoni.setBounds(16, 56, 192, 30);
		pnlOpcionais.add(chckbxPPepperoni);
		
		
		JCheckBox chckbxAzeitonas = new JCheckBox("Azeitonas ");
		chckbxAzeitonas.setForeground(new Color(255, 128, 0));
		chckbxAzeitonas.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxAzeitonas.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxAzeitonas.setBackground(new Color(255, 238, 221));
		chckbxAzeitonas.setBounds(16, 88, 192, 30);
		pnlOpcionais.add(chckbxAzeitonas);
		
		
		
		JCheckBox chckbxPimentão = new JCheckBox("Pimentão");
		chckbxPimentão.setForeground(new Color(255, 128, 0));
		chckbxPimentão.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxPimentão.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxPimentão.setBackground(new Color(255, 238, 221));
		chckbxPimentão.setBounds(16, 120, 192, 30);
		pnlOpcionais.add(chckbxPimentão);
		
		
		JCheckBox chckbxCebolaRoxa = new JCheckBox("Cebola roxa");
		chckbxCebolaRoxa.setForeground(new Color(255, 128, 0));
		chckbxCebolaRoxa.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxCebolaRoxa.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxCebolaRoxa.setBackground(new Color(255, 238, 221));
		chckbxCebolaRoxa.setBounds(16, 152, 192, 30);
		pnlOpcionais.add(chckbxCebolaRoxa);
		
		
		
		JCheckBox chckbxCogumelos = new JCheckBox("Cogumelos ");
		chckbxCogumelos.setForeground(new Color(255, 128, 0));
		chckbxCogumelos.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxCogumelos.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxCogumelos.setBackground(new Color(255, 238, 221));
		chckbxCogumelos.setBounds(16, 184, 192, 30);
		pnlOpcionais.add(chckbxCogumelos);
		
		
		JCheckBox chckbxManjericão = new JCheckBox("Manjericão fresco ");
		chckbxManjericão.setForeground(new Color(255, 128, 0));
		chckbxManjericão.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxManjericão.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		chckbxManjericão.setBackground(new Color(255, 238, 221));
		chckbxManjericão.setBounds(16, 216, 192, 30);
		pnlOpcionais.add(chckbxManjericão);
		
		
		
		JPanel pnlBorda = new JPanel();
		pnlBorda.setBackground(new Color(255, 202, 228));
		pnlBorda.setBounds(442, 131, 323, 95);
		contentPane.add(pnlBorda);
		pnlBorda.setLayout(null);
		
		JRadioButton rdbtnCBorda = new JRadioButton("Com borda");
		rdbtnCBorda.setBackground(new Color(255, 235, 215));
		rdbtnCBorda.setForeground(new Color(255, 128, 0));
		rdbtnCBorda.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdbtnCBorda.setBounds(26, 50, 129, 30);
		pnlBorda.add(rdbtnCBorda);
		btns.add(rdbtnCBorda);
		
		
		JLabel lblBorda = new JLabel("Borda ?");
		lblBorda.setHorizontalAlignment(SwingConstants.CENTER);
		lblBorda.setForeground(new Color(240, 0, 120));
		lblBorda.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblBorda.setBackground(new Color(255, 200, 227));
		lblBorda.setBounds(64, 10, 192, 30);
		pnlBorda.add(lblBorda);
		
		JRadioButton rdbtnSemBorda = new JRadioButton("Sem borda");
		rdbtnSemBorda.setForeground(new Color(255, 128, 0));
		rdbtnSemBorda.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rdbtnSemBorda.setBackground(new Color(255, 235, 215));
		rdbtnSemBorda.setBounds(169, 50, 136, 30);
		pnlBorda.add(rdbtnSemBorda);
		btns.add(rdbtnSemBorda);
		
		
		
		JPanel pnlEntrega = new JPanel();
		pnlEntrega.setBackground(new Color(255, 202, 228));
		pnlEntrega.setBounds(442, 236, 323, 154);
		contentPane.add(pnlEntrega);
		pnlEntrega.setLayout(null);
		
		JComboBox cbEntrega = new JComboBox();
		cbEntrega.setBackground(new Color(255, 220, 185));
		cbEntrega.setForeground(new Color(255, 128, 0));
		cbEntrega.setModel(new DefaultComboBoxModel(new String[] {""}));
		cbEntrega.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cbEntrega.setBounds(10, 66, 303, 38);
		pnlEntrega.add(cbEntrega);
		cbEntrega.addItem("Tele entrega");
		cbEntrega.addItem("Retirada");
		cbEntrega.addItem("Comer no local");
		
		
		JLabel lblTipoDeEntrega = new JLabel("Tipo de entrega");
		lblTipoDeEntrega.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoDeEntrega.setForeground(new Color(240, 0, 120));
		lblTipoDeEntrega.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTipoDeEntrega.setBackground(new Color(255, 200, 227));
		lblTipoDeEntrega.setBounds(59, 10, 192, 30);
		pnlEntrega.add(lblTipoDeEntrega);
		
		
		
		JPanel pnlFinPedido = new JPanel();
		pnlFinPedido.setBackground(new Color(255, 162, 208));
		pnlFinPedido.setBounds(207, 401, 558, 30);
		contentPane.add(pnlFinPedido);
		pnlFinPedido.setLayout(null);
		
		JLabel lblResposta = new JLabel("");
		lblResposta.setHorizontalAlignment(SwingConstants.CENTER);
		lblResposta.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblResposta.setBounds(9, 441, 756, 61);
		contentPane.add(lblResposta);
		
		
		JButton btnFinalizarPedido = new JButton("Finalizar pedido");
		btnFinalizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double precoSabor = 0.0;
				int saborCount = 0;
				Double precoAdicionais = 0.0;
				Double precoEntrega = 0.0;
				Double precoBorda = 0.0;
				Double precoFinal = 0.0;
				
				if(chckbxPortuguesa.isSelected() ) {
					precoSabor = precoSabor + 10.0;
					saborCount++;
				}
				if(chckbxQuatroQueijos.isSelected() ) {
					precoSabor = precoSabor + 6.0;
					saborCount++;
				}
				
				if(chckbxCalabresa.isSelected() ) {
					precoSabor = precoSabor + 8.0;
					saborCount++;
				}
				
				if(chckbxVegetariana.isSelected() ) {
					precoSabor = precoSabor + 7.0;
					saborCount++;
				}
				
				if(chckbxFrango.isSelected() ) {
					precoSabor = precoSabor + 5.5;
					saborCount++;
				}
				//**************************************************************
				if(chckbxPPepperoni.isSelected() ) {
					 precoAdicionais++;
				}
				
				if(chckbxAzeitonas.isSelected() ) {
					 precoAdicionais++;
				}
				
				if(chckbxPimentão.isSelected() ) {
					 precoAdicionais++;
				}
				
				if(chckbxCebolaRoxa.isSelected() ) {
					precoAdicionais++;
				}
				
				if(chckbxCogumelos.isSelected() ) {
					 precoAdicionais++;
				}
				
				if(chckbxManjericão.isSelected() ) {
					 precoAdicionais++;
				}
				
				//**************************************************
				
				int selectBorda = 0;
				if(rdbtnCBorda.isSelected() ) {
					precoBorda = precoBorda + 2;
					selectBorda = 1;
				} else {
				
				if(rdbtnSemBorda.isSelected() ) {
					selectBorda = 2;
				}
				}
				
				if(selectBorda == 0) {
					lblResposta.setText("Por favor selecione o tipo de borda da sua pizza!");
				}
				
				//***************************************************
				boolean selectEntrega = false;
				String entrega = (String)cbEntrega.getSelectedItem();
				if(entrega.contains("Tele entrega")) {
					precoEntrega = precoEntrega + 8.50;
					selectEntrega = true;
				}else {
					if(entrega.contains("Retirada")) {
						precoEntrega = 0.0;
						selectEntrega = true;
					}else {
						if(entrega.contains("Comer no local")) {
							precoEntrega = 0.0;
							selectEntrega = true;
						}else {
						precoEntrega = 0.0;
						selectEntrega = false;
					}
				}
			}
				
				if(selectEntrega == false) {
					lblResposta.setText("Por favor selecione o tipo de entrega");
				}
				
				
				if(saborCount > 3 || saborCount == 0) {
					lblResposta.setText("Por favor selecione no minimo 1 e no maximo 3 sabores para a sua pizza!");
				} else {
					precoFinal = precoFinal + precoSabor + precoAdicionais + precoBorda + precoEntrega;
					lblResposta.setText("O preço final do seu pedido é : " + precoFinal);
				}
				
			}
		});
		btnFinalizarPedido.setBounds(164, 0, 197, 29);
		btnFinalizarPedido.setForeground(new Color(255, 0, 128));
		btnFinalizarPedido.setBackground(new Color(255, 162, 208));
		btnFinalizarPedido.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		pnlFinPedido.add(btnFinalizarPedido);
		
		
		
		
		
		
		
		
		
		
	}
}
