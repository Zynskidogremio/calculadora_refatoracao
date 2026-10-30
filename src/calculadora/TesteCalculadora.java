package calculadora;

/**
 * Classe de testes unitários da {@link Calculadora}.
 *
 * <p>Cada teste exibe no console a entrada utilizada, o resultado esperado e o
 * resultado obtido, indicando se o teste passou ou falhou. Ao final, é exibido
 * o total de testes aprovados. Se algum teste falhar, o programa termina com
 * código de saída 1.</p>
 *
 * <p>Cenários cobertos: soma, subtração, multiplicação, divisão, divisão por
 * zero e operação inválida.</p>
 *
 * @author João Vítor Vieira Skierzynski
 * @version 2.0
 */
public class TesteCalculadora {

    /** Quantidade total de testes executados. */
    private static int total = 0;

    /** Quantidade de testes que passaram. */
    private static int aprovados = 0;

    /**
     * Cria a classe de testes. Os testes são executados pelo método
     * {@link #main(String[])}.
     */
    public TesteCalculadora() {
        // Nenhuma inicialização necessária
    }

    /**
     * Executa todos os testes da calculadora e exibe o resumo.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        testarOperacao(calc, "Soma", 2, 3, "+", 5);
        testarOperacao(calc, "Subtração", 10, 4, "-", 6);
        testarOperacao(calc, "Multiplicação", 3, 5, "*", 15);
        testarOperacao(calc, "Divisão", 8, 2, "/", 4);

        testarExcecao(calc, "Divisão por zero", 8, 0, "/", "Divisão por zero não é permitida.");
        testarExcecao(calc, "Operação inválida", 5, 5, "x", "Operador inválido: x");

        System.out.println("==================================");
        System.out.println("Testes aprovados: " + aprovados + "/" + total);

        // Código de saída diferente de zero sinaliza falha (útil para automação)
        if (aprovados != total) {
            System.exit(1);
        }
    }

    /**
     * Testa uma operação que deve retornar um resultado válido.
     *
     * @param calc instância da calculadora sob teste
     * @param nome nome do cenário de teste
     * @param a primeiro operando
     * @param b segundo operando
     * @param operador símbolo da operação
     * @param esperado resultado esperado
     */
    private static void testarOperacao(Calculadora calc, String nome,
                                       int a, int b, String operador, int esperado) {
        int obtido = calc.calcular(a, b, operador);
        registrar(nome, a + " " + operador + " " + b, String.valueOf(esperado),
                String.valueOf(obtido), esperado == obtido);
    }

    /**
     * Testa uma operação que deve lançar {@link IllegalArgumentException}.
     *
     * @param calc instância da calculadora sob teste
     * @param nome nome do cenário de teste
     * @param a primeiro operando
     * @param b segundo operando
     * @param operador símbolo da operação
     * @param mensagemEsperada mensagem esperada na exceção
     */
    private static void testarExcecao(Calculadora calc, String nome,
                                      int a, int b, String operador, String mensagemEsperada) {
        String obtido;
        try {
            obtido = "nenhuma exceção (resultado " + calc.calcular(a, b, operador) + ")";
        } catch (IllegalArgumentException e) {
            obtido = e.getMessage();
        }
        registrar(nome, a + " " + operador + " " + b, mensagemEsperada,
                obtido, mensagemEsperada.equals(obtido));
    }

    /**
     * Registra e imprime o resultado de um teste, atualizando os contadores.
     *
     * @param nome nome do cenário de teste
     * @param entrada descrição da entrada utilizada
     * @param esperado resultado esperado
     * @param obtido resultado obtido
     * @param passou {@code true} se o teste passou
     */
    private static void registrar(String nome, String entrada,
                                  String esperado, String obtido, boolean passou) {
        total++;
        if (passou) {
            aprovados++;
        }
        System.out.println("[" + (passou ? "PASSOU" : "FALHOU") + "] " + nome);
        System.out.println("   Entrada  : " + entrada);
        System.out.println("   Esperado : " + esperado);
        System.out.println("   Obtido   : " + obtido);
    }
}
