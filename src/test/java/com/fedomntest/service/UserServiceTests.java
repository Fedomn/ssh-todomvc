package com.fedomntest.service;

import com.fedomn.dao.UserDao;
import com.fedomn.model.User;
import com.fedomn.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserServiceImpl userService;

    private List<User> mockUser = Arrays.asList(
            new User("Frank"),
            new User("Lucy")
    );

    @Test
    public void should_get_correct_user() throws Exception {
        //given
        String uid = "1";
        User mockUser = mock(User.class);
        given(userDao.findById(uid)).willReturn(mockUser);

        //when
        User user = userService.findById(uid);

        //then
        assertEquals(user, mockUser);
    }
}
