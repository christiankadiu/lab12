package it.unibo.es1;

import java.util.LinkedList;
import java.util.List;



public class LogicsImpl implements Logics {
	private int size;
	private List<Integer> values;


	public LogicsImpl(int size) {
		this.size = size;
		this.values = new LinkedList<Integer>();
		for (int i = 1; i <= size; i++) {
			values.add(0);
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<Integer> values() {
		return values;
	}

	@Override
	public List<Boolean> enablings() {
		return values.stream().map(x -> x <= values.size()).toList();
	}

	@Override
	public int hit(int elem) {
		int i = values.get(elem) + 1;
		values.set(elem, i);
		return i;
	}

	@Override
	public String result() {
		String s = "";
		for (Integer integer : values) {
			s = s + "|" + integer;
		}
		return "<< "+ s +" >> "; 
	}

	@Override
	public boolean toQuit() {
		return values.stream().allMatch(x -> x == this.values.get(0)); 
	}
}
