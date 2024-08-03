package hn.unah.lenguajes._0.examen2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hn.unah.lenguajes._0.examen2.Entities.Prestamo;
import hn.unah.lenguajes._0.examen2.Services.PrestamoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("api/prestamos")
public class PrestamoController {
    
    @Autowired
    private PrestamoService prestamoService;

    @PutMapping("/crear/{id}")
    public String crear(@PathVariable(name = "id") String id,
                        @RequestBody Prestamo prestamo) {
        if (this.prestamoService.crearPrestamo(id, prestamo)) {
            return "Prestamo agregado correctamente";
        }else {
            return "Error al agregar prestamo";
        }
    }

    @GetMapping("/obtenerPorId/{id}")
    public Prestamo obtener(@PathVariable int id) {
        return this.prestamoService.buscarPorId(id);
    }
    
    
}
