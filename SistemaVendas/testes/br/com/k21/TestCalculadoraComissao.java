package br.com.k21;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculadoraComissao {
	
	@Test
	public void para_uma_venda_100_reais_paga_5() {
		double venda = 100;
		double comissaoEsperada = 5;
		double comissaoObtida = 0;
		
		CalculadoraComissao calculadoraComissao;
		calculadoraComissao = new CalculadoraComissao();
		
		comissaoObtida = calculadoraComissao.calcular(venda);
		
		assertEquals(comissaoEsperada, comissaoObtida, 0);
	}

	@Test
	public void para_uma_venda_55_reais_59_centavos_paga_2_reais_77_centavos() {
		double venda = 55.59;
		double comissaoEsperada = 2.77;
		double comissaoObtida = 0;
		
		CalculadoraComissao calculadoraComissao;
		calculadoraComissao = new CalculadoraComissao();
		
		comissaoObtida = calculadoraComissao.calcular(venda);
		
		assertEquals(comissaoEsperada, comissaoObtida, 0);
	}
	
	@Test
	public void para_uma_venda_1_real_paga_5_centavos() {
		int venda = 1;
		double comissaoEsperada = 0.05;
		double comissaoObtida = 0;
		
		CalculadoraComissao calculadoraComissao;
		calculadoraComissao = new CalculadoraComissao();
		
		comissaoObtida = calculadoraComissao.calcular(venda);
		
		assertEquals(comissaoEsperada, comissaoObtida, 0);
	}

	
	
}
