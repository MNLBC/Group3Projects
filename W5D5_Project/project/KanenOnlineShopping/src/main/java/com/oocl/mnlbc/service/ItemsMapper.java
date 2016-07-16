package com.oocl.mnlbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.oocl.mnlbc.model.ItemsBean;
import com.oocl.mnlbc.model.OrderBean;

public class ItemsMapper implements RowMapper<ItemsBean>{


	@Override
	public ItemsBean mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
