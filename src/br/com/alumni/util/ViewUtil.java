package br.com.alumni.util;

import android.annotation.SuppressLint;
import android.widget.EditText;
import android.widget.RatingBar;

public final class ViewUtil {
	
	private static final Integer ZERO = 0;
	
	private ViewUtil(){
		
	}
	
	public static String getStringFrom(EditText editText){
		return editText.getText().toString();
	}
	
	@SuppressLint("NewApi")
	public static Integer getIntegerFrom(EditText editText){
		String stringValueFromEditText = getStringFrom(editText);
		return stringValueFromEditText.isEmpty() ? ZERO : Integer.valueOf(stringValueFromEditText);
	}

	public static Double getDoubleFrom(RatingBar ratingBar){
		return Double.valueOf(ratingBar.getRating());
		
	}
}
