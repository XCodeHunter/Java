package br.com.example.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import br.com.example.dao.LeitorDao;
import br.com.example.model.LeitorModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Index extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeLeitor;
	private LeitorModel leitor;
	private LeitorDao leitorDao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
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
	public Index() {
		setTitle("Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de leitor");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(21, 99, 105, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome do leitor");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(21, 28, 117, 22);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.RED, Color.BLACK));
		lblMensagem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMensagem.setBounds(21, 380, 595, 36);
		contentPane.add(lblMensagem);
		
		txtNomeLeitor = new JTextField();
		txtNomeLeitor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNomeLeitor.setColumns(10);
		txtNomeLeitor.setBounds(174, 23, 444, 36);
		contentPane.add(txtNomeLeitor);
		
		JComboBox ListarTipoLeitor = new JComboBox();
		ListarTipoLeitor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ListarTipoLeitor.setModel(new DefaultComboBoxModel(new String[] {"Selecione uma op\u00E7\u00E3o", "Aluno\t", "Professor", "Adm"}));
		ListarTipoLeitor.setBounds(171, 95, 444, 36);
		contentPane.add(ListarTipoLeitor);
		
		TextArea txtListar = new TextArea();
		txtListar.setBounds(22, 192, 595, 182);
		contentPane.add(txtListar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtNomeLeitor.setText(null);
				txtListar.setText(null);
				ListarTipoLeitor.setSelectedIndex(0);
				lblMensagem.setText(null);
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNovo.setBounds(22, 145, 89, 23);
		contentPane.add(btnNovo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leitor = new LeitorModel();
				leitor.setNomeLeitor(txtNomeLeitor.getText());
				leitor.setTipoLeitor((String)ListarTipoLeitor.getSelectedItem());
				
				
				try {
					leitorDao = new LeitorDao();
					leitorDao.salvar(leitor);
					lblMensagem.setText("SALVO COM SUCESSO");
				} catch (Exception e2) {
					lblMensagem.setText("Erro " + e2.getMessage());
				}
				
				txtNomeLeitor.setText(null);
				txtListar.setText(null);
				ListarTipoLeitor.setSelectedIndex(0);
				
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSalvar.setBounds(121, 145, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListar.setBounds(220, 145, 89, 23);
		contentPane.add(btnListar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAlterar.setBounds(319, 145, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConsultar.setBounds(522, 145, 105, 25);
		contentPane.add(btnConsultar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExcluir.setBounds(418, 145, 89, 23);
		contentPane.add(btnExcluir);
		

	}
}
