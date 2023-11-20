import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.Random;


public class G2048
{
    
    private JFrame game;
    private JPanel gridPanel;
    private JLabel[][] gridLabels;
    private boolean win;

    private static final int SIZE = 4;
    private int[][] grid;
    private Random random;
    public G2048() 
    {
        grid = new int[SIZE][SIZE];
        random = new Random();
        game = new JFrame("2048");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(300, 300);
        game.setLayout(new BorderLayout());
        gridPanel = new JPanel(new GridLayout(SIZE, SIZE));
        gridLabels = new JLabel[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                gridLabels[i][j] = new JLabel("", JLabel.CENTER);
                gridLabels[i][j].setFont(new Font("Arial", Font.BOLD, 24));
                gridLabels[i][j].setOpaque(true);
                gridLabels[i][j].setBackground(Color.GREEN);
                gridPanel.add(gridLabels[i][j]);
            }
        }
        game.add(gridPanel, BorderLayout.CENTER);
        JPanel infoPanel = new JPanel(new GridLayout(2, 2));
        game.add(infoPanel, BorderLayout.NORTH);
        game.addKeyListener(new KeyAdapter() 
        {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP) {
                    Up();
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    Down();
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    Left();
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    Right();
                }
                updateGridLabels();
                if (isGameOver()) {
                    OVER();
                }
            }
        });
        game.setFocusable(true);
        game.requestFocus();
        game.setVisible(true);
        initializeGrid();
        updateGridLabels();
    }
    public void initializeGrid() 
    {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = 0;
            }
        }
        addNewNumber();
        addNewNumber();
    }
    public void addNewNumber() 
    {
        int row, col;
        do {
            row = random.nextInt(SIZE);
            col = random.nextInt(SIZE);
        } while (grid[row][col] != 0);
        grid[row][col] = (random.nextInt(2) + 1) * 2;
    }
    public void updateGridLabels() 
    {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == 0) {
                    gridLabels[i][j].setText("");
                    gridLabels[i][j].setBackground(Color.GREEN);
                } else if (grid[i][j] == 2048) {
                    win = true;
                    gridLabels[i][j].setText(String.valueOf(grid[i][j]));
                } else {
                    gridLabels[i][j].setText(String.valueOf(grid[i][j]));
                }
                gridLabels[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE));
            }
        }
    }
    
    public void Up() 
    {
        boolean moved = false;
        for (int j = 0; j < SIZE; j++) {
            int mergeValue = -1;
            for (int i = 1; i < SIZE; i++) {
                if (grid[i][j] != 0) {
                    int row = i;
                    while (row > 0 && (grid[row - 1][j] == 0 || grid[row - 1][j] == grid[row][j])) {
                        if (grid[row - 1][j] == grid[row][j] && mergeValue != row - 1) {
                            grid[row - 1][j] *= 2;
                            grid[row][j] = 0;
                            mergeValue = row - 1;
                            moved = true;
                        } else if (grid[row - 1][j] == 0) {
                            grid[row - 1][j] = grid[row][j];
                            grid[row][j] = 0;
                            moved = true;
                        }
                        row--;
                    }
                }
            }
        }
        if (moved) {
            addNewNumber();
        }
    }
    public void Down() 
    {
        boolean moved = false;
        for (int j = 0; j < SIZE; j++) {
            int mergeValue = -1;
            for (int i = SIZE - 2; i >= 0; i--) {
                if (grid[i][j] != 0) {
                    int row = i;
                    while (row < SIZE - 1 && (grid[row + 1][j] == 0 || grid[row + 1][j] == grid[row][j])) {
                        if (grid[row + 1][j] == grid[row][j] && mergeValue != row + 1) {
                            grid[row + 1][j] *= 2;
                            grid[row][j] = 0;
                            mergeValue = row + 1;
                            moved = true;
                        } else if (grid[row + 1][j] == 0) {
                            grid[row + 1][j] = grid[row][j];
                            grid[row][j] = 0;
                            moved = true;
                        }
                        row++;
                    }
                }
            }
        }
        if (moved) {
            addNewNumber();
        }
    }
    public void Left() 
    {
        boolean moved = false;
        for (int i = 0; i < SIZE; i++) {
            int mergeValue = -1;
            for (int j = 1; j < SIZE; j++) {
                if (grid[i][j] != 0) {
                    int col = j;
                    while (col > 0 && (grid[i][col - 1] == 0 || grid[i][col - 1] == grid[i][col])) {
                        if (grid[i][col - 1] == grid[i][col] && mergeValue != col - 1) {
                            grid[i][col - 1] *= 2;
                            grid[i][col] = 0;
                            mergeValue = col - 1;
                            moved = true;
                        } else if (grid[i][col - 1] == 0) {
                            grid[i][col - 1] = grid[i][col];
                            grid[i][col] = 0;
                            moved = true;
                        }
                        col--;
                    }
                }
            }
        }
        if (moved) {
            addNewNumber();
        }
    }
    public void Right() 
    {
        boolean moved = false;
        for (int i = 0; i < SIZE; i++) {
            int mergeValue = -1;
            for (int j = SIZE - 2; j >= 0; j--) {
                if (grid[i][j] != 0) {
                    int col = j;
                    while (col < SIZE - 1 && (grid[i][col + 1] == 0 || grid[i][col + 1] == grid[i][col])) {
                        if (grid[i][col + 1] == grid[i][col] && mergeValue != col + 1) {
                            grid[i][col + 1] *= 2;
                            grid[i][col] = 0;
                            mergeValue = col + 1;
                            moved = true;
                        } else if (grid[i][col + 1] == 0) {
                            grid[i][col + 1] = grid[i][col];
                            grid[i][col] = 0;
                            moved = true;
                        }
                        col++;
                    }
                }
            }
        }
        if (moved) {
            addNewNumber();
        }
    }
    public boolean isGameOver() {
        if(win){
            return true;
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == 0 ||
                        (i > 0 && grid[i][j] == grid[i - 1][j]) ||
                        (i < SIZE - 1 && grid[i][j] == grid[i + 1][j]) ||
                        (j > 0 && grid[i][j] == grid[i][j - 1]) ||
                        (j < SIZE - 1 && grid[i][j] == grid[i][j + 1])) {
                    return false;
                }
            }
        }
        return true;
    }
    public void OVER() {
        String result;
        if (win) {
            result = "Congratulations! You reached the 2048 tile!";
        } else {
            result = "Game over!Would you like to play again?";
        }
        int choice = JOptionPane.showConfirmDialog(game, result, "Game Over", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            restart();
        } else {
            System.exit(0);
        }
    }
    public void restart() {
        win=false;
        initializeGrid();
        updateGridLabels();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() 
            {
                new G2048();
            }
        });
    }
}