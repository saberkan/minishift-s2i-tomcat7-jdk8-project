package fr.dauphine.tprestjersey.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Todos {
	
    @XmlElementWrapper(name="todos")
    @XmlElement(name="todo")
	private List<Todo> todos;

	public Todos() {
		this.todos = new ArrayList<Todo>();
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public boolean add(Todo e) {
		return todos.add(e);
	}

	public Todo getTodoById(int id) {
		return todos.get(id);
	}
	
}
