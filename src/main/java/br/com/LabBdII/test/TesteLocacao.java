package br.com.LabBdII.test;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.LabBdII.models.Cliente;
import br.com.LabBdII.models.Imovel;
import br.com.LabBdII.models.Locacao;
import br.com.LabBdII.repository.LocacaoRepository;
import br.com.LabBdII.utils.DateUtilJPA;
import br.com.LabBdII.utils.JPAUtil;

public class TesteLocacao {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		LocacaoRepository locRepo = new LocacaoRepository(em);

		EntityTransaction tx = em.getTransaction();

		Cliente cl = new Cliente("Porto", 656546543d, 78675645d, 77653456d, "porto@gmail.com",
				new Date(DateUtilJPA.getConvertDate("2000-11-4")));
		// Test Create - Update
		tx.begin();
			em.persist(cl);
			Imovel m = em.getReference(Imovel.class, 2);
			Cliente c = em.getReference(Cliente.class, cl.getIdCliente());
			Locacao loc = new Locacao(m, c, 300.0, 20.0, 10, new Date(DateUtilJPA.getConvertDate("2020-10-30")),
					new Date(DateUtilJPA.getConvertDate("2021-10-30")), true, "Aceitamos Finaciamento");
			locRepo.salvaOuAtualiza(loc);
		tx.commit();

//		//Test Delete
//		tx.begin();
//			locRepo.deletePorId(5);
//		tx.commit();
//		em.close();
//		Test List
		tx.begin();
			Cliente inquilino = em.getReference(Cliente.class,2);
			List<Locacao> locacoes = locRepo.locacaoPorInquilino(inquilino);
		tx.commit();
		em.close();
		for (Locacao locacao : locacoes) {
			System.out.println("\n\n");
			System.out.println(locacao.toString());
			System.out.println("\n\n");
		}
		
	}

}
