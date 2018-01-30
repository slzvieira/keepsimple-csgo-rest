/**
 * 
 */
package br.com.slzvieira.boot;

import org.springframework.web.client.RestTemplate;

import br.com.slzvieira.boot.model.Cliente;

/**
 * @author slvieira
 *
 */
public class Consumer {

    private static final RestTemplate restTemplate = new RestTemplate();
    
    public static void main(String[] args) {
        
        Cliente cliente = restTemplate.getForObject("http://localhost:8080/clientes/5", Cliente.class);
        
        System.out.println(cliente.getId());
        System.out.println(cliente.getNome());
    }
}
