package com.informatorio.domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String direccion;
    private String contrasenia;
    private List<Cuenta> cuentas = new ArrayList<Cuenta>();
    
    
    public Cliente(String nombre_cliente, String direccion_cliente, String contrasenia_cliente){
        this.nombre = nombre_cliente;
        this.direccion = direccion_cliente;
        this.contrasenia = contrasenia_cliente;
    }


    public String get_nombre(){
        return this.nombre;
    }

    public String get_contrasenia(){
        return this.contrasenia;
    }

    public List<Cuenta> get_cuentas(){
        return this.cuentas;
    }

    public String get_direccion(){
        return this.direccion;
    }


    public void agregar_cuenta(Integer tipo_cuenta){
        if (tipo_cuenta == 1){
            new CuentaCorriente(this);
            
        }
        else if (tipo_cuenta == 2){
            new CuentaAhorro(this);
            

        }
        System.out.println("-------------------------------------------------------");
        System.out.println("se ha agregado la cuenta numero: " + (cuentas.size() -1));
        System.out.println("-------------------------------------------------------");



    }

    public void eliminar_cuenta(Integer cuenta_eliminar){
        cuentas.remove(cuentas.get(cuenta_eliminar));
    }

    public void consultar_saldo(Integer num_cuenta){
        cuentas.get(num_cuenta).consultar_saldo();
        
    }

    public void ver_cuentas(){
        for (Cuenta cuenta : cuentas) {
            System.out.println("-------------------------------------");
            System.out.println("numero cuenta: " + cuenta.get_numero_cuenta());

            if (cuenta instanceof CuentaCorriente){
                System.out.println("tipo cuenta : Cuenta Corriente");
            } else if (cuenta instanceof CuentaAhorro){
                System.out.println("tipo cuenta : Cuenta Ahorro");
            }
            System.out.println("-------------------------------------");
        }
    }

}
