package forms;

import model.Cliente;

import javax.swing.*;
import java.awt.*;

public class Banco extends JFrame {
    private Cliente cliente;
    private JLabel lblSaldo;
    private JTextArea txtHistorial;

    public Banco(Cliente cliente) {
        this.cliente = cliente;
        setTitle("Banco - Cliente: " + cliente.getNombre());
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        lblSaldo = new JLabel("Saldo actual: $" + cliente.getSaldo());
        add(lblSaldo, BorderLayout.NORTH);

        txtHistorial = new JTextArea();
        add(new JScrollPane(txtHistorial), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new GridLayout(1,4));
        JButton btnDeposito = new JButton("Depósito");
        JButton btnRetiro = new JButton("Retiro");
        JButton btnTransferencia = new JButton("Transferencia");
        JButton btnSalir = new JButton("Salir");

        panelBotones.add(btnDeposito);
        panelBotones.add(btnRetiro);
        panelBotones.add(btnTransferencia);
        panelBotones.add(btnSalir);
        add(panelBotones, BorderLayout.SOUTH);

        btnDeposito.addActionListener(e -> deposito());
        btnRetiro.addActionListener(e -> retiro());
        btnTransferencia.addActionListener(e -> transferencia());
        btnSalir.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void deposito() {
        String valorStr = JOptionPane.showInputDialog("Ingrese monto a depositar:");
        double valor = Double.parseDouble(valorStr);
        cliente.setSaldo(cliente.getSaldo() + valor);
        actualizarSaldo();
        txtHistorial.append("Depósito: $" + valor + "\n");
    }

    private void retiro() {
        String valorStr = JOptionPane.showInputDialog("Ingrese monto a retirar:");
        double valor = Double.parseDouble(valorStr);
        if (valor <= cliente.getSaldo()) {
            cliente.setSaldo(cliente.getSaldo() - valor);
            actualizarSaldo();
            txtHistorial.append("Retiro: $" + valor + "\n");
        } else {
            JOptionPane.showMessageDialog(this, "Saldo insuficiente");
        }
    }

    private void transferencia() {
        String destinatario = JOptionPane.showInputDialog("Ingrese destinatario:");
        String valorStr = JOptionPane.showInputDialog("Ingrese monto a transferir:");
        double valor = Double.parseDouble(valorStr);
        if (valor <= cliente.getSaldo()) {
            cliente.setSaldo(cliente.getSaldo() - valor);
            actualizarSaldo();
            txtHistorial.append("Transferencia a " + destinatario + " por $" + valor + "\n");
        } else {
            JOptionPane.showMessageDialog(this, "Saldo insuficiente");
        }
    }

    private void actualizarSaldo() {
        lblSaldo.setText("Saldo actual: $" + cliente.getSaldo());
    }
}
