
package controladores;

import Servicios.productoService;
import entidades.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/procutos")
public class ProductoController {
    
    @Autowired
    private productoService prodcutoservice;
    
    @GetMapping("/listar")
    public String listarProductos(Model model){

        model.addAttribute("titulo","Productos");
        model.addAttribute("listapro", prodcutoservice.listarProductos());
        return "lista/productos-listar";
    }

    @GetMapping("/crear")
    public String toCrear(Model model) {
        model.addAttribute("titulo", "Crear producto");
        model.addAttribute("producto", new Producto());
        return "formulario/form-producto";
    }

    @PostMapping("/crear")
    public String crear(Producto producto) {
        producto.setNombre(prodcutoservice.findByIdNombreProducto(producto.getProducto().getId()));
        prodcutoservice.crearProducto(producto);
        return "redirect:/producto/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
        if (habitacionService.findByIdHabitacion(id) == null) {
            model.addAttribute("error", "Error al editar");
            return "redirect:/habitacion/listar";
        }
        model.addAttribute("titulo", "Editar Habitacion");
        model.addAttribute("habitacion", habitacionService.findByIdHabitacion(id));
        model.addAttribute("categoriaList", categoriaService.listarCategorias());
        model.addAttribute("niveles", nivelService.listarNiveles());
        return "formulario/Form-Habitacion";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id, Model model) {
        if (habitacionService.findByIdHabitacion(id) == null) {
            model.addAttribute("error", "Error al eliminar");
            return "redirect:/habitacion/listar";
        }
        habitacionService.eliminarHabitacion(id);
        return "redirect:/habitacion/listar";
    }
}
