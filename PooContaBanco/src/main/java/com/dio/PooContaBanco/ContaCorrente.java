package com.dio.PooContaBanco;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void envioExtrato() {
        System.out.println("Extrato Conta Corrente: ");
        super.envioExtrato();
    }
}
