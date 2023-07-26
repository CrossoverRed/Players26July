package sg.edu.rp.c326.id22015010.players26july;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    EditText etUName;
    ToggleButton tbMode;
    Button btnLoadUName, btnSaveUName;
    SharedPreferences myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUName = findViewById(R.id.etUserName);
        tbMode = findViewById(R.id.toggleMode); // Assign the ToggleButton view here
        btnLoadUName = findViewById(R.id.btnLoad); // Assign the Button view here
        btnSaveUName = findViewById(R.id.btnSave); // Assign the Button view here
        myPref = getPreferences(MODE_PRIVATE);

        btnLoadUName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg;
                if (tbMode.isChecked()){
                    msg = myPref.getString("MultiName", "Player X");
                }else{
                    msg = myPref.getString("SoloName", "Solo Player X");
                }
                etUName.setText(msg);
            }
        });

        btnSaveUName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor prefEdit = myPref.edit();
                String saveMsg = etUName.getText().toString();
                if (tbMode.isChecked()){
                    prefEdit.putString("MultiName", saveMsg);
                }else {
                    prefEdit.putString("SoloName", saveMsg);
                }
                prefEdit.commit();
            }
        });

    }
}