import entity.Conta;
import facade.Fachada;
import facade.IFachada;
import java.util.Scanner;

public class Main {

    public static void main(String[] Args){
        IFachada Fachada = new Fachada();
        Conta c = new Conta("Rodolfo","46219",300);
        Conta c2 = new Conta("Janilson","01274",600);
        Fachada.inserirConta(c);
        Fachada.inserirConta(c2);
        Fachada.mostrarContas();

        Scanner scanner = new Scanner(System.in);

        int escolha = 1;
        while (escolha != 0){
            System.out.println("-------------- MENU ---------------");
            System.out.println("[1] - Inserir Conta");
            System.out.println("[2] - Remover Conta");
            System.out.println("[3] - Alterar Conta");
            System.out.println("[4] - Buscar Conta");
            System.out.println("[5] - Relatório de Contas");
            System.out.println("[0] - Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            switch (escolha){
                case 1:
                    try {
                        System.out.print("Número da Conta: ");
                        String numeroConta = scanner.next();

                        System.out.print("Titular da Conta: ");
                        String titular = scanner.next();
                        System.out.print("Insira o valor inicial: R$ ");
                        double saldo = scanner.nextDouble();

                        Fachada.inserirConta(new Conta(numeroConta, titular, saldo));

                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Número da Conta: ");
                        String numero = scanner.next();
                        Fachada.removerConta(numero);
                    } catch (Exception e) {
                        System.out.println("Ocorreu um erro ao tentar remover a conta.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o número da conta que deseja alterar: ");
                    String numC = scanner.next();
                    Fachada.alterarConta(numC);
                    break;

                case 4:
                    try {
                        System.out.print("Número da Conta: ");
                        String num = scanner.next();
                        System.out.println(Fachada.buscarConta(num));
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    Fachada.mostrarContas();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Escolha uma das opções presentes no menu!");
            }
            System.out.println();
        }
        scanner.close();
    }
}
