import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMain {
    private JButton btnCadastrar;
    private JButton btnAlterar;
    private JButton btnMostrar;
    private JButton btnMostrarEspecifico;
    private JButton btnExcluir;
    private JPanel telaPanel;

    public TelaMain() {
        JFrame cadastro = new Cadastro();

        cadastro.setTitle("Tela de Início");
        cadastro.setSize(500, 500);
        cadastro.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cadastro.setContentPane(telaPanel);
        cadastro.setVisible(true);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cadastro cadastro = new Cadastro();

                cadastro.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(telaPanel);
                frame.setVisible(false);
            }
        });

        btnAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnMostrarEspecifico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaMain();
            }
        });
    }
}