package com.app.menu;

import java.beans.JavaBean;

/*
 * trying out the builder pattern
 */
@JavaBean//will it work?
public class Dish extends BaseEntity {
	
	private final String name;//name of the dish
	private final String description;//description of the dish 

	public Dish(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public final String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public static class Builder {//dish builder
		private String name;
		private String description;
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}
		public Dish build() {
			return new Dish(name, description);
		}

	}

}
