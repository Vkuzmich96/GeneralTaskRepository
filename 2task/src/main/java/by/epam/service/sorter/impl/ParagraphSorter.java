package by.epam.service.sorter.impl;

import by.epam.service.composit.Ellyment;
import by.epam.service.sorter.Sorter;

import java.util.Comparator;
import java.util.List;

public class ParagraphSorter implements Sorter {

    private Comparator<Ellyment> comparator;

    public ParagraphSorter(Comparator<Ellyment> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void sort(List<Ellyment> list) {
        Ellyment temp;
        int j;
        for(int i = 0; i < list.size() - 1; i++){
            if (comparator.compare(list.get(i), list.get(i+1)) > 0){
                temp = list.get(i + 1);
                list.set(i + 1, list.get(i));
                j = i;
                while (j > 0 && comparator.compare(temp, list.get(i-1)) < 0) {
                    list.set(j, list.get(j - 1));
                    j--;
                }
                list.set(j, temp);
            }
        }
    }

}
