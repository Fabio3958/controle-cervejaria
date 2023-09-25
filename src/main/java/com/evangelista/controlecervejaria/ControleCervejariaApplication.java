package com.evangelista.controlecervejaria;

import com.evangelista.controlecervejaria.controller.DemandController;
import com.evangelista.controlecervejaria.model.Barrel;
import com.evangelista.controlecervejaria.model.Demand;
import com.evangelista.controlecervejaria.repository.BarrelRepository;
import com.evangelista.controlecervejaria.repository.ClientRepository;
import com.evangelista.controlecervejaria.service.DemandService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@OpenAPIDefinition(info = @Info(title = "Swagger OpneAPI", version = "1", description = "API desenvolvida para o controle pedidos de uma cervejaria"))
@SpringBootApplication
public class ControleCervejariaApplication implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;
	@Autowired
	BarrelRepository barrelRepository;
	@Autowired
	DemandService demandService;

	DemandController demandController = new DemandController();

	public static void main(String[] args) {
		SpringApplication.run(ControleCervejariaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

		Barrel barrel1 = new Barrel(1L, 50D);
		Barrel barrel2 = new Barrel(2L, 30D);
		Barrel barrel3 = new Barrel(3L, 20D);
		Barrel barrel4 = new Barrel(4L, 20D);
		Barrel barrel5 = new Barrel(5L, 50D);
		barrelRepository.save(barrel1);
		barrelRepository.save(barrel2);
		barrelRepository.save(barrel3);
		barrelRepository.save(barrel4);
		barrelRepository.save(barrel5);

		List<Barrel> barrelList1 = new ArrayList<>();
		barrelList1.add(barrel1);
		barrelList1.add(barrel2);

		List<Barrel> barrelList2 = new ArrayList<>();
		barrelList2.add(barrel3);

		List<Barrel> barrelList3 = new ArrayList<>();
		barrelList3.add(barrel1);
		barrelList3.add(barrel3);
		barrelList3.add(barrel5);


		Demand demand1 = new Demand(1L, demandService.calculateDemandTotalValue(barrelList1), barrelList1);
		Demand demand2 = new Demand(2L, demandService.calculateDemandTotalValue(barrelList2), barrelList2);
		Demand demand3 = new Demand(3L, demandService.calculateDemandTotalValue(barrelList3), barrelList3);
		demandService.save(demand1);
		demandService.save(demand2);
		demandService.save(demand3);

		List<Demand> demandList = new ArrayList<>();
		demandList.add(demand1);
		demandList.add(demand2);
		demandList.add(demand3);

		/*Client client1 = new Client(1L, "José da Silva", "15991234567", "jose@gmail.com", Date.from(Instant.now()),
				"Sorocaba", "Eden", "Rua 1", "45", demandList);

		clientRepository.save(client1);*/

	}
}
