
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Temperatura extends JFrame implements ActionListener {

    //Deklaracja zmiennych  ////
    private JLabel lCelsius, lFarenheit;
    private JTextField tCelsius, tFarenheit;
    private JButton bKonwetuj;
    private double tempCelsius, tempFareheit;
    private ButtonGroup radioPanel;
    private JRadioButton rbFtoC, rbCtoF;

    public Temperatura() {

        setSize(400, 320);
        setTitle("Obliczenie temperatury Celsius to Farenheit");
        setLayout(null);

        lCelsius = new JLabel("Stopnie Celsiusa: ");
        lCelsius.setBounds(20, 20, 150, 20);
        add(lCelsius);

        tCelsius = new JTextField();
        tCelsius.setBounds(170, 20, 100, 20);
        add(tCelsius);
        tCelsius.addActionListener(this);
        //tCelsius.setToolTipText("Podaj temeperaturę w stopniach Celsiusza");

        lFarenheit = new JLabel(" Stopnie Farenheita: ");
        lFarenheit.setBounds(20, 70, 150, 20);
        add(lFarenheit);

        tFarenheit = new JTextField();
        tFarenheit.setBounds(170, 70, 100, 20);
        add(tFarenheit);
        tFarenheit.addActionListener(this);
        //tFarenheit.setToolTipText("Podaj temeperaturę w stopniach Farenheita");

        bKonwetuj = new JButton("Przelicz");
        bKonwetuj.setBounds(120, 120, 150, 20);
        add(bKonwetuj);
        bKonwetuj.addActionListener(this);

        radioPanel = new ButtonGroup();

        rbCtoF = new JRadioButton("Celsius to Farenheit");
        rbCtoF.setBounds(50, 250, 150, 20);
        rbCtoF.setSelected(true);
        radioPanel.add(rbCtoF);
        add(rbCtoF);

        rbFtoC = new JRadioButton("Farenheir to Celsius");
        rbFtoC.setBounds(200, 250, 150, 20);
        radioPanel.add(rbFtoC);
        add(rbFtoC);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object zrodlo = e.getSource();

        if (zrodlo == bKonwetuj) {
            if (rbCtoF.isSelected()) {
                tempCelsius = Double.parseDouble(tCelsius.getText());
                tempFareheit = 32.0 + (9.0 / 5.0) * tempCelsius;
                tFarenheit.setText(String.valueOf(tempFareheit));
            } else if (rbFtoC.isSelected()) {
                tempFareheit = Double.parseDouble(tFarenheit.getText());
                tempCelsius = (tempFareheit - 32.0) * (5.0 / 9.0);
                tCelsius.setText(String.valueOf(tempCelsius));
            }
        }
        if (zrodlo == tCelsius) {
            tempCelsius = Double.parseDouble(tCelsius.getText());
            tempFareheit = 32.0 + (9.0 / 5.0) * tempCelsius;
            tFarenheit.setText(String.valueOf(tempFareheit));
        } else if (zrodlo == tFarenheit) {
            tempFareheit = Double.parseDouble(tFarenheit.getText());
            tempCelsius = (tempFareheit - 32.0) * (5.0 / 9.0);
            tCelsius.setText(String.valueOf(tempCelsius));
        }
    }

    public static void main(String[] args) {
        Temperatura temp = new Temperatura();
        temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        temp.setVisible(true);
    }
}


