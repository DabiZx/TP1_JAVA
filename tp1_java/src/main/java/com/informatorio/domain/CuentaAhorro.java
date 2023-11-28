package com.informatorio.domain;

public class CuentaAhorro extends Cuenta{
    private Double tasa_interes = 10.0;
    

    public CuentaAhorro(Cliente cliente_titular){
        super(cliente_titular);
    }

    @Override
    public void agregar_intereses(Double cantidad, Integer meses){
        Double tasa_interes_decimal = (tasa_interes/100);
        
        Double interes = (1 + tasa_interes_decimal * meses);

        Double cantidad_final = cantidad * interes;

        System.out.println("se ha agregado: " + cantidad_final + "$ a su saldo");
        depositar_saldo(cantidad_final);

        


    }
}
