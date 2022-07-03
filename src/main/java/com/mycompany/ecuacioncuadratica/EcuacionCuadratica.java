package com.mycompany.ecuacioncuadratica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class EcuacionCuadratica extends JFrame {

    //Metodo constructor
    public EcuacionCuadratica() {

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400, 300);

        this.setLayout(null);

        JLabel lblA = new JLabel();
        lblA.setText("Coeficiente A:");
        lblA.setBounds(10, 10, 150, 25);
        this.getContentPane().add(lblA);

        JLabel lblB = new JLabel();
        lblB.setText("Coeficiente B:");
        lblB.setBounds(10, 35, 150, 25);
        this.getContentPane().add(lblB);

        JLabel lblC = new JLabel();
        lblC.setText("Coeficiente C:");
        lblC.setBounds(10, 60, 150, 25);
        this.getContentPane().add(lblC);

        JTextField txtA = new JTextField();
        txtA.setText("");
        txtA.setBounds(160, 10, 100, 25);
        this.getContentPane().add(txtA);

        JTextField txtB = new JTextField();
        txtB.setText("");
        txtB.setBounds(160, 35, 100, 25);
        this.getContentPane().add(txtB);

        JTextField txtC = new JTextField();
        txtC.setText("");
        txtC.setBounds(160, 60, 100, 25);
        this.getContentPane().add(txtC);

        JButton btnCalcular = new JButton();
        btnCalcular.setText("Calcular Raices");
        btnCalcular.setBounds(10, 90, 200, 25);
        this.getContentPane().add(btnCalcular);

        JLabel lblX1 = new JLabel();
        lblX1.setText("Raíz X1:");
        lblX1.setBounds(10, 120, 150, 25);
        this.getContentPane().add(lblX1);

        JLabel lblX2 = new JLabel();
        lblX2.setText("Raíz X2 :");
        lblX2.setBounds(10, 145, 150, 25);
        this.getContentPane().add(lblX2);

        JTextField txtX1 = new JTextField();
        txtX1.setText("");
        txtX1.setBounds(160, 120, 200, 25);
        this.getContentPane().add(txtX1);
        txtX1.setEditable(false);

        JTextField txtX2 = new JTextField();
        txtX2.setText("");
        txtX2.setBounds(160, 145, 200, 25);
        this.getContentPane().add(txtX2);
        txtX2.setEditable(false);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    //Obtener datos de entrada
                    double a = Double.parseDouble(txtA.getText());
                    double b = Double.parseDouble(txtB.getText());
                    double c = Double.parseDouble(txtC.getText());

                    DecimalFormat df = new DecimalFormat("#,##0.000000");
                    //Proceso
                    if (a != 0) {
                        double f = Math.pow(b, 2) - 4 * a * c;
                        if (f >= 0) {
                            double x1 = (-b + Math.sqrt(f)) / (2 * a);
                            double x2 = (-b - Math.sqrt(f)) / (2 * a);

                            txtX1.setText(df.format(x1));
                            txtX2.setText(df.format(x1));
                        } else {
                            //raices complejas o imaginarias
                            double xr = -b / (2 * a);
                            double xri = Math.sqrt(-f) / (2 * a);

                            //Mostrar raices
                            txtX1.setText(df.format(xr) + " + " + df.format(xri) + " * i");
                            txtX2.setText(df.format(xr) + " - " + df.format(xri) + " * i");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La ecuacion no es cuadratica");

                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error en la entrada de datos: \n" + ex.getMessage());
                }
            }
        });

    }

    public static void main(String[] args) {

        new EcuacionCuadratica().setVisible(true);

    }

}
