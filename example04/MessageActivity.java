package cn.edu.zjut.demo04;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MessageActivity extends ActionBarActivity {
    private TextView name, ph_num, email;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        name = (TextView) findViewById(R.id.name);
        ph_num = (TextView) findViewById(R.id.ph_num);
        email = (TextView) findViewById(R.id.email);
        back = (Button) findViewById(R.id.back);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null) {
            String Name = bundle.getString("Name");
            String Phone_num = bundle.getString("Phone_number");
            String Email = bundle.getString("Email");
            name.setText(Name);
            ph_num.setText(Phone_num);
            email.setText(Email);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bback = new Intent(MessageActivity.this, MainActivity.class);
                startActivity(bback);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_message, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
