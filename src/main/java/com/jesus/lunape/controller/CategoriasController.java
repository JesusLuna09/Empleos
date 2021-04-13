package com.jesus.lunape.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.jesus.lunape.model.Categoria;
import com.jesus.lunape.service.IntCategoriasService;

@Controller
//anotacion @RequestMapping a nivel de la clase
@RequestMapping(value="/categorias")
public class CategoriasController {
	
	@Autowired
	private IntCategoriasService categoriasService;

	@RequestMapping(value="/modificar",method=RequestMethod.GET)
	public String modificar(@RequestParam("id") int idCategoria,
			Model model) {
		Categoria categoria = categoriasService.buscarPorId(idCategoria);
		model.addAttribute("categoria", categoria);
		return "categorias/formCategoria";
	}
	
	@RequestMapping(value="/eliminar",method=RequestMethod.GET)
	public String eliminar(@RequestParam("id") int idCategoria,
			RedirectAttributes attributes) {
		categoriasService.eliminar(idCategoria);
		attributes.addFlashAttribute("msg", "Categoria eliminada");
		return "redirect:/categorias/index";
	}
	
	
	@RequestMapping(value="/indexPaginate",method=RequestMethod.GET)
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Categoria> lista = categoriasService.buscarTodas(page);
		model.addAttribute("categorias", lista);
		return "categorias/listaCategorias";
	}

	
		//@GetMapping("/index")
		//anotacion a nivel de metodo
		@RequestMapping(value="/index",method=RequestMethod.GET)
		public String mostrarIndex(Model model) {
			//
			List<Categoria> lista = categoriasService.obtenerTodas();
			for (Categoria categoria : lista) {
				System.out.println(categoria);
			}
			model.addAttribute("categorias", lista);
			return "categorias/listaCategorias";
			
	}
		//@GetMapping("/crear")
		@RequestMapping(value="/crear",method=RequestMethod.GET)
		public String crear(Categoria categoria) {
			return "categorias/formCategoria";
		}
		
		//@GetMapping("/guardar")
	/*	@RequestMapping(value="/guardar",method=RequestMethod.POST)
		public String guardar(@RequestParam("nombre") String nombre,
				@RequestParam("descripcion") String descripcion) {
			System.out.println("Nombre Categoria : " + nombre);
			System.out.println("Descripcion : " + descripcion);
			
			return "categorias/listaCategorias";
		}*/
		
		@RequestMapping(value="/guardar", method=RequestMethod.POST)
		public String guardar(Categoria categoria, BindingResult result,
				RedirectAttributes attributes) {
			
			if(result.hasErrors()) {
				for (ObjectError error: result.getAllErrors()) {
					System.out.println("Ocurrio un error : "+ error.getDefaultMessage());
				}
				return "vacantes/formCategoria";
			}
			attributes.addFlashAttribute("msg", "La categoria se guardo");
			//categoria.setId(categoriasService.obtenerTodas().size()+1);
			categoriasService.guardar(categoria);
			return "redirect:/categorias/index";
		}
		
		
		
}
