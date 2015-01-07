package Extras;

import android.graphics.Bitmap;

import com.android.volley.RequestQueue;

import java.util.Date;

public class Utils {

	
	static public String ChangeDate (Long utc){
	
		Date date = new Date(utc);
		return date.toLocaleString();
		 
	}
	
	public static Boolean hasImage(String url) {
		Boolean image = false;
		if (url != null) {
			if (url.indexOf(".jpg") != -1 || url.indexOf(".png")!= -1 || url.indexOf(".gif") != -1 ||
					url.indexOf(".JPG") != -1 || url.indexOf(".PNG")!= -1 || url.indexOf(".GIF") != -1	)
					image = true;
		}
		return image;
	  }
	
	
	
}



