package br.com.k21;

import org.junit.Test;

import br.com.k21.dao.VendaDAO;
import br.com.k21.infra.BaseDBTest;

public class VendaDAOTest extends BaseDBTest {

	@Test
	public void testTotal_Para_Vendedor_Inexistente() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 99;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2001;
		double resultado;
		double esperado = 0.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
	
	@Test
	public void testTotal_Para_Vendedor_existente() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 2;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2011;
		double resultado;
		double esperado = 100;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
	
	@Test
	public void testTotal_Para_Vendedor_sem_venda() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 3;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2011;
		double resultado;
		double esperado = 0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
	
	@Test
	public void testTotal_Para_Vendedor_com_varias_vendas_no_mesmo_ano() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 7;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2013;
		double resultado;
		double esperado = 700;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
	
	@Test
	public void testTotal_Para_Vendedor_com_vendas_em_2013_e_sem_vendas_em_2011() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 7;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2011;
		double resultado;
		double esperado = 0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
	
}
