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

import cc.worksite.aoko.HelpCenterActivity;
import cc.worksite.aoko.LoginActivity;
import cc.worksite.aoko.R;
import cc.worksite.aoko.ShowInfoActivity;
import cc.worksite.aoko.util.SlidingMenu;


public class InfoFragment extends Fragment implements View.OnClickListener {
    private View view;

    private TextView title_text;
    private ImageButton shortcut;

    private RelativeLayout detail1, detail2, detail3, detail4, detail5, detail6, detail7;

    private TextView show_time1, show_time2, show_time3, show_time4, show_time5, show_time6, show_time7;
    private TextView main_title1, main_title2, main_title3, main_title4, main_title5, main_title6, main_title7;
    private TextView sub_title1, sub_title2, sub_title3, sub_title4, sub_title5, sub_title6, sub_title7;
    private ImageView detail_icon1, detail_icon2, detail_icon3, detail_icon4, detail_icon5, detail_icon6, detail_icon7;

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
        view = inflater.inflate(R.layout.info_fragment, container, false);

        title_text = (TextView) view.findViewById(R.id.title_show).findViewById(R.id.title_text);
        shortcut = (ImageButton) view.findViewById(R.id.title_show).findViewById(R.id.shortcut);

        detail1 = (RelativeLayout) view.findViewById(R.id.info_content)
                .findViewById(R.id.info_detail1);
        detail2 = (RelativeLayout) view.findViewById(R.id.info_content)
                .findViewById(R.id.info_detail2);
        detail3 = (RelativeLayout) view.findViewById(R.id.info_content)
                .findViewById(R.id.info_detail3);
        detail4 = (RelativeLayout) view.findViewById(R.id.info_content)
                .findViewById(R.id.info_detail4);
        detail5 = (RelativeLayout) view.findViewById(R.id.info_content)
                .findViewById(R.id.info_detail5);
        detail6 = (RelativeLayout) view.findViewById(R.id.info_content)
                .findViewById(R.id.info_detail6);
        detail7 = (RelativeLayout) view.findViewById(R.id.info_content)
                .findViewById(R.id.info_detail7);

