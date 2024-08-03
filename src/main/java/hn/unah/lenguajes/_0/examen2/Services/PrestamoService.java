package hn.unah.lenguajes._0.examen2.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hn.unah.lenguajes._0.examen2.Entities.Cliente;
import hn.unah.lenguajes._0.examen2.Entities.Prestamo;
import hn.unah.lenguajes._0.examen2.Repositories.ClienteRepository;
import hn.unah.lenguajes._0.examen2.Repositories.PrestamoRepository;

@Service
public class PrestamoService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PrestamoRepository prestamoRepository;

    public boolean crearPrestamo(String id, Prestamo prestamo) {
        Cliente clienteEditar = this.clienteRepository.findById(id).get();
        if (this.clienteRepository.existsById(id) && clienteEditar.getPrestamo().size() < 2) {

            clienteEditar.getPrestamo().add(prestamo);

            double i = prestamo.getInteres()/12;
            double M = prestamo.getMonto();
            int n = prestamo.getPlazo();
            prestamo.setCuota((M * i * Math.pow((1 + i), n * 12)) / Math.pow((1 + i), n * 12) - 10);

            prestamo.setClientes(clienteEditar);

            this.clienteRepository.save(clienteEditar);


            return true;
        }else {
            return false;
        }
    }

    public Prestamo buscarPorId(int id) {
        return this.prestamoRepository.findById(id).get();
    }
}
