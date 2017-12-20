package org.unicef.etl.entity;

import java.sql.Types;

import org.hibernate.dialect.PostgreSQLDialect;

public class MyPostgreSQL94Dialect extends PostgreSQLDialect {
	
	public MyPostgreSQL94Dialect() {
		this.registerColumnType(Types.JAVA_OBJECT, "jsonb");
	}
}
