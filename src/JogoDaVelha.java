import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class JogoDaVelha {
    int larguraTabuleiro = 600;
    int alturaTabuleiro = 650;
    
    JFrame frame = new JFrame("Jogo da Velha");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();

    public JogoDaVelha() {
        frame.setVisible(true);
        frame.setSize(larguraTabuleiro, alturaTabuleiro);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Jogo da Velha");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);
    }

    
}
