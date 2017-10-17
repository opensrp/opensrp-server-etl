package org.opensrp.etl.interfaces;

public interface RegisterService<T> {
	
	public void save(T t);
	
	public boolean delete(T t);
	
	public void update(T t);
	
	public T findById(int id);
	
	public T findByCaseId(String caseId);
	
}
