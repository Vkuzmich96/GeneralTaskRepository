package by.kuzmich.threads.service.writer;

import by.kuzmich.threads.bean.Matrix;
import by.kuzmich.threads.bean.Move;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NumberWriterThread implements Runnable{
    private Matrix matrix;
    private Thread thread;
    private final int TIME_OUT = 1;
    private Move move;

    public NumberWriterThread(Matrix matrix, Move move) {
        this.matrix = matrix;
        this.move = move;
        thread = new Thread(this);
    }

    public Thread getThread(){
        return thread;
    }

    public void goWrite(){
        thread.start();
    }

    private void write() {
        try {
            matrix.write(move);
            TimeUnit.MICROSECONDS.sleep(TIME_OUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        write();
    }
}
