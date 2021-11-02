package com.qa.starterproject;

public class Cat {
	
	private String name;

	private String breed;

	private int height;

	public Cat(String name, String breed, int height) {
		super();
		this.name = name;
		this.breed = breed;
		this.setHeight(height);
	}

	public Cat() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if (height > 8 && height < 100) {
			this.height = height;
		} else {
			System.out.println("Invalid height: " + height);
		}
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", breed=" + breed + ", height=" + height + "]";
	}

}

