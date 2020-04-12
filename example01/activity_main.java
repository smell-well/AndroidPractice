package cn.edu.zjut.demo01;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private EditText UserName,UserPwd;
    private Button Submit;
    private CheckBox PE, Music, Read, Online;
    private RadioButton Male, Female;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Submit = (Button) findViewById(R.id.Submit);
        View.OnClickListener Smt_Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserName = (EditText) findViewById(R.id.inputUserName);
                UserPwd = (EditText) findViewById(R.id.inputUserPasswd);
                result = (TextView) findViewById((R.id.Result));
                PE = (CheckBox) findViewById(R.id.PE);
                Music = (CheckBox) findViewById(R.id.Music);
                Online = (CheckBox) findViewById(R.id.Online);
                Read = (CheckBox) findViewById(R.id.Read);
                Male = (RadioButton) findViewById(R.id.Male);
                Female = (RadioButton) findViewById(R.id.Female);
                String UName = UserName.getText().toString();
                String UPwd = UserPwd.getText().toString();
                if(UName.length() == 0|| UPwd.length() == 0)
                {
                    result.setText("注册信息不完整");
                }
                else
                {
                    String res = "注册信息如下\n";
                    res += "用户名: " + UName + "\n";
                    res += "用户密码: " + UPwd + "\n";
                    if(Male.isChecked())
                        res += "性别: " + "男\n";
                    if(Female.isChecked())
                        res += "性别: " + "女\n";
                    res += "爱好: ";
                    if(PE.isChecked())
                        res += "体育 ";
                    if(Music.isChecked())
                        res += "音乐 ";
                    if(Read.isChecked())
                        res += "阅读 ";
                    if(Online.isChecked())
                        res += "上网 ";
                    result.setText(res);
                }
            }
        };
        Submit.setOnClickListener(Smt_Listener);
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
