package br.ufrpe.oo.camadas.usuario.gui;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.ufrpe.oo.camadas.infra.MeuProjetoException;
import br.ufrpe.oo.camadas.infra.gui.GUIUtil;
import br.ufrpe.oo.camadas.usuario.negocio.UsuarioServices;


public class LoginUsuarioForm extends JFrame {
	private static final long serialVersionUID = 1L;
	private GUIUtil guiUtil = GUIUtil.getInstancia();
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUsuarioForm frame = new LoginUsuarioForm();
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
	public LoginUsuarioForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Login");
		lblNome.setBounds(20, 28, 46, 14);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(83, 25, 218, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(20, 80, 46, 14);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(83, 77, 218, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnNewButton.setBounds(212, 122, 89, 23);
		contentPane.add(btnNewButton);
		
		
		JButton btnInserir = new JButton("Tela de Cadastro");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InserirUsuarioForm form = new InserirUsuarioForm();
				form.setVisible(true);
				LoginUsuarioForm.this.setVisible(false);
			}
		});
		btnInserir.setBounds(20, 122, 130, 23);
		contentPane.add(btnInserir);
		
		this.setTitle("Login");
	}

	private void login() {
		if (!validarCampos()) {
			return;
		}
		
		UsuarioServices services = UsuarioServices.getInstancia();
		try {
			services.login(textField.getText(), new String(passwordField.getPassword()));
		} catch (MeuProjetoException e) {
			guiUtil.showError(e);
		}
	}
	private boolean validarCampos() {
		//Atenção para a sobrecarga dos métodos de validar campo obrigatório na classe GUIUtil
		if(guiUtil.validarCampoObrigatorio(textField, "login")
				&& guiUtil.validarCampoObrigatorio(passwordField, "senha")){
			return true;
		}
		return false;
	}
}