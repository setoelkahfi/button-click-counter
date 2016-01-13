package id.web.setoelkahfi.buttonclickcounter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity {

    private Button ourButton;
    private TextView ourMessage;
    private int timesButtonClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ourButton = (Button) findViewById(R.id.button);
        ourMessage = (TextView) findViewById(R.id.textView);

        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timesButtonClicked++;
                String result = "The button got tapped " + timesButtonClicked + " time";
                if (timesButtonClicked > 1) {
                    result += "s";
                }
                ourMessage.setText(result + ".");
            }
        };

        ourButton.setOnClickListener(ourOnClickListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast toastMessage = Toast.makeText(this, "Lu mau ngapain? Orang belum kelar.", Toast.LENGTH_LONG);
            toastMessage.show();
            return true;
        } else if (id == R.id.action_logout) {
            Toast toastMessage = Toast.makeText(this, "Lu mau logout ya? Monggoh.", Toast.LENGTH_LONG);
            toastMessage.show();
            return true;
        } else if (id == R.id.action_profile) {
            Toast toastMessage = Toast.makeText(this, "Ngintip profile elu.", Toast.LENGTH_LONG);
            toastMessage.show();
            return true;
        } else if (id == R.id.action_update) {
            Toast toastMessage = Toast.makeText(this, "OK, mulai dari nol lagi ya ...", Toast.LENGTH_LONG);
            ourMessage.setText("Klik lagi aja tombolnya ...");
            timesButtonClicked = 0;
            toastMessage.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}