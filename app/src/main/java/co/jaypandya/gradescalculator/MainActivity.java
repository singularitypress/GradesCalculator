package co.jaypandya.gradescalculator;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "Assignment 1 ";

    private Button mAverageButton;
    private Button mAboutButton;
    private Button mMinButton;
    private Button mAvgButton;
    private Button mMaxButton;
    private EditText mIosGrade;
    private EditText mAndroidGrade;
    private EditText mWindowsGrade;
    private int iosGrade = 1;
    private int androidGrade = 1;
    private int windowsGrade = 1;
    private float average = 1;

    String[] androidColleges =
            {
                    "Humber Valley College",
                    "Hummingbird Academy",
                    "Harrington High",
                    "Georgian Bay College",
                    "Saracuse Academy",
                    "St-Vincent College",
                    "Seneca College",
                    "Seneca Markham",
                    "Seneca York"
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.i(TAG, "Jay Pandya 062791132");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, androidColleges);
        AutoCompleteTextView acTextView = (AutoCompleteTextView)findViewById(R.id.AndroidColleges);
        acTextView.setThreshold(1);
        acTextView.setAdapter(adapter);

        mIosGrade = (EditText)findViewById(R.id.ios_grade);
        mAndroidGrade = (EditText)findViewById(R.id.android_grade);
        mWindowsGrade = (EditText)findViewById(R.id.windows_grade);

        mAverageButton = (Button)findViewById(R.id.average_button);
        mAboutButton = (Button)findViewById(R.id.about_button);
        mMinButton = (Button)findViewById(R.id.min_button);
        mAvgButton = (Button)findViewById(R.id.avg_button);
        mMaxButton = (Button)findViewById(R.id.max_button);

        mAverageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                iosGrade = Integer.parseInt(mIosGrade.getText().toString());
                androidGrade = Integer.parseInt(mAndroidGrade.getText().toString());
                windowsGrade = Integer.parseInt(mWindowsGrade.getText().toString());

                if(iosGrade > 100 || androidGrade > 100 || windowsGrade > 100 || iosGrade < 0 || androidGrade < 0 || windowsGrade < 0) {
                    Snackbar.make(v, "Please enter a number between 1-100", Snackbar.LENGTH_LONG).show();
                } else {
                    average = (iosGrade+androidGrade+windowsGrade)/3;
                    Intent i = new Intent(getApplicationContext(), AverageDisplay.class);
                    i.putExtra("average", average);
                    i.putExtra("ios", iosGrade);
                    i.putExtra("android", androidGrade);
                    i.putExtra("windows", windowsGrade);
                    startActivity(i);
                }
            }
        });

        mAboutButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(i);
            }
        });

        mMinButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            iosGrade = Integer.parseInt(mIosGrade.getText().toString());
            androidGrade = Integer.parseInt(mAndroidGrade.getText().toString());
            windowsGrade = Integer.parseInt(mWindowsGrade.getText().toString());

            Intent i = new Intent(getApplicationContext(), MinMaxAvg.class);

            if (iosGrade < androidGrade && iosGrade < windowsGrade){
                i.putExtra("num", iosGrade);
                startActivity(i);
            } else if (androidGrade < iosGrade && androidGrade < windowsGrade){
                i.putExtra("num", androidGrade);
                startActivity(i);
            } else if (windowsGrade < iosGrade && windowsGrade < androidGrade){
                i.putExtra("num", windowsGrade);
                startActivity(i);
            }
            }
        });

        mAvgButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                iosGrade = Integer.parseInt(mIosGrade.getText().toString());
                androidGrade = Integer.parseInt(mAndroidGrade.getText().toString());
                windowsGrade = Integer.parseInt(mWindowsGrade.getText().toString());

                Intent i = new Intent(getApplicationContext(), AverageDisplay.class);
                if(iosGrade > 100 || androidGrade > 100 || windowsGrade > 100 || iosGrade < 0 || androidGrade < 0 || windowsGrade < 0) {
                    Snackbar.make(v, "Please enter a number between 1-100", Snackbar.LENGTH_LONG).show();
                } else {
                    average = (iosGrade + androidGrade + windowsGrade) / 3;
                    i.putExtra("average", average);
                    i.putExtra("ios", iosGrade);
                    i.putExtra("android", androidGrade);
                    i.putExtra("windows", windowsGrade);
                    startActivity(i);
                }
            }
        });

        mMaxButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                iosGrade = Integer.parseInt(mIosGrade.getText().toString());
                androidGrade = Integer.parseInt(mAndroidGrade.getText().toString());
                windowsGrade = Integer.parseInt(mWindowsGrade.getText().toString());

                Intent i = new Intent(getApplicationContext(), MinMaxAvg.class);

                if (iosGrade > androidGrade && iosGrade > windowsGrade){
                    i.putExtra("num", iosGrade);
                    startActivity(i);
                } else if (androidGrade > iosGrade && androidGrade > windowsGrade){
                    i.putExtra("num", androidGrade);
                    startActivity(i);
                } else if (windowsGrade > iosGrade && windowsGrade > androidGrade){
                    i.putExtra("num", windowsGrade);
                    startActivity(i);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        View parentLayout = findViewById(android.R.id.content);

        Intent i = new Intent(getApplicationContext(), MinMaxAvg.class);

        switch(item.getItemId()){
            case R.id.action_settings:
                this.aboutDialog();
                break;
            case R.id.min_settings:
                iosGrade = Integer.parseInt(mIosGrade.getText().toString());
                androidGrade = Integer.parseInt(mAndroidGrade.getText().toString());
                windowsGrade = Integer.parseInt(mWindowsGrade.getText().toString());
                if (iosGrade < androidGrade && iosGrade < windowsGrade){
                    i.putExtra("num", iosGrade);
                } else if (androidGrade < iosGrade && androidGrade < windowsGrade){
                    i.putExtra("num", androidGrade);
                } else if (windowsGrade < iosGrade && windowsGrade < androidGrade){
                    i.putExtra("num", windowsGrade);
                }
                this.startActivity(i);
                break;
            case R.id.avg_settings:
                iosGrade = Integer.parseInt(mIosGrade.getText().toString());
                androidGrade = Integer.parseInt(mAndroidGrade.getText().toString());
                windowsGrade = Integer.parseInt(mWindowsGrade.getText().toString());
                int avg = (iosGrade+androidGrade+windowsGrade)/3;
                i.putExtra("num", avg);
                this.startActivity(i);
                break;
            case R.id.max_settings:
                iosGrade = Integer.parseInt(mIosGrade.getText().toString());
                androidGrade = Integer.parseInt(mAndroidGrade.getText().toString());
                windowsGrade = Integer.parseInt(mWindowsGrade.getText().toString());
                if (iosGrade > androidGrade && iosGrade > windowsGrade){
                    i.putExtra("num", iosGrade);
                } else if (androidGrade > iosGrade && androidGrade > windowsGrade){
                    i.putExtra("num", androidGrade);
                } else if (windowsGrade > iosGrade && windowsGrade > androidGrade){
                    i.putExtra("num", windowsGrade);
                }
                this.startActivity(i);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void aboutDialog() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        AboutDialog abt = AboutDialog.newInstance(R.string.about_text);
        abt.show(ft, "Start");
    }
}
