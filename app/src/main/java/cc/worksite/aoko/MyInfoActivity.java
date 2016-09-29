package cc.worksite.aoko;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MyInfoActivity extends AppCompatActivity {
    private Button login;
    private RelativeLayout my_profile,msg,setting,about_us,check_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        initView();
    }

    private void initView() {
//        login = (Button)findViewById(R.id.login);
//        my_profile = (RelativeLayout)findViewById(R.id.my_profile);
//        msg = (RelativeLayout)findViewById(R.id.msg);
//        setting = (RelativeLayout)findViewById(R.id.setting);
//        about_us = (RelativeLayout)findViewById(R.id.about_us);
//        check_update = (RelativeLayout)findViewById(R.id.check_update);

//        login.setOnClickListener(this);
//        findViewById(R.id.outter).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MyInfoActivity.this,"my profile is checked!",Toast.LENGTH_SHORT).show();
//            }
//        });
//        msg.setOnClickListener(this);
//        setting.setOnClickListener(this);
//        about_us.setOnClickListener(this);
//        check_update.setOnClickListener(this);
    }

//    @Override
//    public void onClick(View view) {
//switch (view.getId()){
//    case R.id.my_profile:
//        Toast.makeText(MyInfoActivity.this,"my profile is checked!",Toast.LENGTH_SHORT).show();
//        break;
//}
//    }
}
