package br.com.alumni.activity;

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
	
	private Student studentToUpdate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alumni_form);
		
		Intent intent = getIntent();
		studentToUpdate = (Student) intent.getSerializableExtra("selectedStudent");
		Button button = (Button) findViewById(R.id.btnSaveAlumni);
		alumniFormHelper = new AlumniFormHelper(this);
		
		if (studentToUpdate != null) {
			button.setText("Update");
			alumniFormHelper.addToForm(studentToUpdate);
		}
		
		addOnClickListenerTo(button);
		
	}
	
	private void addOnClickListenerTo(Button button){
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
		
	}
	
}