package com.informatorio.domain;

public class CuentaCorriente extends Cuenta{
    private Double cantidad_dinero_banco = 10000.0;


    public Double get_cantidad_dinero_banco(){
        return cantidad_dinero_banco;
    }

    
    public CuentaCorriente(Cliente cliente_titular){
        super(cliente_titular);
    }

    @Override
    public void retirar_saldo(Double cantidad){
        if (cantidad > this.saldo){
            if (cantidad > this.cantidad_dinero_banco){
                System.out.println("la cantidad ha excedido el limite de sobregiro el cual es: " + this.cantidad_dinero_banco + " ingrese otra cantidad");
            }
            else{
                this.cantidad_dinero_banco -= cantidad - this.saldo;
                
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("la cantidad que ingreso ha excedido su saldo el banco le desconto: " + (cantidad - this.saldo) + " al limite de sobregiro" );
                System.out.println("el limite de sobregiro ahora es de: " + this.cantidad_dinero_banco + "$");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
                this.saldo = 0.0;
            }
        } 
        else{
            super.retirar_saldo(cantidad);
    }
}
}