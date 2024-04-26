package repository;

import entity.Conta;
import exception.ExcecaoElementoInexistente;
import java.util.ArrayList;
import java.util.Scanner;

public class RepositorioConta implements IRepositorioConta{
    public ArrayList<Conta> contas;
    public int qtd_contas;
    public Scanner sc = new Scanner(System.in);

    public RepositorioConta(){
        this.contas = new ArrayList<Conta>();
        this.qtd_contas = contas.size();
    }

    public void inserirConta(Conta c){
        this.contas.add(c);
    }

    public void alterarConta(String numero) {
        for (Conta c : contas) {
            if (c.getNumero().equals(numero)) {
                System.out.print("Novo saldo: ");
                double novoSaldo = Double.parseDouble(sc.nextLine());
                c.setSaldo(novoSaldo);
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public void removerConta(String numero){
        if (this.verificarExistenciaConta(numero)) {
            for (Conta c : contas){
                if (c.getNumero().equals(numero)){
                    this.contas.remove(c);
                    System.out.println("Conta removida com sucesso!");
                    return;
                }
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public Conta buscarConta(String numero) throws ExcecaoElementoInexistente{
        for (Conta c : contas){
            if (c.getNumero().equals(numero)){
                return c;
            }
        }
        throw new ExcecaoElementoInexistente("Conta Não Encontrada");
    }
    public boolean verificarExistenciaConta(String numero){
        for (Conta c : contas){
            if (c.getNumero().equals(numero)){
                return true;
            }
        }
        return false;
        
    }

    public void mostrarContas(){
        if(contas.isEmpty()) {
            System.out.println("A lista de contas está vazia.");
        } else {
            for (Conta c : contas){
                System.out.println(c);
            }
        }
    }
}