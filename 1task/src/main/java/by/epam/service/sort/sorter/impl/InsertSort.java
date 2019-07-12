package by.epam.service.sort.sorter.impl;

import by.epam.entity.Employee;

import by.epam.service.sort.sorter.Sorter;

import java.util.Comparator;
import java.util.List;

public class InsertSort implements Sorter<Employee> {

    @Override
    public void sort(List<Employee> list, Comparator comparator) {
        Employee temp;
        int j;
        for(int i = 0; i < list.size() - 1; i++){
            if (comparator.compare(list.get(i),list.get(i + 1)) > 0){
                temp = list.get(i + 1);
                list.set(i + 1, list.get(i));
                j = i;
                while (j > 0 && comparator.compare(temp, list.get(j - 1)) < 0) {
                    list.set(j, list.get(j - 1));
                    j--;
                }
                list.set(j, temp);
            }
        }
    }
}
