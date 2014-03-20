package br.com.alumni.helper;

import static br.com.alumni.util.ViewUtil.getDoubleFrom;
import static br.com.alumni.util.ViewUtil.getIntegerFrom;
import static br.com.alumni.util.ViewUtil.getStringFrom;
import android.widget.EditText;
import android.widget.RatingBar;
import br.com.alumni.R;
import br.com.alumni.activity.AlumniForm;
import br.com.alumni.model.Student;
import br.com.alumni.model.builder.StudentBuilder;

public class AlumniFormHelper {
	
	private EditText studentName;
	private EditText studentAge;
	private EditText studentAddress;
	private EditText studentPhone;
	private EditText studentEmail;
	private RatingBar studentRanking;

	public AlumniFormHelper(AlumniForm alumniForm){
		studentName = (EditText) alumniForm.findViewById(R.id.name);
		studentAge = (EditText) alumniForm.findViewById(R.id.age);   
		studentAddress = (EditText) alumniForm.findViewById(R.id.address);
		studentPhone = (EditText) alumniForm.findViewById(R.id.phone);
		studentEmail = (EditText) alumniForm.findViewById(R.id.email);
		studentRanking = (RatingBar) alumniForm.findViewById(R.id.ranking);
		
	}
	
	
	public Student getStudent() {
		
		return StudentBuilder.aStudent().withName(getStringFrom(studentName))
										.withAge(getIntegerFrom(studentAge))
										.withAddress(getStringFrom(studentAddress))
										.withPhone(getStringFrom(studentPhone))
										.withEmail(getStringFrom(studentEmail))
										.withRanking(getDoubleFrom(studentRanking))
										.build();
	}


	public void addToForm(Student studentToUpdate) {
		studentName.setText(studentToUpdate.getName());
		studentAge.setText(studentToUpdate.getAge().toString());
		studentAddress.setText(studentToUpdate.getAddress());
		studentPhone.setText(studentToUpdate.getPhone());
		studentEmail.setText(studentToUpdate.getEmail());
		studentRanking.setRating(studentToUpdate.getRanking().floatValue());
		
	}
	
}