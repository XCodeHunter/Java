package br.com.unicid.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.MaskFormatter;

import br.com.unicid.dao.AlunoDao;
import br.com.unicid.dao.CampusDao;
import br.com.unicid.dao.CursoDao;
import br.com.unicid.integration.ViaCepIntegration;
import br.com.unicid.model.AlunoModel;
import br.com.unicid.model.CampusModel;
import br.com.unicid.model.CursoModel;
import br.com.unicid.model.EnderecoModel;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JTextField txtRGM;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtLogradouro;
	private JTextField txtMunicipio;
	private JTextField txtEstado;

	private ViaCepIntegration via = new ViaCepIntegration();
	private JTextField txtCep;
	private AlunoDao alunoDao;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	@SuppressWarnings("rawtypes")
	public Tela() throws ParseException {
		CampusDao campus = new CampusDao();
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

		JFormattedTextField fmtCelular = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		fmtCelular.setBounds(76, 188, 143, 25);
		panel.add(fmtCelular);

		JFormattedTextField fmtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		fmtData.setBounds(189, 46, 128, 25);
		panel.add(fmtData);

		txtCep = new JTextField();
		txtCep.setFocusTraversalKeysEnabled(false);
		txtCep.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				if (txtCep.getText().toString().length() == 8) {
					EnderecoModel adress;
					try {
						adress = via.ConsultarCEP(txtCep.getText());
						txtLogradouro.setText(adress.getLogradouro());
						txtMunicipio.setText(adress.getLocalidade());
						txtEstado.setText(adress.getUf());
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
		});
		txtCep.setBounds(63, 116, 143, 25);;
		panel.add(txtCep);
		txtCep.setColumns(10);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Curso", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurso.setBounds(17, 21, 45, 22);
		panel_1.add(lblCurso);
		
		JComboBox cbxCampus = new JComboBox();
		extracted(cbxCampus);
		cbxCampus.setBounds(90, 68, 439, 31);
		panel_1.add(cbxCampus);

		JComboBox cbxCurso = new JComboBox();
		cbxCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CursoModel curso = (CursoModel) cbxCurso.getSelectedItem();
				cbxCampus.removeAllItems();
				extracted(cbxCampus);
				campus.listarCurso().stream().forEach((cam) -> {
				if(curso.getCampus().getIdCampus() == cam.getIdCampus())
						cbxCampus.addItem(cam); 
				});
			}
		});
		extracted(cbxCurso);
		cbxCurso.setBounds(70, 14, 439, 31);
		panel_1.add(cbxCurso);

		JLabel lblC = new JLabel("Campus");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblC.setBounds(17, 69, 63, 22);
		panel_1.add(lblC);


		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPeriodo.setBounds(17, 117, 63, 22);
		panel_1.add(lblPeriodo);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Matutino");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(119, 117, 109, 23);
		panel_1.add(rdbtnNewRadioButton);

		JRadioButton rdbtnVespertino = new JRadioButton("Vespertino");
		buttonGroup.add(rdbtnVespertino);
		rdbtnVespertino.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnVespertino.setBounds(230, 118, 109, 23);
		panel_1.add(rdbtnVespertino);

		JRadioButton rdbtnNoturno = new JRadioButton("Noturno");
		buttonGroup.add(rdbtnNoturno);
		rdbtnNoturno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNoturno.setBounds(349, 118, 109, 23);
		panel_1.add(rdbtnNoturno);

		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AlunoModel aluno;
				try {
					aluno = new AlunoModel();
					aluno.setRgm(Integer.parseInt(txtRGM.getText()));
					aluno.setNome(txtNome.getText());
					aluno.setDataNascimento(fmtData.getText());
					aluno.setCpf(fmtCpf.getText());
					aluno.setEmail(txtEmail.getText());
					aluno.setCep(txtCep.getText());
					aluno.setLogradouro(txtLogradouro.getText());
					aluno.setMunicipio(txtMunicipio.getText());
					aluno.setEstado(txtEstado.getText());
					aluno.setCelular(fmtCelular.getText());
					
					CursoModel curso = (CursoModel) cbxCurso.getSelectedItem();
					curso.setIdCurso(curso.getIdCurso());
					
					CampusModel campuscbx = (CampusModel) cbxCampus.getSelectedItem();
					curso.setCampus(campuscbx);
					curso.setCurso(curso.getCurso());
					
					
					if (rdbtnNewRadioButton.isSelected()) {
						curso.setPeriodo(rdbtnNewRadioButton.getText());
					} else if (rdbtnNoturno.isSelected()) {
						curso.setPeriodo(rdbtnNoturno.getText());
					}else {
						curso.setPeriodo(rdbtnVespertino.getText());
					}
					
					
					aluno.setCurso(curso);
					
					alunoDao = new AlunoDao();
					alunoDao.salvar(aluno);
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}


			}
		});
		btnSalvar.setIcon(new ImageIcon(".\\Images\\icons8-crie-um-novo-64.png"));
		btnSalvar.setBounds(47, 150, 82, 76);
		panel_1.add(btnSalvar);

		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(".\\Images\\icons8-desligar-48.png"));
		btnSair.setBounds(439, 150, 122, 76);
		panel_1.add(btnSair);

		JButton btnLeitura = new JButton("");
		btnLeitura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLeitura.setIcon(new ImageIcon(".\\Images\\icons8-leitura-48.png"));
		btnLeitura.setBounds(139, 150, 82, 76);
		panel_1.add(btnLeitura);

		JButton btnAtualizar = new JButton("");
		btnAtualizar.setIcon(new ImageIcon(".\\Images\\icons8-update-60.png"));
		btnAtualizar.setBounds(234, 150, 82, 76);
		panel_1.add(btnAtualizar);

		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(".\\Images\\icons8-remover-48.png"));
		btnExcluir.setBounds(326, 150, 82, 76);
		panel_1.add(btnExcluir);
		
		CursoDao dao = new CursoDao();
		
		dao.listarCurso().stream().forEach((c) -> {
			cbxCurso.addItem(c);
		});
	}

	private void extracted(JComboBox cbxCurso) {
		cbxCurso.setModel(new DefaultComboBoxModel(new String[] {"Selecione uma op\u00E7\u00E3o"}));
	}
}
