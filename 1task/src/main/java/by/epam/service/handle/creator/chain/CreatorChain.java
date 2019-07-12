package by.epam.service.handle.creator.chain;

import by.epam.service.ServiceException;

public interface CreatorChain <T>{
    T create(String[] strings) throws ServiceException;
    CreatorChain<T> linkWith(CreatorChain<T> next);
}
