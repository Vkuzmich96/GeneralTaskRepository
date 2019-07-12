package by.epam.service.team;

import by.epam.entity.Team;
import by.epam.repository.impl.EmployeeRepository;
import by.epam.service.ServiceException;
import by.epam.service.handle.Handler;
import by.epam.service.handle.HandlerFactory;
import by.epam.service.handle.HandlerKey;
import by.epam.service.team.create.TeamCreator;
import by.epam.service.team.create.TeamCreatorFactory;
import by.epam.service.team.create.TeamKey;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamCreatorTest {
    private Handler handler = HandlerFactory.getInstance().getHandler(HandlerKey.FILE_HANDLER);
    private EmployeeRepository repository = EmployeeRepository.getInstance();
    private TeamCreator creator = TeamCreatorFactory.getInstance().getTeamCreator(TeamKey.VAR_1);

    @Before
    public void prepare() throws ServiceException {
        repository.addAll(handler.handle("TestValues.txt"));
    }

    @Test
    public void create() {
        Team team = creator.create();
        assertNotNull(team);
    }
}