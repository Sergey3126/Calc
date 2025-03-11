public class CalculatorWithMathCopy  {



    /**
     * корень
     *
     * @param sqrt1
     * @return
     */
    public double sqrt(double sqrt1) {
        if (sqrt1 < 0) {
            System.out.println("Корень только из положительного числа");
            System.exit(0);
        }
        double result = Math.sqrt(sqrt1);
        return result;
    }

    /**
     * модуль
     *
     * @param module1
     * @return
     */
    public double module(double module1) {
        double module = Math.abs(module1);
        return module;
    }
}
