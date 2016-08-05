import algorithm.PackageMinimizationSolver;
import io.FileLoader;
import io.IOParser;

class PackageMinimizationApp {

    public static void main(String arg[]) {
        try {
            PackageMinimizationSolver packageMinimizationSolver;
            IOParser ioParser = new IOParser();
            FileLoader fileLoader = new FileLoader();
            packageMinimizationSolver = fileLoader.load();
            ioParser.getInput(packageMinimizationSolver);
            packageMinimizationSolver.fulfilled();
            ioParser.getOutput(packageMinimizationSolver);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}