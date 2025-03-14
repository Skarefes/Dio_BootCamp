package com.dio.PooContaBanco;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(){
        this.contas = new ArrayList<>();
    }

    public void addConta(Conta conta){
        contas.add(conta);
    }

    public void listarClientes(){
       if (contas == null){
           System.out.println("Nenhuma conta criada");
       }
       System.out.println("Total de contas: " + contas.size());
    }
}
