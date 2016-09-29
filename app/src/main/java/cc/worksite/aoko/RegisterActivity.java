package cc.worksite.aoko;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cc.worksite.aoko.fragment.HomeFragment;
import cc.worksite.aoko.util.LogUtil;
import cc.worksite.aoko.util.ToastUtil;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText num, code;
    private Button send, register;
    private TextView one, two;
    String ver_code;
    String phone;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);
        num = (EditText) findViewById(R.id.num);
        code = (EditText) findViewById(R.id.code);
        send = (Button) findViewById(R.id.send);
        register = (Button) findViewById(R.id.register);
        one = (TextView) findViewById(R.id.one);
        two = (TextView) findViewById(R.id.two);

        send.setTextColor(Color.argb(255, 255, 255, 255));
        register.setTextColor(Color.argb(255, 255, 255, 255));
        one.setTextColor(Color.argb(255, 63, 81, 181));
        two.setTextColor(Color.argb(255, 63, 81, 181));

        send.setOnClickListener(this);
        register.setOnClickListener(this);
        one.setClickable(true);
        one.setFocusable(true);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new AlertDialog.Builder(RegisterActivity.this).setIcon(android.R.drawable.stat_sys_warning)
                        .setTitle("提示").setMessage("此处之后再做处理").create();
                dialog.show();
            }
        });
        two.setClickable(true);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);

            }
        });

    }

    public static boolean isMobileNO(String mobiles) {
        String telRegex = "[1][3578]\\d{9}";
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }

    @Override
    public void onClick(View view) {
        phone = num.getText().toString();
        ver_code = code.getText().toString();

        password = phone.substring(phone.length() - 6);
        switch (view.getId()) {
            case R.id.send:
                if (isMobileNO(phone)) {
                    BmobSMS.requestSMSCode(phone, "AoKe", new QueryListener<Integer>() {
                        @Override
                        public void done(Integer smsId, BmobException ex) {
                            if (ex == null) {
                                send.setClickable(false);
                                send.setBackgroundColor(Color.GRAY);
                                Toast.makeText(RegisterActivity.this, "验证码发送成功，请在5分钟内使用", Toast.LENGTH_SHORT).show();

                                new CountDownTimer(60000, 1000) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        send.setBackgroundResource(R.color.gray);
                                        send.setText(millisUntilFinished / 1000 + "秒");
                                    }

                                    @Override
                                    public void onFinish() {
                                        send.setClickable(true);
                                        send.setBackgroundResource(R.drawable.btn_login_bg);
                                        send.setText("重新发送");
                                    }
                                }.start();
                            } else {
                                ToastUtil.show(RegisterActivity.this, "请稍后再试，错误代码：" + ex.toString(), 0);
                            }
                        }
                    });

                } else {
                    ToastUtil.show(RegisterActivity.this, "请输入正确的手机号码", 0);
                }
                break;
            case R.id.register:
                if (ver_code != null) {
                    BmobUser user = new BmobUser();
                    user.signOrLogin(ver_code, new SaveListener<BmobUser>() {

                        @Override
                        public void done(BmobUser user,BmobException e) {
                            if(e==null){
                                user.setMobilePhoneNumber(phone);
                                user.setMobilePhoneNumberVerified(true);
                                user.setUsername("NeuEC_"+password);
                                user.setPassword(password);
                                Intent intent = new Intent();
                                intent.setClass(RegisterActivity.this, HomeFragment.class);
                                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                                ToastUtil.show(RegisterActivity.this,"注册成功,密码默认为手机号码后6位！",0);
                            }else{
                                ToastUtil.show(RegisterActivity.this, "请稍后重试！错误代码："+e.toString(), 0);
                            }

                        }

                    });
//
//                    BmobSMS.verifySmsCode(phone, ver_code, new UpdateListener() {
//                        @Override
//                        public void done(BmobException ex) {
//                            if (ex == null) {
//                                ToastUtil.show(RegisterActivity.this, "注册成功！", 0);
//                                Intent intent = new Intent();
//                                intent.setClass(RegisterActivity.this, HomeFragment.class);
//                                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
//                            } else {
//                                Log.d("debug", ex.toString() + "--->" + ver_code);
//                                ToastUtil.show(RegisterActivity.this, "请稍后重试！错误代码："+ex.toString(), 0);
//                            }
//                        }
//                    });
                } else {
                    ToastUtil.show(RegisterActivity.this, "请输入正确的验证码！", 0);
                }
                break;
        }
    }
}
