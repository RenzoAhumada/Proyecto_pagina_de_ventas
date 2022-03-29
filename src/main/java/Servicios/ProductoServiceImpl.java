
package Servicios;

import entidades.Producto;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements productoService {
    
    @Autowired
    private productoService productoservice;
    
    @Override
    @Transactional
    public List<Producto> listarProductos() {
        return productoservice.listarProductos();
    }

    @Override
    @Transactional
    public void eliminarProducto(Integer id) {
        productoservice.delete(findByIdProducto(id));
    }

    @Override
    @Transactional
    public void crearProducto(Producto producto) {
        productoservice.save(producto);
    }

    @Override
    @Transactional
    public Producto findByIdProducto(Integer id) {
       return productoservice.findByIdProducto(id).orElse(null);
    }

    @Override
    @Transactional
    public Producto buscarPorNombreProducto(String nombre) {
       return productoservice.buscarPorNombreProducto(nombre).orElse(null);
    }
}
