package cc.worksite.aoko.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cc.worksite.aoko.FavoritesActivity;
import cc.worksite.aoko.HelpCenterActivity;
import cc.worksite.aoko.IntegralActivity;
import cc.worksite.aoko.LoginActivity;
import cc.worksite.aoko.MyBalanceActivity;
import cc.worksite.aoko.MyOrderActivity;
import cc.worksite.aoko.R;
import cc.worksite.aoko.RealNameActivity;
import cc.worksite.aoko.SettingActivity;
import cc.worksite.aoko.util.SlidingMenu;
import cc.worksite.aoko.util.ToastUtil;


public class MineFragment extends Fragment implements View.OnClickListener {
    private View view;

    private TextView title_text;
    private ImageButton shortcut;

    private ImageView login;
    private Bitmap bitmap;
    private Button login_btn;

    private RelativeLayout slip_order, slip_balance, slip_real_name, slip_integral,
            slip_favorites, slip_setting;

    private TextView slip_text_order, slip_text_balance, slip_text_real_name, slip_text_integral,
            slip_text_favorites, slip_text_setting;

    private Button logout_btn;

    private ImageView shortcut_login;
    private Bitmap shortcut_bitmap;
    private Button shortcut_login_btn;

    private RelativeLayout help_center, tel_service,
            about_us, check_update;

    private TextView help_center_text, tel_service_text,
            about_us_text, check_update_text;

