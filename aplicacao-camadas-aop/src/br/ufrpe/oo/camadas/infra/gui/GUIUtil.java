package br.ufrpe.oo.camadas.infra.gui;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUIUtil {
	private static GUIUtil instancia = new GUIUtil();
	private GUIUtil() {
		
	}
	public static GUIUtil getInstancia() {
		return instancia;
	}
	
	public void showError(Throwable t) {
		this.showError(t.getMessage());
	}
	
	public void showError(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
	}
	public boolean validarCampoObrigatorio(JTextField textField, String campo) {
		if (textField.getText().trim().length() == 0) {
			return tratarErroCampoObrigatorio(textField, campo);
		}
		return true;
	}
	public boolean validarCampoObrigatorio(JPasswordField passwordField, String campo) {
		if (new String(passwordField.getPassword()).trim().length() == 0) {
			return tratarErroCampoObrigatorio(passwordField, campo);
		}
		return true;
	}
	private boolean tratarErroCampoObrigatorio(JComponent component, String campo) {
		showError("Campo " + campo + " não pode ser vazio.");
		component.requestFocusInWindow();
		return false;
	}
}
