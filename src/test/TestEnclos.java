package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import zoo.Animal;
import zoo.Enclos;
import zoo.Espece;
import zoo.Soigneur;
import zoo.Zoo;

public class TestEnclos {
	
	private Zoo zoo;
	private Soigneur s1;
	private Espece espece;
	private Enclos enclos;
	private Animal animal1;
	private Animal animal2;
	private Animal animal3;
	private Animal animal4;
	
	
	@Before
	public void setUp() throws Exception {
		zoo = new Zoo("Zoolander");
		s1 = new Soigneur("Soigneur1",1, zoo);
		
		this.espece = new Espece("Félins", 100, 50, 3);
		this.enclos = new Enclos(15,"1",espece);
		
		this.animal1 = new Animal(espece,"Tsuki", 20, 5,"F");
		this.animal2 = new Animal(espece,"Meli", 50, 3,"F");
		this.animal3 = new Animal(espece,"Louna", 40, 4,"F");
		this.animal4 = new Animal(espece,"Aventure", 30, 6,"F");
	}
	
	@After
	public void TearDown() throws Exception{
		zoo = null;
	}
	
	@Test
	public void testAttributionAnimal() {	
		enclos.ajouterAnimal(animal1);
		assertTrue(1 == enclos.getNbAnimaux());
		System.out.println("testAttributionAnimal passed with success");
	}
	
	@Test
	public void testAttributionAnimalDepassement() {
		enclos.ajouterAnimal(animal1);
		enclos.ajouterAnimal(animal2);
		enclos.ajouterAnimal(animal3);
		enclos.ajouterAnimal(animal4);
		assertTrue (3 == enclos.getNbAnimaux());
		System.out.println("testAttributionEnclosDepassement passed with success");
	}
	
	@Test
	public void testEnleverAnimal() {
		enclos.ajouterAnimal(animal1);
		enclos.enleverAnimal(animal1);
		assertTrue (0 == enclos.getNbAnimaux());
		System.out.println("testEnleverAnimal passed with success");
	}
	
	@Test
	public void testEnleverAnimalPasPresent() {
		enclos.ajouterAnimal(animal1);
		enclos.enleverAnimal(animal2);
		assertTrue (1 == enclos.getNbAnimaux());
		System.out.println("testEnleverAnimalPasPresent passed with success");
	}
	
	@Test
	public void testNbAnimauxMax() {
		assertTrue (3 == enclos.getNbAnimauxMax());
		System.out.println("testNbAnimauxMax passed with success");
	}
	
	

}
