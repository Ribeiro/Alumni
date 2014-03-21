package br.com.alumni.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import br.com.alumni.R;
import br.com.alumni.model.Student;

public class AlumniSendEmail extends Activity {
	
	private Button buttonSend;
	private EditText textTo;
	private EditText textSubject;
	private EditText textMessage;
	private Student student;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alumni_send_email);
		
		buttonSend = (Button) findViewById(R.id.buttonSend);
		textTo = (EditText) findViewById(R.id.editTextTo);
		textSubject = (EditText) findViewById(R.id.editTextSubject);
		textMessage = (EditText) findViewById(R.id.editTextMessage);
		
		Intent intent = getIntent();
		student = (Student) intent.getSerializableExtra("emailForStudent");
		
		textTo.setText(student.getEmail());
		
		buttonSend.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View v) {
 
			  String to = textTo.getText().toString();
			  String subject = textSubject.getText().toString();
			  String message = textMessage.getText().toString();
 
			  Intent email = new Intent(Intent.ACTION_SEND);
			  email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
			  //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
			  //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
			  email.putExtra(Intent.EXTRA_SUBJECT, subject);
			  email.putExtra(Intent.EXTRA_TEXT, message);
 
			  //need this to prompts email client only
			  email.setType("message/rfc822");
 
			  startActivityForResult(Intent.createChooser(email, "Choose an Email client :"), 1);
			  
			}
			
		});
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if (requestCode == 1) {
			Intent returnIntent = new Intent();
            returnIntent.putExtra("result", "Email has been sent to " + textTo.getText());
            setResult(RESULT_OK, returnIntent);
            finish();
		}
		
		super.onActivityResult(requestCode, resultCode, data);
	}

}
