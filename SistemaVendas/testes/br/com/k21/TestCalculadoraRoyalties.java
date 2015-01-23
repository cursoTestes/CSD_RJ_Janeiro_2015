package br.com.k21;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class TestCalculadoraRoyalties {
	
	private VendaRepository repository ;
	private CalculadoraComissao calcComissao ;
	
	@Before
	public void inicializarMocks(){
		repository = Mockito.mock(VendaRepository.class);
		calcComissao = Mockito.mock(CalculadoraComissao.class);
	}
	
	@Test
	public void teste_Mes_Sem_Vendas() {
		
		int mes = 1;
		int ano = 2014;
		Double esperado = 0.0;
		
		CalculadoraRoyalties calcRoyalties = new CalculadoraRoyalties(repository, calcComissao);
		Double resultado = calcRoyalties.calcula(mes, ano);
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void teste_1_Venda_de_100_Reais_Retorna_19() {
		
		
		int mes = 1;
		int ano = 2014;
		Double esperado = 19D;
		List<Venda> listVendas = Arrays.asList(new Venda(1, 1, mes, ano, 100));
		Mockito.when(repository.obterVendasPorMesEAno(ano, mes)).thenReturn(listVendas);
		Mockito.when(calcComissao.calcular(100.0)).thenReturn(5.0);
		
		CalculadoraRoyalties calcRoyalties = new CalculadoraRoyalties(repository, calcComissao);
		Double resultado = calcRoyalties.calcula(mes, ano);
		
		assertEquals(esperado, resultado);
	}
	
	
}
