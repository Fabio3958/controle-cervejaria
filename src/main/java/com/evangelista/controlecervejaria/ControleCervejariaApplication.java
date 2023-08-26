package com.evangelista.controlecervejaria;

import com.evangelista.controlecervejaria.model.Barrel;
import com.evangelista.controlecervejaria.model.Client;
import com.evangelista.controlecervejaria.model.Demand;
import com.evangelista.controlecervejaria.repository.BarrelRepository;
import com.evangelista.controlecervejaria.repository.ClientRepository;
import com.evangelista.controlecervejaria.repository.DemandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ControleCervejariaApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	BarrelRepository barrelRepository;
	@Autowired
	DemandRepository demandRepository;

	public static void main(String[] args) {
		SpringApplication.run(ControleCervejariaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

		Barrel barrel1 = new Barrel(1L, 50.0);
		Barrel barrel2 = new Barrel(2L, 30.0);
		Barrel barrel3 = new Barrel(3L, 20.0);
		Barrel barrel4 = new Barrel(4L, 20.0);
		barrelRepository.save(barrel1);
		barrelRepository.save(barrel2);
		barrelRepository.save(barrel3);
		barrelRepository.save(barrel4);

		List<Barrel> barrelList1 = new ArrayList<>();
		barrelList1.add(barrel1);
		barrelList1.add(barrel2);

		List<Barrel> barrelList2 = new ArrayList<>();
		barrelList2.add(barrel3);
		barrelList2.add(barrel4);

		Double valor1 = (barrel1.getBarrelVolume() + barrel2.getBarrelVolume()) * 12;
		Double valor2 = (barrel3.getBarrelVolume() + barrel4.getBarrelVolume()) * 12;





		Demand demand1 = new Demand(1L,  valor1, barrelList1);
		Demand demand2 = new Demand(2L,  valor2, barrelList2);
		demandRepository.save(demand1);
		demandRepository.save(demand2);

		List<Demand> demandList = new ArrayList<>();
		demandList.add(demand1);
		demandList.add(demand2);

		Client client1 = new Client(1L, "José da Silva", "15991234567", "jose@gmail.com", Date.from(Instant.now()),
				"Sorocaba", "Eden", "Rua 1", "45", demandList);

		clientRepository.save(client1);

	}
}
