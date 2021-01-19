package br.com.LabBdII.test;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.LabBdII.models.Aluguel;
import br.com.LabBdII.models.Cliente;
import br.com.LabBdII.models.Locacao;
import br.com.LabBdII.repository.AlugueisRepository;
import br.com.LabBdII.utils.DateUtilJPA;
import br.com.LabBdII.utils.JPAUtil;

public class TesteAlugueis {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		AlugueisRepository alg = new AlugueisRepository(em);
		
		EntityTransaction tx = em.getTransaction();
		//Create - Update
		tx.begin();
			Locacao loc = em.getReference(Locacao.class, 2);
    		Aluguel a = new Aluguel(
    			new Date(DateUtilJPA.getConvertDate("2020-12-04")),
    			2.000,
    			new Date(DateUtilJPA.getConvertDate("2020-12-04")),
    			"Qualidade Preço Baixo",
    			loc
    			);
			alg.salvaOuAtualiza(a);
		tx.commit();

		//Delete
		tx.begin();
			alg.deletePorId(3);
		tx.commit();
		
		//List
		tx.begin();
			Cliente c = em.getReference(Cliente.class, 2);
			List<Aluguel> alugueisInquilino = alg.aluguelPorInquilino(c);
		tx.commit();
		for (Aluguel aluguel : alugueisInquilino) {
			System.out.println(aluguel.toString());
		}
		em.close();
	}

}
