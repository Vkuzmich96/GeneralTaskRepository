package by.epam.service.composit;

import by.epam.service.sorter.Sorter;


public interface Container extends Ellyment {
    void add(Ellyment ellyment);
    void sort(Sorter sorter);
}
