package br.com.alura.service;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;



public class BonusServiceTest {
    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto(){

        Funcionario funcionario = new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("25000"));
        BonusService service = new BonusService();
        assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(funcionario));
        //ou uso do Try Catch
        /*try{
            service.calcularBonus(funcionario);
            fail();
        } catch (Exception ex){
            assertEquals("Indeferido pelo fato do valor do bônus ser acima de 10% do salário", ex.getMessage());
        }*/
    }

    @Test
    void bonusDeveRetornarDezPorcentoDoSalarioDoFuncionario(){

        Funcionario funcionario = new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("2500"));
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(funcionario);

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void dezMilReaisDeveSerExatamenteMilReaisDeBonus(){

        Funcionario funcionario = new Funcionario("Guilherme", LocalDate.now(), new BigDecimal("10000"));
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(funcionario);

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
