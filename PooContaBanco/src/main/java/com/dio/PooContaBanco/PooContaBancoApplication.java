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
		Cliente roger = new Cliente();
		roger.setNome("Roger");

		Conta cc = new ContaCorrente(roger);
		Conta cp = new ContaPoupanca(roger);

		cc.deposito(200);
		cc.transferencia(100, cp);

		cc.envioExtrato();
		System.out.println("---------");
		cp.envioExtrato();
	}
}
