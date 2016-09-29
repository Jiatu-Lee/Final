package cc.worksite.aoko;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import cc.worksite.aoko.fragment.HomeFragment;
import cc.worksite.aoko.fragment.InfoFragment;
import cc.worksite.aoko.fragment.MineFragment;
import cc.worksite.aoko.fragment.ReleaseFragment;


public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private Button show_name;
    private FragmentManager fragmentManager;
    private FragmentTabHost tabHost;
    private LayoutInflater layoutInflater;
    private Class fragmentArray[] = {HomeFragment.class, ReleaseFragment.class, InfoFragment.class, MineFragment.class};
    private int mImageViewArray[] = {R.drawable.home_png, R.drawable.release_png, R.drawable.info_png,
            R.drawable.mine_png};
    private String mTextviewArray[] = {"首页", "发布", "消息", "我的"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_AppCompat_Launcher);
//        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE); //声明使用自定义标题
        setContentView(R.layout.activity_main);
//        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_view);//自定义布局赋值
        show_name = (Button) findViewById(R.id.login_btn);

        initView();
    }

    Intent intent = getIntent();

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent result) {
        if (resultCode != RESULT_OK) {
            String phone = intent.getStringExtra("phone");
            show_name.setText(phone);

        }
    }

    /**
     * 初始化组件
     */
    private void initView() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setLogo(R.drawable.release_png);
//        toolbar.setTitle("My Title");
//        toolbar.setSubtitle("Sub title");
//        toolbar.setNavigationIcon(R.drawable.mine_png);
//        getLayoutInflater().inflate(R.layout.title_view, toolbar);
        layoutInflater = LayoutInflater.from(this);
        tabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.tabcontent);
        int count = fragmentArray.length;

        for (int i = 0; i < count; i++) {
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
            tabHost.addTab(tabSpec, fragmentArray[i], null);

            tabHost.getTabWidget().getChildAt(i);

        }
        tabHost.setBackgroundResource(R.color.white);
        tabHost.setCurrentTab(0);
    }

    /**
     * 给Tab按钮设置图标和文字
     */
    private View getTabItemView(int index) {
        View view = layoutInflater.inflate(R.layout.tab_item_view, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageViewArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTextviewArray[index]);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mine:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MyInfoActivity.class);
                startActivity(intent);
                break;
            case R.drawable.home_png:
                break;
            case R.drawable.release_png:
                ((TextView) (findViewById(R.id.show_text))).setText("发布");
                break;
            case R.drawable.info_png:
                ((TextView) (findViewById(R.id.show_text))).setText("信息");

                break;
            case R.drawable.mine_png:
                ((TextView) (findViewById(R.id.show_text))).setText("我的");

                break;
        }
    }
}
