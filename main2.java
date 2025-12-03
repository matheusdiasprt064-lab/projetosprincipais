
import java.util.Random;
import java.util.Scanner;

public class main2 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Jogo de adivinhação");

            boolean jogarNovamente = true;

            while (jogarNovamente) {
                System.out.println("Escolha a dificuldade: ");
                System.out.println("1 - Fácil (1 ao 50)");
                System.out.println("2 - Médio (1 a 100)");
                System.out.println("3 - Díficil (1 a 200)");
                System.out.print("Opção: ");

                int opcaoDificuldade = scanner.nextInt();
                int max = switch (opcaoDificuldade) {
                    case 1 ->
                        50;
                    case 2 ->
                        100;
                    case 3 ->
                        200;
                    default -> {
                        System.out.println("Opção inválida! Usando dificuldade MÉDIA");
                        yield 100;
                    }
                };
                Random random = new Random();
                int numeroSecreto = random.nextInt(max) + 1;

                int tentativasMax = 10;
                int tentativas = 0;
                boolean acertou = false;

                System.out.println("Estou pensando em um número entre 1 e " + max + ".");
                System.out.println("Você tem " + tentativasMax + " tentativas.");

                while (tentativas < tentativasMax) {
                    System.out.print("Digite seu palpite: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Opção inválida! Digite apenas números.");
                        scanner.next();
                        continue;
                    }
                    int palpite = scanner.nextInt();
                    tentativas++;
                    if (palpite == numeroSecreto) {
                        System.out.println("Acertou!");
                        System.out.println("O número era: " + numeroSecreto);
                        System.out.println("Tentativas usadas: " + tentativas);
                        acertou = true;
                        break;
                    } else if (palpite < numeroSecreto) {
                        System.out.println("O número é MAIOR");
                    } else {
                        System.out.println("O número é MENOR");
                    }
                    System.out.println("Tentativas restantes: " + (tentativasMax - tentativas));
                }
                if (!acertou) {
                    System.out.println("Você perdeu!");
                    System.out.println("O número secreto era: " + numeroSecreto);
                }

                System.out.print("Jogar novamente? ");
                char resposta = scanner.next().toLowerCase().charAt(0);
                jogarNovamente = (resposta == 's');
            }

            System.out.println("Obrigado por jogar! Até a próxima!");
        }
    }
}
