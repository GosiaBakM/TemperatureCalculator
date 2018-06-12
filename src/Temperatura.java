
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Temperatura extends JFrame implements ActionListener {

    private JLabel lCelsius, lFarenheit;
    private JTextField tCelsius, tFarenheit;
    private JButton bKonwetuj;
    private double tempCelsius, tempFareheit;
    private JCheckBox chWielkie;
    private ButtonGroup bgRozmiar;
    private JRadioButton rbMaly, rbSredni, rbDuzy;

    public Temperatura() {


        setSize(400, 220);
        setTitle("Obliczenie temperatury Celsius to Farenheit");
        setLayout(null);

        lCelsius = new JLabel("Stopnie Celsiusa: ");
        lCelsius.setBounds(20, 20, 150, 20);
        add(lCelsius);

        tCelsius = new JTextField();
        tCelsius.setBounds(170, 20, 100, 20);
        add(tCelsius);
        tCelsius.addActionListener(this);
        tCelsius.setToolTipText("Podaj temeperaturę w stopniach Celsiusza");

        lFarenheit = new JLabel(" Stopnie Farenheita: ");
        lFarenheit.setBounds(20, 70, 150, 20);
        add(lFarenheit);

        tFarenheit = new JTextField();
        tFarenheit.setBounds(170, 70, 100, 20);
        add(tFarenheit);

        bKonwetuj = new JButton("Przelicz");
        bKonwetuj.setBounds(120, 120, 150, 20);
        bKonwetuj.addActionListener(this);
        add(bKonwetuj);


        chWielkie = new JCheckBox("Wielkie litery");
        chWielkie.setBounds(280, 120, 150, 20);
        add(chWielkie);
        //chWielkie.addActionListener(this);

        bgRozmiar = new ButtonGroup();
        rbMaly = new JRadioButton("Mały", true);
        rbMaly.setBounds(50, 150, 100, 20);
        bgRozmiar.add(rbMaly);
        add(rbMaly);
        rbMaly.addActionListener(this);

        rbSredni = new JRadioButton("Sredni", false);
        rbSredni.setBounds(150, 150, 100, 20);
        bgRozmiar.add(rbSredni);
        add(rbSredni);
        rbSredni.addActionListener(this);

        rbDuzy = new JRadioButton("Duzy", false);
        rbDuzy.setBounds(250, 150, 100, 20);
        bgRozmiar.add(rbDuzy);
        add(rbDuzy);
        rbDuzy.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();

        if (zrodlo == bKonwetuj || zrodlo == tCelsius) {
            if (chWielkie.isSelected()) {
                tFarenheit.setFont(new Font("SansSerif", Font.BOLD, 18));
            } else {
                tFarenheit.setFont(new Font("SansSerif", Font.PLAIN, 12));
            }
            tempCelsius = Double.parseDouble(tCelsius.getText());
            tempFareheit = 32.0 + (9.0 / 5.0) * tempCelsius;
            tFarenheit.setText(String.valueOf(tempFareheit));

        } else if (zrodlo == rbMaly) {
            tFarenheit.setFont(new Font("SansSerif", Font.PLAIN, 12));
        } else if (zrodlo == rbSredni) {
            tFarenheit.setFont(new Font("SansSerif", Font.PLAIN, 15));
        } else if (zrodlo == rbDuzy) {
            tFarenheit.setFont(new Font("SansSerif", Font.PLAIN, 18));
        }
    }

    public static void main(String[] args) {
        Temperatura temp = new Temperatura();
        temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        temp.setVisible(true);


    }
}


