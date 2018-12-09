/**
 * 
 */
package br.com.keepsimple.ffa.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.keepsimple.ffa.domain.Endereco;

/**
 * @author alessandro
 */
@FeignClient(name = "correios-cep", url = "https://viacep.com.br/ws")
public interface CEPServiceClient {

    @GetMapping(path = "/{cep}/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    Endereco buscarEndereco(@PathVariable("cep") String cep);
}

/*
@FeignClient(name = "vv-servicos", url = "${servicos.url}")
public interface ServicosServiceClient {

    @RequestMapping(method = RequestMethod.GET, path = "/seguros/{sku}", consumes = MediaType.APPLICATION_JSON_VALUE)
    SeguroResponse buscarSeguro(@PathVariable("sku") final Long sku,
        @RequestParam(name = "seguradora", required = false) final Integer seguradora,
        @RequestParam(name = "classificacao", required = false) final Integer classificacao);

    @PostMapping(path = "/servicos/fechamento", consumes = MediaType.APPLICATION_JSON_VALUE)
    FechamentoServicosResponse fechamento(@RequestBody final FechamentoServicosRequest request);

}
*/
