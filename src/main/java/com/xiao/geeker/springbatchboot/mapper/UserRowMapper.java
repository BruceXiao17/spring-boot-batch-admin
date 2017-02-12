package com.xiao.geeker.springbatchboot.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xiao.geeker.springbatchboot.vo.UserInfo;

public class UserRowMapper implements RowMapper<UserInfo> {

	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserInfo userInfo = new UserInfo();
		userInfo.setName(rs.getString("name"));
		userInfo.setNickName(rs.getString("nickname"));
		System.out.println("read user>>>>>:" + userInfo);
		return userInfo;
	}

}
