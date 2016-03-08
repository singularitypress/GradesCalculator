package co.jaypandya.gradescalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MinMaxAvg extends AppCompatActivity {

    private TextView mMinMaxAvg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_min_max_avg);

        mMinMaxAvg = (TextView)findViewById(R.id.min_max_avg);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            int num = extras.getInt("num");
            mMinMaxAvg.setText(""+num+"%");
        }
    }
}
