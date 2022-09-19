package br.edu.uea.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import android.widget.Gallery.LayoutParams;
import br.edu.uea.android.ListaImagensCostas.ImageAdapter;

public class ListaImagensBraco extends Activity implements
AdapterView.OnItemSelectedListener, ViewSwitcher.ViewFactory {
int count=0;
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
requestWindowFeature(Window.FEATURE_NO_TITLE);

setContentView(R.layout.mostraimgexercicios);

mSwitcher = (ImageSwitcher) findViewById(R.id.switcher);
mSwitcher.setFactory(this);
mSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
        android.R.anim.fade_in));
mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
        android.R.anim.fade_out));

Gallery g = (Gallery) findViewById(R.id.gallery);
g.setAdapter(new ImageAdapter(this));
g.setOnItemSelectedListener(this);
}

public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
    		
if (count==0){
int posicao = getIntent().getIntExtra("posicao", -1);

	mSwitcher.setImageResource(mImageIds[posicao]);
	count++;
}else{
	
	mSwitcher.setImageResource(mImageIds[position]);
}
}

public void onNothingSelected(AdapterView<?> parent) {
}

public View makeView() {
ImageView i = new ImageView(this);
i.setBackgroundColor(0xFF000000);
i.setScaleType(ImageView.ScaleType.FIT_CENTER);
i.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.MATCH_PARENT,
        LayoutParams.MATCH_PARENT));
return i;
}

private ImageSwitcher mSwitcher;

public class ImageAdapter extends BaseAdapter {
public ImageAdapter(Context c) {
    mContext = c;
}

public int getCount() {
    return mThumbIds.length;
}

public Object getItem(int position) {
    return position;
}

public long getItemId(int position) {
    return position;
}

public View getView(int position, View convertView, ViewGroup parent) {
    ImageView i = new ImageView(mContext);

    i.setImageResource(mThumbIds[position]);
    i.setAdjustViewBounds(true);
    i.setLayoutParams(new Gallery.LayoutParams(
            LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    i.setBackgroundResource(R.drawable.principal);
    return i;
}

private Context mContext;

}

private Integer[] mThumbIds = {
	 R.drawable.biceps1, R.drawable.biceps2, R.drawable.biceps3,
	 R.drawable.biceps4, R.drawable.biceps5
    };

private Integer[] mImageIds = {
		R.drawable.biceps1, R.drawable.biceps2, R.drawable.biceps3,
		 R.drawable.biceps4, R.drawable.biceps5
    };

}