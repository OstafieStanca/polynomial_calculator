package dataModels;

public class Monomial implements Comparable<Monomial> {
    private int grad;
    private double coeficient;

    public Monomial(int grad, double coeficient) {
        this.coeficient = coeficient;
        this.grad = grad;
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public double getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }

    @Override
    public String toString() {
        String semn;
        if (coeficient > 0) semn = "+";
        else semn = "";
        if (grad == 0) {
            return semn + coeficient;
        } else if (grad == 1) {
            if (coeficient == 1) {
                return "+X";
            } else if (coeficient == -1) return "-X";
            else return semn + coeficient + "X";
        } else {
            if (coeficient == 1) {
                return semn + "X^" + grad;
            } else if (coeficient == -1) {
                return "-X^" + grad;
            } else
                return semn + coeficient + "X^" + grad;
        }
    }

    @Override
    public int compareTo(Monomial o) {
        if (this.grad < o.getGrad())
            return 1;
        else if (this.grad > o.getGrad())
            return -1;
        return 0;
    }
}
