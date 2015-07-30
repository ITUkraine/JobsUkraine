package ua.com.jobsukraine.service;

import java.util.List;

public interface DefaultService<T> {

	T add(T obj);
	void delete(int id);
	T edit(T obj);
	T find(int id);
	List<T> getAll();
	
}
