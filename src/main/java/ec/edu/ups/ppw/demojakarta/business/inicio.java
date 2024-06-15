package ec.edu.ups.ppw.demojakarta.business;

import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw.demojakarta.dao.clienteDAO;
import ec.edu.ups.ppw.demojakarta.dao.detallesDAO;
import ec.edu.ups.ppw.demojakarta.dao.facturaDAO;
import ec.edu.ups.ppw.demojakarta.dao.productoDAO;
import ec.edu.ups.ppw.demojakarta.modelo.cliente;
import ec.edu.ups.ppw.demojakarta.modelo.detalleFactura;
import ec.edu.ups.ppw.demojakarta.modelo.factura;
import ec.edu.ups.ppw.demojakarta.modelo.producto;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class inicio {
	
	@Inject
	private clienteDAO dao;
	
	@Inject
	private productoDAO pdao;
	
	@Inject
	private detallesDAO ddao;
	
	@Inject
	private facturaDAO fdao;
	
	@PostConstruct
	public void init() {
		System.out.println("----------------INICIANDO----------------");
		
		cliente cliente = new cliente();
		
		cliente.setCedula("0106785678");
		cliente.setNombre("Esteban Cordova");
		cliente.setCorreo("s3._xc@hotmail.com");
		cliente.setTelefono("0998663179");
		
		dao.insert(cliente);
		
		cliente = new cliente();
		
		cliente.setCedula("0102030405");
		cliente.setNombre("Eduardo Arce");
		cliente.setCorreo("edusitobicholover777@gmail.com");
		cliente.setTelefono("0987654321");
		
		dao.insert(cliente);
		
		producto producto = new producto();
		
		producto.setCodigo(1);
		producto.setPrecio(10.99);
		producto.setStock(100);
		
		pdao.insert(producto);
		
		producto = new producto();
		
		producto.setCodigo(2);
		producto.setPrecio(0.99);
		producto.setStock(50);
		
		pdao.insert(producto);
		
		detalleFactura det = new detalleFactura();
		
		det.setCodigo(1);
		det.setProducto(producto);
		det.setCantidad(4);
		det.setPrecio(3.96);
		
		ddao.insert(det);
		
		det = new detalleFactura();
		
		det.setCodigo(2);
		det.setProducto(pdao.read(1));
		det.setCantidad(1);
		det.setPrecio(10.99);
		
		ddao.insert(det);
		
		factura fac = new factura();
		
		fac.setNumero(1);
		fac.setCliente(cliente);
		fac.setFecha(new Date());
		fac.addDetalle(det);
		
		fdao.insert(fac);
		
		
		List<cliente> listado = dao.getAll();
		for(cliente cli : listado) {
			System.out.println(cli.toString());
		}
		
		List<producto> list = pdao.getAll();
		for(producto cli : list) {
			System.out.println(cli.toString());
		}
		
		List<detalleFactura> lista = ddao.getAll();
		for(detalleFactura cli : lista) {
			System.out.println(cli.toString());
		}
		
		List<factura> li = fdao.getAll();
		for(factura cli : li) {
			System.out.println(cli.toString());
		}
	}
}
