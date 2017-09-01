package ga.twpooi.detectseoul.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import ga.twpooi.detectseoul.Classifier;
import ga.twpooi.detectseoul.R;

public class DetailActivity extends AppCompatActivity {

    private ArrayList<Classifier.Recognition> data;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        data = (ArrayList<Classifier.Recognition>)intent.getSerializableExtra("data");

        textView = (TextView)findViewById(R.id.tv);
        textView.setText(data.toString());

    }
}
