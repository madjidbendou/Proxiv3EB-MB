package org.formation;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ws.rs.core.Response;

import org.formation.spring.dao.CrudClientDAO;
import org.formation.spring.dao.CrudConseillerDAO;
import org.formation.spring.model.Ccp;
import org.formation.spring.model.Ce;
import org.formation.spring.model.Client;
import org.formation.spring.model.Conseiller;
import org.formation.spring.service.ClientWebService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * La classe Proxiv3EMMBApplicationTests permet de tester toutes les méthodes du
 * ClientWebService (injecté dans cette classe par l'annotation @ Autowired ).
 * Lancé avec la base de données fournies, tous les tests passent. Ceci permet
 * de vérifier que toutes les méthodes fonctionnent
 * 
 * @author BENDOU/BAGGI
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Proxiv3EMMBApplicationTests {

	@Autowired
	private CrudClientDAO crudClientDAO;

	@Autowired
	private ClientWebService clientWebService;

	@Autowired
	private CrudConseillerDAO crudConseillerDao;

	@Test
	public void testClientService() {

		assertNotNull(crudClientDAO);
	}

	@Test
	public void testClientWebService() {

		assertNotNull(clientWebService);
	}

	@Test
	public void verificationCreationClient() {
		double b = Math.random() * 1000000;
		Ccp ccp = new Ccp((long) b, 123456);
		double c = Math.random() * 1000000;
		Ce ce = new Ce((long) c, 65432);
		Client r = new Client("Maraichers", "laura", "erica.baggi@gmail.com", "3 rue des chataigners", ce, ccp);
		clientWebService.addClient(r);
		Long id = r.getId();
		Client c1 = crudClientDAO.getOne(id);
		assertNotNull(c1);
	}

	@Test
	public void verificationCreationConseiller() {
		Conseiller co = new Conseiller("louis", "lemarchand", "llemarchand", "soleil");

		clientWebService.addConseiller(co);
		Long id = co.getId();
		Conseiller c1 = crudConseillerDao.getOne(id);
		assertNotNull(c1);
	}

	@Test
	public void verificationRecuperationClient() {
		Client c = clientWebService.getClient("16");
		assertNotNull(c);
		String prenom = "laura";
		assertTrue(prenom.equals(c.getPrenom()));

	}

	@Test
	public void verificationRecuperationConseiller() {
		Conseiller c = clientWebService.getConseiller("5");
		assertNotNull(c);
		String prenom = "ekjhfze";
		assertTrue(prenom.equals(c.getPrenom()));
	}

	@Test
	public void verificationSuppressionClient() {

		Response response = clientWebService.deleteClientById("23");
		assertNotNull(response);
	}

	@Test
	public void verificationModificationClient() {
		Client c = clientWebService.getClient("12");
		c.setNom("Leroys");
		clientWebService.updateClient(c);
		Client c1 = clientWebService.getClient("12");
		String nom = "Leroys";
		assertTrue(nom.equals(c1.getNom()));
	}

	@Test
	public void verificationModificationConseiller() {
		Conseiller c = clientWebService.getConseiller("20");
		c.setNom("Elmer");
		clientWebService.updateConseiller(c);
		Conseiller c1 = clientWebService.getConseiller("20");
		String nom = "Elmer";
		assertTrue(nom.equals(c1.getNom()));
	}

	@Test
	public void verificationObtentionListeClient() {
		List<Client> byNom = clientWebService.getClients();
		assertNotNull(byNom.size());

	}

	@Test
	public void verificationObtentionListeConseiller() {
		List<Conseiller> byNom = clientWebService.getConseillers();
		assertNotNull(byNom.size());
	}

	@Test
	public void verificationVirement() {
		Client c = clientWebService.getClient("12");
		clientWebService.faireVirment("12", "19", "100");

		Client c1 = clientWebService.getClient("12");
		double so1 = c.getCompteCourant().getSoldeBancaireCourant();
		double so2 = c1.getCompteCourant().getSoldeBancaireCourant();
		double so3 = so1 - so2;
		assertNotNull(so3);

	}

}
