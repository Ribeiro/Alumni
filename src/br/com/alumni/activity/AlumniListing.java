package br.com.alumni.activity;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.alumni.R;
import br.com.alumni.infraestructure.StudentDAO;
import br.com.alumni.model.Student;

public class AlumniListing extends Activity {
	
	private List<Student> studentsListing;
	
	private StudentDAO dao;

	private ListView listView;
	
	private Student student;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alumni_listing);
		dao = new StudentDAO(this);
		listView = (ListView) findViewById(R.id.alumniListing);
		registerForContextMenu(listView);
		listStudents();
		
	}

	private void listStudents() {
		studentsListing = dao.getStudents();
		ArrayAdapter<Student> studentAdapter = buildAdapterFor(studentsListing);
		listView.setAdapter(studentAdapter);
		addOnItemClickListenerTo(listView);
		addOnItemLongClickListenerTo(listView);
	}
	
	private ArrayAdapter<Student> buildAdapterFor(List<Student> studentsListing){
		int layout = android.R.layout.simple_list_item_1;
		return new ArrayAdapter<Student>(this, layout, studentsListing);
	}
	
	private void addOnItemClickListenerTo(ListView listView){
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position,
					long id) {
				
				student = (Student) adapterView.getItemAtPosition(position);
				Intent intent = new Intent(AlumniListing.this, AlumniForm.class);
				intent.putExtra("selectedStudent", student);
				startActivity(intent);
				
			}
			
		});
		
	}
	
	private void addOnItemLongClickListenerTo(ListView listView){
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				
				student = (Student) adapterView.getItemAtPosition(position);
				
				return false;
			}
			
		});
		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		listStudents();
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.alumni_listing, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		int clickedItem = item.getItemId();
		
		switch (clickedItem) {
		case R.id.newStudent:
			startActivity(new Intent(this, AlumniForm.class)); 
			break;

		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		menu.add("Call");
		menu.add("Send SMS");
		menu.add("Browse site");
		MenuItem delete = menu.add("Delete");
		delete.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				dao.delete(student);
				dao.close();
				listStudents();
				return false;
			}
			
		});
		
		
		menu.add("See on Map");
		menu.add("Send Email");
		
		super.onCreateContextMenu(menu, v, menuInfo);
		
	}
	
}