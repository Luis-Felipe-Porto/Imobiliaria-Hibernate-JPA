package br.com.LabBdII.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.LabBdII.models.Imovel;
import br.com.LabBdII.repository.ImoveisRepository;
import br.com.LabBdII.utils.JPAUtil;

public class TesteImovel {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		ImoveisRepository imov = new ImoveisRepository(em);
		
		EntityTransaction tx = em.getTransaction();
		//Create - Update
		tx.begin();
			Imovel m = new Imovel(
    			"Residencial",
    			"Rua Brasil A10",
    			"Calhau ",
    			6514047d,
    			400d,
    			2,3,4,2,
    			7000d,
    			"Area Nobre"
    			);
			imov.salvaOuAtualiza(m);
		tx.commit();

		//Remover 
//		tx.begin();
//			imov.deletePorId(4);
//		tx.commit();

		// Listar
		tx.begin();
			List<Imovel> imoveis = imov.getImoveis();
			System.out.println("============= Imoveis ==============");
			for (Imovel imovel : imoveis) {
				System.out.println(imovel.toString());
			}
		tx.commit();
		em.close();

	}

}
