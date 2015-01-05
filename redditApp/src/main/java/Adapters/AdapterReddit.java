package Adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.redditapp.R;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import Extras.VolleyThumbail;
import Model.Publish;
import Model.ViewHolderReddit;
//import android.R;

public class AdapterReddit extends ArrayAdapter<Publish> {

	Activity ctx;
	int lis;
	List<Publish> obj;
    ImageLoader imageloader;
	public AdapterReddit(Context context, int resource, List<Publish> objects) {
		super(context, resource, objects);
		this.ctx = (Activity) context;
		this.lis = resource;
		this.obj = objects;
	}
	
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolderReddit holder = null;
		
		if(convertView == null){
			LayoutInflater inflate = ctx.getLayoutInflater();
			convertView = inflate.inflate(this.lis, null);			
			holder = new ViewHolderReddit();
			
			holder.autor = (TextView) convertView.findViewById(R.id.author);
			holder.comments= (TextView) convertView.findViewById(R.id.comment);
			holder.date = (TextView) convertView.findViewById(R.id.date);
			holder.thumbail = (NetworkImageView) convertView.findViewById(R.id.thumbail);
			holder.title = (TextView) convertView.findViewById(R.id.titlepublish);
			
			convertView.setTag(holder);
	
		}else {
			holder = (ViewHolderReddit) convertView.getTag();
		}
		
		Publish publ = obj.get(position);
		
		if (publ != null ){
			holder.autor.setText(publ.getAutor());
			holder.comments.setText(publ.getCommnets());
			holder.date.setText(publ.getDate());
			holder.title.setText(publ.getTitle());
			if ((publ.getThumbail() != null )&& (publ.getThumbail() != "") ){
                Log.i("RedditActivity", publ.getThumbail().toString());
                imageloader = VolleyThumbail.getInstance(ctx).getImageLoader();
                holder.thumbail.setImageUrl(publ.getThumbail(),imageloader);
           }else
				holder.thumbail.setImageResource(R.drawable.ic_launcher);
			
		}
		return convertView;
	}


	

}
