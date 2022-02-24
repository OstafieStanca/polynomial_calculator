package graphicalUserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private final JTextField dataInFirstPolynom = new JTextField();
    private final JTextField dataInSecondPolynom = new JTextField();
    private final JTextField dataOut = new JTextField();
    private final JTextField dataOutRest = new JTextField();
    private final JButton addButton = new JButton("Addition");
    private final JButton decButton = new JButton("Substruction");
    private final JButton multiplyButton = new JButton("Multiply");
    private final JButton divideButton = new JButton("Divide");
    private final JButton integralButton = new JButton("Integral");
    private final JButton derivativeButton = new JButton("Derivative");
    private final JButton clearButton = new JButton("Clear");
    private final JLabel labelResult = new JLabel("Result");
    private final JLabel labelEmpty = new JLabel("             ");
    private final JLabel labelEmpty2 = new JLabel("             ");
    private final JRadioButton radioButtonFirstPolynomial = new JRadioButton("First polynomial");
    private final JRadioButton radioButtonSecondPolynomial = new JRadioButton("Second polynomial");

    public View() {
        JPanel finalContent = new JPanel(new GridLayout(1, 1));
        JPanel content = new JPanel(new GridLayout(2, 1));
        content.setLayout(new GridLayout(2, 0));
        JPanel content1 = new JPanel(new GridLayout(1, 3));
        JPanel content1Column2 = new JPanel(new GridLayout(2, 0));
        JPanel content1Column1 = new JPanel(new GridLayout(2, 1));
        JPanel content1Column3 = new JPanel(new GridLayout(3, 1));
        content1Column3.add(labelResult);
        content1Column3.add(dataOut);
        content1Column3.add(dataOutRest);
        content1Column2.add(dataInFirstPolynom);
        content1Column2.add(dataInSecondPolynom);
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButtonFirstPolynomial);
        bg.add(radioButtonSecondPolynomial);
        content1Column1.add(radioButtonFirstPolynomial);
        content1Column1.add(radioButtonSecondPolynomial);
        content1.add(content1Column1);
        content1.add(content1Column2);
        content1.add(content1Column3);
        JPanel content2 = new JPanel(new GridLayout(3, 3));
        content2.add(addButton);
        content2.add(decButton);
        content2.add(multiplyButton);
        content2.add(divideButton);
        content2.add(integralButton);
        content2.add(derivativeButton);
        content2.add(labelEmpty);
        content2.add(clearButton);
        content2.add(labelEmpty2);
        content.add(content1);
        content.add(content2);
        finalContent.add(content);
        dataOutRest.setVisible(false);
        addButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        decButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        multiplyButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        divideButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        integralButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        derivativeButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        clearButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        clearButton.setSize(new Dimension(10, 10));
        labelResult.setFont(new Font("Times New Roman", Font.ITALIC, 24));
        labelResult.setHorizontalAlignment(SwingConstants.CENTER);
        labelResult.setVerticalAlignment(SwingConstants.CENTER);
        radioButtonFirstPolynomial.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        radioButtonSecondPolynomial.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        radioButtonSecondPolynomial.setVerticalAlignment(SwingConstants.CENTER);
        radioButtonSecondPolynomial.setHorizontalAlignment(SwingConstants.CENTER);
        radioButtonFirstPolynomial.setVerticalAlignment(SwingConstants.CENTER);
        radioButtonFirstPolynomial.setHorizontalAlignment(SwingConstants.CENTER);
        dataOut.setHorizontalAlignment(SwingConstants.CENTER);
        dataOut.setEditable(false);
        dataOutRest.setHorizontalAlignment(SwingConstants.CENTER);
        dataOut.setFont(new Font("Times New Roman", Font.BOLD, 20));
        dataOutRest.setFont(new Font("Times New Roman", Font.BOLD, 20));
        dataOutRest.setEditable(false);
        dataInFirstPolynom.setHorizontalAlignment(SwingConstants.CENTER);
        dataInSecondPolynom.setHorizontalAlignment(SwingConstants.CENTER);
        this.setContentPane(finalContent);
        this.pack();
        this.setTitle("POLYNOMIAL CALCULATOR");
        this.setSize(1100, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getDataInFirstPolynomial() {
        return dataInFirstPolynom.getText();
    }

    public String getDataInSecondPolynomial() {
        return dataInSecondPolynom.getText();
    }

    public void setDataInFirstPolynom(String text) {
        this.dataInFirstPolynom.setText(text);
    }

    public void setDataInSecondPolynom(String text) {
        this.dataInSecondPolynom.setText(text);
    }

    public void setDataOut(String text) {
        this.dataOut.setText(text);
    }

    public void setVisibleRest(boolean b) {
        this.dataOutRest.setVisible(b);
    }

    public void setDataOutRest(String text) {
        this.dataOutRest.setText(text);
    }

    public boolean getTheFirstRadioButtonValue() {
        return radioButtonFirstPolynomial.isSelected();
    }

    public boolean getTheSecondRadioButtonValue() {
        return radioButtonSecondPolynomial.isSelected();
    }

    void addTwoPolynomials(ActionListener mal) {
        addButton.addActionListener(mal);
    }

    void decreaseTwoPolynomials(ActionListener mal) {
        decButton.addActionListener(mal);
    }

    void multiplyTwoPolynomials(ActionListener mal) {
        multiplyButton.addActionListener(mal);
    }

    void divideTwoPolynomials(ActionListener mal) {
        divideButton.addActionListener(mal);
    }

    void integralPolynomial(ActionListener mal) {
        integralButton.addActionListener(mal);
    }

    void derivativePolynomial(ActionListener mal) {
        derivativeButton.addActionListener(mal);
    }

    void clearPolynomial(ActionListener mal) {
        clearButton.addActionListener(mal);
    }
}
