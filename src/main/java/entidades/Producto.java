
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name="producto")
public class Producto implements Serializable {
    
    private static final long serialVersionUID = -4592600819270861934L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id", nullable = false)
    private Integer id;
    
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    
    @Column(name="descripcion", nullable = false, length = 100)
    private String descripcion;

    @Column(name="precio", nullable = false)
    private Integer precio;

}
