package by.epam.service.sorter;

import by.epam.service.comparator.CompareParagraphsBySize;
import by.epam.service.sorter.impl.ParagraphSorter;

import java.util.HashMap;
import java.util.Map;

public class SorterFactory {
    private static SorterFactory factory = new SorterFactory();

    private Map<SorterKey, Sorter> map = new HashMap<>();

    public static SorterFactory getInstance(){
        return factory;
    }

    public Sorter get (SorterKey key) {
        return map.get(key);
    }

    private SorterFactory(){
        map.put(SorterKey.SORT_PARAGRAPHS_BY_SIZE, new ParagraphSorter(new CompareParagraphsBySize()));
    }
}
