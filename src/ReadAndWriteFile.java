import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists())
                throw new FileNotFoundException();

            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bf.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            bf.close();
        }catch (Exception e) {
            System.err.println("File is not exist or invalid content!");
        }
        return numbers;
    }

    public void writeFile(String filePath, int max) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Max value: " + max);
            bufferedWriter.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int findMax(List<Integer> number) {
        int max = number.get(0);
        for (Integer integer : number) {
            if (max < integer)
                max = integer;
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("result.txt", maxValue);
    }
}
