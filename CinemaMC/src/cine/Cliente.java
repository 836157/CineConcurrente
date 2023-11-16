/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine;

/**
 *
 * @author Usuario
 */
public class Cliente {

    private final String name;
    private final int salaElegida;

    public Cliente(String name) {
        this.name = name;
        this.salaElegida = (int) (Math.random() * 4) + 1;
    }

    public String getNombre() {
        return name;
    }

    public int getSala() {
        return salaElegida;
    }

}
