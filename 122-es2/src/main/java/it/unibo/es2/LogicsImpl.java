package it.unibo.es2;

import java.util.ArrayList;
import java.util.List;

public class LogicsImpl implements Logics{

    private List<List<Boolean>> grids;
    private int size;
    
    public LogicsImpl(int size) {
        this.size = size;
        grids = new ArrayList<List<Boolean>>();
        for(int i = 0; i < size; i++){
            final List<Boolean> row = new ArrayList<>();
            grids.add(row);
            for (int k = 0; k < size; k++){
                row.add(false);
            }
        }
    }
    
    @Override
    public String settext(Pair<Integer, Integer> pos){
        grids.get(pos.getX()).set(pos.getY(), true);
        return "*";
    }

    @Override
    public boolean toQuit() {
        for (int i = 0; i < size; i++) {
            boolean checkRow = true;
            for (int k = 0; k < size; k++) {
                if (!grids.get(i).get(k)) {
                    checkRow = false;
                    break;
                }
            }
            if (checkRow) {
                return true;
            }
        }

        for (int i = 0; i < size; i++) {
            boolean checkColumn = true;
            for (int k = 0; k < size; k++) {
                if (!grids.get(k).get(i)) {
                    checkColumn = false;
                    break;
                }
            }
            if (checkColumn) {
                return true;
            }
        }
        return false;
    }
    
}
