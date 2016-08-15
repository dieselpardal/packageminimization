import algorithm.PackageMinimizationSolver;
import io.FileLoader;
import io.IOParser;
import models.Request;
import models.Response;

class PackageMinimizationApp {

    private static final String DISTRIBUTION_TXT_FILE = "src/main/resources/case1.txt";

    public static void main(String arg[]) {
        try {
            FileLoader fileLoader = new FileLoader();
            Request request = fileLoader.load(DISTRIBUTION_TXT_FILE);
            PackageMinimizationSolver solver = new PackageMinimizationSolver();
            Response response = solver.fulfillOrder(request);
            IOParser ioParser = new IOParser();
            ioParser.print(response);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}