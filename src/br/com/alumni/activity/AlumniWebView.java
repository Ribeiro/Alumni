package br.com.alumni.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import br.com.alumni.R;
import br.com.alumni.model.Student;

public class AlumniWebView extends Activity{
	
	private WebView webView;
	private Student student;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		   super.onCreate(savedInstanceState);
		   setContentView(R.layout.alumni_webview);
	 
		   webView = (WebView) findViewById(R.id.alumniWebView);
		   webView.getSettings().setJavaScriptEnabled(true);
		   
		   Intent intent = getIntent();
		   student = (Student) intent.getSerializableExtra("studentSite");
		   
		   webView.loadUrl("http://".concat(student.getSite()));
	 
		   //String customHtml = "<html><body><h1>Hello, WebView</h1></body></html>";
		   //webView.loadData(customHtml, "text/html", "UTF-8");
	 
		}
	
	

}
