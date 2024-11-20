package br.ufrpe.oo.camadas.aspects;


public aspect LogUsuarioGetsSetsAspect {
	pointcut getsExecution() : execution(* br.ufrpe.oo.camadas.usuario.dominio.Usuario.get*(..));
	pointcut setsExecution() : execution(* br.ufrpe.oo.camadas.usuario.dominio.Usuario.set*(..));

	//Após executar o programa, tente comentar os pontos de corte acima e descomentar os pontos de corte abaixo.
//	pointcut getsExecution() : execution(* *.get*(..)) && this(br.ufrpe.oo.camadas.usuario.dominio.Usuario);
//	pointcut setsExecution() : execution(* *.set*(..)) && this(br.ufrpe.oo.camadas.usuario.dominio.Usuario);

	before() : getsExecution() || setsExecution() {
		//observe a diferença entre o "entrou" no método e o "saiu" do método.
		String assinatura = thisJoinPoint.getSignature().toShortString();
		System.out.printf("Entrou ano método %s.\n", assinatura);
	}

	after() : getsExecution() || setsExecution() {
		//observe a diferença entre o "entrou" no método e o "saiu" do método.
		String assinatura = thisJoinPoint.getSignature().toShortString();
		System.out.printf("Saiu no método %s.\n", assinatura);
	}
}
