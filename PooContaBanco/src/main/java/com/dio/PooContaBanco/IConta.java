package com.dio.PooContaBanco;

public interface IConta {
     void deposito(double saldo);

     void saque(double saldo);

     void transferencia(double valor, Conta contaDestino);

}
