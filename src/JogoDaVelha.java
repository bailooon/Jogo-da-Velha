import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class JogoDaVelha {
    int larguraTabuleiro = 600;
    int alturaTabuleiro = 650;
    
    JFrame tela = new JFrame("Jogo da Velha");
    JLabel textoRotulo = new JLabel();
    JPanel textoPainel = new JPanel();
    JPanel tabuleiroPainel = new JPanel();

    JButton[][] tabuleiro = new JButton[3][3];
    String jogadorX = "X";
    String jogadorO = "O";
    String jogadorAtual = jogadorX;

    public JogoDaVelha() {
        tela.setVisible(true);
        tela.setSize(larguraTabuleiro, alturaTabuleiro);
        tela.setLocationRelativeTo(null);
        tela.setResizable(false);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLayout(new BorderLayout());

        textoRotulo.setBackground(Color.darkGray);
        textoRotulo.setForeground(Color.white);
        textoRotulo.setFont(new Font("Arial", Font.BOLD, 50));
        textoRotulo.setHorizontalAlignment(JLabel.CENTER);
        textoRotulo.setText("Jogo da Velha");
        textoRotulo.setOpaque(true);

        textoPainel.setLayout(new BorderLayout());
        textoPainel.add(textoRotulo);
        tela.add(textoPainel, BorderLayout.NORTH);

        tabuleiroPainel.setLayout(new GridLayout(3, 3));
        tabuleiroPainel.setBackground(Color.darkGray);
        tela.add(tabuleiroPainel);

        for (int v=0; v<3; v++){
            for (int c=0; c<3; c++){
                JButton casa = new JButton();
                tabuleiro[v][c] = casa;
                tabuleiroPainel.add(casa);

                casa.setBackground(Color.darkGray);
                casa.setForeground(Color.white);
                casa.setFont(new Font("Arial", Font.BOLD, 120));
                casa.setFocusable(false);

                
            }
        }
    }

    
}
