package Extras;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;

/**
 * Created by wcamaly on 05/01/2015.
 */
public class VolleyThumbail {
    private static VolleyThumbail mInstance = null;
    private ImageLoader mImageLoader;
    private static VolleyServices volleys;
    private static RequestQueue rq;

    private VolleyThumbail(Context context) {
       // mRequestQueue = Volley.newRequestQueue(MyApplication.getAppContext());
        volleys = VolleyServices.getInstance(context);
        rq = volleys.getRequestQueue();

        mImageLoader = new ImageLoader(this.rq, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);
            public void putBitmap(String url, Bitmap bitmap) {
                mCache.put(url, bitmap);
            }
            public Bitmap getBitmap(String url) {
                return mCache.get(url);
            }
        });
    }


    public static VolleyThumbail getInstance(Context context){
        if(mInstance == null){
            mInstance = new VolleyThumbail(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        return this.rq;
    }

    public ImageLoader getImageLoader(){
        return this.mImageLoader;
    }
}

