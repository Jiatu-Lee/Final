package cc.worksite.aoko;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DialActivity extends AppCompatActivity {
    private TextView info_title, info_content;
    private ImageView img_back;
    private Button dial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dial);
        info_title = (TextView) findViewById(R.id.info_title);
        info_content = (TextView) findViewById(R.id.info_content);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int key = bundle.getInt("key");
        String value = bundle.getString("value");
        switch (key) {
            case 1:
                info_title.setText(value);
                info_content.setText(info_1);
                break;
            case 2:
                info_title.setText(value);
                info_content.setText(info_2);
                break;
        }
        img_back = (ImageView) findViewById(R.id.back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
            }
        });

        dial=(Button)findViewById(R.id.dial);
        dial.setVisibility(View.VISIBLE);
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent() ;
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:15382294032"));
                startActivity(i);
            }
        });

    }

    private String info_1 = "　　山东供应嘎拉、美八苹果【１８２６５１７７８８８】嘎拉、美八苹果批发价格山东苹" +
            "果产地，" +
            "今年苹果价格偏低，最新果园直销优质嘎拉/美八苹果年苹果大量，苹果价格持续下降，山东嘎拉/美八苹果" +
            "价格行情，山东苹果多年来以他一流的质量，合理的价格，独特的口感，美丽的果光而名闻天下，销至全国" +
            "各大批发市场及出口海外全国的苹果价格,一级红富士苹果产地价格,今年红富士苹果大量上市，苹果量大，价" +
            "格非常便宜，欢迎各地客商，来我基地考察装货。果园直销，苹果价格最便宜，产地直销【嘎拉、美八苹果】," +
            "本基地现有苹果纸袋膜袋嘎拉苹果。）山东最大的优质苹果种植基地,现万亩套袋无公害种植面积达到200多万" +
            "亩，由于我们的水土资源独特，气候温暖，含矿物质丰富，全年无霜期达到240多天。并采用传统种植技术和现" +
            "代种植技术相结合。栽培出的苹果：储藏期长、苹果无污染、无公害、色泽鲜艳、光亮红润，红中透粉，有条红" +
            "、也有片红，水分多、糖度高，口感好、脆甜香，质细汁多，品质上乘，个大形正。我们提供专业的服务，装车" +
            "、选果、包装、食宿、配货等一条龙服务。目前，本基地红富士苹果现已大量上市，欢迎广大批发商前来咨询、" +
            "收购。";
    private String info_2 = "　　日前，中国品牌研究院对二千六百二十九位参加过广交会的外商进行了一项调查，主题为" +
            "外商所熟悉和喜爱的中国品牌。\n" +
            "\n" +
            "　　接受调查的对象分别来自法国、英国、德国、美国等四十多个国家和地区。\n" +
            "\n" +
            "　　调查结果显示，外商最喜欢的中国品牌前十名为：格兰仕、雅戈尔、安溪铁观音、美的、远大、海尔、" +
            "美雅、长虹、新科和TCL。\n" +
            "\n" +
            "　　安溪铁观音成惟一的农产品品牌。\n" +
            "\n" +
            "　　盛产于福建安溪县的铁观音茶乃乌龙茶中的极品，是安溪广大茶农在长期的生产生活实践中培育出的独" +
            "特品种，对土壤、气候条件、栽培技术和初制工艺等要求极为严格，只有安溪境内的铁观音最具乌龙茶特征。\n" +
            "\n" +
            "　　近年来，安溪茶业发展呈现出前所未有的兴盛局面，茶业已成为该县最大的传统特色支柱产业和重要的" +
            "民生产业。全县现有茶园四十万亩，年产茶叶四点五万吨，约占中国大陆乌龙茶总产量的三分之一强，福建" +
            "省的二分之一。\n" +
            "\n" +
            "　　二OO五年底，“安溪铁观音”证明商标被国家工商总局商标局认定为中国驰名商标，成为大陆第一个涉茶" +
            "驰名商标。\n" +
            "\n" +
            "　　安溪铁观音的品牌发展，有效带动了国内外茶叶市场的拓展。二OO五年六月底，“安溪铁观音”作为中国" +
            "地理标志产品的唯一代表，获世界知识产权组织的邀请参加在意大利帕尔玛举行的“全球地理标志保护研讨会”。" +
            "\n\n" +
            "　　如今，安溪铁观音茶叶不仅国内市场火热，国际市场也日益拓展，品饮安溪乌龙茶、铁观音已成为时尚，" +
            "在世界茶叶消费大国俄罗斯，出现圣彼得堡安溪茶叶一条街，铁观音成为俄罗斯的新宠商品。\n" +
            "\n" +
            "　　“安溪铁观音”地理标志证明商标的注册和使用，极大推动了安溪全县经济的发展。安溪铁观音也创造了" +
            "县级茶园面积、茶业产值、茶叶平均单价等多项全国第一。\n" +
            "\n" +
            "　　面对新一轮茶业良好发展态势，安溪县提出未来茶业发展“安溪铁观音·和谐健康新生活”新理念，体现了" +
            "天、地、人、茶的有机统一，自然与社会的和谐共融。\n" +
            "\n" +
            " \n" +
            "\n" +
            "一杯清茶，一段人生，一丝回味！喝茶，可以休闲，更可会友，对坐倾谈,更多品味、更多回味！\n" +
            "                                                                                                 本文选自鑫园春茶叶 ";


}
