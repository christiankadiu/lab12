package it.unibo.es3;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class LogicsImpl implements Logics{

    private int width;
    private List<List<Boolean>> attivi;

    LogicsImpl(int width){
        attivi = new ArrayList<List<Boolean>>();
        for (int i = 0; i < width; i++){
            final List<Boolean> row = new ArrayList<>();
            attivi.add(row);
            for (int k = 0; k < width; k++){
                row.add(false);
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
        return List.of((random.nextInt(width*width)+1), (random.nextInt(width*width)+1), (random.nextInt(width*width)+1));
    }

    @Override
    public void advance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'advance'");
    }

    

}
