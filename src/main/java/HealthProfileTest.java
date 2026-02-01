import java.util.Scanner;
import java.util.Locale; // Import necessário para padronizar o ponto decimal

public class HealthProfileTest {
  public static void main(String[] args) {

    // Configura o scanner para aceitar ponto (.) como separador decimal (Padrão americano)
    // Isso evita erro se você digitar "1.75" e o computador estiver esperando "1,75"
    Scanner input = new Scanner(System.in).useLocale(Locale.US);

    System.out.println("--- CADASTRO DO PERFIL DE SAÚDE ---");

    // 1. SOLICITAR DADOS
    System.out.print("Digite o primeiro nome: ");
    String name = input.nextLine();

    System.out.print("Digite o sobrenome: ");
    String surname = input.nextLine();

    System.out.print("Digite o sexo (M/F): ");
    // Lê a linha inteira e pega apenas a primeira letra
    char sex = input.nextLine().charAt(0);

    System.out.print("Digite o ano de nascimento (AAAA): ");
    int year = input.nextInt();

    System.out.print("Digite o mês de nascimento (1-12): ");
    int month = input.nextInt();

    System.out.print("Digite o dia de nascimento (1-31): ");
    int day = input.nextInt();

    System.out.print("Digite a altura (em metros, ex: 1.75): ");
    double height = input.nextDouble();

    System.out.print("Digite o peso (em kg, ex: 68.5): ");
    double weight = input.nextDouble();

    // 2. INSTANCIAR OBJETO
    // Cria o objeto HealthProfile passando os dados para o construtor
    HealthProfile profile = new HealthProfile(
        name, 
        surname, 
        sex,
        day, 
        month, 
        year, 
        height, 
        weight
        );

    // 3. IMPRIMIR RELATÓRIO
    System.out.println("\n--- RELATÓRIO DO PERFIL DE SAÚDE ---");

    // Imprime dados básicos
    System.out.printf("Nome completo: %s %s%n", profile.getName(), 
                      profile.getSurname());
    System.out.printf("Sexo: %s%n", profile.getSex());
    System.out.printf("Data de Nascimento: %02d/%02d/%d%n", 
                      profile.getDayOfBirth(), profile.getMonthOfBirth(), 
                      profile.getYearOfBirth()
                      );
    System.out.printf("Altura: %.2f m%n", profile.getHeight());
    System.out.printf("Peso: %.1f kg%n", profile.getWeight());

    // Imprime dados calculados
    System.out.println("\n--- CÁLCULOS DE SAÚDE ---");
    System.out.printf("Idade: %d anos%n", profile.calculateAge());
    System.out.printf("IMC (Índice de Massa Corporal): %.1f%n", 
                      profile.calculateIMC()
                      );
    System.out.printf("Frequência Cardíaca Máxima: %d bpm%n", 
                      profile.getMaximumHeartRate()
                      );
    System.out.printf("Frequência Cardíaca Alvo: %s%n", 
                      profile.getTargetHeartRate()
                      );

    // Exibe a tabela de valores do IMC (Método estático)
    HealthProfile.displayValuesIMC();

    input.close(); // Fecha o scanner
  } 
}