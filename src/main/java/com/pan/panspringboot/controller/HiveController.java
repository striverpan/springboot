package com.pan.panspringboot.controller;


import com.pan.panspringboot.common.result.ResultBean;
import com.pan.panspringboot.common.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("hive")
public class HiveController {
/*


    @Autowired
    @Qualifier("hiveJdbcTemplate")
    private JdbcTemplate hiveJdbcTemplate;

    @GetMapping(value = "/select")
    public ResultBean selectFromHive() {

        String sql = "select * from kylin_country";
        List<Map<String, Object>> rows = hiveJdbcTemplate.queryForList(sql);
        Iterator<Map<String, Object>> it = rows.iterator();
        while (it.hasNext()) {
            Map<String, Object> row = it.next();
            System.out.println(String.format("%s\t%s", row.get("kylin_country.country"), row.get("kylin_country.name")));
        }
        return ResultUtil.success();
    }

    @GetMapping(value = "/getMeta")
    public ResultBean getHiveTableMetaInfo() {

        */
/*ResultSet resultSet = hiveJdbcTemplate.queryForMap(" <TABLE_NAME>");
        ResultSetMetaData metaData = resultSet.getMetaData();
        while (resultSet.next()) {

            System.out.println(" Column names : " + resultSet.getString(metaData.getColumnName(1)));

        }*//*


        String sql = "DESCRIBE table2";

        hiveJdbcTemplate.execute(sql, new PreparedStatementCallback() {

            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

                ResultSet resultSet = ps.executeQuery();
                ResultSetMetaData metaData = resultSet.getMetaData();
                while (resultSet.next()) {
                    System.out.println(" Column names : " + resultSet.getString(metaData.getColumnName(1)));
                }

                return null;

            }
        });


        return ResultUtil.success();
    }

*/

}
