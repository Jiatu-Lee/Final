package cc.worksite.aoko.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
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

import cc.worksite.aoko.DialActivity;
import cc.worksite.aoko.GoActivity;
import cc.worksite.aoko.HelpCenterActivity;
import cc.worksite.aoko.LoginActivity;
import cc.worksite.aoko.R;
import cc.worksite.aoko.RecActivity;
import cc.worksite.aoko.util.AutoPlayGallery;
import cc.worksite.aoko.util.ImageAdapter;
import cc.worksite.aoko.util.MyGridAdapter;
import cc.worksite.aoko.util.MyGridView;
import cc.worksite.aoko.util.SlidingMenu;


public class HomeFragment extends Fragment implements View.OnClickListener {
    private View view;
    private ImageButton img_button;
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

    private TextView sub_title1, sub_title2, sub_title3, sub_title4, sub_title5,
            sub_title6, sub_title7, sub_title8;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment, container, false);
        img_button = (ImageButton) view.findViewById(R.id.mine);
        img_button.setOnClickListener(this);
        menu = (SlidingMenu) view.findViewById(R.id.menu);
        view.findViewById(R.id.include_home).findViewById(R.id.login).setOnClickListener(this);
        gridview = (MyGridView) view.findViewById(R.id.include_content).findViewById(R.id.grid_view);
        gridview.setAdapter(new MyGridAdapter(getContext()));

