package com.footballers.cruddemo;

import com.footballers.cruddemo.dao.FootballerDAO;
import com.footballers.cruddemo.entity.Footballer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(FootballerDAO footballerDAO) {

		return runner -> {
//			createFootballer(footballerDAO);
//			readFootballer(footballerDAO);
//			readAllFootballes(footballerDAO);
//			readFootballerByLastName(footballerDAO);
//			updateFootballer(footballerDAO);
//			deleteFootballer(footballerDAO);
			deleteAllFootballers(footballerDAO);
		};
	}

	private void deleteAllFootballers(FootballerDAO footballerDAO) {
		System.out.println("Deleting all footballers ...");
		int footballersDeleted = footballerDAO.deleteAll();
		System.out.println(footballersDeleted + " footballers was deleted from table");
	}

	private void deleteFootballer(FootballerDAO footballerDAO) {
		int id = 1;
		System.out.println("Delete footballer id: " + id);
		footballerDAO.delete(id);
	}

	private void updateFootballer(FootballerDAO footballerDAO) {
		// create footballer by id
		int id = 3;
		Footballer footballer = footballerDAO.findById(id);
		System.out.println("Footballer to update: " + footballer);

		// change last name
		footballer.setLastName("Evra");

		// update
		footballerDAO.update(footballer);

		// show updated footballer
		System.out.println("Updated footballer: " + footballerDAO.findById(id));

	}

	private void readFootballerByLastName(FootballerDAO footballerDAO) {

		List<Footballer> theFootballers = footballerDAO.findByLastName("Camavinga");

		for (Footballer footballer : theFootballers) {
			System.out.println(footballer);
		}
	}

	private void readAllFootballes(FootballerDAO footballerDAO) {
		List<Footballer> theFootballers = footballerDAO.findAll();

		for (Footballer footballer : theFootballers) {
			System.out.println(footballer);
		}
	}

	private void readFootballer(FootballerDAO footballerDAO) {
		Footballer footballer = new Footballer("Vini", "Jr", "Forward");
		System.out.println("Create footballer to find with id: " + footballer.getId());

		footballerDAO.save(footballer);

		System.out.println("Finding footballer by id ...");
		Footballer foundFootballer = footballerDAO.findById(footballer.getId());

		System.out.println("Found footballer id: " + foundFootballer.getId());

	}

	private void createFootballer(FootballerDAO footballerDAO) {

		System.out.println("Create new footballer and save to table ...");
		Footballer footballer = new Footballer("Patrick", "Vieira", "Midfielder");
		footballerDAO.save(footballer);
		System.out.println("Footballer has been created ...");
	}

}
