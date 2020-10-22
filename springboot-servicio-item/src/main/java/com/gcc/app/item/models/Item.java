package com.gcc.app.item.models;

public class Item {
	
	private Producto producto;
	private Integer cantidad;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(Producto p, int i) {
		this.producto=p;
		this.cantidad=i;
		
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Double getTotal() {
		return producto.getPrecio()*getCantidad();
	}

}
