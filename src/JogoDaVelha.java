
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JogoDaVelha {

    int larguraTabuleiro = 600;
    int alturaTabuleiro = 700;

    JFrame tela = new JFrame("Jogo da Velha");
    JLabel textoRotulo = new JLabel();
    JLabel placar = new JLabel();
    JPanel textoPainel = new JPanel();
    JPanel tabuleiroPainel = new JPanel();
    JPanel placarPainel = new JPanel();
    JPanel reiniciarPainel = new JPanel();
    JPanel painelSul = new JPanel();

    JButton[][] tabuleiro = new JButton[3][3];
    JButton reiniciar = new JButton();
    String jogadorX = "X";
    String jogadorO = "O";
    String jogadorAtual = jogadorX;
    int pontosX = 0;
    int pontosO = 0;

    boolean gameOver = false;
    int turnos = 0;

    public JogoDaVelha() {
        tela.setVisible(true);
        tela.setSize(larguraTabuleiro, alturaTabuleiro);
        tela.setLocationRelativeTo(null);
        tela.setResizable(false);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLayout(new BorderLayout());

        textoRotulo.setBackground(Color.black);
        textoRotulo.setForeground(Color.white);
        textoRotulo.setFont(new Font("Arial", Font.BOLD, 50));
        textoRotulo.setHorizontalAlignment(JLabel.CENTER);
        textoRotulo.setText("Jogo da Velha");
        textoRotulo.setOpaque(true);

        placar.setBackground(Color.black);
        placar.setForeground(Color.white);
        placar.setFont(new Font("Arial", Font.BOLD, 22));
        placar.setText("Jogador X: " + pontosX + " | Jogador O: " + pontosO);
        
        placar.setOpaque(true);

        textoPainel.setLayout(new BorderLayout());
        textoPainel.add(textoRotulo);
        tela.add(textoPainel, BorderLayout.NORTH);

        tabuleiroPainel.setLayout(new GridLayout(3, 3));
        tabuleiroPainel.setBackground(Color.darkGray);
        tela.add(tabuleiroPainel);

        placarPainel.setLayout(new BorderLayout());
        placarPainel.add(placar);
        // tela.add(placarPainel, BorderLayout.SOUTH);

        reiniciarPainel.setLayout(new BorderLayout());
        reiniciarPainel.add(reiniciar);
        // tela.add(reiniciarPainel);

        reiniciar.setFont(new Font("Arial", Font.BOLD, 20));
        reiniciar.setText("Reiniciar Jogo");
        reiniciar.setFocusable(false);
        reiniciar.setBackground(Color.gray);
        reiniciar.setForeground(Color.white);

        painelSul.setLayout(new GridLayout());
        painelSul.add(placarPainel);
        painelSul.add(reiniciarPainel);
        tela.add(painelSul, BorderLayout.SOUTH);





        for (int v = 0; v < 3; v++) {
            for (int c = 0; c < 3; c++) {
                JButton casa = new JButton();
                tabuleiro[v][c] = casa;
                tabuleiroPainel.add(casa);

                casa.setBackground(Color.darkGray);
                casa.setForeground(Color.white);
                casa.setFont(new Font("Arial", Font.BOLD, 120));
                casa.setFocusable(false);

                casa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (gameOver) return;
                        JButton casa = (JButton) e.getSource();
                        if (casa.getText() == "") {
                            casa.setText(jogadorAtual);
                            turnos++;
                            checkWinner();
                            if (gameOver == true && jogadorAtual == jogadorX){
                                pontosX += 1;
                            }else if(gameOver == true && jogadorAtual == jogadorO){
                                pontosO += 1;
                            }
                            placar.setText("Jogador X: " + pontosX + " | Jogador O: " + pontosO);
                            if (!gameOver){
                                jogadorAtual = jogadorAtual == jogadorX ? jogadorO : jogadorX;
                                textoRotulo.setText("vez do jogador " + jogadorAtual);
                            }
                        }
                    }
                });

            }
        }
    }

    void checkWinner() {
        //Horizontal
        for (int v = 0; v < 3; v++){
            if (tabuleiro[v][0].getText() == "") continue;
            
            if (tabuleiro[v][0].getText() == tabuleiro[v][1].getText() &&
                tabuleiro[v][1].getText() == tabuleiro[v][2].getText()){
                    for (int i = 0; i < 3; i++){
                        setVencedor(tabuleiro[v][i]);
                    }
                    gameOver = true;
                    return;
                }
        }

        //Vertical
        for (int c = 0; c < 3; c++) {
            if (tabuleiro[0][c].getText() == "") continue;
            
            if (tabuleiro[0][c].getText() == tabuleiro[1][c].getText() &&
                tabuleiro[1][c].getText() == tabuleiro[2][c].getText()){
                    for (int i = 0; i < 3; i++){
                        setVencedor(tabuleiro[i][c]);
                    }
                    gameOver = true;
                    return;
                }

        }

        //Diagonal
        if (tabuleiro[0][0].getText() == tabuleiro[1][1].getText() &&
            tabuleiro[1][1].getText() == tabuleiro[2][2].getText() &&
            tabuleiro[0][0].getText() != ""){
                for (int i = 0; i < 3; i++){
                    setVencedor(tabuleiro[i][i]);
                }
                gameOver = true;
                return;
        }

        //Anti-Diagonal
        if (tabuleiro[0][2].getText() == tabuleiro[1][1].getText() &&
            tabuleiro[1][1].getText() == tabuleiro[2][0].getText() &&
            tabuleiro[0][2].getText() != ""){
                    setVencedor(tabuleiro[0][2]);
                    setVencedor(tabuleiro[1][1]);
                    setVencedor(tabuleiro[2][0]);
                    gameOver = true;
                    return;
        }

        if (turnos == 9) {
            for (int v = 0; v < 3; v++){
                for (int c = 0; c < 3; c++){
                    setEmpate(tabuleiro[v][c]);
            }
            gameOver = true;
        }
    }

}
    void setVencedor(JButton casa){
        casa.setForeground(Color.green);
        casa.setBackground(Color.gray);
        textoRotulo.setText(jogadorAtual + " é o vencedor!!!");
        
    }

    void setEmpate(JButton casa){
        casa.setForeground(Color.yellow);
        casa.setBackground(Color.gray);
        textoRotulo.setText(" Empate");
    }
}

