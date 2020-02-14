package com.xx.mapper;

import com.xx.entity.Person;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @Repository 注解：用于标记是数据访问Bean对象。在 Mybatis的接口中，
 * 实际是非必要的，只是为了避免在Service中，@Autowired 注入时无须警告
 *
 * @Param 注解：声明变量名
 * 在方法为单参数时，非必须
 * 在方法为多参数时，必须。
 * 这是一个良好的编程习惯，禁止使用Map作为查询参数
 */
@Repository
public interface PersonMapper {

    @Insert("INSERT INTO persons(username, password, create_time) VALUES(#{username}, #{password}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(Person person);

    @Update(value = {
            "<script>",
            "UPDATE persons",
            "<set>",
            "<if test='username != null'>, username = #{username}</if>",
            "<if test='password != null'>, password = #{password}</if>",
            "</set>",
            "WHERE id = #{id}",
            "</script>"
    })
    int updateById(Person person);

    @Insert("DELETE FROM persons WHERE id = #{id}")
    int deleteById(@Param("id") Integer id); // 生产请使用标记删除，除非有点想不开，嘿嘿。

    @Select("SELECT username, password, create_time FROM persons WHERE id = #{id}")
    Person selectById(@Param("id") Integer id);

    @Select("SELECT username, password, create_time FROM persons WHERE username = #{username}")
    Person selectByUsername(@Param("username") String username);

    @Select(value = {
            "<script>",
            "SELECT username, password, create_time FROM persons",
            "WHERE id IN",
            "<foreach item='id' collection='ids' separator=',' open='(' close=')' index=''>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    List<Person> selectByIds(@Param("ids") Collection<Integer> ids);
}
