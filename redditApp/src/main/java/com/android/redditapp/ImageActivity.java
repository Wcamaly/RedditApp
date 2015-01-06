package com.android.redditapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import Extras.VolleyThumbail;

public class ImageActivity extends ActionBarActivity {
    ImageLoader image;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		Bundle im = this.getIntent().getExtras();
        NetworkImageView img = (NetworkImageView) findViewById(R.id.timage);
        image = VolleyThumbail.getInstance(this.getApplicationContext()).getImageLoader();
        img.setImageUrl(im.get("image").toString(),image);

	}

	
}
