/**
 * 
 */
package br.com.keepsimple.ffa;

import org.springframework.web.client.RestTemplate;

import br.com.keepsimple.ffa.domain.Cliente;

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
