package br.ufrpe.oo.camadas.usuario.negocio;

import java.util.List;

import br.ufrpe.oo.camadas.infra.MeuProjetoException;
import br.ufrpe.oo.camadas.usuario.dominio.Usuario;
import br.ufrpe.oo.camadas.usuario.persistencia.UsuarioDAO;

public class UsuarioServices {
	private UsuarioDAO dao = UsuarioDAO.getInstancia();
	
	private static UsuarioServices instancia = new UsuarioServices();
	private UsuarioServices() {}
	public static UsuarioServices getInstancia() {
		return instancia;
	}
	
	public void inserir(Usuario usuario) throws MeuProjetoException {
		validarInserirUsuario(usuario);
		dao.inserir(usuario);
	}
	private void validarInserirUsuario(Usuario usuario) throws MeuProjetoException {
		StringBuilder erro = new StringBuilder();
		if (usuario == null) {
			erro.append("Usu�rio n�o pode ser vazio\n");
		}
		if (usuario.getLogin() == null || usuario.getLogin().trim().length() == 0) {
			erro.append("Nome do usu�rio inv�lido\n");
		}
		if (usuario.getSenha() == null || usuario.getSenha().trim().length() == 0) {
			erro.append("Senha do usu�rio inv�lida\n");
		}
		if (erro.length()>0) {
			//o m�todo "trim", remover espa�os em branco do in�cio e do fim da String.
			throw new MeuProjetoException(erro.toString().trim());
		}
	}
	public void alterar(Usuario usuario) {
		dao.alterar(usuario);
	}
	public void remover(Usuario usuario) {
		dao.remover(usuario);
	}
	public List<Usuario> consultarTodos() {
		return dao.consultarTodos();
	}
	public Usuario consultar(long id) {
		return dao.consultarPorId(id);
	}
	public void login(String login, String senha) throws MeuProjetoException {
		Usuario usuario = dao.consultar(login, senha);
		if (usuario == null) {
			throw new MeuProjetoException("Usu�rio n�o cadastrado");
		}
		SessaoUsuario sessao = SessaoUsuario.getInstancia();
		sessao.setUsuarioLogado(usuario);
	}
}
