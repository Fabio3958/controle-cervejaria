package com.evangelista.controlecervejaria.service.ViaCep;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "viacep.com.br/ws/", name = "viacep")
public interface ViaCepService {

    @GetMapping("{cep}/json/")
    Endereco getEndereco(@PathVariable String cep);

}
