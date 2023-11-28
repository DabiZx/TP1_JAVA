package com.informatorio.domain;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private Cliente cliente_actual = null;


    public Banco(){};

    public Cliente get_cliente_actual(){
        return this.cliente_actual;
    }

    public List<Cliente> get_clientes(){
        return this.clientes;
    }

    public void set_cliente_actual(Cliente cliente){
        this.cliente_actual = cliente;
    }


    public void registrarse(String nombre_cliente, String direccion_cliente, String contrasenia_cliente){
        Cliente new_cliente = new Cliente(nombre_cliente, direccion_cliente, contrasenia_cliente);
        this.clientes.add(new_cliente);
        
    }


    
    public void login(String nombre_cliente, String contrasenia_cliente){

        for (Cliente cliente : clientes) {

            if (cliente.get_nombre().equals(nombre_cliente) && contrasenia_cliente.equals(contrasenia_cliente)) {
                this.cliente_actual = cliente;
                return;
             }
        }

        
    }
    
    public void logout(){
        cliente_actual = null;
    }


    public void gestionar_clientes(){
        for(Cliente cliente : clientes){
            System.out.println("------------------------------");
            System.out.println("nombre cliente: " + cliente.get_nombre());
            System.out.println("direccion: " + cliente.get_direccion());
            System.out.println("------------------------------");
        }
  }

    public void abrir_cuenta(Integer tipo_cuenta){
        cliente_actual.agregar_cuenta(tipo_cuenta);

    }
    }


