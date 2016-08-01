
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Loader {
    private static final String DISTRIBUTION_TXT_FILE = "src/main/case1.txt";
    private static final String SPACE = " ";
    private static final int SIZE_CENTERS = 3;
    private static final int SIZE_PRODUCTS = 2;

    public void load(Distribution distribution) throws Exception {
        BufferedReader read;
        String text;
        File file = new File(DISTRIBUTION_TXT_FILE);
        try {
            read = new BufferedReader(new FileReader(file));
            while ((text = read.readLine()) != null) {
                String sub[] = text.split(SPACE);
                if (sub.length == SIZE_CENTERS) {
                    distribution.setCenter(sub);
                }
                if (sub.length == SIZE_PRODUCTS) {
                    distribution.setProduct(sub);
                }
            }
        } catch (Exception e) {
            throw new Exception("Não foi possivel carregar o arquivo dos cases.");
        }

    }

}
