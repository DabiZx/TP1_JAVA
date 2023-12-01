package com.informatorio.servicios.cliente;

import java.util.Scanner;

import com.informatorio.domain.Banco;
import com.informatorio.domain.Cliente;

public class ClienteServicioImpl implements ClienteServicio{


    private Scanner input = new Scanner(System.in);

    private Banco banco = new Banco();

    private Cliente cliente_actual;
    


    public ClienteServicioImpl(){}; 


    public void setBanco(Banco banco) {
        this.banco = banco;
    }


    public void setCliente_actual() {
        this.cliente_actual = banco.get_cliente_actual();
    }



    @Override
    public void agregar_cuenta() {
        System.out.println("-------------------------");
        System.out.println("selecciona el tipo de cuenta");
        System.out.println("-------------------------");
            
        System.out.println();
        System.out.println("1_ Cuenta Corriente");
        System.out.println("2_ Cuenta Ahorro");

        Integer tipo_cuenta = input.nextInt();
        input.nextLine();
            
        cliente_actual.agregar_cuenta(tipo_cuenta);
    }

    @Override
    public void eliminar_cuenta() {
        System.out.println("====================-");
        System.out.println("   eliminar cuenta   ");
        System.out.println("=====================");

        cliente_actual.ver_cuentas();

        System.out.println("ingrese el numero de cuenta que desea eliminar");

        Integer num_cuenta = input.nextInt();
        input.nextLine();

        cliente_actual.eliminar_cuenta(num_cuenta);
    }




    @Override
    public void ver_cuentas() {
        cliente_actual.ver_cuentas();
    }

    @Override
    public void consultar_saldo() {
        cliente_actual.ver_cuentas();
        System.out.println("======================================================");
        System.out.println("ingrese el numero de la cuenta que quiere ver el saldo");
        System.out.println("======================================================");

        Integer num_cuenta = input.nextInt();
        input.nextLine();

        cliente_actual.consultar_saldo(num_cuenta); 
    }


    @Override
    public Integer acceder_cuenta() {
        cliente_actual.ver_cuentas();

        System.out.println("ingrese el numero de la cuenta que quiere acceder");
        Integer num_cuenta = input.nextInt();
        input.nextLine();

        return num_cuenta;
    }
    
}
