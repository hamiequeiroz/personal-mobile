package br.edu.uea.android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;
 
public class ImageAdapter extends BaseAdapter {
	
private Context Context;
 
private int[] Images = {  R.drawable.ombros1, R.drawable.ombros2, R.drawable.ombros3,
        R.drawable.ombros4,R.drawable.ombros5, R.drawable.ombros6,
       R.drawable.ombros7, R.drawable.ombros8, R.drawable.ombros9,
       R.drawable.ombros10, R.drawable.ombros11, R.drawable.ombros12,
       R.drawable.ombros13, R.drawable.ombros14, R.drawable.ombros15,
       R.drawable.ombros16, R.drawable.ombros17};







public ImageAdapter(Context c) {
this.Context = c;
}
 
public int getCount() {
return this.Images.length;
}
 
public Object getItem(int position) {
return position;
}
 
public long getItemId(int position) {
return position;
}
 
public View getView(int position, View convertView, ViewGroup parent) {
ImageView img = new ImageView(this.Context);
img.setImageResource(this.Images[position]);
img.setScaleType(ImageView.ScaleType.FIT_XY);
img.setLayoutParams(new Gallery.LayoutParams(165, 165));
return img;
}
 
public float getScale(boolean focused, int offset) {
return Math.max(0, 1.0f / (float) Math.pow(2, Math.abs(offset)));
}
}