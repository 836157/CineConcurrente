/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine;


import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author Usuario
 */
public class ManagerCinema {

    //numeros de taquillas, van a ser hilos en ejecucion.
    private static final int NUM_TAQUILLAS = 3;
    private static final int NUM_CLIENTES = 20;

    private LinkedBlockingQueue<Cliente> colaClientes = new LinkedBlockingQueue<>();

    //Object lock = new Object();
    private Thread[] taquillas = new Thread[NUM_TAQUILLAS];

    public ManagerCinema() {

        for (int i = 0; i < NUM_TAQUILLAS; i++) {
            taquillas[i] = new Thread(new Taquilla(this, (i + 1)));
        }
    }

    public void iniciarCine() {
        for (int i = 1; i <= NUM_CLIENTES; i++) {
            Cliente cliente = new Cliente("Cliente" + i);
            agregarCliente(cliente);
        }

        for (Thread taquilla : taquillas) {
            taquilla.start();
        }

    }

    public LinkedBlockingQueue<Cliente> getColaClientes() {
        return colaClientes;
    }

    public void agregarCliente(Cliente cliente) {
        colaClientes.offer(cliente);
    }

    public Cliente obtenerCliente() throws InterruptedException {
        while (!colaClientes.isEmpty()) {
            return colaClientes.poll();
        }
        return null;
    }

}
