package br.com.LabBdII.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.LabBdII.models.Imovel;

public class ImoveisRepository {
	
    private final EntityManager manager;
    private final DAOGenerico<Imovel> daoGenerico;
    
	public ImoveisRepository(EntityManager manager) {
		this.manager = manager;
		this.daoGenerico = new DAOGenerico<Imovel>(manager);
	}
	//CRIAR
	public Imovel salvaOuAtualiza(Imovel aluguel) {
		return daoGenerico.salvaOuAtualiza(aluguel);
	}
	// LISTAR TODOS
    public List<Imovel> getImoveis() {
        return manager
                .createQuery("from Imovel a ", Imovel.class)
                .getResultList();
    }
    //BUSCAR POR ID
    public Imovel buscaPorId(Integer id){
    	return daoGenerico.buscaPorId(Imovel.class, id);
    }
    // DELETAR
    public Imovel deletePorId(Integer id) {
    	Imovel d = buscaPorId(id);
    	daoGenerico.remove(d);
    	return d;
    }
}
