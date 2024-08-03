package hn.unah.lenguajes._0.examen2.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hn.unah.lenguajes._0.examen2.Entities.Cliente;
import hn.unah.lenguajes._0.examen2.Services.ClienteService;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    
    @PostMapping("/crear")
    public Cliente crear(@RequestBody Cliente nvoCliente) {
        if (this.clienteService.crearCliente(nvoCliente)) {
            return nvoCliente;
        }else {
            return null;
        }
    }
}
