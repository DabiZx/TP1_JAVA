package com.informatorio.menu_principal;

import java.util.Scanner;

import com.informatorio.domain.*;

import com.informatorio.servicios.*;
import com.informatorio.servicios.archivos.ArchivoServicioImpl;


public class MenuPrincipal {

    private Scanner input = new Scanner(System.in);

    private Banco banco = new Banco();

    private ArchivoServicioImpl archivo_servicio = new ArchivoServicioImpl();

    public MenuPrincipal(){}
    
    public void opciones_inicio(){
        while (true) {
            System.out.println("=======================");
            System.out.println("  Bienvenido al banco");
            System.out.println("=======================");
            System.out.println();
            System.out.println("1_ Registrarse");
            System.out.println("2_ Iniciar Sesion");
            System.out.println("3_ ver lista de clientes");
            System.out.println("4_ exportar a csv");
            System.out.println("5_ salir");

            Integer opcion = input.nextInt();
            input.nextLine();


            switch (opcion) {
                case 1:
                    opciones_registro();
                    break;
                case 2:
                    opciones_login();
                    break;

                case 3:
                    banco.gestionar_clientes();
                    break;
                case 4:
                    archivo_servicio.exportarCuentasACsv(banco.get_clientes(), "Cuentas.csv");
                    break;
                    
                
                case 5:
                    return;
 
                    
                default:
                    return;
            }

            
        }


    }


    public void opciones_registro(){
        while (true) {
            System.out.println("-----------------------");
            System.out.println("       Regsitrase      ");
            System.out.println("-----------------------");

            System.out.println("Ingresa Tu nombre");
            
            String nombre = input.nextLine();

            System.out.println("Ingresa tu direccion");

            String direccion = input.nextLine();

            System.out.println("Ingresa tu contraseña");

            String contrasenia = input.nextLine();

            banco.registrarse(nombre, direccion, contrasenia);

            System.out.println("-------------------------------------");
            System.out.println("registro exitoso ahora inicia sesion");
            System.out.println("-------------------------------------");
            return;

            
        }
    }

    public void opciones_login(){
        while (true) {
            System.out.println("-----------------------");
            System.out.println("     iniciar sesion  ");
            System.out.println("-----------------------");
            System.out.println("ingrese su nombre");

            String nombre = input.nextLine();

            System.out.println("Ingresa tu contraseña");
            String contrasenia = input.nextLine();

            banco.login(nombre, contrasenia);

            opciones_usuario_logeado();

            break;
            
            
        }
    }




