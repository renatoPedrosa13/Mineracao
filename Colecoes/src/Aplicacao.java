import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import rpv.com.MeuArrayList;

public class Aplicacao {

	@Test
	public void testColecoes() {
		Collection<Integer> c = new MeuArrayList<>();
		//Collection<Object> c = new MeuArrayList<>();
		c.add(1);
		c.add(null); 
		c.add(2);
		c.remove(2);
		

		for (Integer num : c ){
		//for (Object object : c ){
			//System.out.println(object);
			System.out.println(num);
			System.out.println(c.isEmpty());
		}
	
	}

}




