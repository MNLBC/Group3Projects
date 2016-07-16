package com.oocl.mnlbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.oocl.mnlbc.model.ItemsBean;

public class ItemsMapper implements RowMapper<ItemsBean>{

	@Override
	public ItemsBean mapRow(ResultSet arg0, int arg1) throws SQLException {

		return null;
	}

}
