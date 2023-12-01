package com.informatorio.menu_principal;

import java.util.Scanner;

import com.informatorio.domain.*;

import com.informatorio.servicios.archivos.ArchivoServicioImpl;
import com.informatorio.servicios.cliente.ClienteServicioImpl;
import com.informatorio.servicios.cuenta.CuentaServicioImpl;


public class MenuPrincipal {

    private Scanner input = new Scanner(System.in);

    private Banco banco = new Banco();

    private ArchivoServicioImpl archivo_servicio = new ArchivoServicioImpl();

    private CuentaServicioImpl cuenta_sercvicio = new CuentaServicioImpl();

    private ClienteServicioImpl cliente_servicio  = new ClienteServicioImpl();


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

            if (banco.get_clientes().size() != 0){
                for (Cliente cliente : banco.get_clientes()) {
                    if (cliente.get_nombre().equals(nombre)){
                        System.out.println("--------------------------------------");
                        System.out.println("ese nombre ya esta en uso ingrese otro");
                        System.out.println("--------------------------------------");
                        return;
                    }
            }
            

                
                
            }

            System.out.println("Ingresa tu direccion");

            String direccion = input.nextLine();

            System.out.println("Ingresa tu contraseña");

            String contrasenia = input.nextLine();


    
            banco.registrarse(nombre, direccion, contrasenia);
                
            System.out.println("-------------------------------------");
            System.out.println("registro exitoso ahora inicia sesion");
            System.out.println("-------------------------------------");
            return;}
    
            
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
        if (banco.get_cliente_actual() == null){
            
            System.out.println("------------------------------------");
            System.out.println("no se pudo inicar sesion");
            System.out.println("------------------------------------");
            return;
    }

        cliente_servicio.setBanco(banco);
        cliente_servicio.setCliente_actual();

        System.out.println("-----------------------------------------");
        System.out.println("inicio sesion exitoso bienvenido " + banco.get_cliente_actual().get_nombre());
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
                    cliente_servicio.agregar_cuenta();

                    break;
                    
                case 2:
                    cliente_servicio.eliminar_cuenta();
                    break;
                    
                case 3:
                    cliente_servicio.consultar_saldo();  
                    break;

                case 4:
                    cliente_servicio.ver_cuentas();
                      
                    break;
                    
                case 5:
                    opciones_cuenta(cliente_servicio.acceder_cuenta());
                    break;
                        
                case 6:
                    banco.logout();
                    return;
                default:
                    break;
                }
            }
    } 



    public void opciones_cuenta(Integer num_cuenta){
        cuenta_sercvicio.setBanco(banco);
        
        cuenta_sercvicio.setCuenta_actual(num_cuenta);

        

        while(true){
        System.out.println("======================================");
        System.out.println("has accedido a la cuenta: " + num_cuenta);
        System.out.println("======================================");

        System.out.println();
        System.out.println("1_ consultar saldo");
        System.out.println("2_ depositar saldo");
        System.out.println("3_ retirar saldo");
        System.out.println("4_ salir");


        if (cuenta_sercvicio.getCuenta_actual().get_tipo() == "CuentaAhorro"){
            System.out.println("5_ agregar intereses");
        }
        


        Integer opcion = input.nextInt();
        input.nextLine();

        switch (opcion) {
            case 1:
                cuenta_sercvicio.consultar_saldo();
                break;
        
            case 2:
                cuenta_sercvicio.depositar_saldo();
                break;
            case 3:
                cuenta_sercvicio.retirar_saldo();
                break;
            
            case 4:
                return;
            case 5:
                cuenta_sercvicio.agregar_intereses();
                
            default:
                break;
        }
    }   
    }
}