package sg.edu.rp.c346.id21023028.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //obtain shared preference instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //create shared preference editor
        SharedPreferences.Editor prefEdit = prefs.edit();
        //set key value pair in editor
        prefEdit.putString("greetings","Hello!");
        //save the changes to to sharedpreference
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //obtain shared preference instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //retrieve value from instance, provide default value if non is present
        String msg = prefs.getString("greetings","No greetings name");
        Toast.makeText(MainActivity.this, msg,
                Toast.LENGTH_LONG).show();
    }
}