package cn.edu.zjut.demo01;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private EditText UserName,UserPwd;
    private Button Submit,Cancel;
    private CheckBox PE, Music, Travel, Online;
    private TextView result;
    private Spinner Address;
    private static final String[] provience = {"浙江省", "江苏省", "上海市"};
    private ArrayAdapter<String> adp2Address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserName = (EditText) findViewById(R.id.inputUserName);
        UserPwd = (EditText) findViewById(R.id.inputUserPasswd);
        result = (TextView) findViewById((R.id.Result));
        PE = (CheckBox) findViewById(R.id.PE);
        Music = (CheckBox) findViewById(R.id.Music);
        Online = (CheckBox) findViewById(R.id.Online);
        Travel = (CheckBox) findViewById(R.id.Travel);


        Address = (Spinner) findViewById(R.id.Address);
        adp2Address = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, provience);
        Address.setAdapter(adp2Address);
        Address.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //按下确定后
        Submit = (Button) findViewById(R.id.Submit);
        View.OnClickListener Smt_Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UName = UserName.getText().toString();
                String UPwd = UserPwd.getText().toString();
                if(UName.length() == 0|| UPwd.length() == 0)
                {
                    result.setText("用户名或密码错误");
                }
                else
                {
                    String res = "";
                    res += "用户名: " + UName + "\n";
                    res += "用户密码: " + UPwd + "\n";
                    res += "爱好: ";
                    if(PE.isChecked())
                        res += "体育 ";
                    if(Music.isChecked())
                        res += "音乐 ";
                    if(Travel.isChecked())
                        res += "旅游 ";
                    if(Online.isChecked())
                        res += "上网 ";
                    res += "\n";

                    int pos = Address.getSelectedItemPosition();
                    res += "所在地: " + provience[pos] + "\n";
                    result.setText(res);
                }
            }
        };
        Submit.setOnClickListener(Smt_Listener);

        Cancel = (Button) findViewById(R.id.Cancel);
        View.OnClickListener Cel_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
            }
        };
        Cancel.setOnClickListener(Cel_listener);
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
