import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Loader {

    public static void main(String[] args) throws Exception {
        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        List<Long> times = new ArrayList<>();
        long start = System.currentTimeMillis();
        for(int regionCode = 1; regionCode < 100; regionCode++) {
            int finalRegionCode = regionCode;
            new Thread(() -> {
                try (PrintWriter writer = new PrintWriter("res/numbers_" + finalRegionCode + ".txt")) {

                    StringBuilder builder = new StringBuilder();
                    for (int number = 1; number < 1000; number++) {
                        for (char firstLetter : letters) {
                            for (char secondLetter : letters) {
                                for (char thirdLetter : letters) {
                                    builder.append(firstLetter);
                                    builder.append(padNumber(number, 3));
                                    builder.append(secondLetter);
                                    builder.append(thirdLetter);
                                    builder.append(padNumber(finalRegionCode, 2));
                                    builder.append("\n");
                                }
                            }
                        }
                    }
                    writer.write(builder.toString());
                    writer.flush();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                long threadTimeMillis = System.currentTimeMillis();
                times.add(threadTimeMillis);
                System.out.println(times.get(times.size() - 1) - start + "ms");
            }).start();
        }
    }

    private static String padNumber(int number, int numberLength) {
        StringBuilder numberStr = new StringBuilder(Integer.toString(number));
        int padSize = numberLength - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            numberStr.insert(0, '0');
        }

        return numberStr.toString();
    }
}
