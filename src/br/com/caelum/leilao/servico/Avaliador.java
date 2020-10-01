package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {

    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;
    private double valorMedio = 0;    
    
    public void avalia(Leilao leilao) {
    	double soma = 0;
        for (Lance lance : leilao.getLances()) {
            if (lance.getValor() > maiorDeTodos) {
                maiorDeTodos = lance.getValor();
            } 
            
            if (lance.getValor() < menorDeTodos) {
                menorDeTodos = lance.getValor();
            }
            
            soma += lance.getValor();
        }
        
        if (soma == 0) {
        	return;
        }
        
        valorMedio = soma / leilao.getLances().size();
    }

    public double getMaiorLance() {
        return maiorDeTodos;
    }

    public double getMenorLance() {
        return menorDeTodos;
    }
    
    public double getValorMedio() {
		return valorMedio;
	}
}
