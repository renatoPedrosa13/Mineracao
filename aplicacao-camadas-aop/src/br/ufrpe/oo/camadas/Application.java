package br.ufrpe.oo.camadas;

import java.awt.EventQueue;

import br.ufrpe.oo.camadas.usuario.gui.InserirUsuarioForm;

public class Application {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserirUsuarioForm frame = new InserirUsuarioForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}