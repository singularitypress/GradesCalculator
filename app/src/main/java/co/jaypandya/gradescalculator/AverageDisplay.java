package co.jaypandya.gradescalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class AverageDisplay extends AppCompatActivity {

    private TextView mAverageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAverageText = (TextView)findViewById(R.id.average_grade);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            float average = extras.getFloat("average");
            int ios = extras.getInt("ios");
            int android = extras.getInt("android");
            int windows = extras.getInt("windows");
            mAverageText.setText(
                    "iOS: "+ios+"%\n"+
                    "Android: "+android+"%\n"+
                    "Windows Mobile: "+windows+"%\n"+
                    "Average: "+average+"%");
        }
    }

}
