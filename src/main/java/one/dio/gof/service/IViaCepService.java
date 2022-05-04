package one.dio.gof.service;

import one.dio.gof.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public
interface IViaCepService {
    @GetMapping("/{cep}/json")
    Address cepLookUp(@PathVariable("cep") String cep);
}