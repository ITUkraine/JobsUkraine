package ua.com.jobsukraine.service;

public interface DefaultService<T> {

	T add(T obj);

	void delete(int id);

	T edit(T obj);

	T find(int id);

}
