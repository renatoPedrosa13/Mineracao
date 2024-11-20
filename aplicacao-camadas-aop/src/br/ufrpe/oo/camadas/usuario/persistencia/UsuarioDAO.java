package br.ufrpe.oo.camadas.usuario.persistencia;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.oo.camadas.infra.dao.BasicDAO;
import br.ufrpe.oo.camadas.usuario.dominio.Usuario;

public class UsuarioDAO extends BasicDAO<Usuario> {
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private static UsuarioDAO instancia = new UsuarioDAO();
	private UsuarioDAO() {}
	public static UsuarioDAO getInstancia() {
		return instancia;
	}

	
	public Usuario consultar(String login, String senha) {
		for (Usuario usuario : this.usuarios) {
			if (login.equals(usuario.getLogin()) 
					&& senha.equals(usuario.getSenha())) {
				return usuario;
			}
		}
		return null;
	}
}
