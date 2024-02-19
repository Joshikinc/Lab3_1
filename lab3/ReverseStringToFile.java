import java.io.*;
import java.util.Stack;

public class ReverseStringToFile {
    public static void main(String[] args) {
        // Путь к файлу для чтения
        String inputFile = "input.txt";
        // Путь к файлу для записи
        String outputFile = "output.txt";

        // Создаем стек для хранения строк
        Stack<String> stack = new Stack<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            // Читаем строки из файла и помещаем их в стек
            while ((line = reader.readLine()) != null) {
                stack.push(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            // Извлекаем строки из стека и записываем их в обратном порядке в файл
            while (!stack.isEmpty()) {
                String line = stack.pop();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Строки успешно записаны в файл в обратном порядке.");
    }
}