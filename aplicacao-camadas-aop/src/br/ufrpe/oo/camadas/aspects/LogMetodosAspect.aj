package br.ufrpe.oo.camadas.aspects;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public aspect LogMetodosAspect {
	private Logger logger = createLogger();
	//tente tirar os pontos de corte com o "!" na frente e rodar o programa para ver o erro
	pointcut allMethodsExecution() : execution(* br.ufrpe.oo.camadas..*(..)) 
										&& !execution(* br.ufrpe.oo.camadas.aspects..*(..));
	pointcut allMethodsCall() : call(* br.ufrpe.oo.camadas..*(..))
										&& !call(* br.ufrpe.oo.camadas.aspects..*(..));
	
	before() : allMethodsCall() {
		//observe a diferen�a entre o "entrou" no m�todo e o "saiu" do m�todo.
		String assinatura = thisJoinPoint.getSignature().toShortString();
		logger.log(Level.INFO, "Entrou no m�todo {0}.", assinatura );
	}

	after() : allMethodsCall() {
		//observe a diferen�a entre o "entrou" no m�todo e o "saiu" do m�todo.
		String assinatura = thisJoinPoint.getSignature().toShortString();
		logger.log(Level.INFO, "Saiu do m�todo {0}.", assinatura );
	}

	Object around() : allMethodsExecution() {
		String assinatura = thisJoinPoint.getSignature().toShortString();
    	long t1 = System.nanoTime();
    	Object result = proceed();
    	long t2 = System.nanoTime();
		if (logger.isLoggable(Level.FINE)) {
			//antes de logar checa se o n�vel est� habilitado, para evitar a realiza��o do c�lculo e a 
			long t3 = t2-t1;
			logger.log(Level.FINE, "Executou o m�todo {0} em {1} nanoseg.", new Object[]{assinatura, t3});
		}
		return result;
	}

	
	private Logger createLogger() {
		Logger result = Logger.getLogger("LogMetodos");
		
		//alterar o n�vel do log conforme necess�rio para a aplica��o
//		Level level = Level.FINEST;
//		Level level = Level.FINER;
//		Level level = Level.FINE;
//		Level level = Level.CONFIG;
//		Level level = Level.INFO;
//		Level level = Level.WARNING;
//		Level level = Level.SEVERE;
		Level level = Level.OFF;
		result.setLevel(level);
		
		if (level != Level.OFF) {
			ConsoleHandler consoleHandler = new ConsoleHandler();
			consoleHandler.setLevel(level);
			result.addHandler(consoleHandler);
	
			FileHandler fileHandler;
			try {
				fileHandler = new FileHandler("/aplicacao-camadas-aop-LogMetodos.xml");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			fileHandler.setLevel(level);
			result.addHandler(fileHandler);
		}
		return result;
	}
}
