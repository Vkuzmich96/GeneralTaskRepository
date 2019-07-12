package by.kuzmich.threads;

import by.kuzmich.threads.service.filler.Filler;
import by.kuzmich.threads.service.filler.FillerFactory;
import by.kuzmich.threads.service.filler.FillerKey;

public class Runner {
    private static Filler filler = FillerFactory.getInstance().get(FillerKey.ThreadFiller);

    public static void main(String[] args) {
        filler.fill();
    }
}
