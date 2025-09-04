import java.util.InputMismatchException;
import java.util.Scanner;

 class Calculadora {

    public static void main(String[] args) {

        // Cria um objeto Scanner para ler a entrada do usuário a partir do console
        Scanner scanner = new Scanner(System.in);

        // Declaração das variáveis para os números, operação e resultado
        double num1, num2, resultado;
        char operacao;

        System.out.println("--- Calculadora Simples em Java ---");

        try {
            // Solicita e lê o primeiro número
            System.out.print("Digite o primeiro número: ");
            num1 = scanner.nextDouble();

            // Solicita e lê a operação
            System.out.print("Digite a operação (+, -, *, /): ");
            operacao = scanner.next().charAt(0);

            // Solicita e lê o segundo número
            System.out.print("Digite o segundo número: ");
            num2 = scanner.nextDouble();

            // A estrutura switch escolhe qual cálculo fazer com base na operação digitada
            switch (operacao) {
                case '+':
                    resultado = num1 + num2;
                    break;

                case '-':
                    resultado = num1 - num2;
                    break;

                case '*':
                    resultado = num1 * num2;
                    break;

                case '/':
                    // Verifica se o segundo número é zero para evitar erro de divisão por zero
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        System.out.println("Erro: Divisão por zero não é permitida.");
                        // Encerra o programa se houver divisão por zero
                        return;
                    }
                    break;

                // Caso o usuário digite uma operação inválida
                default:
                    System.out.println("Erro: Operação inválida. Use +, -, * ou /.");
                    // Encerra o programa
                    return;
            }

            // Exibe o resultado final formatado com duas casas decimais
            System.out.printf("\nResultado: %.2f %c %.2f = %.2f\n", num1, operacao, num2, resultado);

        } catch (InputMismatchException e) {
            // Captura o erro se o usuário digitar algo que não seja um número
            System.out.println("Erro: Entrada inválida. Por favor, digite apenas números.");
        } finally {
            // Fecha o objeto scanner para liberar os recursos do sistema
            scanner.close();
        }
    }
}