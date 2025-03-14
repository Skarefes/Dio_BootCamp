package com.dio.PooContaBanco;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Conta implements IConta{
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIA = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIA++;
        this.cliente = cliente;
    }

    @Override
    public void deposito(double valor) {
        this.saldo = saldo + valor;
    }

    @Override
    public void saque(double valor) {
        this.saldo = saldo - valor;
    }

    @Override
    public void transferencia(double valor, Conta contaDestino) {
        this.saque(valor);
        contaDestino.deposito(valor);
    }

    protected void envioExtrato(){
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println("Agencia: " + agencia);
        System.out.println("Numero: " + numero);
        System.out.println("Extrato: " + saldo);
    }
}