    private SlidingMenu menu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mine_fragment, container, false);

        title_text = (TextView) view.findViewById(R.id.title_show).findViewById(R.id.title_text);
        shortcut = (ImageButton) view.findViewById(R.id.title_show).findViewById(R.id.shortcut);

        login = (ImageView) view.findViewById(R.id.mine_content)
                .findViewById(R.id.login_portrait).findViewById(R.id.login);
        bitmap = ((BitmapDrawable) (login.getDrawable())).getBitmap();
        login_btn = (Button) view.findViewById(R.id.mine_content)
                .findViewById(R.id.login_portrait).findViewById(R.id.login_btn);

        shortcut_login = (ImageView) view.findViewById(R.id.activity_my_info)
                .findViewById(R.id.login_portrait).findViewById(R.id.login);
        shortcut_bitmap = ((BitmapDrawable) (shortcut_login.getDrawable())).getBitmap();
        shortcut_login_btn = (Button) view.findViewById(R.id.activity_my_info)
                .findViewById(R.id.login_portrait).findViewById(R.id.login_btn);

        slip_order = (RelativeLayout) view.findViewById(R.id.mine_content)
                .findViewById(R.id.order);
        slip_balance = (RelativeLayout) view.findViewById(R.id.mine_content)
                .findViewById(R.id.balance);
        slip_real_name = (RelativeLayout) view.findViewById(R.id.mine_content)
                .findViewById(R.id.real_name);
        slip_integral = (RelativeLayout) view.findViewById(R.id.mine_content)
                .findViewById(R.id.integral);
        slip_favorites = (RelativeLayout) view.findViewById(R.id.mine_content)
                .findViewById(R.id.favorites);
        slip_setting = (RelativeLayout) view.findViewById(R.id.mine_content)
                .findViewById(R.id.setting);

        help_center = (RelativeLayout) view.findViewById(R.id.activity_my_info)
                .findViewById(R.id.help_center);
        tel_service = (RelativeLayout) view.findViewById(R.id.activity_my_info)
                .findViewById(R.id.tel_service);
        about_us = (RelativeLayout) view.findViewById(R.id.activity_my_info)
                .findViewById(R.id.about_us);
        check_update = (RelativeLayout) view.findViewById(R.id.activity_my_info)
                .findViewById(R.id.check_update);

        slip_text_order = (TextView) view.findViewById(R.id.order).findViewById(R.id.slip_text);
        slip_text_balance = (TextView) view.findViewById(R.id.balance).findViewById(R.id.slip_text);
        slip_text_real_name = (TextView) view.findViewById(R.id.real_name).findViewById(R.id.slip_text);
        slip_text_integral = (TextView) view.findViewById(R.id.integral).findViewById(R.id.slip_text);
        slip_text_favorites = (TextView) view.findViewById(R.id.favorites).findViewById(R.id.slip_text);
        slip_text_setting = (TextView) view.findViewById(R.id.setting).findViewById(R.id.slip_text);

        slip_text_real_name = (TextView) view.findViewById(R.id.real_name).findViewById(R.id.slip_text);
        slip_text_integral = (TextView) view.findViewById(R.id.integral).findViewById(R.id.slip_text);
        slip_text_favorites = (TextView) view.findViewById(R.id.favorites).findViewById(R.id.slip_text);
        slip_text_setting = (TextView) view.findViewById(R.id.setting).findViewById(R.id.slip_text);

        logout_btn = (Button) view.findViewById(R.id.mine_content)
                .findViewById(R.id.logout);

        help_center_text = (TextView) view.findViewById(R.id.activity_my_info)
                .findViewById(R.id.help_center).findViewById(R.id.slip_text);
        tel_service_text = (TextView) view.findViewById(R.id.activity_my_info)
                .findViewById(R.id.tel_service).findViewById(R.id.slip_text);
        about_us_text = (TextView) view.findViewById(R.id.activity_my_info)
                .findViewById(R.id.about_us).findViewById(R.id.slip_text);
        check_update_text = (TextView) view.findViewById(R.id.activity_my_info)
                .findViewById(R.id.check_update).findViewById(R.id.slip_text);

        menu = (SlidingMenu) view.findViewById(R.id.menu);

        //自定义字体
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "LTJH.ttf");
        title_text.setTypeface(tf);

        slip_text_order.setTypeface(tf);
        slip_text_balance.setTypeface(tf);
        slip_text_real_name.setTypeface(tf);
        slip_text_integral.setTypeface(tf);
        slip_text_favorites.setTypeface(tf);
        slip_text_setting.setTypeface(tf);

        help_center_text.setTypeface(tf);
        tel_service_text.setTypeface(tf);
        about_us_text.setTypeface(tf);
        check_update_text.setTypeface(tf);
        title_text.setText("我 的");

        slip_text_order.setText("我的订单");
        slip_text_balance.setText("我的余额");
        slip_text_real_name.setText("实名认证");
        slip_text_integral.setText("积分商城");
        slip_text_favorites.setText("我的收藏");
        slip_text_setting.setText("设置");

        help_center_text.setText("帮助中心");
        tel_service_text.setText("客服电话(153-8229-4237)");
        about_us_text.setText("关于我们");
        check_update_text.setText("检查更新");

        initListener();

        return view;
    }

    private void initListener() {
        shortcut.setOnClickListener(this);
        login.setOnClickListener(this);
        login.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (bitmap.getPixel((int) (motionEvent.getX()), ((int) motionEvent.getY())) == 0) {
                    return true;//透明区域返回true
                }
                return false;
            }
        });
        login_btn.setOnClickListener(this);

        shortcut_login.setOnClickListener(this);
        shortcut_login.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (shortcut_bitmap.getPixel((int) (motionEvent.getX()), ((int) motionEvent.getY())) == 0) {
                    return true;//透明区域返回true
                }
                return false;
            }
        });
        shortcut_login_btn.setOnClickListener(this);

        slip_order.setOnClickListener(this);
        slip_balance.setOnClickListener(this);
        slip_real_name.setOnClickListener(this);
        slip_integral.setOnClickListener(this);
        slip_favorites.setOnClickListener(this);
        slip_setting.setOnClickListener(this);

        logout_btn.setOnClickListener(this);

        help_center.setOnClickListener(this);
        tel_service.setOnClickListener(this);
        about_us.setOnClickListener(this);
        check_update.setOnClickListener(this);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.shortcut:
                menu.toggle();
                break;
            case R.id.login:
                intent.setClass(getContext(), LoginActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.login_btn:
                intent.setClass(getContext(), LoginActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.order:
                intent.setClass(getContext(), MyOrderActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.balance:
                intent.setClass(getContext(), MyBalanceActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.real_name:
                intent.setClass(getContext(), RealNameActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.integral:
                intent.setClass(getContext(), IntegralActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.favorites:
                intent.setClass(getContext(), FavoritesActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.setting:
                intent.setClass(getContext(), SettingActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.logout:
                ToastUtil.show(getContext(), "logout!", 0);
                break;
            case R.id.help_center:
                intent.setClass(getActivity(), HelpCenterActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.tel_service:
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:15382294237"));
                startActivity(intent);
                break;
            case R.id.about_us:
                Dialog dialog = new AlertDialog.Builder(getContext()).setIcon(android.R.drawable.ic_menu_share)
                        .setTitle("关于我们").setMessage("大连东软信息学院 电子商务团队").create();
                dialog.show();
                break;
            case R.id.check_update:
                final Handler handler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        switch (msg.what) {
                            case 1:
                                Dialog dialog = new AlertDialog.Builder(getContext()).setMessage("当前已是最新版本，无需进行更新。").create();
                                dialog.show();
                                break;
                            default:
                                break;
                        }
                        super.handleMessage(msg);
                    }
                };
                new Thread(new Runnable() {
                    final ProgressDialog progressDialog = ProgressDialog.show(getContext(), null, "检查更新中……", true);

                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                            progressDialog.dismiss();
                            Message message = new Message();
                            message.what = 1;
                            handler.sendMessage(message);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;

        }

    }
}

