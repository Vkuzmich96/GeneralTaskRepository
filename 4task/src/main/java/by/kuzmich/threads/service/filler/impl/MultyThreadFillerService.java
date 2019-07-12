package by.kuzmich.threads.service.filler.impl;

import by.kuzmich.threads.bean.Matrix;
import by.kuzmich.threads.bean.Move;
import by.kuzmich.threads.service.filler.Filler;
import by.kuzmich.threads.service.writer.NumberWriterThread;

import java.util.Random;

public class MultyThreadFillerService implements Filler {
    private Matrix matrix;
    private Random random = new Random();

    public MultyThreadFillerService(Matrix matrix) {
        this.matrix = matrix;
    }

    public void fill () {
        try {
            NumberWriterThread writer;
            Move move;
            for (int i = 0; i < matrix.length(); i ++){
                move = new Move(i,i,random.nextInt(100));
                writer = new NumberWriterThread(matrix, move);
                writer.goWrite();
                writer.getThread().join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(matrix);
    }

}
