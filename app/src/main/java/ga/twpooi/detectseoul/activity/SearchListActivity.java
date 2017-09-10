package ga.twpooi.detectseoul.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ga.twpooi.detectseoul.R;

public class SearchListActivity extends AppCompatActivity {

    private String searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);

        searchText = getIntent().getStringExtra("search");

        ((TextView)findViewById(R.id.tv_text)).setText(searchText);

    }
}
