package com.informatorio.domain;

public class Cuenta {
    protected Integer numero_cuenta;
    protected Cliente titular;
    protected Double saldo = 0.0;

    public Cuenta(Cliente titularCliente){
        titularCliente.get_cuentas().add(this);
        this.titular = titularCliente;
        this.numero_cuenta = titularCliente.get_cuentas().indexOf(this);
        
    }

    public void set_saldo(Double cantidad){
        this.saldo = cantidad;
    }

    public void set_titular(Cliente cliente){
        this.titular = cliente;
    }


    public Integer get_numero_cuenta(){
        return this.numero_cuenta;
    }

    public Cliente get_titular(){
        return this.titular;
    }

    public Double get_saldo(){
        return this.saldo;
    }


    public String get_tipo(){
        if (this instanceof CuentaCorriente){
            return "CuentaCorriente";
        }
        else if (this instanceof CuentaAhorro){
            return "CuentaAhorro";
        }

        return "Cuenta";
    }


    public void depositar_saldo(Double cantidad){
        saldo += cantidad;
        System.out.println("------------------------------------");
        System.out.println("tu saldo ahora es de: " + saldo + "$");
        System.out.println("------------------------------------");
    }

    public void retirar_saldo(Double cantidad){
        if (cantidad > saldo){
            System.out.println("la cantidad a retirar es mayor al saldo ingrese otra");
        }
        else{
            saldo -= cantidad;
            System.out.println("------------------------------------");
            System.out.println("tu saldo ahora es de: " + saldo + "$");
            System.out.println("------------------------------------");
        }
   
    }

    public void consultar_saldo(){
        System.out.println("el saldo de la cuenta numero: " + this.numero_cuenta + " es de: " + saldo + "$");
    }


    public void agregar_intereses(Double cantidad, Integer meses){

    }
    
}
