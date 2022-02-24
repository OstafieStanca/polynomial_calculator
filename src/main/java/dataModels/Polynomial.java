package dataModels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private final List<Monomial> monomialList;

    public Polynomial() {
        this.monomialList = new ArrayList<Monomial>();
    }

    public static Polynomial parsePolynomial(String dataIn) {
        Polynomial result = new Polynomial();
        String patternFormat = "([+-]?\\d\\d?\\d?X[^+-]?\\d\\d?\\d?)|([+-]?X[^+-]?\\d?\\d?\\d?)|([+-]?\\d\\d?\\d?X?[^+-]?\\d?\\d?\\d?)";
        Pattern pattern = Pattern.compile(patternFormat);
        Matcher matcher = pattern.matcher(dataIn);
        while (matcher.find()) {
            Monomial m = new Monomial(0, 0);
            String[] mCurr = matcher.group().split("X");
            if (mCurr.length == 2) {
                StringBuilder sb1 = new StringBuilder(mCurr[0]);
                StringBuilder sb2 = new StringBuilder(mCurr[1]);
                if (sb1.length() != 0 && (sb1.charAt(0) == '-' || sb1.charAt(0) == '+')) {
                    double semn = (sb1.charAt(0) == '-') ? -1.0 : 1.0;
                    sb1.deleteCharAt(0);
                    if (sb1.toString().length() == 0) {
                        m.setCoeficient(semn);
                    } else
                        m.setCoeficient(semn * Double.parseDouble(sb1.toString()));
                    sb2.deleteCharAt(0);
                    m.setGrad(Integer.parseInt(sb2.toString()));
                } else {
                    sb2.deleteCharAt(0);
                    if (sb1.toString().length() != 0)
                        m.setCoeficient(Double.parseDouble(sb1.toString()));
                    else m.setCoeficient(1.0);
                    m.setGrad(Integer.parseInt(sb2.toString()));
                }
            } else if (mCurr.length == 1) {
                StringBuilder sb1 = new StringBuilder(mCurr[0]);
                if (sb1.charAt(0) == '^') {
                    m.setCoeficient(1.0);
                    sb1.deleteCharAt(0);
                    m.setGrad(Integer.parseInt(sb1.toString()));
                } else if (mCurr[0].charAt(0) == '-' || mCurr[0].charAt(0) == '+') {
                    double semn = (mCurr[0].charAt(0) == '-') ? -1.0 : 1.0;
                    sb1.deleteCharAt(0);
                    if (sb1.toString().length() == 0) {
                        m.setCoeficient(semn);
                    } else {
                        m.setCoeficient(semn * Double.parseDouble(sb1.toString()));
                    }
                    m.setGrad(1);
                } else {
                    m.setCoeficient(Double.parseDouble(sb1.toString()));
                    m.setGrad(1);
                }
            } else if (matcher.group().equals("X")) {
                m.setCoeficient(1.0);
                m.setGrad(1);
            }
            result.addList(m);
        }
        result.sortPolynom();
        return result;
    }

    public List<Monomial> getMonomialList() {
        return monomialList;
    }

    public void addList(Monomial termen) {
        this.monomialList.add(termen);
    }

    @Override
    public String toString() {
        String result = "";
        for (Monomial m : monomialList) {
            result = result + m.toString();
        }
        return result;
    }

    public void sortPolynom() {
        Collections.sort(this.monomialList);
    }

    public Monomial getTheFirstMonom() {
        return this.monomialList.get(0);
    }

    public int isNotEmpty() {
        if (this.monomialList.isEmpty()) return 0;
        return 1;
    }

    public void clearPolynomial() {
        this.monomialList.clear();
    }

}
