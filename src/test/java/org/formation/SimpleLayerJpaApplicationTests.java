package org.formation;

import static org.junit.Assert.assertNotNull;

import org.formation.spring.dao.CrudClientDAO;
import org.formation.spring.model.Client;
import org.formation.spring.model.Conseiller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleLayerJpaApplicationTests {

	@Autowired
	private CrudClientDAO crudClientDAO;

	@Test
	public void testClientService() {

		assertNotNull(crudClientDAO);
//		Adresse a = new Adresse(1, "kjhk", "kjhkjh");
//		
		Conseiller co = new Conseiller("premier", "conseiller", "de la", "banque");
		Client c = new Client("client de test", "a persister", "a voir sur mozilla", "pas encore de compte", co);
	

//		
		crudClientDAO.save(c);
//		List<Client> byNom = crudClientDAO.findAllClientByNom("client de test");
//		
//		System.out.println(byNom);
//		assertEquals(2, byNom.size());

	}

}
