package br.com.keepsimple.ffa.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.keepsimple.ffa.domain.Cliente;

@Service
public class ClienteService {
	
	private static final Map<Integer, Cliente> clienteMap = new HashMap<>();
	private static int nextId = 1;

//    @Autowired
//    ClienteRepository clienteRepository;
	
	public Cliente cadastrar(Cliente cliente) {
//		return clienteRepository.save(cliente);
		cliente.setId(nextId++);
		return clienteMap.put(cliente.getId(), cliente);
	}
	
	public Collection<Cliente> buscarTodos() {
//	    return clienteRepository.findAll();
		return clienteMap.values();
	}
	
	public void excluir(Cliente cliente) {
//	    clienteRepository.delete(cliente);
		clienteMap.remove(cliente.getId());
	}

    public Cliente buscarPorId(Integer id) {
//	    return clienteRepository.findOne(id);
    	return clienteMap.get(id);
	}

	public Cliente alterar(Cliente cliente) {
//		return clienteRepository.save(cliente);
		return clienteMap.put(cliente.getId(), cliente);
	}
}