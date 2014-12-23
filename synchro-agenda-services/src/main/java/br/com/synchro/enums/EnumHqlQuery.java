package br.com.synchro.enums;

/**
 * 
 * EnumHqlQuery.java
 * Created on 14/05/2014
 * @author OpenText Professional Services
 *
 */
public enum EnumHqlQuery {
	
	CONTACT_SEARCH_BY_NAME(
			"    FROM Contact c " +
			"   WHERE c.user.username = :usernameParam "
			+ "   AND (c.name LIKE :nameParam " +
			"      OR c.surname LIKE :nameParam) " +
			"ORDER BY c.name ASC"
	),
	
	CONTACT_SEARCH_BY_LOGIN(
			"    FROM Contact c " +
					"   WHERE c.user.username = :usernameParam " +
					"ORDER BY c.name ASC"
	),
	
	USER_LOGIN_QUERY(
			"FROM User u WHERE u.username = :username"
	);
	
	EnumHqlQuery(String query) {		
		this.query = query;		
	}
	
	private String query;
	
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}	
}
