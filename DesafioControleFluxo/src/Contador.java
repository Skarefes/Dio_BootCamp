import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Contador {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);


        System.out.println("Digite o primeiro parametro:");
        int parametro1 = teclado.nextInt();
        System.out.println("Digite o segundo parametro:");
        int parametro2 = teclado.nextInt();

        try{
            contar(parametro1, parametro2);
       }catch (Exception e){
            System.out.println("O segundo parametro deve ser maior que o primeiro");
        }

    }

    static void contar(int parametro1, int parametro2) throws ParametrosInvalidosException{
        if (parametro1 > parametro2){
            throw new RuntimeException();
        }

        int contagem = parametro2 - parametro1;
        for (int i = 1; i <= contagem
                ; i ++){
            System.out.println("Imprimindo o numero: " + i);
        }


    }
}