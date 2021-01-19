package br.com.LabBdII.repository;

import java.util.Objects;

import javax.persistence.EntityManager;

import br.com.LabBdII.models.EntidadeBase;

public class DAOGenerico<T extends EntidadeBase> {
	private final EntityManager manager;

	DAOGenerico(EntityManager manager) {
		this.manager = manager;
	}

	T buscaPorId(Class<T> clazz, Integer id) {
		return manager.find(clazz, id);
	}

	T salvaOuAtualiza(T t) {
		if (Objects.isNull(t.getId()))
			this.manager.persist(t);
		else
			t = this.manager.merge(t);
		return t;
	}

	void remove(T t) {
		manager.remove(t);
		manager.flush();
	}
}
