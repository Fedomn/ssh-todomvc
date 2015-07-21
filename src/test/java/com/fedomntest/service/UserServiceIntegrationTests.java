package com.fedomntest.service;

import com.fedomn.model.Fj;
import com.fedomn.model.User;
import com.fedomn.service.FjService;
import com.fedomn.service.UserService;
import org.assertj.core.util.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-IntegrationTest.xml")
@Transactional
public class UserServiceIntegrationTests extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private FjService fjService;

    @Autowired
    private UserService userService;

    @Test
    public void should_save_user_success() throws Exception {
        //given
        int beforeSaveAmount = userService.findAll().size();
        //when
        userService.save(new User("Frank", new Date(), "Male", 9000f));
        //then
        assertEquals(userService.findAll().size(), beforeSaveAmount + 1);
    }

    @Test
    public void should_get_user_success() throws Exception {
        //given
        User savedUser = new User("Frank", new Date(), "Male", 9000f);
        String uuid = userService.save(savedUser);
        //when
        User user = userService.findById(uuid);
        User getNameUser = userService.findByName("Frank");
        //then
        assertThat(user).isEqualTo(savedUser);
        assertThat(getNameUser).isEqualTo(savedUser);
    }

    @Test
    public void should_update_user_success() throws Exception {
        //given
        User savedUser = new User("Frank", new Date(), "Male", 9000f);
        String uuid = userService.save(savedUser);
        //when
        User getUser = userService.findById(uuid);
        String updateName = "UpdateFrank";
        getUser.setName(updateName);
        userService.update(getUser);
        //then
        assertThat(userService.findById(uuid).getName()).isEqualTo(updateName);
    }

    @Test
    public void should_delete_user_success() throws Exception {
        //given
        User savedUser = new User("Frank", new Date(), "Male", 9000f);
        String uuid = userService.save(savedUser);
        //when
        userService.delete(savedUser);
        //then
        assertThat(userService.findById(uuid)).isNull();
    }

    @Test
    public void should_save_user_with_fj_success() throws Exception {
        //given
        Set<Fj> fjSet = Sets.newLinkedHashSet(new Fj("FuJian1"));
        User user = new User("Frank", new Date(), "Male", 9000f);
        user.setFjSet(fjSet);
        //when
        int beforeSaveFjAmountCount = fjService.findAll().size();
        userService.save(user);
        //then
        assertThat(fjService.findAll().size()).isEqualTo(beforeSaveFjAmountCount + 1);
    }

    @Test
    public void should_get_user_and_fj_success() throws Exception {
        //given
        User user = new User("Frank", new Date(), "Male", 9000f);
        Set<Fj> fjSet = Sets.newLinkedHashSet(
                new Fj("fj1"),
                new Fj("fj2"),
                new Fj("fj3")
        );
        user.setFjSet(fjSet);
        //when
        userService.save(user);
        String uuid = user.getId();
        //then
        assertThat(userService.findById(uuid)).isEqualTo(user);
        assertThat(userService.findById(uuid).getFjSet()).isEqualTo(user.getFjSet());
    }

    @Test
    public void should_update_user_with_deletedFjs_success() throws Exception {
        //given
        User user = new User("Frank", new Date(), "Male", 9000f);
        user.setFjSet(Sets.newLinkedHashSet(
                new Fj("fj1"),
                new Fj("fj2"),
                new Fj("fj3")
        ));
        userService.save(user);

        int beforeSaveFjSize = userService.findById(user.getId()).getFjSet().size();

        User sessionUser = userService.findById(user.getId());
        Iterator<Fj> itUser = sessionUser.getFjSet().iterator();
        while (itUser.hasNext()) {
            sessionUser.getFjSet().remove(itUser.next());//size - 1
            sessionUser.getFjSet().add(new Fj("fj4"));//size + 1
            sessionUser.getFjSet().add(new Fj("fj5"));//size + 1
            break;
        }

        //when
        userService.save(sessionUser);

        //then
        assertThat(userService.findById(user.getId()).getFjSet().size()).isEqualTo(beforeSaveFjSize - 1 + 1 + 1);
    }

    @Test
    public void should_delete_user_with_fj_success() throws Exception {
        //given
        User user = new User("Frank", new Date(), "Male", 9000f);
        Set<Fj> fjSet = Sets.newLinkedHashSet(
                new Fj("fj1"),
                new Fj("fj2"),
                new Fj("fj3")
        );
        user.setFjSet(fjSet);
        int beforeSavedFjSize = fjService.findAll().size();

        userService.save(user);
        String userId = user.getId();

        //when
        userService.deleteById(userId);

        //then
        assertThat(userService.findById(userId)).isNull();
        assertThat(fjService.findAll().size()).isEqualTo(beforeSavedFjSize);
    }
}
