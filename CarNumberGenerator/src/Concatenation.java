
public class Concatenation {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 200_000_000; i++) {
            str.append("some text some text some text");
            if(str.length() == 2147483640){
                str = new StringBuilder();
            }
        }

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }
}
