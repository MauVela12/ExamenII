package hn.unah.lenguajes._0.examen2.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.unah.lenguajes._0.examen2.Entities.Cliente;
import hn.unah.lenguajes._0.examen2.Entities.Prestamo;
import hn.unah.lenguajes._0.examen2.Repositories.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodos() {
        return this.clienteRepository.findAll();
    }

    public boolean crearCliente(Cliente nvoCliente) {
        if (this.clienteRepository.existsById(nvoCliente.getDni())) {
            return false;
        }else {
            if (nvoCliente.getPrestamo() != null) {
                for (Prestamo prestamo : nvoCliente.getPrestamo()) {
                    double i = prestamo.getInteres()/12;
                    double M = prestamo.getMonto();
                    int n = prestamo.getPlazo();

                    prestamo.setCuota((M * i * Math.pow((1 + i), n * 12)) / Math.pow((1 + i), n * 12) - 1);
                    prestamo.setClientes(nvoCliente);
                }

                this.clienteRepository.save(nvoCliente);

                return true;
            }else {
                this.clienteRepository.save(nvoCliente);
                return true;
            }
        }
    }
}
