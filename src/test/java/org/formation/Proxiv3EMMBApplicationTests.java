package org.formation;

import static org.junit.Assert.assertNotNull;

import org.formation.spring.dao.CrudClientDAO;
import org.formation.spring.model.Ccp;
import org.formation.spring.model.Ce;
import org.formation.spring.model.Client;
import org.formation.spring.model.Conseiller;
//import org.formation.spring.model.Conseiller;
import org.formation.spring.service.ClientWebService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Proxiv3EMMBApplicationTests {

	@Autowired
	private CrudClientDAO crudClientDAO;
	
	@Autowired
	private ClientWebService clientWebService;

	@Test
	public void testClientService() {

		assertNotNull(crudClientDAO);
//		Adresse a = new Adresse(1, "kjhk", "kjhkjh");
//		

//		Conseiller co = new Conseiller("louis", "ekjhfze", "fzelkjfz", "ekzjfhzle");
//		double b= Math.random() * 1000000;
//		Ccp ccp = new Ccp((long)b, 123456 );
//		double c= Math.random() * 1000000;
//		Ce ce= new Ce((long)c, 65432);
//		Client r = new Client("eleonore", "laura", "erica.baggi@gmail.com","3 rue des chataigners", ce, ccp);
//		
//		clientWebService.addConseiller(co);
//		
//		Client c5= crudClientDAO.getOne(1L);
//		System.out.println(c5.getNom());
//		clientWebService.deleteClients("1");
//		clientWebService.deleteClients("3");
		
//		Client c2= clientWebService.getClient("2");
//		c2.setNom("madjid");
//		clientWebService.updateClient(c2);
		//		
//		clientWebService.faireVirment("10","12", "-1000");
		
		//		List<Client> byNom = crudClientDAO.findAllClientByNom("client de test");
//		
//		System.out.println(byNom);
//		assertEquals(2, byNom.size());

	}

}
