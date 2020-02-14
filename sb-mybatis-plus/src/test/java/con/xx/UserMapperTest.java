package con.xx;

import com.xx.Application;
import com.xx.entity.User;
import com.xx.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        User person = new User();
        person.setUsername(UUID.randomUUID().toString());
        person.setPassword("123456");
        person.setCreateTime(new Date());
        userMapper.insert(person);
    }

    @Test
    public void testUpdateById() {
        User updatePerson = new User();
        updatePerson.setId(1);
        updatePerson.setPassword("12345678");
        updatePerson.setUsername("xinput3");
        userMapper.updateById(updatePerson);
    }

    @Test
    public void testDeleteById() {
        userMapper.deleteById(1);
    }

    @Test
    public void testSelectById() {
        userMapper.selectById(1);
    }

    @Test
    public void testSelectByUsername() {
        userMapper.selectByUsername("xinput");
    }

    @Test
    public void testSelectByIds() {
        List<User> users = userMapper.selectByIds(Arrays.asList(1, 3));
        System.out.println("persons：" + users.size());
    }
}
