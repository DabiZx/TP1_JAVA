package com.informatorio.servicios.archivos;

import com.informatorio.domain.Cliente;

import java.util.List;


public interface ArchivoServicio {
    
    void exportarCuentasACsv(List<Cliente> clientes, String nombre_archivo);
}
