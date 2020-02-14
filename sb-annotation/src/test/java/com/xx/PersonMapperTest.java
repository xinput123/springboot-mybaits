package com.xx;

import com.xx.entity.Person;
import com.xx.mapper.PersonMapper;
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
public class PersonMapperTest {

    @Autowired
    private PersonMapper personMapper;

    @Test
    public void testInsert() {
        Person person = new Person();
        person.setUsername(UUID.randomUUID().toString());
        person.setPassword("123456");
        person.setCreateTime(new Date());
        personMapper.insert(person);
    }

    @Test
    public void testUpdateById() {
        Person updatePerson = new Person();
        updatePerson.setId(2);
        updatePerson.setPassword("123456");
        updatePerson.setUsername("xinput2");
        personMapper.updateById(updatePerson);
    }

    @Test
    public void testDeleteById() {
        personMapper.deleteById(2);
    }

    @Test
    public void testSelectById() {
        personMapper.selectById(1);
    }

    @Test
    public void testSelectByUsername() {
        personMapper.selectByUsername("xinput");
    }

    @Test
    public void testSelectByIds() {
        List<Person> users = personMapper.selectByIds(Arrays.asList(1, 3));
        System.out.println("persons：" + users.size());
    }
}
