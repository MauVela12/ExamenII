package hn.unah.lenguajes._0.examen2.Entities;

import java.sql.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "prestamos")
@Data
public class Prestamo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoprestamo")
    private int codigoPrestamo;

    @Column(name = "fechaapertura")
    private Date fechaApertura;

    private double monto;

    private double cuota;

    private int plazo;

    private double interes;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    private Cliente clientes;

    @OneToMany
    @JoinColumn(name = "codigoprestamo", referencedColumnName = "codigoprestamo")
    private List<Cuota> cuotas;
}
