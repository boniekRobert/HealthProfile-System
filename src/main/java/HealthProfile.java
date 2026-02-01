// É necessário importar as classes do pacote java.time para trabalhar com a data atual.
import java.time.LocalDate;
import java.time.Year;

public class HealthProfile {

  // Atributos
  private String name;
  private String surname;
  private char sex;
  private int dayOfBirth;
  private int monthOfBirth;
  private int yearOfBirth;
  private double height; // Em metros
  private double weight; // Em quilogramas

  // Construtor
  // Recebe todos os dados e os atribui usando os métodos set para garantir a validação
  public HealthProfile(
      String name, 
      String surname, 
      char sex,
      int day, 
      int month, 
      int year,
      double height, 
      double weight
      ) {
          this.name = name;
          this.surname = surname;
          this.sex = sex;

          // Chama os setters para validar os dados no momento da criação do objeto
          setYearOfBirth(year);
          setMonthOfBirth(month);
          setDayOfBirth(day); // O dia é validado por último, pois depende do mês e ano
          setHeight(height);
          setWeight(weight);
      }

  // Setters (lógica e validação)
  public void setName(String name) {
    this.name = name;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void setSex(char sex) {
    this.sex = sex;
  }

  public void setYearOfBirth(int year) {
    int currentYear = Year.now().getValue();
    // Validação: O ano deve ser positivo e não pode ser futuro
    if (year > 0 && year <= currentYear) {
      this.yearOfBirth = year;
    } else {
      System.out.println("Invalid year of birth: " + year);
    }
  }

  public void setMonthOfBirth(int month) {
    // Validação: O mês deve estar entre 1 e 12
    if (month >= 1 && month <= 12) {
      this.monthOfBirth = month;
    } else {
      System.out.println("Invalid month of birth: " + month);
    }
  }

  public void setDayOfBirth(int day) {
    // A validação do dia depende do mês e do ano (para anos bissextos)
    int lastOfDayTheMonth;

    if (this.monthOfBirth == 2) { // Fevereiro
      // Lógica do ano bissexto: divisível por 4, exceto se for por 100 (a não ser que seja por 400)
      boolean leapYear = (this.yearOfBirth % 4 == 0 && 
                          this.yearOfBirth % 100 != 0) || 
                          (this.yearOfBirth % 400 == 0);
      if (leapYear) {
        lastOfDayTheMonth = 29;
      } else {
        lastOfDayTheMonth = 28;
      }
    } else if (this.monthOfBirth == 4 || this.monthOfBirth == 6 || 
               this.monthOfBirth == 9 || this.monthOfBirth == 11) {
      // Meses com 30 dias
      lastOfDayTheMonth = 30;
    } else {
      // Meses com 31 dias
      lastOfDayTheMonth = 31;
    }

    if (day >= 1 && day <= lastOfDayTheMonth) {
      this.dayOfBirth = day;
    } else {
      System.out.println("Invalid day of birth: " + day);
    }
  }

  public void setHeight(double height) {
    if (height > 0) { // Altura deve ser positiva
      this.height = height;
    }
  }

  public void setWeight(double weight) {
    if (weight > 0) { // Peso deve ser positivo
      this.weight = weight;
    }
  }

  // Métodos getters
  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public char getSex() {
    return sex;
  }

  public int getDayOfBirth() {
    return dayOfBirth;
  }

  public int getMonthOfBirth() {
    return monthOfBirth;
  }

  public int getYearOfBirth() {
    return yearOfBirth;
  }

  public double getHeight() {
    return height;
  }

  public double getWeight() {
    return weight;
  }

  // Métodos de cálculos exigidos pelo enunciado

  /*
  Calcula a idade da pessoa em anos completos
  @return
  */
  public int calculateAge() {
    LocalDate currentDate = LocalDate.now();
    int age = currentDate.getYear() - this.yearOfBirth;

    // Verifica se o aniversário deste ano já passou
    if (currentDate.getMonthValue() < this.monthOfBirth ||
       (currentDate.getMonthValue() == this.monthOfBirth && 
        currentDate.getDayOfMonth() < this.dayOfBirth)) {
      age--;  // Ainda não fez aniversário este ano
    }
    return age;
  }

  /*
  Calcula o IMC
  Índice de Massa Corporal (IMC).
  Fórmula: peso (kg) / [altura (m)]²
  */
  public double calculateIMC() {
    if (this.height == 0) return 0; // Evita divisão por zero
    return this.weight / (this.height * this.height);
  }

  /**
  Calcula a Frequência Cardíaca Máxima.
  Fórmula: 220 - idade
  */
  public int getMaximumHeartRate() {
    return 220 - calculateAge();
  }

  /**
  Calcula o intervalo da Frequência Cardíaca Alvo (50%-85% da máxima).
  @return Uma String formatada com o intervalo (ex: "95 - 162 bpm")
  */
  public String getTargetHeartRate() {
    int rateMax = getMaximumHeartRate();
    double targetMin = rateMax * 0.50;
    double targetMax = rateMax * 0.85;
    // "%.0f" formata o double sem casas decimais
    return String.format("%.0f - %.0f bpm", targetMin, targetMax);
  }

  /**
  Exibe os valores padrão de IMC (como pedido no Exercício 2.33).
  Este é um método estático porque os valores são universais, não dependem de um objeto.
  */
  public static void displayValuesIMC() {
    System.out.println("\n--- Valores de IMC (Categorias) ---");
    System.out.println("Abaixo do peso:  menos de 18.5");
    System.out.println("Normal:          entre 18.5 e 24.9");
    System.out.println("Sobrepeso:       entre 25 e 29.9");
    System.out.println("Obeso:           30 ou mais");
    System.out.println("-------------------------------------");
  }
}