package main.java.ar.edu.utn.frba.ia.ag;

import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.Simple;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.MutacionSimple;
import main.java.ar.edu.utn.frba.ia.ag.paro.CantidadDeCiclos;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Torneo;

/**
 * Created by anicolasgarcia on 10/9/17.
 */
public class ConfiguracionAcertijo extends Configuracion {

    public ConfiguracionAcertijo() {

        super(new CantidadDeCiclos(1199L), // criterio de paro
                999, // cantIndividuosIniciales
                new Torneo(), // seleccion
                new Simple(), // cruzamiento
                new MutacionSimple(0.2)); // mutacion
    }
}

