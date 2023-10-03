import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cadastro extends JFrame {
    private JTextField txtNome;
    private JTextField txtEmail;
    private JTextField txtTelefone;
    private JTextField txtSexo;
    private JButton btnSalvar;
    private JPanel cadastroPanel;
    private Usuario usuario;
    private TelaMain telaMain;

    public Cadastro() {
        this.telaMain = telaMain;

        setTitle("Cadastro");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(cadastroPanel);
        setVisible(true);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String email = txtEmail.getText();
                String telefone = txtTelefone.getText();
                String sexo = txtSexo.getText();

                usuario = new Usuario(nome, email, telefone, sexo);

                Connection connection = null;
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost/contatos", "root", "root");

                    String sql = "INSERT INTO contatos (nome, email, telefone, sexo) VALUES (?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, nome);
                    preparedStatement.setString(2, email);
                    preparedStatement.setString(3, telefone);
                    preparedStatement.setString(4, sexo);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");

                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao salvar dados no banco de dados.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao salvar dados no banco de dados.");
                } finally {
                    try {
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

    }
}