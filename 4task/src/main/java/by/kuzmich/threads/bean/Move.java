package by.kuzmich.threads.bean;

import java.util.Objects;

public class Move {
    private int x;
    private int y;
    private int number;

    public Move(int x, int y, int number) {
        this.x = x;
        this.y = y;
        this.number = number;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return x == move.x &&
                y == move.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
