import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class BankTransactionAnalyzerSimple {
	
	// The path in which the file should be placed
    private static final String RESOURCES = "src/resources/";

    public static void main(String[] args) throws IOException {

    	 Scanner scanner = new Scanner(System.in);
    	 
         System.out.print("Enter the file name: ");
         String fileName = scanner.nextLine();
         scanner.close();
         
         // final path for the file
         final Path path = Paths.get(RESOURCES+fileName);

         if (!Files.exists(path)) {
             System.out.println("File not found: " + fileName);
             return;
         }

         final List<String> lines = Files.readAllLines(path);
         double total = 0d;

        for (String line : lines) {

            String[] columns = line.split(",");
 
            final double amount = Double.parseDouble(columns[1]);
            total += amount; 
            
        }

        System.out.println("The total for all transactions is " + total);
    }
}
