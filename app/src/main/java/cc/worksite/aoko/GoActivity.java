package cc.worksite.aoko;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class GoActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView sub_title1, sub_title2, sub_title3, sub_title4, sub_title5,
            sub_title6, sub_title7, sub_title8;
    private ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_go);

        sub_title1 = (TextView) findViewById(R.id.one).findViewById(R.id.textView1);
        sub_title2 = (TextView) findViewById(R.id.one).findViewById(R.id.textView2);
        sub_title3 = (TextView) findViewById(R.id.one).findViewById(R.id.textView3);
        sub_title4 = (TextView) findViewById(R.id.one).findViewById(R.id.textView4);
        sub_title5 = (TextView) findViewById(R.id.two).findViewById(R.id.textView1);
        sub_title6 = (TextView) findViewById(R.id.two).findViewById(R.id.textView2);
        sub_title7 = (TextView) findViewById(R.id.two).findViewById(R.id.textView3);
        sub_title8 = (TextView) findViewById(R.id.two).findViewById(R.id.textView4);

        sub_title1.setText("大量批发山东嘎啦苹果\n" + "TEL:153****4032");
        sub_title2.setText("铁观音茶叶（安溪）国际农产品\n" + "TEL:153****4025");
        sub_title3.setText("邮寄虫草不翼而飞 快递丢失怎么赔偿");
        sub_title4.setText("俄罗斯小麦蚜虫首次入侵澳大利亚 澳粮食产业遭遇威胁");
        sub_title5.setText("天津稻田植保首次用上无人机");
        sub_title6.setText("大量批发山东嘎啦苹果\n" + "TEL:153****4013");
        sub_title7.setText("欧盟成员国投票通过一系列草甘膦使用限制措施");
        sub_title8.setText("铁观音茶叶（安溪）国际农产品\n" + "TEL:153****1232");
        sub_title1.setOnClickListener(this);
        sub_title2.setOnClickListener(this);
        img_back = (ImageView) findViewById(R.id.back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.textView1:
                intent.setClass(GoActivity.this, DialActivity.class);
                bundle.putInt("key", 1);
                bundle.putString("value", "大量批发山东嘎啦苹果");
                intent.putExtras(bundle);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                break;
            case R.id.textView2:
                intent.setClass(GoActivity.this, DialActivity.class);
                bundle.putInt("key", 2);
                bundle.putString("value", "铁观音茶叶（安溪）国际农产品");
                intent.putExtras(bundle);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                break;
        }
    }
}
