
package Servicios;

import entidades.Producto;
import java.util.List;
import org.springframework.stereotype.Service;


public interface productoService{
     
    List<Producto> listarProductos();

     
    void eliminarProducto(Integer id);

     
    void crearProducto(Producto producto);

     
    Producto findByIdProducto(Integer id);

     
    Producto buscarPorNombreProducto(String nombre);
}

