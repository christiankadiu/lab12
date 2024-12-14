package it.unibo.es3;

import java.util.List;

public interface Logics {

    String setText(Pair<Integer, Integer> pos);

    List<Integer> random();

    void advance(Pair<Integer, Integer> pos);

    List<Pair<Integer, Integer>> activeButtons();

    List<Pair<Integer, Integer>> adjacent(Pair<Integer, Integer> pos);

    int toQuit();

}
