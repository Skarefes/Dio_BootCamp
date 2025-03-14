package com.dio.PooContaBanco;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void envioExtrato() {
        System.out.println("Extrato Conta Poupança: ");
        super.envioExtrato();
    }
}
