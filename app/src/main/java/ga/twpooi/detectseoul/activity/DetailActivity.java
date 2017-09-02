package ga.twpooi.detectseoul.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import java.util.ArrayList;

import ga.twpooi.detectseoul.Classifier;
import ga.twpooi.detectseoul.R;

public class DetailActivity extends AppCompatActivity {

    private ArrayList<Classifier.Recognition> data;

    private TextView textView;
    private Toolbar toolbar;
    private TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        data = (ArrayList<Classifier.Recognition>)intent.getSerializableExtra("data");

        init();

    }

    private void init(){

        textView = (TextView)findViewById(R.id.tv);
        textView.setText(data.toString());

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbarTitle = (TextView)findViewById(R.id.toolbar_title);
        toolbarTitle.setText(data.get(0).getTitle());

    }

    public void hideToolbar() {
        toolbar.animate().translationY(-toolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));
    }
    public void showToolbar() {
        toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.no_change,R.anim.slide_down_info);
    }
}
