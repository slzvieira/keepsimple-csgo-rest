/**
 * 
 */
package br.com.keepsimple.ffa.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.keepsimple.ffa.domain.Address;

/**
 * @author alessandro
 */
@FeignClient(name = "correios-cep", url = "https://viacep.com.br/ws")
public interface CEPServiceClient {

    @GetMapping(path = "/{cep}/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    Address buscarEndereco(@PathVariable("cep") String cep);
}
