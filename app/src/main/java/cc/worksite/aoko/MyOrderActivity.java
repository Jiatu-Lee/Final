package cc.worksite.aoko;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

public class MyOrderActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout detail1, detail2, detail3, detail4, detail5, detail6, detail7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_order);
        findViewById(R.id.back).setOnClickListener(this);
        detail1 = (RelativeLayout) findViewById(R.id.info_detail1);
        detail2 = (RelativeLayout) findViewById(R.id.info_detail2);
        detail3 = (RelativeLayout) findViewById(R.id.info_detail3);
        detail4 = (RelativeLayout) findViewById(R.id.info_detail4);
        detail5 = (RelativeLayout) findViewById(R.id.info_detail5);
        detail6 = (RelativeLayout) findViewById(R.id.info_detail6);
        detail7 = (RelativeLayout) findViewById(R.id.info_detail7);
        detail1.setOnClickListener(this);
        detail2.setOnClickListener(this);
        detail3.setOnClickListener(this);
        detail4.setOnClickListener(this);
        detail5.setOnClickListener(this);
        detail6.setOnClickListener(this);
        detail7.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.back:
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                break;
            case R.id.info_detail1:
                showDiaLog();
                break;
            case R.id.info_detail2:
                showDiaLog();
                break;
            case R.id.info_detail3:
                showDiaLog();
                break;
            case R.id.info_detail4:
                showDiaLog();
                break;
            case R.id.info_detail5:
                showDiaLog();
                break;
            case R.id.info_detail6:
                showDiaLog();
                break;
            case R.id.info_detail7:
                showDiaLog();
                break;

        }

    }

    private void showDiaLog() {
        Dialog dialog = new AlertDialog.Builder(this).setIcon(android.R.drawable.stat_sys_warning)
                .setTitle("提示").setMessage("此处之后再做处理").create();
        dialog.show();
    }
}
