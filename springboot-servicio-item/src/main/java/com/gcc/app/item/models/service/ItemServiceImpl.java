package com.gcc.app.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gcc.app.item.models.Item;
import com.gcc.app.item.models.Producto;

@Service
public class ItemServiceImpl implements ItemService {

	
	@Autowired
	RestTemplate clientRestTemplate;
	
	@Override
	public List<Item> findAll() {
		List<Producto> productos=Arrays.asList(clientRestTemplate.getForObject("http://localhost:8001/listar", Producto[].class));
		
		return productos.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
		
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		HashMap<String,Object> uriVariables= new HashMap<>();
		uriVariables.put("id", id);
		Producto pr= clientRestTemplate.getForObject("http://localhost:8001/ver/{id}", Producto.class, uriVariables);
		return new Item(pr,cantidad);
		
	}

}
