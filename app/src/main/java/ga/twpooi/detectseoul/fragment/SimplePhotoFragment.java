package ga.twpooi.detectseoul.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ga.twpooi.detectseoul.R;

public class SimplePhotoFragment extends BaseFragment {

    // UI
    private View view;
    private Context context;

    private ImageView imageView;
    private String img;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setRetainInstance(true);
        if(getArguments() != null) {
            img = getArguments().getString("img");
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_simple_photo, container, false);
        context = container.getContext();

        init();


        return view;
    }

    private void init(){

        imageView = (ImageView)view.findViewById(R.id.image);
        Picasso.with(context)
                .load(img)
                .into(imageView);

    }



}
