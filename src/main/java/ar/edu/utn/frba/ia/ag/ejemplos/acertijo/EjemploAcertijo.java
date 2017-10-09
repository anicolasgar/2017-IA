package main.java.ar.edu.utn.frba.ia.ag.ejemplos.acertijo;

import main.java.ar.edu.utn.frba.ia.ag.*;

import java.util.logging.Logger;

/**
 * Created by anicolasgarcia on 10/8/17.
 */
public class EjemploAcertijo {

    public static void main(String[] args) {

        AlgoritmoGenetico acertijo = new AlgoritmoGenetico(new ConfiguracionAcertijo(), IndividuoAcertijo.class);
        Individuo ia = acertijo.ejecutar();
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("Individuo final: " + ia.toString());
    }
}
