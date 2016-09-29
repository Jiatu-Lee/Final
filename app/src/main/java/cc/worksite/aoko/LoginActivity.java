package cc.worksite.aoko;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cc.worksite.aoko.util.ToastUtil;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText phone_num, pwd;
    private Button btn_login;
    private TextView forget, register;
    String phone, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(LoginActivity.this, "1ada93470281020adc01c3a44f372fe1");
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        phone_num = (EditText) findViewById(R.id.phone_num);
        pwd = (EditText) findViewById(R.id.pwd);
        btn_login = (Button) findViewById(R.id.btn_login);
        register = (TextView) findViewById(R.id.register);
        forget = (TextView) findViewById(R.id.forget);

        btn_login.setTextColor(Color.argb(255, 255, 255, 255));
        register.setTextColor(Color.argb(255, 63, 81, 181));
        forget.setTextColor(Color.argb(255, 63, 81, 181));
        btn_login.setOnClickListener(this);
        register.setOnClickListener(this);
        forget.setOnClickListener(this);
    }

    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobiles) {
        /*
        移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
        联通：130、131、132、152、155、156、185、186
        电信：133、153、180、189、（1349卫通）
        虚拟运营商：170、177
        总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
        */
        String telRegex = "[1][3578]\\d{9}";
        //"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }
    private void Login() {
        BmobUser user = new BmobUser();
        user.setUsername(phone);
        user.setPassword(password);
//        BmobUser.loginByAccount("username", "用户密码", new LogInListener<BmobUser>() {
//
//            @Override
//            public void done(BmobUser user, BmobException e) {
//                if(user!=null){
//                    Log.i("smile","用户登陆成功");
//                }
//            }
//        });
        user.login(new SaveListener<BmobUser>() {
            @Override
            public void done(BmobUser bmobUser, BmobException e) {
                if (e != null) {
                    ToastUtil.show(LoginActivity.this, "用户名或密码错误", 0);
                } else {
                    ToastUtil.show(LoginActivity.this, "登录成功！", 0);
                    //Intent intent = new Intent();
                    //intent.putExtra("phone", phone);
                    //setResult(RESULT_OK, intent);
                    finish();
                    LoginActivity.this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                }
            }
        });
    }
    @Override
    public void onClick(View view) {
        phone = phone_num.getText().toString();
        password = pwd.getText().toString();
        switch (view.getId()) {
            case R.id.btn_login:
                if (isMobileNO(phone)) {
                  Login();
                } else {
                    ToastUtil.show(LoginActivity.this, "请输入正确的手机号码", 0);
                }

                break;
            case R.id.register:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                break;
            case R.id.forget:
                Dialog dialog = new AlertDialog.Builder(LoginActivity.this).setIcon(android.R.drawable.stat_sys_warning)
                        .setTitle("提示").setMessage("此处之后再做处理").create();
                dialog.show();
                break;
        }

    }



}
