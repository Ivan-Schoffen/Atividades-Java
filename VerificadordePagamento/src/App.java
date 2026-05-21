import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Data prevista: ");
        String prevista = scanner.next();
        System.out.print("Data pagamento: ");
        String pgmnt = scanner.next();
        System.out.print("Valor: ");
        float valor = scanner.nextInt();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate vencimento = LocalDate.parse(prevista, formato);
        LocalDate pagamento = LocalDate.parse(pgmnt, formato);

        long diferenca = ChronoUnit.DAYS.between(vencimento, pagamento);
        
        if(diferenca == 0) {
            System.out.printf("\nPagamento realizado no prazo.\n");
            System.out.println("Valor final: R$ " + valor);
        } else {
            System.out.printf("\nPagamento em atraso.\n");
            System.out.println("Dias em atraso: " + diferenca);
            float juros = valor * 0.02f;
            System.out.println("Juros: R$ " + juros);
            System.out.println("Valor final: R$ " + (valor + juros));
        }


        scanner.close();
    }
}
