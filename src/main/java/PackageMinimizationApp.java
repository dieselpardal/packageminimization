
class PackageMinimizationApp {

    public static void main(String arg[]) {
        try {
            Distribution distribution = new Distribution();
            Loader loader = new Loader();
            loader.load(distribution);
            distribution.getInput();
            distribution.fulfilled();
            distribution.getOutput();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}