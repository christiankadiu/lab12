package it.unibo.es3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LogicsImpl implements Logics {

    private int width;
    private List<List<Boolean>> attivi;
    private List<List<Pair<Integer, Integer>>> posizioni;

    LogicsImpl(int width) {
        attivi = new ArrayList<List<Boolean>>();
        posizioni = new ArrayList<List<Pair<Integer, Integer>>>();
        for (int i = 0; i < width; i++) {
            final List<Boolean> row = new ArrayList<>();
            final List<Pair<Integer, Integer>> rowPos = new ArrayList<>();
            attivi.add(row);
            posizioni.add(rowPos);
            for (int k = 0; k < width; k++) {
                Pair<Integer, Integer> p = new Pair<Integer, Integer>(i, k);
                row.add(false);
                rowPos.add(p);
            }
        }
        this.width = width;
    }

    @Override
    public String setText(Pair<Integer, Integer> pos) {
        attivi.get(pos.getX()).set(pos.getY(), true);
        return "*";
    }

    @Override
    public List<Integer> random() {
        Random random = new Random();
        return List.of((random.nextInt(width * width) + 1), (random.nextInt(width * width) + 1),
                (random.nextInt(width * width) + 1));
    }

    @Override
    public void advance(Pair<Integer, Integer> pos) {

    }

    public List<Pair<Integer, Integer>> activeButtons() {
        List<Pair<Integer, Integer>> lista = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            for (int k = 0; k < width; k++) {
                if (attivi.get(i).get(k)) {
                    Pair<Integer, Integer> pos = new Pair<Integer, Integer>(i, k);
                    lista.add(pos);
                }
            }
        }
        return lista;
    }

    @Override
    public List<Pair<Integer, Integer>> adjacent(Pair<Integer, Integer> pos) {
        List<Pair<Integer, Integer>> lista = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            Pair<Integer, Integer> p = new Pair<Integer, Integer>(pos.getX() + i, pos.getY());
            if (!p.equals(pos)) {
                lista.add(p);
            }
        }
        for (int i = -1; i <= 1; i++) {
            Pair<Integer, Integer> p = new Pair<Integer, Integer>(pos.getX(), pos.getY() + i);
            if (!p.equals(pos)) {
                lista.add(p);
            }
        }
        for (int i = -1; i <= 1; i++) {
            Pair<Integer, Integer> p = new Pair<Integer, Integer>(pos.getX() + i, pos.getY() + i);
            if (!p.equals(pos)) {
                lista.add(p);
            }
        }
        for (int i = -1; i <= 1; i++) {
            Pair<Integer, Integer> p = new Pair<Integer, Integer>(pos.getX() + i, pos.getY() - i);
            if (!p.equals(pos)) {
                lista.add(p);
            }
        }
        return lista;
    }

    @Override
    public int toQuit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toQuit'");
    }

}
