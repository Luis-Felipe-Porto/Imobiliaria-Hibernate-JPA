package br.com.LabBdII.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.LabBdII.models.Cliente;
import br.com.LabBdII.models.Locacao;

public class LocacaoRepository {
    private final EntityManager manager;
    private final DAOGenerico<Locacao> daoGenerico;
    
	public LocacaoRepository(EntityManager manager) {
		this.manager = manager;
		this.daoGenerico = new DAOGenerico<Locacao>(manager);
	}
	//CRIAR
	public Locacao salvaOuAtualiza(Locacao aluguel) {
		return daoGenerico.salvaOuAtualiza(aluguel);
	}
	// LISTAR TODOS
    public List<Locacao> locacoes() {
        return manager
                .createQuery("from Aluguel a ", Locacao.class)
                .getResultList();
    }
    //BUSCAR POR ID
    public Locacao buscaPorId(Integer id){
    	return daoGenerico.buscaPorId(Locacao.class, id);
    }
    // DELETAR
    public Locacao deletePorId(Integer id) {
    	Locacao d = buscaPorId(id);
    	daoGenerico.remove(d);
    	return d;
    }
    public List<Locacao> locacaoPorInquilino(Cliente inquilino){
        return manager
                .createQuery("from Locacao l where l.inquilino.id = :id group by l.inquilino ", Locacao.class)
                .setParameter("id", inquilino.getIdCliente())
                .getResultList();
                
    }
}
