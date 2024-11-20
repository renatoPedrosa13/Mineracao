package br.ufrpe.oo.camadas.infra;

public class MeuProjetoRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public MeuProjetoRuntimeException(String mensagem) {
		super(mensagem);
	}
	public MeuProjetoRuntimeException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
