package it.unibo.es3;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GUI extends JFrame {
    
    private final List<JButton> cells = new ArrayList<>();
    private Logics logic;
    private final Map<JButton, Pair<Integer, Integer>> mappa = new HashMap<>();
    
    public GUI(int width) {
        logic = new LogicsImpl(width);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70*width, 70*width);
        
        JPanel panel = new JPanel(new GridLayout(width,width));
        this.getContentPane().add(panel);
        JPanel barra = new JPanel();
        JButton butt = new JButton("ciao");
        barra.add(butt);
        this.getContentPane().add(barra, BorderLayout.SOUTH);

        ActionListener pre = e1 -> {
            logic.advance();
        };
        
        ActionListener al = e -> {
            var jb = (JButton)e.getSource();
            Pair<Integer, Integer> pos = new Pair<Integer,Integer>(mappa.get(jb).getX(), mappa.get(jb).getY());
        	jb.setText(logic.setText(pos));
        };
        
        List<Integer> random;
        random = logic.random();
        for (int i=0; i<width; i++){
            for (int j=0; j<width; j++){
                Pair<Integer, Integer> pos = new Pair<Integer,Integer>(i, j);
                if(((i)*width+j) == random.get(0) || ((i)*width+j) == random.get(1) || ((i)*width+j) == random.get(2)){
                    final JButton jb = new JButton(logic.setText(pos));
                    this.cells.add(jb);
                    jb.addActionListener(al);
                    panel.add(jb);
                }else {
                    final JButton jb = new JButton();
                    this.cells.add(jb);
                    jb.addActionListener(al);
                    panel.add(jb);
                }
            }
        }
        for (int i = 0; i < width; i++){
            for(int k = 0; k < width; k++){
                Pair<Integer, Integer> pos = new Pair<Integer,Integer>(i, k);
                mappa.put(cells.get(i*width+k), pos);
            }
        }
        this.setVisible(true);
    }
    
}