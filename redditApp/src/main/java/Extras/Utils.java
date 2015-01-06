package Extras;

import android.graphics.Bitmap;

import com.android.volley.RequestQueue;

import java.util.Date;

public class Utils {

	/*	private static VolleyServices volleys;
	private static RequestQueue rq;
	private static Bitmap thumbail;
public static Bitmap LoadThumbail (String url, Context context){
		volleys = VolleyServices.getInstance(context);
		rq = volleys.getRequestQueue();

			ImageRequest image = new ImageRequest(url, new Response.Listener<Bitmap>() {

				@Override
				public void onResponse(Bitmap imge) {
					thumbail = imge;
				}
			}, 0, 0, null, new Response.ErrorListener() {

				@Override
				public void onErrorResponse(VolleyError arg0) {
					thumbail = null;
					
				}
			});
		rq.add(image);
		
		return thumbail;
	}
	*/
	
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



