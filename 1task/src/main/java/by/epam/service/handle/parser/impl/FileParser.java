package by.epam.service.handle.parser.impl;

import by.epam.service.ServiceException;
import by.epam.service.handle.parser.Parser;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileParser implements Parser {
    @Override
    public List<String[]> parse(String path) throws ServiceException {
        isValid(path);
        List<String[]> list = new ArrayList<>();
        try(BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path))) {
            String readResult;
            do {
                readResult = bufferedReader.readLine();
                if (readResult!=null){
                    list.add(split(readResult));
                }
            }while (readResult != null);

        }catch (IOException e){
            throw new ServiceException("В парсере возникли непредвиденные проблемы с чтением из файла", e);
        }
        return list;
    }

    private String[] split(String string){
        return string.split(";");
    }

    private void isValid(String path) throws ServiceException {
        if (path == null) {
            throw new ServiceException("В парсер вместо пути к файлу пришёл null");
        } else if ("".equals(path)) {
            throw new ServiceException("В парсер вместо пути к файлу пришла пустая строка");
        }
    }
}
