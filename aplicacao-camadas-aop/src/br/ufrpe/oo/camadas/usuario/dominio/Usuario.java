package br.ufrpe.oo.camadas.usuario.dominio;

import br.ufrpe.oo.camadas.infra.dominio.BasicObject;

public class Usuario extends BasicObject {
	private String login;
	private String senha;
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
