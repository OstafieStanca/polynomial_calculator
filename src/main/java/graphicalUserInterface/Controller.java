package graphicalUserInterface;

import businessLogic.Operations;
import dataModels.Polynomial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private final View view;

    public Controller(View view) {
        this.view = view;
        view.addTwoPolynomials(new AdditionListener());
        view.decreaseTwoPolynomials(new DecreaseListener());
        view.multiplyTwoPolynomials(new MultiplyListener());
        view.divideTwoPolynomials(new DivideListener());
        view.integralPolynomial(new IntegralListener());
        view.derivativePolynomial(new DerivativeListener());
        view.clearPolynomial(new ClearListener());
    }

    private class AdditionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.setVisibleRest(false);
            if (view.getDataInFirstPolynomial().length() != 0 && view.getDataInSecondPolynomial().length() != 0) {
                Polynomial polynom1 = Polynomial.parsePolynomial(view.getDataInFirstPolynomial());
                Polynomial polynom2 = Polynomial.parsePolynomial(view.getDataInSecondPolynomial());
                Polynomial sum = Operations.add(polynom1, polynom2);
                view.setDataOut(sum.toString());
            } else JOptionPane.showMessageDialog(view, "Introduceti date in ambele campuri!!");
        }
    }

    private class DecreaseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.setVisibleRest(false);
            if (view.getDataInFirstPolynomial().length() != 0 && view.getDataInSecondPolynomial().length() != 0) {
                Polynomial polynom1 = Polynomial.parsePolynomial(view.getDataInFirstPolynomial());
                Polynomial polynom2 = Polynomial.parsePolynomial(view.getDataInSecondPolynomial());
                Polynomial dec = Operations.decrease(polynom1, polynom2);
                view.setDataOut(dec.toString());
            } else JOptionPane.showMessageDialog(view, "Introduceti date in ambele campuri!!");

        }
    }

    private class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.setVisibleRest(false);
            if (view.getDataInFirstPolynomial().length() != 0 && view.getDataInSecondPolynomial().length() != 0) {
                Polynomial polynom1 = Polynomial.parsePolynomial(view.getDataInFirstPolynomial());
                Polynomial polynom2 = Polynomial.parsePolynomial(view.getDataInSecondPolynomial());
                Polynomial multiply = Operations.multiply(polynom1, polynom2);
                view.setDataOut(multiply.toString());
            } else JOptionPane.showMessageDialog(view, "Introduceti date valide in ambele campuri!!");
        }
    }

    private class DivideListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (view.getDataInFirstPolynomial().length() != 0 && view.getDataInSecondPolynomial().length() != 0) {
                Polynomial polynom1 = Polynomial.parsePolynomial(view.getDataInFirstPolynomial());
                Polynomial polynom2 = Polynomial.parsePolynomial(view.getDataInSecondPolynomial());
                Polynomial q = new Polynomial();
                Polynomial divide = Operations.divide(polynom1, polynom2, q);
                view.setDataOut(q.toString());
                view.setVisibleRest(true);
                view.setDataOutRest(divide.toString());
            } else JOptionPane.showMessageDialog(view, "Introduceti date in ambele campuri!!");
        }
    }

    private class IntegralListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.setVisibleRest(false);
            Polynomial integral = new Polynomial();
            if (view.getTheFirstRadioButtonValue()) {
                if (view.getDataInFirstPolynomial().length() != 0) {
                    Polynomial polynom1 = Polynomial.parsePolynomial(view.getDataInFirstPolynomial());
                    integral = Operations.integral(polynom1);
                } else JOptionPane.showMessageDialog(view, "Introduceti date in campul selectat!!");
            } else if (view.getTheSecondRadioButtonValue()) {
                if (view.getDataInSecondPolynomial().length() != 0) {
                    Polynomial polynom2 = Polynomial.parsePolynomial(view.getDataInSecondPolynomial());
                    integral = Operations.integral(polynom2);
                } else JOptionPane.showMessageDialog(view, "Introduceti date in campul selectat!!");
            } else {
                JOptionPane.showMessageDialog(view, "Selectati un polinom!!");
            }
            view.setDataOut(integral.toString());
        }
    }

    private class DerivativeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.setVisibleRest(false);
            Polynomial derivative = new Polynomial();
            if (view.getTheFirstRadioButtonValue()) {
                if (view.getDataInFirstPolynomial().length() != 0) {
                    Polynomial polynom1 = Polynomial.parsePolynomial(view.getDataInFirstPolynomial());
                    derivative = Operations.derivative(polynom1);
                } else JOptionPane.showMessageDialog(view, "Introduceti date in campul selectat!!");
            } else if (view.getTheSecondRadioButtonValue()) {
                if (view.getDataInSecondPolynomial().length() != 0) {
                    Polynomial polynom2 = Polynomial.parsePolynomial(view.getDataInSecondPolynomial());
                    derivative = Operations.derivative(polynom2);
                } else JOptionPane.showMessageDialog(view, "Introduceti date in campul selectat!!");
            } else {
                JOptionPane.showMessageDialog(view, "Selectati un polinom!!");
            }
            view.setDataOut(derivative.toString());
        }
    }

    private class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.setDataInFirstPolynom("");
            view.setDataInSecondPolynom("");
        }
    }
}

