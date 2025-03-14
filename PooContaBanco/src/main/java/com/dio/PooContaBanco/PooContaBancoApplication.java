package com.dio.PooContaBanco;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PooContaBancoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PooContaBancoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Banco bb = new Banco();
		Cliente roger = new Cliente();
		roger.setNome("Roger");
		Cliente merlin = new Cliente();
		merlin.setNome("Merlin");

		Conta cc = new ContaCorrente(roger);
		Conta cp = new ContaPoupanca(roger);
		Conta cc2 = new ContaCorrente(merlin);

		cc.deposito(200);
		cc.transferencia(100, cp);
		cc2.deposito(500);
		cc2.saque(200);

		bb.addConta(cc);
		bb.addConta(cp);
		bb.addConta(cc2);

		System.out.println("***BANCO BB***");
		bb.listarClientes();

		System.out.println("---------");
		cc.envioExtrato();
		System.out.println("---------");
		cp.envioExtrato();
		System.out.println("---------");
		cc2.envioExtrato();
	}
}
