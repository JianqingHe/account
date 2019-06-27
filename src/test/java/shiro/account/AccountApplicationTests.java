package shiro.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shiro.account.entity.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountApplicationTests {


    @Autowired
    private UserEntity userEntity;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetUserInfo() {

        System.out.println(userEntity);
    }
}
