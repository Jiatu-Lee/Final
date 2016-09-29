package cc.worksite.aoko;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class HelpCenterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView back_help;
    private TextView means, membership, complaint, publish, contact, modify, not_through, privileges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_help_center);
        back_help = (ImageView) findViewById(R.id.back_help);
        means = (TextView) findViewById(R.id.means);
        membership = (TextView) findViewById(R.id.membership);
        complaint = (TextView) findViewById(R.id.complaint);
        publish = (TextView) findViewById(R.id.publish);
        contact = (TextView) findViewById(R.id.contact);
        modify = (TextView) findViewById(R.id.modify);
        not_through = (TextView) findViewById(R.id.not_through);
        privileges = (TextView) findViewById(R.id.privileges);

        means.setTextColor(Color.argb(255, 63, 81, 181));
        membership.setTextColor(Color.argb(255, 63, 81, 181));
        complaint.setTextColor(Color.argb(255, 63, 81, 181));
        publish.setTextColor(Color.argb(255, 63, 81, 181));
        contact.setTextColor(Color.argb(255, 63, 81, 181));
        modify.setTextColor(Color.argb(255, 63, 81, 181));
        not_through.setTextColor(Color.argb(255, 63, 81, 181));
        privileges.setTextColor(Color.argb(255, 63, 81, 181));

        initListener();

    }

    private void initListener() {
        back_help.setOnClickListener(this);
        means.setOnClickListener(this);
        membership.setOnClickListener(this);
        complaint.setOnClickListener(this);
        publish.setOnClickListener(this);
        contact.setOnClickListener(this);
        modify.setOnClickListener(this);
        not_through.setOnClickListener(this);
        privileges.setOnClickListener(this);
    }

    private void helpDialog(String title, String message) {
        Dialog dialog = new AlertDialog.Builder(HelpCenterActivity.this)
                .setTitle(title).setMessage(message).create();
        dialog.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_help:
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                break;
            case R.id.means:
                helpDialog("防诈骗手段", "blah blah blah");
                break;
            case R.id.membership:
                helpDialog("会员服务协议", "blah blah blah");
                break;
            case R.id.complaint:
                helpDialog("举报与投诉", "blah blah blah");
                break;
            case R.id.publish:
                helpDialog("如何发布信息", "blah blah blah");
                break;
            case R.id.contact:
                helpDialog("如何联系买(卖)家", "blah blah blah");
                break;
            case R.id.modify:
                helpDialog("如何修改个人信息", "blah blah blah");
                break;
            case R.id.not_through:
                helpDialog("实名认证未予通过", "blah blah blah");
                break;
            case R.id.privileges:
                helpDialog("会员特权", "blah blah blah");
                break;


        }

    }
}
