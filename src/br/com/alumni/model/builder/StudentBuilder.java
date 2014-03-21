package br.com.alumni.model.builder;

import br.com.alumni.model.Student;

public final class StudentBuilder {
	
	protected Student student;
	
	public StudentBuilder() {
		this.student = new Student();
	}
	
	public static StudentBuilder aStudent() {
		return new StudentBuilder();
	}
	
	public Student build() {
		return this.student;
	}
	
	public StudentBuilder withId(final Long id) {
		this.student.setId(id);
		return this;
	}
	
	public StudentBuilder withName(final String name) {
		this.student.setName(name);
		return this;
	}
	
	public StudentBuilder withAge(final Integer age) {
		this.student.setAge(age);
		return this;
	}
	
	public StudentBuilder withAddress(final String address) {
		this.student.setAddress(address);
		return this;
	}
	
	public StudentBuilder withPhone(final String phone) {
		this.student.setPhone(phone);
		return this;
	}
	

	public StudentBuilder withEmail(final String email) {
		this.student.setEmail(email);
		return this;
	}
	
	public StudentBuilder withRanking(final Double ranking) {
		this.student.setRanking(ranking);
		return this;
	}
	
	public StudentBuilder withPhoto(final String photo) {
		this.student.setPhoto(photo);
		return this;
	}
	
	public StudentBuilder withSite(final String url) {
		this.student.setSite(url);
		return this;
	}

}