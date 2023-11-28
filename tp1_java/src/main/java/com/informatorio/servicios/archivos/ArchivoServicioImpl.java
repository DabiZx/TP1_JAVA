package com.informatorio.servicios.archivos;

import com.informatorio.domain.*;
import com.informatorio.domain.Cliente;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArchivoServicioImpl implements ArchivoServicio{
    
    private Banco banco = new Banco();

    private final String UBICACION_ARCHIVO ="/TPI1_JAVA/tp1_java/src/main/java/com/informatorio/recursos/";

    public ArchivoServicioImpl(){};
    

    @Override
    public void exportarCuentasACsv(List<Cliente> clientes, String nombre_archivo) {

        String ruta = System.getProperty("user.dir").concat(UBICACION_ARCHIVO).concat(nombre_archivo);
         
        try(CSVWriter writer = new CSVWriter(new FileWriter(ruta))){
            String[] encabezados = {"Numero Titular", "Nombre Titular", "Saldo", "Tipo"};

            writer.writeNext(encabezados);

            for (Cliente cliente : clientes) {
                for (Cuenta cuenta : cliente.get_cuentas()) {

                    String[] datos = {
                        String.valueOf(clientes.indexOf(cliente)),
                        cuenta.get_titular().get_nombre(),
                        String.valueOf(cuenta.get_saldo()),
                        cuenta.get_tipo()

                    };

                    writer.writeNext(datos);
                    
                }

                
            }
            writer.close();
            System.out.println("exportacion a CSV exitosa");

        } catch(IOException e){
            System.out.println("algo salio mal motivo: " + e.getMessage());
        }
    }
}
