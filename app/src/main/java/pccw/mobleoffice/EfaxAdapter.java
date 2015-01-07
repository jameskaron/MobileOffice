package pccw.mobleoffice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 80575749 on 2015/1/7.
 */
public class EfaxAdapter extends ArrayAdapter<Efax> {

    private int resourecId;

    public EfaxAdapter(Context context, int resource, List<Efax> objects) {
        super(context, resource, objects);
        resourecId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Efax efax = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourecId, null);
        ImageView efaxImage = (ImageView) view.findViewById(R.id.efax_image);
        TextView efaxText = (TextView) view.findViewById(R.id.efax_text);
        efaxImage.setImageResource(efax.getImageId());
        efaxText.setText(efax.getName());
        return view;
    }
}
