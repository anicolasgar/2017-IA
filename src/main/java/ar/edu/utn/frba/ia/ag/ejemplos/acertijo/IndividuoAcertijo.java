package main.java.ar.edu.utn.frba.ia.ag.ejemplos.acertijo;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

/**
 * Created by anicolasgarcia on 10/8/17.
 */
public class IndividuoAcertijo extends Individuo {

    public enum PROFESION {
        PROFESORA,
        ENFERMERA,
        CONTADORA,
        BIOLOGA;
    }

    public enum CIUDAD {
        A,
        B,
        C,
        D;
    }

    private Integer LC;
    private Integer LP;
    private Integer KC;
    private Integer KP;
    private Integer NC;
    private Integer NP;
    private Integer RC;
    private Integer RP;

    public Integer getLC() {
        return LC;
    }

    public void setLC(Integer LC) {
        this.LC = LC;
    }

    public Integer getLP() {
        return LP;
    }

    public void setLP(Integer LP) {
        this.LP = LP;
    }

    public Integer getKC() {
        return KC;
    }

    public void setKC(Integer KC) {
        this.KC = KC;
    }

    public Integer getKP() {
        return KP;
    }

    public void setKP(Integer KP) {
        this.KP = KP;
    }

    public Integer getNC() {
        return NC;
    }

    public void setNC(Integer NC) {
        this.NC = NC;
    }

    public Integer getNP() {
        return NP;
    }

    public void setNP(Integer NP) {
        this.NP = NP;
    }

    public Integer getRC() {
        return RC;
    }

    public void setRC(Integer RC) {
        this.RC = RC;
    }

    public Integer getRP() {
        return RP;
    }

    public void setRP(Integer RP) {
        this.RP = RP;
    }


    public double aptitud() {

        double regla1 = this.getNP() == 2 ? 5 : -5;
        double regla2 = this.getLC() == 4 ? 5 : -5;
        double regla3 = this.getKC() != 1 && this.getKC() != 2 ? 5 : -5;
        double regla4 = (
                (this.getNC() == 1 && this.getNP() == 3)
                        || (this.getKC() == 1 && this.getKP() == 3)
                        || (this.getRC() == 1 && this.getRP() == 3)
                        || (this.getLC() == 1 && this.getLP() == 3)
        ) ? 2 : -10;
        double regla5 = (
                (this.getNC() == 3 && this.getNP() == 4)
                        || (this.getKC() == 3 && this.getKP() == 4)
                        || (this.getRC() == 3 && this.getRP() == 4)
                        || (this.getLC() == 3 && this.getLP() == 4)
        ) ? 2 : -10;
        double regla6 = this.getLP() == 1 || this.getKP() == 1 || this.getRP() == 1 || this.getNP() == 1 ? 1 : -15;
        double regla7 = this.getLC() == this.getKC()
                || this.getLC() == this.getRC()
                || this.getLC() == this.getNC()
                || this.getKC() == this.getRC()
                || this.getKC() == this.getNC()
                || this.getRC() == this.getNC() ? -5 : 2;
        double regla8 = this.getLP() == this.getKP()
                || this.getLP() == this.getNP()
                || this.getLP() == this.getRP()
                || this.getKP() == this.getNP()
                || this.getKP() == this.getRP()
                || this.getNP() == this.getRP() ? -5 : 2;


        return regla1 + regla2 + regla3 + regla4 + regla5 + regla6 + regla7 + regla8;
    }

    @Override
    public boolean esMasAptoQue(Individuo individuo) {
        return this.aptitud() > individuo.aptitud();
    }

    @Override
    public Individuo generarRandom() {

        IndividuoAcertijo ia = new IndividuoAcertijo();
        int min = 1;
        int max = 4;
        int randomCiudad;
        int randomProfesion;

        ArrayList<Integer> ciudadesDisponibles = inicializoCiudadesDisponibles();
        ArrayList<Integer> profesionesDisponibles = inicializoProfesionesDisponibles();

        // Luz
        randomCiudad = ThreadLocalRandom.current().nextInt(min, max + 1);
        randomProfesion = ThreadLocalRandom.current().nextInt(min, max + 1);
        ia.setLC(randomCiudad);
        ia.setLP(randomProfesion);

        // Katty
        randomCiudad = getElementoNoRepetido(ciudadesDisponibles, ThreadLocalRandom.current().nextInt(min, max + 1));
        randomProfesion = getElementoNoRepetido(profesionesDisponibles, ThreadLocalRandom.current().nextInt(min, max + 1));

        ia.setKC(randomCiudad);
        ia.setKP(randomProfesion);

        // Nora
        randomCiudad = getElementoNoRepetido(ciudadesDisponibles, ThreadLocalRandom.current().nextInt(min, max + 1));
        randomProfesion = getElementoNoRepetido(profesionesDisponibles, ThreadLocalRandom.current().nextInt(min, max + 1));

        ia.setNC(randomCiudad);
        ia.setNP(randomProfesion);

        // Ruth
        randomCiudad = getElementoNoRepetido(ciudadesDisponibles, ThreadLocalRandom.current().nextInt(min, max + 1));
        randomProfesion = getElementoNoRepetido(profesionesDisponibles, ThreadLocalRandom.current().nextInt(min, max + 1));

        ia.setRC(randomCiudad);
        ia.setRP(randomProfesion);

//        try {
//            String generada = "LC:" + this.getLC() + " LP:" + this.getLP() +
//                    "//" +
//                    "KC:" + this.getKC() + " KP:" + this.getKP() +
//                    "//" +
//                    "NC:" + this.getNC() + " NP:" + this.getNP() +
//                    "//" +
//                    "RC:" + this.getRC() + " RP:" + this.getRP() +
//                    "//" +
//                    " / aptitud: " + this.aptitud();
//
//            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(generada);
//        } catch (Exception e) {
//            //
//        }
        return ia;
    }

    private ArrayList<Integer> inicializoProfesionesDisponibles() {
        ArrayList<Integer> profesionesDisponibles = new ArrayList();
        profesionesDisponibles.add(1);
        profesionesDisponibles.add(2);
        profesionesDisponibles.add(3);
        profesionesDisponibles.add(4);
        return profesionesDisponibles;
    }

    private ArrayList<Integer> inicializoCiudadesDisponibles() {
        ArrayList<Integer> ciudadesDisponibles = new ArrayList();
        ciudadesDisponibles.add(1);
        ciudadesDisponibles.add(2);
        ciudadesDisponibles.add(3);
        ciudadesDisponibles.add(4);
        return ciudadesDisponibles;
    }

    private Integer getElementoNoRepetido(ArrayList<Integer> list, Integer item) {
        Integer value;
        if (!list.contains(item)) {
            value = list.stream().findFirst().get();
        }
        value = item;
        list.remove(new Integer(value));

        return value;
    }

    @Override
    public String toString() {

        return "LC:" + this.getLC() + " LP:" + this.getLP() +
                "//" +
                "KC:" + this.getKC() + " KP:" + this.getKP() +
                "//" +
                "NC:" + this.getNC() + " NP:" + this.getNP() +
                "//" +
                "RC:" + this.getRC() + " RP:" + this.getRP() +
                "//" +
                " / aptitud: " + this.aptitud();
    }
}
