package br.com.k21;

public class CalculadoraComissao {

	public double calcular(double venda) {
		
		double comissao = venda *0.05;
		comissao = arredondaParaEmpresaNaoLevarPrejuizo(comissao);
		
		return comissao;
	}

	private double arredondaParaEmpresaNaoLevarPrejuizo(double comissao) {
		return Math.floor(comissao*100)/100;
	}
}
