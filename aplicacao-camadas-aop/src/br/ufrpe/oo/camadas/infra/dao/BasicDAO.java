package br.ufrpe.oo.camadas.infra.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.ufrpe.oo.camadas.infra.dominio.BasicObject;

public class BasicDAO<T extends BasicObject> {
	private List<T> list = new ArrayList<T>();
	
	public void inserir(T t) {
		list.add(t);
		t.setId(list.size());
	}
	
	public void remover(T t) {
		list.remove(t);
	}

	public void alterar(T t) {
		this.remover(t);
		this.inserir(t);
	}
	
	public List<T> consultarTodos() {
		return Collections.unmodifiableList(this.list);
	}

	public T consultarPorId(long id) {
		for (T t : list) {
			if (t.getId() == id) {
				return t;
			}
		}
		return null;
	}
}
