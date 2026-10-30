package calculadora;

public class TesteCalculadora {

    private static int total = 0;
    private static int aprovados = 0;

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

        if (aprovados != total) {
            System.exit(1);
        }
    }

    private static void testarOperacao(Calculadora calc, String nome,
                                       int a, int b, String operador, int esperado) {
        int obtido = calc.calcular(a, b, operador);
        registrar(nome, a + " " + operador + " " + b, String.valueOf(esperado),
                String.valueOf(obtido), esperado == obtido);
    }

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
