package com.xx;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xx.entity.Person;
import com.xx.mapper.PersonMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PersonMapperTest {

    @Autowired
    private PersonMapper personMapper;

    @Test
    public void testInsert() {
        Person person = new Person()
                .setUsername(UUID.randomUUID().toString())
                .setPassword("nanfeng")
                .setCreateTime(new Date());
        personMapper.insert(person);
        System.out.println(person.getId());
    }

    @Test
    public void testUpdateById() {
        Person updatePerson = new Person()
                .setId(4)
                .setPassword("puff");
        personMapper.updateByPrimaryKey(updatePerson);
    }

    @Test
    public void testDeleteById() {
        personMapper.deleteByPrimaryKey(2);
    }

    @Test
    public void testSelectById() {
        personMapper.selectByPrimaryKey(1);
    }

    @Test
    public void testSelectByUsername() {
        personMapper.selectByUsername("yunai");
    }

    @Test
    public void testSelectByIds() {
        List<Person> users = personMapper.selectByIds(Arrays.asList(1, 3));
        System.out.println("users：" + users.size());
    }

    @Test // 更多使用，可以参考 https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md
    public void testSelectPageByCreateTime() {
        // 设置分页
        PageHelper.startPage(1, 10);
        Date createTime = new Date(2018 - 1990, Calendar.FEBRUARY, 24); // 临时 Demo ，实际不建议这么写
        // 执行列表查询
        // PageHelper 会自动发起分页的数量查询，设置到 PageHelper 中
        List<Person> persons = personMapper.selectListByCreateTime(createTime); // 实际返回的是 com.github.pagehelper.Page 代理对象
        // 转换成 PageInfo 对象，并输出分页
        PageInfo<Person> page = new PageInfo(persons);
        System.out.println(page.getTotal());
    }

}
