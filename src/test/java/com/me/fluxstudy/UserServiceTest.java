package com.me.fluxstudy;

import com.me.fluxstudy.dao.UserDao;
import com.me.fluxstudy.model.User;
import com.me.fluxstudy.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserServiceTest.class)
public class UserServiceTest {

    @Mock
    private UserService userService;

    @Mock
    private UserDao userDao;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        User user=new User();
        user.setId(1L);
        when(userService.getUserById(argThat(id->{
            if(id==null){
                return false;
            }
            if(id.equals(1L)){
                return true;
            }
            return false;
        }))).thenReturn(user);

        User user2=new User();
        user2.setId(2L);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        when(userService.getUserById(argThat(id->{
            if(id==null){
                return false;
            }
            if(id.equals(2L)){
                return true;
            }
            return false;
        }))).thenReturn(user2);
    }

    @Test
    public void testGetUserById(){
        User user = userService.getUserById(1L);
        Assert.assertEquals(1L, (long) user.getId());

    }
}