        show_time1 = (TextView) view.findViewById(R.id.info_detail1).findViewById(R.id.show_time);
        main_title1 = (TextView) view.findViewById(R.id.info_detail1).findViewById(R.id.main_title);
        sub_title1 = (TextView) view.findViewById(R.id.info_detail1).findViewById(R.id.sub_title);
        detail_icon1 = (ImageView) view.findViewById(R.id.info_detail1).findViewById(R.id.info_icon);
        detail_icon1.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.detail_png_1));

        show_time2 = (TextView) view.findViewById(R.id.info_detail2).findViewById(R.id.show_time);
        main_title2 = (TextView) view.findViewById(R.id.info_detail2).findViewById(R.id.main_title);
        sub_title2 = (TextView) view.findViewById(R.id.info_detail2).findViewById(R.id.sub_title);
        detail_icon2 = (ImageView) view.findViewById(R.id.info_detail2).findViewById(R.id.info_icon);
        detail_icon2.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.detail_png_2));

        show_time3 = (TextView) view.findViewById(R.id.info_detail3).findViewById(R.id.show_time);
        main_title3 = (TextView) view.findViewById(R.id.info_detail3).findViewById(R.id.main_title);
        sub_title3 = (TextView) view.findViewById(R.id.info_detail3).findViewById(R.id.sub_title);
        detail_icon3 = (ImageView) view.findViewById(R.id.info_detail3).findViewById(R.id.info_icon);
        detail_icon3.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.detail_png_3));

        show_time4 = (TextView) view.findViewById(R.id.info_detail4).findViewById(R.id.show_time);
        main_title4 = (TextView) view.findViewById(R.id.info_detail4).findViewById(R.id.main_title);
        sub_title4 = (TextView) view.findViewById(R.id.info_detail4).findViewById(R.id.sub_title);
        detail_icon4 = (ImageView) view.findViewById(R.id.info_detail4).findViewById(R.id.info_icon);
        detail_icon4.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.detail_png_4));

        show_time5 = (TextView) view.findViewById(R.id.info_detail5).findViewById(R.id.show_time);
        main_title5 = (TextView) view.findViewById(R.id.info_detail5).findViewById(R.id.main_title);
        sub_title5 = (TextView) view.findViewById(R.id.info_detail5).findViewById(R.id.sub_title);
        detail_icon5 = (ImageView) view.findViewById(R.id.info_detail5).findViewById(R.id.info_icon);
        detail_icon5.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.detail_png_2));

        show_time6 = (TextView) view.findViewById(R.id.info_detail6).findViewById(R.id.show_time);
        main_title6 = (TextView) view.findViewById(R.id.info_detail6).findViewById(R.id.main_title);
        sub_title6 = (TextView) view.findViewById(R.id.info_detail6).findViewById(R.id.sub_title);
        detail_icon6 = (ImageView) view.findViewById(R.id.info_detail6).findViewById(R.id.info_icon);
        detail_icon6.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.detail_png_4));

        show_time7 = (TextView) view.findViewById(R.id.info_detail7).findViewById(R.id.show_time);
        main_title7 = (TextView) view.findViewById(R.id.info_detail7).findViewById(R.id.main_title);
        sub_title7 = (TextView) view.findViewById(R.id.info_detail7).findViewById(R.id.sub_title);
        detail_icon7 = (ImageView) view.findViewById(R.id.info_detail7).findViewById(R.id.info_icon);
        detail_icon7.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.detail_png_3));

        shortcut_login = (ImageView) view.findViewById(R.id.activity_my_info)
                .findViewById(R.id.login_portrait).findViewById(R.id.login);
        shortcut_bitmap = ((BitmapDrawable) (shortcut_login.getDrawable())).getBitmap();
        shortcut_login_btn = (Button) view.findViewById(R.id.activity_my_info)
                .findViewById(R.id.login_portrait).findViewById(R.id.login_btn);

        help_center = (RelativeLayout) view.findViewById(R.id.activity_my_info)
                .findViewById(R.id.help_center);
        tel_service = (RelativeLayout) view.findViewById(R.id.activity_my_info)
                .findViewById(R.id.tel_service);
        about_us = (RelativeLayout) view.findViewById(R.id.activity_my_info)
                .findViewById(R.id.about_us);
        check_update = (RelativeLayout) view.findViewById(R.id.activity_my_info)
                .findViewById(R.id.check_update);

        help_center_text = (TextView) view.findViewById(R.id.activity_my_info)
                .findViewById(R.id.help_center).findViewById(R.id.slip_text);
        tel_service_text = (TextView) view.findViewById(R.id.activity_my_info)
                .findViewById(R.id.tel_service).findViewById(R.id.slip_text);
        about_us_text = (TextView) view.findViewById(R.id.activity_my_info)
                .findViewById(R.id.about_us).findViewById(R.id.slip_text);
        check_update_text = (TextView) view.findViewById(R.id.activity_my_info)
                .findViewById(R.id.check_update).findViewById(R.id.slip_text);


        menu = (SlidingMenu) view.findViewById(R.id.menu);
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "LTJH.ttf");
        title_text.setTypeface(tf);
        help_center_text.setTypeface(tf);
        tel_service_text.setTypeface(tf);
        about_us_text.setTypeface(tf);
        check_update_text.setTypeface(tf);

        show_time1.setTypeface(tf);
        show_time2.setTypeface(tf);
        show_time3.setTypeface(tf);
        show_time4.setTypeface(tf);
        show_time5.setTypeface(tf);
        show_time6.setTypeface(tf);
        show_time7.setTypeface(tf);
        main_title1.setTypeface(tf);
        main_title2.setTypeface(tf);
        main_title3.setTypeface(tf);
        main_title4.setTypeface(tf);
        main_title5.setTypeface(tf);
        main_title6.setTypeface(tf);
        main_title7.setTypeface(tf);
        sub_title1.setTypeface(tf);
        sub_title2.setTypeface(tf);
        sub_title3.setTypeface(tf);
        sub_title4.setTypeface(tf);
        sub_title5.setTypeface(tf);
        sub_title6.setTypeface(tf);
        sub_title7.setTypeface(tf);

        title_text.setText("消 息");

        help_center_text.setText("帮助中心");
        tel_service_text.setText("客服电话 (153-8229-4237)");
        about_us_text.setText("关于我们");
        check_update_text.setText("检查更新");

        show_time1.setText("10:24");
        show_time2.setText("08:31");
        show_time3.setText("07:47");
        show_time4.setText("昨天 22:53");
        show_time5.setText("昨天 15:22");
        show_time6.setText("08月11号");
        show_time7.setText("08月10号");
        main_title1.setText("#国内资讯# 互联网+农业，强势来袭！");
        main_title2.setText("#供求信息# 大量批发山东嘎啦苹果");
        main_title3.setText("#国际# 欧盟成员国投票通过一系列草甘膦使用限制措施");
        main_title4.setText("#国内资讯# 天津稻田植保首次用上无人机");
        main_title5.setText("#国内资讯# 邮寄虫草不翼而飞 快递丢失怎么赔偿");
        main_title6.setText("#国际# 俄罗斯小麦蚜虫首次入侵澳大利亚 澳粮食产业遭遇威胁");
        main_title7.setText("#供求信息# 铁观音茶叶（安溪）国际农产品");
        sub_title1.setText("“互联网+”带动传统农业升级。目前物联网、大数据、" +
                "电子商务等互联网技术越来越多的应用在农业生产领域，并在一定程度" +
                "上加速了转变农业生产方式、发展现代农业的步伐。");
        sub_title2.setText("本基地常年供应四季苹果山东产地直销嘎拉、美八苹果，" +
                "所处的纬度，海拔高度，土壤厚度特别适宜苹果生产，并且没有工业污染，" +
                "被农业部确定为中国苹果优势产业带．盛产大量的绿色无公害水果，并采用" +
                "传统种植技术和现代种植技术相结合。绝不乱报价格，让您准确了解市场行情，把握商机，多赚钱。");
        sub_title3.setText("7月11日，欧盟成员国投票接受了草甘膦使用的相关限制条件。" +
                "这是继上月欧盟决定延长草甘膦登记18个月后的最新决定。具体限制条件如下：" +
                " 尽量减少公园和游乐场等特定地点的使用。地方市政使用草甘膦来清除道路和" +
                "人行道边的杂草，而如果喷洒时期过近，这将对儿童和犬类造成危害。此外，" +
                "残余草甘膦还有可能进入集水系统。");
        sub_title4.setText(" 北辰区首次试用“无人智能植保飞机”进行稻田植保作业喜获成功，" +
                "这不仅给种田大户吃了“定心丸”，也让农机大户看到了致富的新路子。" +
                "　据了解，北辰区有农业大田近二十万亩，在农耕作业中，翻耕、播种、收割等" +
                "环节都实现了百分之百机械化作业，但植保环节仍然以传统人工或半机械作业为主，" +
                "作业效率很低。“无人智能植保飞机”不仅作业范围广、喷洒效果好，而且安全性和" +
                "作业效率高，可广泛应用于水稻、小麦、果树等农作物及林业病虫害防治和营养服务" +
                "以及农作物制种和授粉。为了进一步提高全区农业机械化综合水平，北辰区农机推广站" +
                "决定引进试用植保飞机开展农田植保作业，提高作业效率。");
        sub_title5.setText("从西藏林芝通过中国邮政EMS寄出价值万元的虫草至陕西西安，快件却在成都" +
                "经转时“不翼而飞”。连续多天，郑先生拨打中国邮政EMS客服电话11183，得到的答复都是" +
                "“24小时内会有人工作人员联系处理”，却始终没有人回复告知快件的下落。");
        sub_title6.setText("不久前，澳大利亚北部的一个小麦农场发现俄罗斯小麦蚜虫，而该害虫是" +
                "首次在澳大利亚出现。俄罗斯小麦蚜虫破坏力极强，会导致小麦、大麦和燕麦等作物减产75%，" +
                "同时会使作物更容易感染其他病毒，细菌和锈病，严重者会导致作物死亡。");
        sub_title7.setText("水里有幽香，之于口感，是回味绵长;之于感受，是恬淡宁静；之于心情，是悠然自得;" +
                "之于韵律，如古筝音符，低回婉转，凝重深厚。真水无痕  茶过留香喝一泡好茶，要的是好心情、" +
                "好品味、好境界。或者还有一份如魏晋名士“目送征鸿、手挥五弦”一般的洒脱。");
        initListener();

        return view;


    }

    private void initListener() {
        shortcut.setOnClickListener(this);
        detail1.setOnClickListener(this);
        detail2.setOnClickListener(this);
        detail3.setOnClickListener(this);
        detail4.setOnClickListener(this);
        detail5.setOnClickListener(this);
        detail6.setOnClickListener(this);
        detail7.setOnClickListener(this);

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
            case R.id.shortcut:
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
            case R.id.info_detail1:
                intent.setClass(getActivity(), ShowInfoActivity.class);
                bundle.putInt("key", 1);
                bundle.putString("value", "互联网+农业，强势来袭！");
                intent.putExtras(bundle);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.info_detail2:
                intent.setClass(getActivity(), ShowInfoActivity.class);
                bundle.putInt("key", 2);
                bundle.putString("value", "大量批发山东嘎啦苹果");
                intent.putExtras(bundle);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.info_detail3:
                intent.setClass(getActivity(), ShowInfoActivity.class);
                bundle.putInt("key", 3);
                bundle.putString("value", "欧盟成员国投票通过一系列草甘膦使用限制措施");
                intent.putExtras(bundle);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.info_detail4:
                intent.setClass(getActivity(), ShowInfoActivity.class);
                bundle.putInt("key", 4);
                bundle.putString("value", "天津稻田植保首次用上无人机");
                intent.putExtras(bundle);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.info_detail5:
                intent.setClass(getActivity(), ShowInfoActivity.class);
                bundle.putInt("key", 5);
                bundle.putString("value", "邮寄虫草不翼而飞 快递丢失怎么赔偿");
                intent.putExtras(bundle);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.info_detail6:
                intent.setClass(getActivity(), ShowInfoActivity.class);
                bundle.putInt("key", 6);
                bundle.putString("value", "俄罗斯小麦蚜虫首次入侵澳大利亚 澳粮食产业遭遇威胁");
                intent.putExtras(bundle);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.info_detail7:
                intent.setClass(getActivity(), ShowInfoActivity.class);
                bundle.putInt("key", 7);
                bundle.putString("value", "铁观音茶叶（安溪）国际农产品");
                intent.putExtras(bundle);
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
