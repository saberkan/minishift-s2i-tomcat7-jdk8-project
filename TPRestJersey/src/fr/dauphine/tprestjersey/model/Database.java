package fr.dauphine.tprestjersey.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Database {
	public static Map<String, Todo> todos = new ConcurrentHashMap<String, Todo>();;

	static {
		for(int i = 0; i<200; i++) {
			Todo todo = new Todo();
			todo.setId("todo" + i);
			todos.put(todo.getId(), todo);
		}
	}
	
	public static Todo getTodo(String id) {
		return todos.get(id);
	}
}
