/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HC;

/**
 *
 * @author JOÃO VICTOR
 */
public class Classificacao {
    String nome;
    int vit;
    int derr;
    int emp;
    int saldo;
    int pontos;

    public Classificacao(String nome, int vit, int derr, int emp, int saldo, int pontos) {
        this.nome = nome;
        this.vit = vit;
        this.derr = derr;
        this.emp = emp;
        this.saldo = saldo;
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public int getVit() {
        return vit;
    }

    public int getDerr() {
        return derr;
    }

    public int getEmp() {
        return emp;
    }

    public int getSaldo() {
        return saldo;
    }

    public int getPontos() {
        return pontos;
    }
    
    
}
