
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class calculadora2 {

    static Scanner input = new Scanner(System.in);
    static List<String> historico = new ArrayList<>();

    public static void main(String[] args) {

        int opcao;

        do {
            menu();
            opcao = input.nextInt();

            switch (opcao) {
                case 1 ->
                    operacaoBasica("+");
                case 2 ->
                    operacaoBasica("-");
                case 3 ->
                    operacaoBasica("*");
                case 4 ->
                    operacaoBasica("/");
                case 5 ->
                    potencia();
                case 6 ->
                    raiz();
                case 7 ->
                    porcentagem();
                case 8 ->
                    mostrarHistorico();
                case 0 ->
                    System.out.println("Saindo...");
                default ->
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        input.close();
    }

    public static void menu() {
        System.out.println("\n=== CALCULADORA AVANÇADA ===");
        System.out.println("[1] Somar");
        System.out.println("[2] Subtrair");
        System.out.println("[3] Multiplicar");
        System.out.println("[4] Dividir");
        System.out.println("[5] Potência");
        System.out.println("[6] Raiz Quadrada");
        System.out.println("[7] Porcentagem");
        System.out.println("[8] Ver Histórico");
        System.out.println("[0] Sair");
        System.out.print("Escolha: ");
    }

    public static void operacaoBasica(String operador) {
        System.out.print("Digite o primeiro número: ");
        double a = input.nextDouble();

        System.out.print("Digite o segundo número: ");
        double b = input.nextDouble();

        double resultado = 0;

        switch (operador) {
            case "+" ->
                resultado = a + b;
            case "-" ->
                resultado = a - b;
            case "*" ->
                resultado = a * b;
            case "/" -> {
                if (b == 0) {
                    System.out.println("Erro: divisão por zero!");
                    return;
                }
                resultado = a / b;
            }
        }

        System.out.println("Resultado: " + resultado);
        historico.add(a + " " + operador + " " + b + " = " + resultado);
    }

    public static void potencia() {
        System.out.print("Base: ");
        double base = input.nextDouble();
        System.out.print("Expoente: ");
        double expoente = input.nextDouble();

        double resultado = Math.pow(base, expoente);
        System.out.println("Resultado: " + resultado);

        historico.add(base + " ^ " + expoente + " = " + resultado);
    }

    public static void raiz() {
        System.out.print("Digite o número: ");
        double num = input.nextDouble();

        if (num < 0) {
            System.out.println("Erro: número negativo!");
            return;
        }

        double resultado = Math.sqrt(num);
        System.out.println("Resultado: " + resultado);

        historico.add("√" + num + " = " + resultado);
    }

    public static void porcentagem() {
        System.out.print("Valor total: ");
        double total = input.nextDouble();
        System.out.print("Percentual (%): ");
        double perc = input.nextDouble();

        double resultado = total * (perc / 100);
        System.out.println(perc + "% de " + total + " é: " + resultado);

        historico.add(perc + "% de " + total + " = " + resultado);
    }

    public static void mostrarHistorico() {
        System.out.println("\n=== HISTÓRICO ===");
        if (historico.isEmpty()) {
            System.out.println("Nenhuma operação realizada.");
            return;
        }
        for (String registro : historico) {
            System.out.println(registro);
        }
    }
}
