package com.gcc.app.item.models.controllers;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gcc.app.item.models.Item;
import com.gcc.app.item.models.Producto;
import com.gcc.app.item.models.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@RefreshScope
@RestController
public class ItemController {
	
	@Autowired
	@Qualifier("itemServiceFeign")
	ItemService itemService;
	
	
	@Value("${configuracion.texto}")
	private String texto;
	
	@GetMapping("/listar")
	public List<Item> listar(){
		List<Item> result=itemService.findAll();
		return result;
	}
	@HystrixCommand(fallbackMethod = "detalleFallback")
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}
	
	public Item detalleFallback( Long id, Integer cantidad) {
		Producto p= new Producto();
		p.setNombre("error");
		p.setPrecio(-1.0);
		return new Item(p,-1);
	}

	@GetMapping("/obtener-config")
	public ResponseEntity<?> obtenerConfig(){
		
		return new ResponseEntity<String>(texto,HttpStatus.OK);
	}
}
