package br.ufrpe.oo.camadas.infra;

public class MeuProjetoException extends Exception {
	private static final long serialVersionUID = 1L;
	public MeuProjetoException(String mensagem) {
		super(mensagem);
	}
	public MeuProjetoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
