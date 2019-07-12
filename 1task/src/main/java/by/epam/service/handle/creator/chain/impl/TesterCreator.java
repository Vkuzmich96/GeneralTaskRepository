package by.epam.service.handle.creator.chain.impl;

import by.epam.entity.Employee;
import by.epam.entity.tester.*;
import by.epam.service.ServiceException;
import by.epam.service.handle.FileArgumentConstants;
import by.epam.service.handle.creator.chain.EmployeeCreator;

public class TesterCreator extends EmployeeCreator {

    @Override
    public Employee create(String[] strings) throws ServiceException {
        if("tester".equals(strings[FileArgumentConstants.KIND_ARGUMENT])){
            switch (strings[FileArgumentConstants.POSITION_ARGUMENT]){
                case "junior":
                    return build(new JuniorTester(), strings);
                case "middle":
                    return build(new MiddleTester(), strings);
                case "senior":
                    return build(new SeniorTester(), strings);
                case "lead":
                    return build(new TeamLeadTester(), strings);
                default:
                    throw new ServiceException("builder can not create employee with position  " + strings[FileArgumentConstants.POSITION_ARGUMENT]);
            }
        } else {
            return nextParse(strings);
        }
    }

    private Tester build(Tester tester, String[] strings){
        super.build(tester, strings);
        tester.setTestingKind(
                "automatic".equals(strings[FileArgumentConstants.TESTING_KIND_ARGUMENT]) ? TestingKind.AUTOMATIC : TestingKind.BY_HAND
        );
        return tester;
    }
}
