package ga.twpooi.detectseoul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

import ga.twpooi.detectseoul.activity.CameraActivity;

public class StartActivity extends BaseActivity {

    private ImageView backgroundImg;
    private TextView tv_title;
    private TextView tv_sub_title;
    private Button searchBtn, detectBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        init();

    }

    private void init(){

        backgroundImg = (ImageView)findViewById(R.id.background_img);
        tv_title = (TextView)findViewById(R.id.tv_title);
        tv_sub_title = (TextView)findViewById(R.id.tv_sub_title);
        searchBtn = (Button)findViewById(R.id.search_btn);
        detectBtn = (Button)findViewById(R.id.detect_btn);

        detectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(StartActivity.this, MainActivity.class);
//                startActivity(intent);
                showDetectDialog();
            }
        });

    }

    public void showDetectDialog(){
        String[] list = {
                "Gallery",
                "URL",
                "Camera"
        };
        new MaterialDialog.Builder(this)
                .title("선택")
                .items(list)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        switch (which){
                            case 0: // Gallery
                                showSnackbar("Gallery");
                                break;
                            case 1: // URL
                                showSnackbar("URL");
                                break;
                            case 2: { // Camera
                                Intent intent = new Intent(StartActivity.this, CameraActivity.class);
                                startActivity(intent);
                                break;
                            }
                        }
                    }
                })
                .show();
    }

}