//        ArrayList<HashMap<String, Object>> meumList = new ArrayList<HashMap<String, Object>>();
//        for(int i = 1;i < 10;i++)
//        {
//            HashMap<String, Object> map = new HashMap<String, Object>();
//            map.put("ItemImage", R.drawable.grid_deliver);
//            map.put("ItemText", ""+i);
//            meumList.add(map);
//        }
//        SimpleAdapter saItem = new SimpleAdapter(getContext(),meumList,R.layout.item,new String[]{"ItemImage","ItemText"},new int[]{R.id.ItemImage,R.id.ItemText});
//
//        //添加Item到网格中
//        gridview.setAdapter(saItem);

        sub_title1 = (TextView) view.findViewById(R.id.include_content)
                .findViewById(R.id.one).findViewById(R.id.textView1);
        sub_title2 = (TextView) view.findViewById(R.id.include_content)
                .findViewById(R.id.one).findViewById(R.id.textView2);
        sub_title3 = (TextView) view.findViewById(R.id.include_content)
                .findViewById(R.id.one).findViewById(R.id.textView3);
        sub_title4 = (TextView) view.findViewById(R.id.include_content)
                .findViewById(R.id.one).findViewById(R.id.textView4);
        sub_title5 = (TextView) view.findViewById(R.id.include_content)
                .findViewById(R.id.two).findViewById(R.id.textView1);
        sub_title6 = (TextView) view.findViewById(R.id.include_content)
                .findViewById(R.id.two).findViewById(R.id.textView2);
        sub_title7 = (TextView) view.findViewById(R.id.include_content)
                .findViewById(R.id.two).findViewById(R.id.textView3);
        sub_title8 = (TextView) view.findViewById(R.id.include_content)
                .findViewById(R.id.two).findViewById(R.id.textView4);

        sub_title1.setText("大量批发山东嘎啦苹果\n" + "TEL:153****4032");
        sub_title2.setText("铁观音茶叶（安溪）国际农产品\n" + "TEL:153****4025");
        sub_title3.setText("邮寄虫草不翼而飞 快递丢失怎么赔偿");
        sub_title4.setText("俄罗斯小麦蚜虫首次入侵澳大利亚 澳粮食产业遭遇威胁");
        sub_title5.setText("天津稻田植保首次用上无人机");
        sub_title6.setText("大量批发山东嘎啦苹果\n" + "TEL:153****4013");
        sub_title7.setText("欧盟成员国投票通过一系列草甘膦使用限制措施");
        sub_title8.setText("铁观音茶叶（安溪）国际农产品\n" + "TEL:153****1232");


        shortcut_login = (ImageView) view.findViewById(R.id.include_home)
                .findViewById(R.id.login_portrait).findViewById(R.id.login);
        shortcut_bitmap = ((BitmapDrawable) (shortcut_login.getDrawable())).getBitmap();
        shortcut_login_btn = (Button) view.findViewById(R.id.include_home)
                .findViewById(R.id.login_portrait).findViewById(R.id.login_btn);
        shortcut_btn = (ImageButton) view.findViewById(R.id.mine);
        help_center = (RelativeLayout) view.findViewById(R.id.include_home)
                .findViewById(R.id.help_center);
        tel_service = (RelativeLayout) view.findViewById(R.id.include_home)
                .findViewById(R.id.tel_service);
        about_us = (RelativeLayout) view.findViewById(R.id.include_home)
                .findViewById(R.id.about_us);
        check_update = (RelativeLayout) view.findViewById(R.id.include_home)
                .findViewById(R.id.check_update);

        help_center_text = (TextView) view.findViewById(R.id.include_home)
                .findViewById(R.id.help_center).findViewById(R.id.slip_text);
        tel_service_text = (TextView) view.findViewById(R.id.include_home)
                .findViewById(R.id.tel_service).findViewById(R.id.slip_text);
        about_us_text = (TextView) view.findViewById(R.id.include_home)
                .findViewById(R.id.about_us).findViewById(R.id.slip_text);
        check_update_text = (TextView) view.findViewById(R.id.include_home)
                .findViewById(R.id.check_update).findViewById(R.id.slip_text);

        AutoPlayGallery g = (AutoPlayGallery) view.findViewById(R.id.autoGallery);
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
        sub_title1.setOnClickListener(this);
        sub_title2.setOnClickListener(this);
        sub_title3.setOnClickListener(this);
        sub_title4.setOnClickListener(this);
        sub_title5.setOnClickListener(this);
        sub_title6.setOnClickListener(this);
        sub_title7.setOnClickListener(this);
        sub_title8.setOnClickListener(this);

        shortcut_login.setOnClickListener(this);
        shortcut_btn.setOnClickListener(this);
        shortcut_login.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (shortcut_bitmap.getPixel((int) (motionEvent.getX()), ((int) motionEvent.getY())) == 0) {
                    return true;//透明区域返回true
                }
                return false;


            }
        });

        gridview.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                        int index = arg2 + 1;
                        switch (index) {
                            case 1:
                                Intent intent1 = new Intent(getContext(), RecActivity.class);
                                startActivity(intent1);
                                getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);

                                break;
                            case 2:
                                Intent intent2 = new Intent(getContext(), GoActivity.class);
                                startActivity(intent2);
                                getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);

                                break;
                            case 3:
                                Dialog dialog3 = new android.app.AlertDialog.Builder(getContext()).setIcon(android.R.drawable.stat_sys_warning)
                                        .setTitle("提示").setMessage("此处之后再做处理").create();
                                dialog3.show();
                                break;
                            case 4:
                                Dialog dialog4 = new android.app.AlertDialog.Builder(getContext()).setIcon(android.R.drawable.stat_sys_warning)
                                        .setTitle("提示").setMessage("此处之后再做处理").create();
                                dialog4.show();
                                break;
                            case 5:
                                Dialog dialog5 = new android.app.AlertDialog.Builder(getContext()).setIcon(android.R.drawable.stat_sys_warning)
                                        .setTitle("提示").setMessage("此处之后再做处理").create();
                                dialog5.show();
                                break;
                            case 6:
                                Dialog dialog6 = new android.app.AlertDialog.Builder(getContext()).setIcon(android.R.drawable.stat_sys_warning)
                                        .setTitle("提示").setMessage("此处之后再做处理").create();
                                dialog6.show();
                                break;

                        }
                    }
                }
        );
        shortcut_login_btn.setOnClickListener(this);

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
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.textView1:
                intent.setClass(getActivity(), DialActivity.class);
                bundle.putInt("key", 1);
                bundle.putString("value", "大量批发山东嘎啦苹果");
                intent.putExtras(bundle);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                break;
            case R.id.textView2:
                intent.setClass(getActivity(), DialActivity.class);
                bundle.putInt("key", 2);
                bundle.putString("value", "铁观音茶叶（安溪）国际农产品");
                intent.putExtras(bundle);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                break;
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
