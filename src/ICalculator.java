
public interface ICalculator {

    /**
     * деление
     *
     * @param division1
     * @param division2
     * @return
     */
    double division(double division1, double division2);

    /**
     * умножение
     *
     * @param multiplication1
     * @param multiplication2
     * @return
     */
    double multiplication(double multiplication1, double multiplication2);

    /**
     * вычитание
     *
     * @param minus1
     * @param minus2
     * @return
     */
    double minus(double minus1, double minus2);

    /**
     * сложение
     *
     * @param plus1
     * @param plus2
     * @return
     */
    double sum(double plus1, double plus2);

    /**
     * степень
     *
     * @param pow1
     * @param pow2
     * @return
     */
    double pow(double pow1, int pow2);

    /**
     * корень
     *
     * @param sqrt1
     * @return
     */
    double sqrt(double sqrt1);

    /**
     * модуль
     *
     * @param module1
     * @return
     */
    double module(double module1);
}