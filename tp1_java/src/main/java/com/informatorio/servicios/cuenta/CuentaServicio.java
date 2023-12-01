package com.informatorio.servicios.cuenta;



public interface CuentaServicio {
    
    void consultar_saldo();
    void depositar_saldo();
    void retirar_saldo();
    void agregar_intereses();
}
