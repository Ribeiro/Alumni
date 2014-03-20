package br.com.alumni.model;

import java.io.Serializable;

public class Student implements Serializable, Entity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3146716334148613614L;
	private Long _id;
	private String name;
	private Integer age;
	private String address;
	private String phone;
	private String email;
	private Double ranking;
	private String photo;
	private static final String NO_PHOTO = "No Photo";
	private static final Long ZERO = 0L;

	public Student(Integer id, String name, Integer age, String address,
			String phone, String email, Double ranking, String photo) {
		super();
		this._id = id == null ? ZERO : id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.ranking = ranking;
		this.photo = photo == null ? NO_PHOTO : photo;
	}

	public Student() {
		
	}

	public Long getId() {
		return _id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public Double getRanking() {
		return ranking;
	}

	public String getPhoto() {
		return photo;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Long id) {
		this._id = id;
		
	}

	public void setPhoto(String photo) {
		this.photo = photo;
		
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setAddress(String address) {
		this.address = address;
		
	}

	public void setPhone(String phone) {
		this.phone = phone;
		
	}

	public void setEmail(String email) {
		this.email = email;
		
	}

	public void setRanking(Double ranking) {
		this.ranking = ranking;
		
	}

}