package com.gcc.app.item.models.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcc.app.item.clients.ProductoClienteRest;
import com.gcc.app.item.models.Item;
import com.gcc.app.item.models.Producto;

@Service("itemServiceFeign")
public class ItemServiceFeignImpl implements ItemService {
	
	
	@Autowired
	ProductoClienteRest productoClientRest;

	@Override
	public List<Item> findAll() {
		List<Producto> productos=productoClientRest.listar();
		
		
		return productos.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
		
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		
		 return new Item(productoClientRest.findbyId(id),cantidad);
	}

}
