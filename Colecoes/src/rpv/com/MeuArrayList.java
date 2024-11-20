package rpv.com;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class MeuArrayList<E> extends ArrayList<E> { 
	/**
	 * Adiciona um elemento na coleção, caso ele não seja nulo (<code>null</code>).
	 * <br>
	 * O javadoc pode conter elementos HTML.
	 * <table border=1>
	 * <tr>
	 * <td>Até mesmo</td>
	 * <td>tabelas</td>
	 * </tr>
	 * <tr>
	 * <td>Até mesmo</td>
	 * <td>tabelas</td>
	 * </tr>
	 * </table> 
	 * <br>
	 * <ul>
	 * <li>E listas <li>
	 * <li>E listas <li>
	 * </ul>
	 * 
	 * @param e o objeto a ser adicionado
	 * @return <code>true</code> se o elemento for adicionado e <code>false</code> caso contrário.
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	@Override
	public boolean add(E e) {
		
		if(e ==null) {
			return false;
		}
		return super.add(e);
	}

}