/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Taquilla implements Runnable {

    private final ManagerCinema mc;
    private final int numTaquilla;

    public Taquilla(ManagerCinema mc, int nombre) {
        this.mc = mc;
        this.numTaquilla = nombre;
    }

    @Override
    public void run() {

        Random random = new Random();
        try {
            while (true) {
                Cliente cliente = mc.obtenerCliente();
                if (cliente != null) {
                    System.out.println("La taquilla" + numTaquilla + " comienza a atender a " + cliente.getNombre() + " que quiere la sala : " + cliente.getSala());
                    int tiempoAtencioon = random.nextInt(5) + 1;
                    Thread.sleep(tiempoAtencioon * 1000);
                    System.out.println("La taquilla" + numTaquilla + " termino de atender a " + cliente.getNombre() + " en " + tiempoAtencioon + "seg");

                } else {
                    System.out.println("LA COLA SE VACIO!!!!");
                    System.out.println("********************");
                    System.out.println("Finalizando Programa");
                    System.exit(0);
                }

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
