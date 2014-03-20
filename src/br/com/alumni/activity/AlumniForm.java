package br.com.alumni.activity;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import br.com.alumni.R;
import br.com.alumni.helper.AlumniFormHelper;
import br.com.alumni.infraestructure.StudentDAO;
import br.com.alumni.model.Student;

public class AlumniForm extends Activity {
	
	private AlumniFormHelper alumniFormHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alumni_form);
		
		Intent intent = getIntent();
		final Student studentToUpdate = (Student) intent.getSerializableExtra("selectedStudent");
		Button button = (Button) findViewById(R.id.btnSaveAlumni);
		alumniFormHelper = new AlumniFormHelper(this);
		
		if (studentToUpdate != null) {
			button.setText("Update");
			alumniFormHelper.addToForm(studentToUpdate);
		}
		
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Student student = alumniFormHelper.getStudent();
				StudentDAO dao = new StudentDAO(AlumniForm.this);
				
				if (studentToUpdate == null) {
					dao.save(student);
					
				} else {
					student.setId(studentToUpdate.getId());
					dao.update(student);
				}
				
				dao.close();
				
				finish();
				
			}
			
		});
		
		
		//addOnClickListenerTo(button, studentToUpdate);
		
	}
	
//	private void addOnClickListenerTo(Button button, Student studentToUpdate){
//		button.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Student student = alumniFormHelper.getStudent();
//				StudentDAO dao = new StudentDAO(AlumniForm.this);
//				
//				if (studentToUpdate == null) {
//					dao.save(student);
//					
//				} else {
//
//				}
//				
//				
//				
//				dao.close();
//				
//				
//				finish();
//				
//			}
//			
//		});
//		
//	}
	
}