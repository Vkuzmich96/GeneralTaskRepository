package by.epam.service;

import by.epam.service.composit.Container;
import by.epam.service.composit.Ellyment;
import by.epam.service.sorter.Sorter;

public class EllymentSortService implements SortService {
    private Sorter sorter;

    public EllymentSortService(Sorter sorter) {
        this.sorter = sorter;
    }

    @Override
    public void sort(Ellyment ellyment) {
        ((Container)ellyment).sort(sorter);
    }
}
