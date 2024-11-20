package br.ufrpe.oo.camadas.aspects;


public aspect LogUsuarioGetsSetsAspect {
	pointcut getsExecution() : execution(* br.ufrpe.oo.camadas.usuario.dominio.Usuario.get*(..));
	pointcut setsExecution() : execution(* br.ufrpe.oo.camadas.usuario.dominio.Usuario.set*(..));

	//Ap�s executar o programa, tente comentar os pontos de corte acima e descomentar os pontos de corte abaixo.
//	pointcut getsExecution() : execution(* *.get*(..)) && this(br.ufrpe.oo.camadas.usuario.dominio.Usuario);
//	pointcut setsExecution() : execution(* *.set*(..)) && this(br.ufrpe.oo.camadas.usuario.dominio.Usuario);

	before() : getsExecution() || setsExecution() {
		//observe a diferen�a entre o "entrou" no m�todo e o "saiu" do m�todo.
		String assinatura = thisJoinPoint.getSignature().toShortString();
		System.out.printf("Entrou ano m�todo %s.\n", assinatura);
	}

	after() : getsExecution() || setsExecution() {
		//observe a diferen�a entre o "entrou" no m�todo e o "saiu" do m�todo.
		String assinatura = thisJoinPoint.getSignature().toShortString();
		System.out.printf("Saiu no m�todo %s.\n", assinatura);
	}
}
