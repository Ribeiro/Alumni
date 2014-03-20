package br.com.alumni.infraestructure;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;
import java.util.ArrayList;
import java.util.List;
import nl.qbusict.cupboard.QueryResultIterable;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import br.com.alumni.model.Student;

public class StudentDAO extends SQLiteOpenHelper {
	
	 private static final String DATABASE_NAME = "alumni.db";
	 private static final int DATABASE_VERSION = 1;
	 
	 static {
	        cupboard().register(Student.class);
	    }

	public StudentDAO(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
        cupboard().withDatabase(db).createTables();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        cupboard().withDatabase(db).upgradeTables();
    }


	public void save(Student student) {
		Long id = cupboard().withDatabase(getWritableDatabase()).put(student);
		Log.i("StudentDAO", "Student saved with id => " + id.toString());
	}

	public List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();
		QueryResultIterable<Student> iterable = cupboard().withDatabase(getWritableDatabase()).query(Student.class).query();
		Log.i("StudentDAO" , "Total of Student records found => " + String.valueOf(iterable.getCursor().getCount()));
		
		for (Student student : iterable) {
			students.add(student);
		}
		
		return students;
	}

	public void delete(Student student) {
		Boolean deleted = cupboard().withDatabase(getWritableDatabase()).delete(student);
		Log.i("StudentDAO", "Student with id " + student.getId() + " was deleted? " +  deleted.toString());
	}

	public void update(Student student) {
		Long id = cupboard().withDatabase(getWritableDatabase()).put(student);
		Log.i("StudentDAO", "Student with with id " + id.toString() + " was updated!");
		
	}

}
