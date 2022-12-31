package test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import zoo.Animal;
import zoo.Enclos;
import zoo.Espece;
import zoo.Soigneur;
import zoo.Zoo;

public class TestSoigneur {
	
	private Zoo zoo;
	private Soigneur s1;
	private Espece espece;
	private Enclos enclos1;
	private Enclos enclos2;
	private Enclos enclos3;
	private Enclos enclos4;
	private Enclos enclos5;
	private Enclos enclos6;
	private Animal animal1;
	
	@Before
	public void setUp() throws Exception {
		zoo = new Zoo("Zoolander");
		s1 = new Soigneur("Soigneur1",1, zoo);
		
		this.espece = new Espece("Félins", 100, 50, 5);
		
		this.enclos1 = new Enclos(15,"F1",espece);
		this.enclos2 = new Enclos(15,"F2",espece);
		this.enclos3 = new Enclos(15,"F3",espece);
		this.enclos4 = new Enclos(15,"F4",espece);
		this.enclos5 = new Enclos(15,"F5",espece);
		this.enclos6 = new Enclos(15,"F6",espece);
		
		this.animal1 = new Animal(espece,"Tsuki", 20, 5,"F");
	}
	
	@After
	public void TearDown() throws Exception{
		zoo = null;
	}
	
	@Test
	public void testAttributionEnclos() {
		s1.ajouterEnclosAGerer(enclos1);
		assertTrue(1 == s1.getNbEnclos());
		System.out.println("testAttributionEnclos passed with success");
	}
	
	@Test
	public void testAttributionEnclosDepassement() {
		s1.ajouterEnclosAGerer(enclos1);
		s1.ajouterEnclosAGerer(enclos2);
		s1.ajouterEnclosAGerer(enclos3);
		s1.ajouterEnclosAGerer(enclos4);
		s1.ajouterEnclosAGerer(enclos5);
		s1.ajouterEnclosAGerer(enclos6);
		assertTrue (5 == s1.getNbEnclos());
		System.out.println("testAttributionEnclosDepassement passed with success");
	}
	
	@Test
	public void testEnleverEnclos() {
		s1.ajouterEnclosAGerer(enclos1);
		s1.enleverEnclos(enclos1);
		assertTrue (0 == s1.getNbEnclos());
		System.out.println("testEnleverEnclos passed with success");
	}
	
	@Test
	public void testEnleverEnclosNonGerer() {
		s1.ajouterEnclosAGerer(enclos1);
		s1.enleverEnclos(enclos2);
		assertTrue (1 == s1.getNbEnclos());
		System.out.println("testEnleverEnclosNonGerer passed with success");
	}
	
	@Test
	public void testnbEnclosMax() {
		assertTrue (5 == s1.getNbEnclosMax());
		System.out.println("testnbEnclosMax passed with success");
	}
	
	@Test
	public void testSoigneurOccupeAnimal() {
		s1.ajouterEnclosAGerer(enclos1);
		enclos1.ajouterAnimal(animal1);
		if (animal1.getSoigneurAnimal().equals("C'est le soigneur Soigneur1 (1) qui s'occupe de l'enclos ou est Tsuki")) {
			System.out.println("testChekInventoryBeforeUse passed with success");
		}
	}

}
