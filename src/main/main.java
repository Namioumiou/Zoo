package main;
import zoo.AgentEntretien;
import zoo.Animal;
import zoo.Enclos;
import zoo.Espece;
import zoo.Soigneur;
import zoo.Zoo;

public class main {

	public static void main(String[] args) {
		Zoo zoo = new Zoo("Zoolander");
		System.out.println(zoo.toString());
		Soigneur soigneur1 = new Soigneur("S1",1, zoo);
		soigneur1.direBonjour();
		
		Espece espece1 = new Espece("Félins", 100, 50, 5);
		Animal animal1 = new Animal(espece1,"Tsuki", 20, 5,"F");
		Enclos enclos1 = new Enclos(15,"1",espece1);
		soigneur1.ajouterEnclosAGerer(enclos1);
		zoo.ajouterEnclos(enclos1);
		enclos1.getSoigneur();
		enclos1.ajouterAnimal(animal1);
		System.out.println(enclos1.desciptionEnclosFull());
		System.out.println(animal1.toString());
		System.out.println(soigneur1.desciptionSoigneurFull());
		System.out.println(zoo.toString());
		
		Enclos enclos2 = new Enclos(15,"2",espece1);
		soigneur1.ajouterEnclosAGerer(enclos2);
		zoo.ajouterEnclos(enclos2);
		System.out.println(soigneur1.desciptionSoigneurFull());
		/*soigneur1.enleverEnclos(enclos2);
		System.out.println(soigneur1.desciptionSoigneurFull());*/

		
		
		Enclos enclos3 = new Enclos(15,"3",espece1);
		soigneur1.ajouterEnclosAGerer(enclos3);
		zoo.ajouterEnclos(enclos3);
		System.out.println(soigneur1.desciptionSoigneurFull());
		soigneur1.enleverEnclos(enclos2);
		System.out.println(soigneur1.desciptionSoigneurFull());

		AgentEntretien agent = new AgentEntretien("agent1",2,zoo);
		agent.direBonjour();
		System.out.println(agent.nettoyerPark());


		/*Animal animal2 = new Animal(espece1,"Meli", 50, 3,"F");
		enclos1.ajouterAnimal(animal2);
		System.out.println(enclos1.desciptionEnclosFull());

		Animal animal3 = new Animal(espece1,"Louna", 40, 5,"F");
		enclos1.ajouterAnimal(animal3);
		System.out.println(enclos1.desciptionEnclosFull());
		enclos1.enleverAnimal(animal2);
		System.out.println(enclos1.desciptionEnclosFull());
		System.out.println(animal1.getSoigneurAnimal());*/
	}

}
