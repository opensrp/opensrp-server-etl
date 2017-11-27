package org.opensrp.etl.interfaces;

public interface RegisterService<Object> {
	
	public void save(Object t);
	
	public boolean delete(Object t);
	
	public void update(Object t);
	
	public Object findById(int id);
	
	public Object findByCaseId(String caseId);
	
}
