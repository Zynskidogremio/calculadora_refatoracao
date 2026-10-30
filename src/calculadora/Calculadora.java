package calculadora;

/**
 * <p><strong>Projeto Calculadora</strong></p>
 *
 * <p>Esta classe fornece as operações matemáticas básicas (soma, subtração,
 * multiplicação e divisão), além de um método principal que seleciona a
 * operação desejada com base em um operador informado pelo usuário.</p>
 *
 * <p>Ela é o motor de cálculos do módulo financeiro do aplicativo FinançApp,
 * sendo usada em funcionalidades como orçamento mensal, divisão de despesas
 * e projeção de economias.</p>
 *
 * <p>Este projeto é utilizado para demonstrar:</p>
 * <ul>
 *     <li>Testes unitários</li>
 *     <li>Tratamento de erros com exceções</li>
 *     <li>Aplicação de refatoração em código Java</li>
 *     <li>Documentação com JavaDoc</li>
 * </ul>
 *
 * <p>Após a refatoração, os métodos desta classe são <strong>métodos
 * puros</strong>: não guardam estado e não têm efeitos colaterais, o que
 * melhora a legibilidade e facilita os testes unitários.</p>
 *
 * @author João Vítor Vieira Skierzynski
 * @version 2.0
 */
public class Calculadora {

    /**
     * Cria uma nova calculadora. A classe não possui estado interno.
     */
    public Calculadora() {
        // Nenhuma inicialização necessária
    }

    /**
     * Soma dois números inteiros.
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @return o resultado da soma de {@code a} e {@code b}
     */
    public int somar(int a, int b) {
        return a + b;
    }

    /**
     * Subtrai dois números inteiros.
     *
     * @param a minuendo (valor do qual será subtraído)
     * @param b subtraendo (valor a ser subtraído)
     * @return o resultado de {@code a - b}
     */
    public int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dois números inteiros.
     *
     * @param a primeiro fator
     * @param b segundo fator
     * @return o resultado de {@code a * b}
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide dois números inteiros (divisão inteira).
     *
     * <p>A divisão por zero é bloqueada antes de ser executada, evitando que o
     * programa seja interrompido por um erro aritmético.</p>
     *
     * @param a dividendo
     * @param b divisor (não pode ser zero)
     * @return o resultado de {@code a / b}
     * @throws IllegalArgumentException se {@code b} for igual a zero
     */
    public int dividir(int a, int b) {
        // Validação feita antes do cálculo para impedir ArithmeticException
        if (b == 0) {
            throw new IllegalArgumentException("Divisão por zero não é permitida.");
        }
        return a / b;
    }

    /**
     * Executa a operação matemática solicitada com base no operador informado.
     *
     * <p>Operadores aceitos:</p>
     * <ul>
     *     <li>"+": Soma</li>
     *     <li>"-": Subtração</li>
     *     <li>"*": Multiplicação</li>
     *     <li>"/": Divisão</li>
     * </ul>
     *
     * <p>Qualquer operador inválido resulta em exceção com mensagem
     * informativa.</p>
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @param operador símbolo da operação desejada
     * @return o resultado da operação correspondente ao operador informado
     * @throws IllegalArgumentException se o operador for nulo ou não for um
     *         símbolo válido, ou se for solicitada uma divisão por zero
     */
    public int calcular(int a, int b, String operador) {
        // Evita NullPointerException no switch caso o operador seja nulo
        if (operador == null) {
            throw new IllegalArgumentException("Operador inválido: null");
        }

        // Cada operador delega para o método responsável pela operação
        return switch (operador) {
            case "+" -> somar(a, b);
            case "-" -> subtrair(a, b);
            case "*" -> multiplicar(a, b);
            case "/" -> dividir(a, b);
            default -> throw new IllegalArgumentException("Operador inválido: " + operador);
        };
    }
}
