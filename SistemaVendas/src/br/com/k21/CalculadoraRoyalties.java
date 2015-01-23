package br.com.k21;

import java.util.List;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class CalculadoraRoyalties {
	
	private VendaRepository vendaRepository;
	private CalculadoraComissao calculadoraComissao;

	public CalculadoraRoyalties(VendaRepository vendaRepository, 
								CalculadoraComissao calculadoraComissao) {
		this.vendaRepository = vendaRepository;
		this.calculadoraComissao = calculadoraComissao;
		
	}

	public Double calcula(int mes, int ano) {
		
		List<Venda> vendasPorMesEAno = vendaRepository.obterVendasPorMesEAno(ano, mes);
		
		Double totalVendaLiquida = 0.0;
		
		for (Venda venda : vendasPorMesEAno) {
			Double comissao = calculadoraComissao.calcular(venda.getValor());
			totalVendaLiquida += venda.getValor() - comissao;
		}
		
		return (totalVendaLiquida * 0.2);
	}



}
