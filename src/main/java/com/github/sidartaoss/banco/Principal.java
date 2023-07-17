package com.github.sidartaoss.banco;

import com.github.sidartaoss.banco.negocio.ContaCorrente;
import com.github.sidartaoss.banco.negocio.SaldoInsuficienteException;
import com.github.sidartaoss.banco.negocio.Titular;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class Principal {

    private static final Logger logger = LoggerFactory.getLogger(Principal.class);

    public static void main(String[] args) {
        var titular = new Titular("João", "945.987.880-62");
        var contaCorrente = new ContaCorrente(titular, 100, 9999);

        try {
            logger.debug("Manipulando conta corrente...");
            contaCorrente.depositar(BigDecimal.valueOf(200));
            contaCorrente.sacar(BigDecimal.valueOf(50.5));
//            contaCorrente.sacar(BigDecimal.valueOf(300));
            contaCorrente.sacar(BigDecimal.valueOf(-10));
        } catch (SaldoInsuficienteException e) {
            logger.warn("Pedido de saque com saldo insuficiente para conta " +
                    contaCorrente.getAgencia() + "/" + contaCorrente.getNumero(), e);
        } catch (Exception e) {
            logger.error("Erro administrando conta corrente " +
                    contaCorrente.getAgencia() + "/" + contaCorrente.getNumero(), e);
        }
    }
}

/**
 * SEVERE (highest value)
 * WARNING
 * INFO
 * CONFIG
 * FINE
 * FINER
 * FINEST (lowest value)
 */
