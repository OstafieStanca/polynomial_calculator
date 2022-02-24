package businessLogic;

import dataModels.Monomial;
import dataModels.Polynomial;

public class Operations {

    public static Polynomial add(Polynomial polynom1, Polynomial polynom2) {
        Polynomial result = new Polynomial();
        for (Monomial monomPolynom1 : polynom1.getMonomialList()) {
            Monomial termen = new Monomial(monomPolynom1.getGrad(), monomPolynom1.getCoeficient());
            for (Monomial monomPolynom2 : polynom2.getMonomialList()) {
                if (monomPolynom1.getGrad() == monomPolynom2.getGrad())
                    termen = OperationsMonomial.add(monomPolynom1, monomPolynom2);
            }
            if (termen.getCoeficient() != 0)
                result.addList(termen);
        }
        for (Monomial monomPolynom2 : polynom2.getMonomialList()) {
            int gasit = 0;
            for (Monomial monomPolynom1 : polynom1.getMonomialList()) {
                if (monomPolynom2.getGrad() == monomPolynom1.getGrad()) {
                    gasit = 1;
                    break;
                }
            }
            if (gasit == 0) result.addList(monomPolynom2);
        }
        result.sortPolynom();
        return result;
    }

    public static Polynomial decrease(Polynomial polynom1, Polynomial polynom2) {
        Polynomial intermediar = new Polynomial();
        for (Monomial monomPolynom2 : polynom2.getMonomialList()) {
            intermediar.addList(new Monomial(monomPolynom2.getGrad(), monomPolynom2.getCoeficient() * (-1)));
        }
        return Operations.add(polynom1, intermediar);
    }

    public static Polynomial integral(Polynomial polynom) {

        Polynomial result = new Polynomial();
        for (Monomial monom : polynom.getMonomialList()) {
            result.addList(OperationsMonomial.integrare(monom));
        }
        return result;
    }

    public static Polynomial derivative(Polynomial polynom) {
        Polynomial result = new Polynomial();
        for (Monomial monom : polynom.getMonomialList()) {
            if (OperationsMonomial.derivare(monom).getGrad() >= 0)
                result.addList(OperationsMonomial.derivare(monom));
        }
        return result;
    }

    public static Polynomial multiply(Polynomial polynom1, Polynomial polynom2) {
        Polynomial mulPolynoms = new Polynomial();
        for (Monomial monom1 : polynom1.getMonomialList()) {
            for (Monomial monom2 : polynom2.getMonomialList()) {
                mulPolynoms.addList(OperationsMonomial.multiply(monom1, monom2));
            }
        }
        Polynomial result = new Polynomial();
        for (Monomial monom : mulPolynoms.getMonomialList()) {
            float coeficient = OperationsMonomial.getNewCoeficient(mulPolynoms, monom.getGrad());
            if (OperationsMonomial.existGrad(result, monom.getGrad()) == 0) {
                result.addList(new Monomial(monom.getGrad(), coeficient));
            }
        }
        result.sortPolynom();
        return result;
    }

    public static Polynomial divide(Polynomial polynom1, Polynomial polynom2, Polynomial q) {
        polynom1.sortPolynom();
        polynom2.sortPolynom();
        Polynomial r = new Polynomial();
        for (Monomial monom : polynom1.getMonomialList()) {
            r.addList(monom);
        }
        Polynomial t = new Polynomial();
        while (r.isNotEmpty() == 1 && r.getTheFirstMonom().getGrad() >= polynom2.getTheFirstMonom().getGrad()) {
            Monomial monom = OperationsMonomial.divide(r.getTheFirstMonom(), polynom2.getTheFirstMonom());
            t.addList(monom);
            q.addList(monom);
            r = Operations.decrease(r, Operations.multiply(t, polynom2));
            t.clearPolynomial();
        }
        return r;
    }
}