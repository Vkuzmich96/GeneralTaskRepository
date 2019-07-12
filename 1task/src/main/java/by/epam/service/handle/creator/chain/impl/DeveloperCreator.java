package by.epam.service.handle.creator.chain.impl;

import by.epam.entity.Employee;
import by.epam.entity.developer.*;
import by.epam.service.handle.FileArgumentConstants;
import by.epam.service.ServiceException;
import by.epam.service.handle.creator.chain.EmployeeCreator;

public class DeveloperCreator extends EmployeeCreator {

    @Override
    public Employee create(String[] strings) throws ServiceException {
        if("developer".equals(strings[FileArgumentConstants.KIND_ARGUMENT])){
            switch (strings[FileArgumentConstants.POSITION_ARGUMENT]){
                case "junior":
                    return build(new JuniorDeveloper(), strings);
                case "middle":
                    return build(new MiddleDeveloper(), strings);
                case "senior":
                    return build(new SeniorDeveloper(), strings);
                case "lead":
                    return build(new TeamLeadDeveloper(), strings);
                default:
                    throw new ServiceException("builder can not create employee with position  " + strings[FileArgumentConstants.POSITION_ARGUMENT]);
            }
        } else {
            return nextParse(strings);
        }
    }

    private Developer build(Developer developer, String[] strings){
        super.build(developer, strings);
        developer.setLanguage(strings[FileArgumentConstants.LANGUAGE_ARGUMENT]);
        return developer;
    }
}
