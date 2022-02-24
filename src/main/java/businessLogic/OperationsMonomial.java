package businessLogic;

import dataModels.Monomial;
import dataModels.Polynomial;

public class OperationsMonomial {
    public static Monomial add(Monomial monom1, Monomial monom2) {

        Monomial result = new Monomial(0, 0);
        result.setGrad(monom1.getGrad());
        result.setCoeficient(monom1.getCoeficient() + monom2.getCoeficient());

        return result;
    }

    public static Monomial multiply(Monomial monom1, Monomial monom2) {
        return new Monomial(monom1.getGrad() + monom2.getGrad(), monom1.getCoeficient() * monom2.getCoeficient());
    }

    public static Monomial derivare(Monomial monom) {

        return new Monomial(monom.getGrad() - 1, monom.getCoeficient() * monom.getGrad());

    }

    public static Monomial integrare(Monomial monom) {
        float value = 1 / (float) (monom.getGrad() + 1);
        return new Monomial(monom.getGrad() + 1, monom.getCoeficient() * value);
    }

    public static Monomial divide(Monomial monom1, Monomial monom2) {
        if (monom2.getCoeficient() != 0) {
            return new Monomial(monom1.getGrad() - monom2.getGrad(), monom1.getCoeficient() / monom2.getCoeficient());
        }
        return new Monomial(0, 0);
    }

    public static float getNewCoeficient(Polynomial polynom, int grad) {
        float result = 0;
        for (Monomial monom : polynom.getMonomialList()) {
            if (monom.getGrad() == grad) {
                result += monom.getCoeficient();
            }
        }
        return result;
    }

    public static int existGrad(Polynomial polynom, int grad) {
        int exista = 0;
        for (Monomial monom : polynom.getMonomialList()) {
            if (monom.getGrad() == grad) {
                exista = 1;
                break;
            }
        }
        return exista;
    }
}
