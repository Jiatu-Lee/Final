package cc.worksite.aoko.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import cc.worksite.aoko.HelpCenterActivity;
import cc.worksite.aoko.LoginActivity;
import cc.worksite.aoko.R;
import cc.worksite.aoko.ReleaseActivity;
import cc.worksite.aoko.util.AutoPlayGallery;
import cc.worksite.aoko.util.ImageAdapter;
import cc.worksite.aoko.util.MyGridAdapter2;
import cc.worksite.aoko.util.MyGridView;
import cc.worksite.aoko.util.SlidingMenu;


public class ReleaseFragment extends Fragment implements View.OnClickListener {

    private View view;
    private ImageButton img_button;
    private TextView show_text;
    private SlidingMenu menu;
    private MyGridView gridview;
    private ImageView shortcut_login;
    private Bitmap shortcut_bitmap;
    private Button shortcut_login_btn;
    private RelativeLayout help_center, tel_service,
            about_us, check_update;
    private ImageButton shortcut_btn;

    private TextView help_center_text, tel_service_text,
            about_us_text, check_update_text;
Intent intent = new Intent();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.release_fragment, container, false);
        img_button = (ImageButton) view.findViewById(R.id.mine);
        img_button.setOnClickListener(this);
        show_text = (TextView) view.findViewById(R.id.show_text);
        menu = (SlidingMenu) view.findViewById(R.id.menu);
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "LTJH.ttf");
        show_text.setTypeface(tf);
        gridview = (MyGridView) view.findViewById(R.id.include_content).findViewById(R.id.grid_view);
        gridview.setAdapter(new MyGridAdapter2(getContext()));
        AutoPlayGallery g = (AutoPlayGallery) view.findViewById(R.id.autoGallery);

        shortcut_btn = (ImageButton) view.findViewById(R.id.mine);
        shortcut_login = (ImageView) view.findViewById(R.id.include_release)
                .findViewById(R.id.login_portrait).findViewById(R.id.login);
        shortcut_bitmap = ((BitmapDrawable) (shortcut_login.getDrawable())).getBitmap();
        shortcut_login_btn = (Button) view.findViewById(R.id.include_release)
                .findViewById(R.id.login_portrait).findViewById(R.id.login_btn);
        help_center = (RelativeLayout) view.findViewById(R.id.include_release)
                .findViewById(R.id.help_center);
        tel_service = (RelativeLayout) view.findViewById(R.id.include_release)
                .findViewById(R.id.tel_service);
        about_us = (RelativeLayout) view.findViewById(R.id.include_release)
                .findViewById(R.id.about_us);
        check_update = (RelativeLayout) view.findViewById(R.id.include_release)
                .findViewById(R.id.check_update);

        help_center_text = (TextView) view.findViewById(R.id.include_release)
                .findViewById(R.id.help_center).findViewById(R.id.slip_text);
        tel_service_text = (TextView) view.findViewById(R.id.include_release)
                .findViewById(R.id.tel_service).findViewById(R.id.slip_text);
        about_us_text = (TextView) view.findViewById(R.id.include_release)
                .findViewById(R.id.about_us).findViewById(R.id.slip_text);
        check_update_text = (TextView) view.findViewById(R.id.include_release)
                .findViewById(R.id.check_update).findViewById(R.id.slip_text);

        ArrayList<Drawable> drawables = new ArrayList<Drawable>();
        drawables.add(getResources().getDrawable(R.drawable.flag_yellow));
        drawables.add(getResources().getDrawable(R.drawable.flag_red));
        drawables.add(getResources().getDrawable(R.drawable.flag_blue));
        ImageAdapter adapter = new ImageAdapter(getContext(), drawables);
        g.setAdapter(adapter);

        help_center_text.setText("帮助中心");
        tel_service_text.setText("客服电话 (153-8229-4237)");
        about_us_text.setText("关于我们");
        check_update_text.setText("检查更新");
        initListener();

        return view;


    }

    private void initListener() {
        shortcut_btn.setOnClickListener(this);
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

        help_center.setOnClickListener(this);
        tel_service.setOnClickListener(this);
        about_us.setOnClickListener(this);
        check_update.setOnClickListener(this);
        gridview.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                        int index = arg2 + 1;
                        switch (index) {
                            case 1:
                                intent.setClass(getContext(),ReleaseActivity.class);
                                intent.putExtra("key",1);
                                startActivity(intent);
                                break;
                            case 2:
                                intent.setClass(getContext(),ReleaseActivity.class);
                                intent.putExtra("key",2);
                                startActivity(intent);
                               break;
                            case 3:
                                intent.setClass(getContext(),ReleaseActivity.class);
                                intent.putExtra("key",3);
                                startActivity(intent);
                                break;
                            case 4:
                                intent.setClass(getContext(),ReleaseActivity.class);
                                intent.putExtra("key",4);
                                startActivity(intent);
                                break;

                        }
                    }
                });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.mine:
                menu.toggle();
                break;
            case R.id.login:
                intent.setClass(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.login_btn:
                intent.setClass(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
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