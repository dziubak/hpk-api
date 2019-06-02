package com.hpk.api.component.dao;

import com.hpk.api.component.dao.rowmapper.GroupRowMapper;
import com.hpk.api.component.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GroupDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Group> getGroupsByDepartmentIdAndCourse(int departmentId, int courseNumber){
        String sql = "SELECT id, teacher_id, name, course, department_id FROM team " +
                "WHERE department_id=:departmentId AND course=:courseNumber";

        Map<String, Integer> params = new HashMap<>();
        params.put("departmentId", departmentId);
        params.put("courseNumber", courseNumber);

        return namedParameterJdbcTemplate.query(sql, params, new GroupRowMapper());
    }

    public List<Group> getListGroupsByName(String groupName){
        String sql = "SELECT id, teacher_id, name, course, department_id FROM team";
        String like = " WHERE name LIKE '" + groupName + "%'";

        sql = groupName != null ? sql.concat(like) : sql;

        return namedParameterJdbcTemplate.query(sql, new GroupRowMapper());
    }

    public Group getGroupById(int groupId){
        String sql = "SELECT id, teacher_id, name, course, department_id FROM team WHERE id=:groupId";

        return namedParameterJdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource().addValue("groupId", groupId),
                new GroupRowMapper());
    }
}
