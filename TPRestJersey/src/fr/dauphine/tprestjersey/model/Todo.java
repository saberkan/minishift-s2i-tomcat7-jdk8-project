package fr.dauphine.tprestjersey.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Todo {
	
	private String id;
	
	private String titre;
	
	private String description;
	
	private boolean isDone;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return "Todo [titre=" + titre + ", description=" + description
				+ ", isDone=" + isDone + "]";
	}
	
	
}
