package app.skripsi.hva.aplikasijualbelijasa.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import app.skripsi.hva.aplikasijualbelijasa.R;
import app.skripsi.hva.aplikasijualbelijasa.app.AppController;
import app.skripsi.hva.aplikasijualbelijasa.data.GetIklan;

import java.util.List;

public class CustomListProfil extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<GetIklan> getIklanItem;
    ImageLoader imageLoader;
    private FragmentManager supportFragmentManager;

    public CustomListProfil(Activity activity, List<GetIklan> getIklanItem) {
        this.activity = activity;
        this.getIklanItem = getIklanItem;
    }

    @Override
    public int getCount() {
        return getIklanItem.size();
    }

    @Override
    public Object getItem(int location) {
        return getIklanItem.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.layout_iklan_profil, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.imageViewJasa);
        TextView nama = (TextView) convertView.findViewById(R.id.txtNamaJasa);
        TextView deskripsi = (TextView) convertView.findViewById(R.id.txtDeskripsi);
        TextView harga = (TextView) convertView.findViewById(R.id.txtHarga);

        GetIklan getIklan = getIklanItem.get(position);

        thumbNail.setImageUrl(getIklan.getImage(), imageLoader);
        nama.setText(getIklan.getNama_jasa());
        deskripsi.setText(getIklan.getDeskripsi());
        harga.setText("Rp " + getIklan.getHarga());

        return convertView;
    }


    public FragmentManager getSupportFragmentManager() {
        return supportFragmentManager;
    }
}
