//package com.facturador.danmar.controller;
//
//import java.text.ParseException;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.danmar.dbf.dto.filtro.FiltroArticulo;
//import com.danmar.dbf.dto.filtro.FiltroCliente;
//import com.danmar.error.ErrorRespuestaBean;
//import com.danmar.filtro.Paginacion;
//import com.facturador.danmar.form.ArticuloForm;
//import com.facturador.danmar.form.ClienteForm;
//import com.facturador.danmar.form.DocumentoEncabezadoForm;
//import com.facturador.danmar.manager.ArticuloManager;
//import com.facturador.danmar.manager.ClienteManager;
//import com.facturador.danmar.manager.DocumentoEncabezadoManager;
//import com.facturador.danmar.manager.TarjetaManager;
//
//
//@Controller
//public class DummyPostaController implements IDummyController{
//
//	
//	@Autowired
//	ArticuloManager articuloManager;
//	
//	@Autowired
//	TarjetaManager tarjetaManager;
//	
//	@Autowired
//	ClienteManager clienteManager;
//
//	@Autowired
//	DocumentoEncabezadoManager documentoEncabezadoManager;
//	
//	@RequestMapping("/Probando")
//	public ModelAndView getVersion(){
//		System.out.println("controlador empieza");
//		//articuloManager.getAll(0, 100);
//		System.out.println("controlador termina");
//		return new ModelAndView("version");
//	}
//
//	@Override
//	public @ResponseBody	List<ClienteForm> findAllClientes(@RequestBody Integer pagina){
//		return null;
//		//return clienteManager.getAll();
//	}
//
//
//	@Override
//	public @ResponseBody List<ClienteForm> searchClientesByFiltro(@RequestBody FiltroCliente pagina) {
//		return null;
//		//return clienteManager.getAll();
//	}
//	
//	public @ResponseBody ClienteForm getClienteById(@PathVariable Integer codigo) {
//		return clienteManager.getById(codigo);
//	}
//	
//	public @ResponseBody	List<ArticuloForm> findAllArticulos(@PathVariable Integer pagina,@PathVariable Integer cantRegistros) {
//		//return articuloManager.getAll(pagina, cantRegistros);
//		return null;
//	}
//	
//	public @ResponseBody List<ArticuloForm> searchArticulosByFiltro(@RequestBody  String nombre,@RequestBody  Paginacion pagina){
//		//return articuloManager.searchByNombre(nombre, pagina.getPagina(), pagina.getCantRegistros());
//		return null;
//	}
//	
//	@RequestMapping(value = "/articulo/probar/", method = RequestMethod.POST)
//	public @ResponseBody String prueba1(@ModelAttribute("nombre") String nombre) {
//		return "OK1";
//	}
//
//	@RequestMapping(value = "/articulo/probar2/", method = RequestMethod.GET)
//	public @ResponseBody String prueba2()
//	{
//		return "OK2";
//	}
//
//
//	public @ResponseBody List<ArticuloForm> searchArticulosByFiltro(@RequestBody FiltroArticulo filtro) throws ParseException{
//		//return articuloManager.searchByFiltros(filtro, filtro.getPagina(), filtro.getCantRegistros());
//		return null;
//	}
//
//	
//	public @ResponseBody ArticuloForm getArticuloById(@PathVariable String nombre) {
//		return articuloManager.getById(nombre);
//	}
//
//	@Override
//	public ErrorRespuestaBean guardar(DocumentoEncabezadoForm form,
//			BindingResult result, HttpServletRequest request)
//			throws ParseException {
//		return documentoEncabezadoManager.save(form);
//	}
//
//	@RequestMapping(value = "/documento/prueba", method = RequestMethod.GET)
//	public @ResponseBody	String guardarPrueba() {
//		DocumentoEncabezadoForm form = new DocumentoEncabezadoForm();
//		
//		documentoEncabezadoManager.save(form);
//		return ("OK");
//	}
//
//	@Override
//	public List<ClienteForm> searchClientesByField(Paginacion pagina) {
//		return null;
//		//return clienteManager.getAll();
//	}
//
//
//	
//}