    public void opciones_usuario_logeado(){
        if (banco.get_cliente_actual() != null){
            Cliente cliente_actual = banco.get_cliente_actual();

            System.out.println("-----------------------------------------");
            System.out.println("inicio sesion exitoso bienvenido " + cliente_actual.get_nombre());
            System.out.println("-----------------------------------------");
            

            while(true){
                System.out.println();
                System.out.println("-----------------------");
                System.out.println("1_ agregar cuenta");
                System.out.println("2_ eliminar cuenta");
                System.out.println("3_ consultar saldo");
                System.out.println("4_ ver cuentas");
                System.out.println("5_ acceder cuenta");
                System.out.println("6_ cerrar sesion");

                Integer opcion = input.nextInt();
                input.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("-------------------------");
                        System.out.println("selecciona el tipo de cuenta");
                        System.out.println("-------------------------");
                        
                        System.out.println();
                        System.out.println("1_ Cuenta Corriente");
                        System.out.println("2_ Cuenta Ahorro");

                        Integer tipo_cuenta = input.nextInt();
                        input.nextLine();
                        
                        cliente_actual.agregar_cuenta(tipo_cuenta);

                        break;
                    
                    case 2:
                        System.out.println("====================-");
                        System.out.println("   eliminar cuenta   ");
                        System.out.println("=====================");

                        cliente_actual.ver_cuentas();

                        System.out.println("ingrese el numero de cuenta que desea eliminar");

                        Integer num_cuenta = input.nextInt();
                        input.nextLine();

                        cliente_actual.eliminar_cuenta(num_cuenta);

                        break;
                    
                    case 3:
                        cliente_actual.ver_cuentas();
                        System.out.println("======================================================");
                        System.out.println("ingrese el numero de la cuenta que quiere ver el saldo");
                        System.out.println("======================================================");

                        num_cuenta = input.nextInt();
                        input.nextLine();

                        cliente_actual.consultar_saldo(num_cuenta);    
                        break;

                    case 4:
                        cliente_actual.ver_cuentas();
                      
                        break;
                    
                    case 5:
                        cliente_actual.ver_cuentas();

                        System.out.println("ingrese el numero de la cuenta que quiere acceder");
                        num_cuenta = input.nextInt();
                        input.nextLine();

                        Integer tipo_cuenta_acceder = 0;

                        if (cliente_actual.get_cuentas().get(num_cuenta) instanceof CuentaCorriente){
                            tipo_cuenta_acceder = 1;
                        }else if (cliente_actual.get_cuentas().get(num_cuenta) instanceof CuentaAhorro) {
                            tipo_cuenta_acceder = 2;
                        }

                        opciones_cuenta(num_cuenta, tipo_cuenta_acceder);

                        break;
                        
                    case 6:
                        banco.logout();
                        return;
                    default:
                        break;
                }
            }
    } 
    else {
        System.out.println("------------------------------------");
        System.out.println("no se pudo inicar sesion");
        System.out.println("------------------------------------");
        return;
     }
    }




    public void opciones_cuenta(Integer num_cuenta, Integer tipo_cuenta){
        Cuenta cuenta = banco.get_cliente_actual().get_cuentas().get(num_cuenta);

        if (tipo_cuenta == 1){
            cuenta = (CuentaCorriente) banco.get_cliente_actual().get_cuentas().get(num_cuenta);
        }
        else if (tipo_cuenta == 2){
            cuenta = (CuentaAhorro) banco.get_cliente_actual().get_cuentas().get(num_cuenta);
        }
        
        
        
        while(true){
        System.out.println("======================================");
        System.out.println("has accedido a la cuenta: " + num_cuenta);
        System.out.println("======================================");

        System.out.println();
        System.out.println("1_ consultar saldo");
        System.out.println("2_ depositar saldo");
        System.out.println("3_ retirar saldo");
        if (tipo_cuenta == 2){
            System.out.println("4_ agregar intereses");
        }
        
        System.out.println("5_ salir");

        Integer opcion = input.nextInt();
        input.nextLine();

        switch (opcion) {
            case 1:
                cuenta.consultar_saldo();
                
                break;

            case 2:
                System.out.println("-------------------------");
                System.out.println("  depositar saldo  ");
                System.out.println("-------------------------");
            
                

                System.out.println();

                System.out.println("ingrese una cantidad: ");
                
                Double cantidad = input.nextDouble();
                input.nextLine();

                cuenta.depositar_saldo(cantidad);
                break;

            case 3:
                System.out.println("-------------------------");
                System.out.println(" retirar saldo  ");
                System.out.println("-------------------------");


                if (tipo_cuenta == 1){
                    System.out.println("tu cuenta es una cuenta Corriente estas cuentas tienen un limite de que tanto dinero podes retirar,");
                    System.out.println("si la cantidad excede su saldo el banco le ofrece 10.000$ para que pueda completar su retiro");
                    System.out.println("pero si excede esa cantidad no podra retirar su saldo");
                }

                System.out.println();

                System.out.println("ingrese una cantidad: ");

                cantidad = input.nextDouble();
                input.nextLine();

                cuenta.retirar_saldo(cantidad);
                break;

            case 4:
                if(tipo_cuenta == 2){

                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println(" agregar intereses, por abonar cada mes te agregaremos un 10% de interes a tu saldo");
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.println();

                    System.out.println("ingrese una cantidad: ");
                    cantidad = input.nextDouble();
                    input.nextLine();

                    System.out.println("ingrese por cuantos meses va a dejar en el banco esa cantidad: ");
                
                    Integer meses = input.nextInt();
                    input.nextLine();

                    cuenta.agregar_intereses(cantidad, meses);
                }
                break;

            case 5:
                return;
            default:
                break;
        }

    }
   
}
}
