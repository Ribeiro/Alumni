package br.com.alumni.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import br.com.alumni.R;
import br.com.alumni.model.Student;

public class AlumniSendSMS extends Activity {
	
	private Button sendButton;
	private EditText textPhoneNo;
	private EditText textSMS;
	private Student student;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alumni_send_sms);
		
		sendButton = (Button) findViewById(R.id.buttonSend);
		textPhoneNo = (EditText) findViewById(R.id.editTextPhoneNo);
		textSMS = (EditText) findViewById(R.id.editTextSMS);
		
		Intent intent = getIntent();
		student = (Student) intent.getSerializableExtra("smsForStudent");
		
		textPhoneNo.setText(student.getPhone());
		
		addClickListenerToSendButton();
		
		
	}

	private void addClickListenerToSendButton() {
		sendButton.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(final View v) {
 
			  final String phoneNo = textPhoneNo.getText().toString();
			  final String sms = textSMS.getText().toString();
 
			  try {
				final SmsManager smsManager = SmsManager.getDefault();
				smsManager.sendTextMessage(phoneNo, null, sms, null, null);
				
				Intent returnIntent = new Intent();
	            returnIntent.putExtra("result", "SMS has been sent to " + textPhoneNo);
	            setResult(RESULT_OK, returnIntent);
	            
				
			  } catch (final Exception e) {
				  Intent returnIntent = new Intent();
				  returnIntent.putExtra("result", "Failed sending SMS to " + textPhoneNo + " Please, try again later!");
				  setResult(RESULT_CANCELED, returnIntent);
				  Log.e("AlumniSendSMS", e.getMessage());
				
			  }finally{
				  finish();
			  }
 
			}
		});
	}

}
