import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.event.CaretListener;

import com.google.gson.Gson;

import javax.swing.event.CaretEvent;

public class JIUFDHGUIED extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblCep;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JIUFDHGUIED frame = new JIUFDHGUIED();
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
	public JIUFDHGUIED() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setFocusTraversalKeysEnabled(false);
		textField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				System.out.println("Passou aq");
				if (textField.getText().toString().length() == 8) {
					Endereco adress;
					try {
						adress = ConsultarCEP(textField.getText());
						textField_1.setText(adress.logradouro);
						textField_2.setText(adress.bairro);
						System.out.println(adress.logradouro);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					textField.setEnabled(false);
				}
			}
		});

		// textField.addKeyListener(new KeyAdapter() {
		// @Override
		// public void keyPressed(KeyEvent arg0) {
		// if(arg0.getKeyCode() == 10)
		// System.out.println(textField.getText());
		// }
		// });
		textField.setBounds(21, 44, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblCep = new JLabel("CEP");
		lblCep.setBounds(21, 22, 46, 14);
		contentPane.add(lblCep);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 44, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(249, 44, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}

	private Endereco ConsultarCEP(String cep) throws Exception {
		try {
			String urlParaChamada = "http://viacep.com.br/ws/" + cep + "/json";

			URL url = new URL(urlParaChamada);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

			if (conexao.getResponseCode() != 200)
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

			BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
			String jsonEmString = converteJsonEmString(resposta);

			Gson gson = new Gson();
			Endereco endereco = gson.fromJson(jsonEmString, Endereco.class);

			return endereco;
		} catch (Exception e) {
			throw new Exception("ERRO: " + e);
		}
	}
	
	private static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
        String resposta, jsonEmString = "";
        while ((resposta = buffereReader.readLine()) != null) {
            jsonEmString += resposta;
        }
        return jsonEmString;
    }
}
