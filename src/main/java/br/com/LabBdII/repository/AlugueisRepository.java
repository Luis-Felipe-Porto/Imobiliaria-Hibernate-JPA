package br.com.LabBdII.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.LabBdII.models.Aluguel;
import br.com.LabBdII.models.Cliente;


public class AlugueisRepository {

	private final EntityManager manager;
	private final DAOGenerico<Aluguel> daoGenerico;

	public AlugueisRepository(EntityManager manager) {
		this.manager = manager;
		this.daoGenerico = new DAOGenerico<Aluguel>(manager);
	}
	//CRIAR
	public Aluguel salvaOuAtualiza(Aluguel aluguel) {
		return daoGenerico.salvaOuAtualiza(aluguel);
	}
	// LISTAR TODOS
    public List<Aluguel> listAlugueis() {
        return manager
                .createQuery("from Aluguel a ", Aluguel.class)
                .getResultList();
    }
    //BUSCAR POR ID
    public Aluguel buscaPorId(Integer id){
    	return daoGenerico.buscaPorId(Aluguel.class, id);
    }
    // DELETAR
    public Aluguel deletePorId(Integer id) {
    	Aluguel d = buscaPorId(id);
    	daoGenerico.remove(d);
    	return d;
    }
    public List<Aluguel> aluguelPorInquilino(Cliente inquilino){
        return manager
                .createQuery("from Aluguel a where a.locacao.inquilino.id = :id ", Aluguel.class)
                .setParameter("id", inquilino.getIdCliente())
                .getResultList();
    }
}
