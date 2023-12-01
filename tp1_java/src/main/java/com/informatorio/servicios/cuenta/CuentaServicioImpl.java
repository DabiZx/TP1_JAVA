package com.informatorio.servicios.cuenta;

import java.util.Scanner;

import com.informatorio.domain.Banco;
import com.informatorio.domain.Cuenta;

public class CuentaServicioImpl implements CuentaServicio{
    private Banco banco;

    private Cuenta cuenta_actual;


    private Scanner input = new Scanner(System.in);



    public CuentaServicioImpl(){};


    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    
    public void setCuenta_actual(Integer num_cuenta) {
        this.cuenta_actual = banco.get_cliente_actual().get_cuentas().get(num_cuenta);;
    }
    

    public Cuenta getCuenta_actual() {
        return cuenta_actual;
    }

    @Override
    public void consultar_saldo() {
        cuenta_actual.consultar_saldo();
        
    }



    @Override
    public void depositar_saldo() {
        System.out.println("-------------------------");
        System.out.println("  depositar saldo  ");
        System.out.println("-------------------------");
    
        

        System.out.println();

        System.out.println("ingrese una cantidad: ");
        
        Double cantidad = input.nextDouble();
        input.nextLine();

        cuenta_actual.depositar_saldo(cantidad);
        
        
    }



    @Override
    public void retirar_saldo() {
        System.out.println("-------------------------");
        System.out.println(" retirar saldo  ");
        System.out.println("-------------------------");


        if (cuenta_actual.get_tipo() == "CuentaCorriente"){
            System.out.println("tu cuenta es una cuenta Corriente estas cuentas tienen un limite de que tanto dinero podes retirar,");
            System.out.println("si la cantidad excede su saldo el banco le ofrece 10.000$ para que pueda completar su retiro");
            System.out.println("pero si excede esa cantidad no podra retirar su saldo");
                }

        System.out.println();

        System.out.println("ingrese una cantidad: ");

        Double cantidad = input.nextDouble();
        input.nextLine();

        cuenta_actual.retirar_saldo(cantidad);
    }



    @Override
    public void agregar_intereses() {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println(" agregar intereses, por abonar cada mes te agregaremos un 10% de interes a tu saldo");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println();

        System.out.println("ingrese una cantidad: ");
        Double cantidad = input.nextDouble();
        input.nextLine();

        System.out.println("ingrese por cuantos meses va a dejar en el banco esa cantidad: ");
        
        Integer meses = input.nextInt();
        input.nextLine();

        cuenta_actual.agregar_intereses(cantidad, meses);
    }


    

}
