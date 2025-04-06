import java.awt.BorderLayout;

import javax.swing.*;

public class JogoDaVelha {
    int larguraTabuleiro = 600;
    int alturaTabuleiro = 650;
    
    JFrame frame = new JFrame();

    public JogoDaVelha() {
        frame.setVisible(true);
        frame.setSize(larguraTabuleiro, alturaTabuleiro);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    }

    
}
