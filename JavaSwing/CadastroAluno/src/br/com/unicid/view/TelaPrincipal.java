package br.com.unicid.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtRGM;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtLogradouro;
	private JTextField txtMunicipio;
	private JTextField txtEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public TelaPrincipal() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 380);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuAluno = new JMenu("Aluno");
		menuBar.add(menuAluno);
		
		JMenuItem menuItemSalvar = new JMenuItem("Salvar");
		menuItemSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		menuAluno.add(menuItemSalvar);
		
		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		menuAluno.add(mntmAlterar);
		
		JMenuItem mntmListar = new JMenuItem("LIstar");
		menuAluno.add(mntmListar);
		
		JMenuItem mntmDeletar = new JMenuItem("Deletar");
		menuAluno.add(mntmDeletar);
		
		JSeparator separator = new JSeparator();
		menuAluno.add(separator);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_DOWN_MASK));
		menuAluno.add(mntmSair);
		
		JMenu menuNotas = new JMenu("Notas e faltas");
		menuBar.add(menuNotas);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Salvar");
		menuNotas.add(mntmNewMenuItem);
		
		JMenuItem mntmAlterar_1 = new JMenuItem("Alterar");
		mntmAlterar_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		menuNotas.add(mntmAlterar_1);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		menuNotas.add(mntmExcluir);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		menuNotas.add(mntmConsultar);
		
		JMenu mnNewMenu = new JMenu("Ajuda");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Sobre");
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 43, 576, 265);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Dados pessoais", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblRGM = new JLabel("RGM");
		lblRGM.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRGM.setBounds(10, 11, 46, 14);
		panel.add(lblRGM);
		
		txtRGM = new JTextField();
		txtRGM.setBounds(54, 8, 128, 25);
		panel.add(txtRGM);
		txtRGM.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(217, 11, 46, 14);
		panel.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(270, 8, 236, 25);
		panel.add(txtNome);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataDeNascimento.setBounds(10, 47, 158, 22);
		panel.add(lblDataDeNascimento);
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(330, 47, 30, 22);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(10, 83, 46, 14);
		panel.add(lblNewLabel_1_2);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(63, 80, 478, 25);
		panel.add(txtEmail);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("CEP");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1.setBounds(10, 119, 46, 14);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Logradouro");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1_1.setBounds(223, 115, 90, 22);
		panel.add(lblNewLabel_1_2_1_1);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(323, 116, 218, 25);
		panel.add(txtLogradouro);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Munic\u00EDpio");
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1_2.setBounds(10, 155, 74, 22);
		panel.add(lblNewLabel_1_2_1_2);
		
		txtMunicipio = new JTextField();
		txtMunicipio.setColumns(10);
		txtMunicipio.setBounds(94, 152, 143, 25);
		panel.add(txtMunicipio);
		
		JLabel lblNewLabel_1_2_1_2_1 = new JLabel("Estado");
		lblNewLabel_1_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1_2_1.setBounds(269, 152, 53, 22);
		panel.add(lblNewLabel_1_2_1_2_1);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(331, 148, 209, 25);
		panel.add(txtEstado);
		
		JLabel lblNewLabel_1_2_1_2_2 = new JLabel("Celular");
		lblNewLabel_1_2_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1_2_2.setBounds(10, 191, 74, 22);
		panel.add(lblNewLabel_1_2_1_2_2);
		
		JFormattedTextField fmtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		fmtCpf.setBounds(370, 44, 171, 25);
		panel.add(fmtCpf);
		
		JFormattedTextField fmtCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		fmtCep.setBounds(63, 116, 143, 25);
		panel.add(fmtCep);
		
		JFormattedTextField fmtCelular = new JFormattedTextField( new MaskFormatter("(##) #####-####"));
		fmtCelular.setBounds(76, 188, 143, 25);
		panel.add(fmtCelular);
		
		JFormattedTextField fmtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		fmtData.setBounds(189, 46, 128, 25);
		panel.add(fmtData);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Curso", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurso.setBounds(17, 21, 45, 22);
		panel_1.add(lblCurso);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(70, 14, 439, 31);
		panel_1.add(comboBox);
		
		JLabel lblC = new JLabel("Campus");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblC.setBounds(17, 69, 63, 22);
		panel_1.add(lblC);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(90, 68, 439, 31);
		panel_1.add(comboBox_1);
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPeriodo.setBounds(17, 117, 63, 22);
		panel_1.add(lblPeriodo);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Matutino");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(90, 120, 109, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnVespertino = new JRadioButton("Vespertino");
		rdbtnVespertino.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnVespertino.setBounds(223, 120, 109, 23);
		panel_1.add(rdbtnVespertino);
		
		JRadioButton rdbtnNoturno = new JRadioButton("Noturno");
		rdbtnNoturno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNoturno.setBounds(345, 120, 109, 23);
		panel_1.add(rdbtnNoturno);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Gustavo Casco\\Downloads\\icons8-crie-um-novo-64.png"));
		btnNewButton.setBounds(47, 150, 82, 76);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Gustavo Casco\\Downloads\\icons8-desligar-48.png"));
		btnNewButton_1.setBounds(439, 150, 122, 76);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Gustavo Casco\\Downloads\\icons8-leitura-48.png"));
		btnNewButton_2.setBounds(142, 150, 82, 76);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.setIcon(new ImageIcon("C:\\Users\\Gustavo Casco\\Downloads\\icons8-update-60.png"));
		btnNewButton_2_1.setBounds(234, 150, 82, 76);
		panel_1.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("");
		btnNewButton_2_1_1.setIcon(new ImageIcon("C:\\Users\\Gustavo Casco\\Downloads\\icons8-remover-48.png"));
		btnNewButton_2_1_1.setBounds(326, 150, 82, 76);
		panel_1.add(btnNewButton_2_1_1);
	}
}
