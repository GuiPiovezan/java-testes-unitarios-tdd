package br.com.alura.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    /*
    * BeforeEach =  chama o método anotado antes da execução de cada teste
    * AfterEach =   chama o método anotado depois da execução de cada teste
    * BeforeAll =   chama o método anotodo uma única vez antes da execução dos testes
    * AfterAll =    chama o método anotado uma única vez depois da execução dos testes
    * */

    @BeforeEach
    private void inicializar() {
        service = new ReajusteService();
        funcionario = new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @Test
    public void reajustarSalarioEmTresPorcentoParaDesempenhoADesejar(){
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajustarSalarioEmQuinzePorcentoParaDesempenhoBom(){
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajustarSalarioEmVintePorcentoParaDesempenhoOtimo(){
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}
