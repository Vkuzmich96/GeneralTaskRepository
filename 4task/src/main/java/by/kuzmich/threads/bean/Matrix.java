package by.kuzmich.threads.bean;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Matrix {
    private final int M = 8;
    private final int N = 8;
    private int[][] matrix = new int[M][N];
    private Lock lock = new ReentrantLock();
    private List<Move> moveList = new ArrayList<>();

    public int[][] getMatrix() {
        return matrix;
    }

    public int length(){
        return matrix.length;
    }

    public void write(Move move) {
        lock.lock();
        if (isUnik(move)){
            moveList.add(move);
            matrix[move.getX()][move.getY()] = move.getNumber();
        }
        lock.unlock();
    }

    private boolean isUnik(Move move){
        boolean flag = true;
        for (Move lastMove : moveList) {
            if (move.equals(lastMove)){
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int [] arr : matrix) {
             string.append(Arrays.toString(arr));
             string.append('\n');
        }
        return string.toString();
    }
}