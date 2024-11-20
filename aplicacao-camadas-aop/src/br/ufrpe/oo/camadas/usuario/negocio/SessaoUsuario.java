package br.ufrpe.oo.camadas.usuario.negocio;

import br.ufrpe.oo.camadas.usuario.dominio.Usuario;

public class SessaoUsuario {
	private Usuario usuarioLogado;
	private static SessaoUsuario instancia = new SessaoUsuario();
	private SessaoUsuario(){}
	public static SessaoUsuario getInstancia() {
		return instancia;
	}
	
	public void setUsuarioLogado(Usuario usuario) {
		this.usuarioLogado = usuario;
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
}
