package cc.worksite.aoko;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowInfoActivity extends AppCompatActivity {

    private TextView info_title, info_content;
    private ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_show_info);
        info_title = (TextView) findViewById(R.id.info_title);
        info_content = (TextView) findViewById(R.id.info_content);

        img_back = (ImageView) findViewById(R.id.back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
            }
        });

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
            case 3:
                info_title.setText(value);
                info_content.setText(info_3);
                break;
            case 4:
                info_title.setText(value);
                info_content.setText(info_4);

                break;
            case 5:
                info_title.setText(value);
                info_content.setText(info_5);
                break;
            case 6:
                info_title.setText(value);
                info_content.setText(info_6);
                break;
            case 7:
                info_title.setText(value);
                info_content.setText(info_7);
                break;
        }
    }

    private String info_1 = "　　互联网农业，当前很热，报道出的模式也较复杂，甚至概念高深，但综合起来，" +
            "主要可归纳为三种模式：一是互联网技术深刻运用的智能农业模式，二是互联网营销综合运用的电商模式，" +
            "三是互联网与农业深度融合的产业链模式，而且这三种模式呈现梯次推进的状态。\n" +
            "\n" +
            "　　互联网带来的智能化让农业也如此现代\n" +
            "\n" +
            "　　2012年12月中旬，一位记者来到位于北京密云县西康各庄村的海华云都生态农业股份有限公司奶牛养" +
            "殖基地，探访这里的智能化养殖，发现仅仅四五名饲养员，就能在半天时间内为数千头奶牛挤奶，这让他大" +
            "为惊奇。为什么可以？每头奶牛一出生都会戴上一只专属的电子“耳钉”，里面储存着奶牛的所有身份信息，" +
            "包括出生时间、谱系、初次产奶时间等，只要进入挤奶大厅，就会与相关设备相连，读取奶牛“耳钉”里的信" +
            "息，并通过挤奶杯上的感应装置传输到后台，每次挤奶的奶质是否合格得到监测。其实这还只能养殖业智能" +
            "化的冰山一角，目前动物的智能化精确饲喂系统，以计算机为控制中心，以饲喂站作为控制终端，以称重传" +
            "感器和射频读卡器采集动物信息，根据科学公式运算出饲料日供量，再由控制器控制机电执行部分精确下料" +
            "，饲喂动物不再是过去的人工操作，而是在计算机上轻点鼠标。\n" +
            "\n" +
            "　　在种植业，同样呈现智能化的系统性操作情形。例如在陕西的西咸新区泾河新城秦龙现代生态智能创意" +
            "农业园里，喷药施肥靠无人飞机，地面遥控员通过雷达和GPS导航对其遥控、定位、喷药施肥和传输数据；采" +
            "摘番茄机器人代劳，通过多传感器数据融合技术，具有获取果实信息、判别成熟度、确定收获目标的三维空间" +
            "信息标定能力，再引导机械手完成抓取、切割、回收任务。\n" +
            "\n" +
            "　　互联网带来的农业智能化浪潮，是以计算机为中心，对当前信息技术的综合集成，集感知、传输、控制、" +
            "作业为一体，将农业的标准化、规范化大大向前推进了一步，不仅节省了人力成本，也提高了品质控制能力，" +
            "增强了自然风险抗击能力，正在得到日益广泛的推广。\n" +
            "\n" +
            "　　互联网带来的电商热潮让三只松鼠脱颖而出\n" +
            "\n" +
            "　　成立仅1年，营业额就达到3亿，仅2013年“双十一”当天就销售3562万元，如果不是在互联网时代，不可" +
            "能诞生这样的奇迹！创造这个奇迹的就是一个叫作“三只松鼠”的电子商务公司，其标签是第一个互联网森林食" +
            "品品牌，代表着天然、新鲜以及非过度加工，主要销售坚果，上线仅65天销售就在淘宝天猫坚果行业跃居第一" +
            "名。奇迹是如何诞生的？\n" +
            "\n" +
            "　　从表面上看有三条十分关键：首先，三只松鼠的产品并不特殊，只是松子、山核桃、碧根果等干果，但是" +
            "做得很时尚，紧盯80后、90后的时尚人群；其次，品牌形象十分有特点，是童真、可爱的动漫小松鼠，又以森" +
            "林绿色和高端黑色作主打色，形成基础、直观的品牌记忆点；第三是产品细节十分周全，以时尚文化延伸与" +
            "三只松鼠有关的东西，比如，产品的包装上撰写松鼠卖萌的小故事；加上倡导“慢食快活”的微杂志、绿色封口" +
            "夹、剥壳器；将果壳垃圾袋命名为“鼠小袋”，擦手用的湿纸巾叫作“鼠小巾”……所有这些随同产品出现，明显有" +
            "别于一般干果产品，自然能引起消费者的满足感和惊喜感，迅速形成品牌认同和口碑传播。\n" +
            "\n" +
            "　　若从策划运营角度看，则同样有三条关键因素：首要是细分市场理念的良好运用，运用大数据，精准定" +
            "位目标客户，避免了泛化营销，没有特色；其次是以精良的客服实现与客户的密切互动，把简单的“B2C”模式" +
            "演化为“B2C2B”，不断改进产品质量；再次是产业链的控制，既没有走从头到尾的全产业链经营，也没有单纯的" +
            "外包生产，而是把原材料供应外包，审验达标后精选分级包装，从而实现了轻装上阵与产品质量控制的良好结合。\n" +
            "\n" +
            "　　三只松鼠带来的启示是：互联网时代的产品销售，不要妄想包打天下，而是要深入研究行业规律，以特" +
            "色迅速起步，特别是要重视时尚文化的运用，那些年轻的买家们，可能表面买的是东西，实际买的是文化，" +
            "是那种感觉。谁给了年轻人想要的那一种滋味，谁就会盈得市场！\n" +
            "\n" +
            "　　联想佳沃开创的跨界时代\n" +
            "\n" +
            "　　2013年11月12日，继佳沃蓝莓于当年5月上市后，联想控股旗下的农业板块佳沃集团宣布推出第二个旗" +
            "舰水果产品佳沃金艳果猕猴桃，但非常特别的是，联想此次推出的猕猴桃与昔日“烟草大王”褚时健种植的“励" +
            "志橙”一起，组合成“褚橙柳桃”首发，随即引发市场热议，并连带引发潘石屹代言家乡苹果、任志强代言家乡" +
            "小米……一时间，褚橙、柳桃、潘苹果等成为农产品品牌营销的佳话。而产品的上市，也标志着联想农业初步结" +
            "果果实。\n" +
            "\n" +
            "　　联想进入农业有标杆性意义：它标志着互联网农业迈入产业深度融合的新层次，也标志着资本下乡进入" +
            "了资本跨界运营的新阶段。联想对农业的改造是全方位的，不仅用互联网技术去改造生产环节提高生产水平，" +
            "而且运用互联网技术管控整个生产经营过程确保产品品质，还运用互联网技术对产品营销进行了创新设计，最" +
            "终将传统隔离的农业一、二、三产业环节打通，形成了完备的产业链。同时，依托联想的全球化视野，可以在全" +
            "球范围内进行产业的布局。也即联想提出的“三全”解决之道，即全程可追溯、全产业链运营、全球化布局。\n" +
            "\n" +
            "　　联想农业的可贵之处在于：对农业的深度研究和平和的预期。首先，联想没有选常规的粮油蔬菜等产业，" +
            "也没有像网易那样去搞养殖业，而是选择了产品较为高端、利润提升空间相对较大的蓝莓和猕猴桃，这让运行" +
            "有了可靠的产业基础，形成了盈利的预期。其次，充分进行了资本运作，没有从头开始，而是采取了收购的办" +
            "法迅速形成规模化生产基地，缩短了投资期限。第三，联想意识到农业是一个长周期的产业，于是柳传志特别" +
            "提醒负责农业板块的陈绍鹏：“我们不急着挣钱。十个亿，二十个亿咱们投得起，咱们一步一步稳着做。”当然" +
            "，联想充裕的资本实力也让他们有了这样说话的底气。\n" +
            "\n" +
            "　　虽然网易猪至今没有出栏，但“柳桃”已经成功上市，还有更多的互联网企业摩拳擦掌准备进入农业领域，" +
            "未来的互联网农业还将风生水起。是借着农业的概念吹起又一波的概念泡沫，还是通过深刻改造和深度融合让" +
            "农业从此与以往大不同，尚需在实践中仔细观察。";
    private String info_2 = "　　山东供应嘎拉、美八苹果【１８２６５１７７８８８】嘎拉、美八苹果批发价格山东苹" +
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
    private String info_3 = "　　生意社07月15日讯\n" +
            "\n" +
            "　　7月11日，欧盟成员国投票接受了草甘膦使用的相关限制条件。这是继上月欧盟决定延长草甘膦登记18" +
            "个月后的最新决定。具体限制条件如下：\n" +
            "\n" +
            "　　禁止使用POE-牛脂基伯胺作为助剂的产品(如Roundup)。这些助剂为表面活性剂，能促进草甘膦在植物" +
            "中的吸收。根据BfR(德国联邦风险评估研究所)的意见，“POE-牛脂基伯胺(polyethoxylated alkylamines)" +
            "比草甘膦活性物质具有更高的毒性。”\n" +
            "\n" +
            "　　加强(不必要的)草甘膦收获前施用审查。农民在收获前的作物中喷洒草甘膦有2种原因：作物促熟以及杀" +
            "死杂草。如果作物没有完全成熟，那么就很有可能会吸收这种毒性物质。具体可查看草甘膦收获前用途指导。\n" +
            "\n" +
            "　　尽量减少公园和游乐场等特定地点的使用。地方市政使用草甘膦来清除道路和人行道边的杂草，而如" +
            "果喷洒时期过近，这将对儿童和犬类造成危害。此外，残余草甘膦还有可能进入集水系统。\n";
    private String info_4 = "　　天津市北辰区首次试用“无人智能植保飞机”进行稻田植保作业喜获成功,这不仅给种田" +
            "大户吃了“定心丸”,也让农机大户看到了致富的新路子。\n" +
            "\n" +
            "　　眼下正是水稻田间管理和病虫害防治的关键期,与往年人工操作不一样的是,高科技农机走进了田间地头" +
            "儿。在北辰区龙顺庄园六百多亩稻田地里,伴随着巨大的引擎轰鸣声,无人植保飞机在操作员的定位遥控下,升" +
            "至距地面两到三米高的空中,寻着设定的航线,从稻田上方穿过,快速地实施喷洒作业。各种农作物营养剂和防" +
            "虫药剂形成雾状水汽直接喷洒于田间,渗透性极强,能让水稻均匀吸收,比传统的人工喷雾效果更好。而无人植" +
            "保飞机进行作业,一个小时可以喷洒六十亩地左右,工作量相当于五、六个劳动力工作一整天。\n" +
            "\n" +
            "　　龙顺庄园农业负责人徐磊一边掐着时间,一边计算着:以十亩地块为标准,人工操作最少得一个半小时," +
            "使用无人植保机十分钟左右就能完成。又省时、又省工,撒得均匀,操作还安全,这个设备买得值!\n" +
            "\n" +
            "　　据了解,北辰区有农业大田近二十万亩,在农耕作业中,翻耕、播种、收割等环节都实现了百分之百机械" +
            "化作业,但植保环节仍然以传统人工或半机械作业为主,作业效率很低。“无人智能植保飞机”不仅作业范围广、" +
            "喷洒效果好,而且安全性和作业效率高,可广泛应用于水稻、小麦、果树等农作物及林业病虫害防治和营养服务" +
            "以及农作物制种和授粉。为了进一步提高全区农业机械化综合水平,北辰区农机推广站决定引进试用植保飞机" +
            "开展农田植保作业,提高作业效率。";
    private String info_5 = "　　7月9日，在西藏林芝市米林县的四川人郑先生通过中国邮政EMS寄出重150g左右、价值" +
            "约万元的虫草，目的地为陕西西安。一个星期过去，家人称仍未收到快件，郑先生通过快递单号查询物流信息" +
            "时发现，7月10日下午快递“离开成都市发往下一城市(经转)”，随后便再无更新。\n" +
            "\n" +
            "　　郑先生拨打了中国邮政EMS客服电话，客服人员告知郑先生按照工作流程，24小时内就会有工作人员回" +
            "复处理。但几天过去了，他仍然未得到任何回复。郑先生称连续多日拨打了客服电话，回复仍然是“24小时内" +
            "回复，请保持电话畅通”。\n" +
            "\n" +
            "　　郑先生说，前天林芝市邮局办公室的一个负责人打过电话，说正在查，可能丢了，也可能没丢。郑先生" +
            "感到疑惑，快递寄送经办的流程、工作人员在系统上都是有记录的，怎么一周时间过去了，还没有查到在哪个" +
            "环节出了问题?\n" +
            "\n" +
            "　　中国邮政负责人介绍，因郑先生的快递选择了保价，如果快件确实丢失，将按照50元保费赔偿1万元的标" +
            "准给予赔付。如果是未保价的快件，只能按照最高不超过邮费3倍的标准赔付。\n" +
            "\n" +
            "　　可是，查出到底哪个环节出了问题，怎么就这么难呢?";
    private String info_6 = "　　三周前，澳大利亚北部的一个小麦农场发现俄罗斯小麦蚜虫，而该害虫是首次在澳大利亚出现。俄罗斯小麦" +
            "蚜虫破坏力极强，会导致小麦、大麦和燕麦等作物减产75%，同时会使作物更容易感染其他病毒，细菌和锈病，" +
            "严重者会导致作物死亡。\n" +
            "\n" +
            "南澳洲生物安全主任Will Zacharin认为这种2 毫米长的淡绿色的蚜虫可能由南美感染该虫害的小麦种植区" +
            "经信风传递带来。该虫害可经由信风、衣物、农场机械传递的蚜虫将毒素注入敏感小麦、燕麦、大麦、水稻" +
            "，会使得这些作物叶片卷曲萎蔫，影响其正常生长。同时，该蚜虫也可能通过奶牛肉牛养殖者感染当地草场、" +
            "牧场。\n" +
            "\n" +
            "目前，该害虫已经蔓延到距离农场相隔400多公里的地方，从北方小麦种植区的克莱尔弗勒里厄半岛边缘，" +
            "澳大利亚南部维多利亚边境的纳拉库特及边城小镇和威默拉亚莫雷主要小麦产区。\n" +
            "\n" +
            "澳大利亚粮食生产主席和维多利亚地区的小麦种植者Andrew Weidemann对该害虫的蔓延速度之快表示担心，" +
            "尽管现在该虫害仅在澳大利亚东部种植区流行。新南威尔士和维多利亚的大麦和小麦刚刚萌发，整个生长季" +
            "看起来情况良好，但目前该地区的种植者需保持警惕。\n" +
            "\n" +
            "维多利亚的植物健康首席官Gabrielle Vivian-Smith提醒粮食种植者和农学家时刻保持警惕。澳大利亚粮" +
            "食生产主席表示目前的首要任务是阻止害虫蔓延到西澳大利亚—虽然到目前为止，西澳大利亚小麦尚未受影响。" +
            "西澳大利亚粮食产出占澳大利亚年产3600万吨粮食的一半，现在正是作物生长季。\n" +
            "\n" +
            "最终培育出新的能抗俄罗斯蚜虫的小麦和大麦品种可能还需要四到五年时间。为控制该害虫的蔓延，种植者们" +
            "要在一季种植期间多次喷洒昂贵的杀虫剂。南澳洲生物安全主任Will Zacharin 说道，“综合现有因素来看，" +
            "我们现在可能不能立即有效控制或消除它；但我们可以通过选择合适的杀虫剂将该虫害的损害降到最低。”南澳" +
            "大利亚州农业部长Leon Bignell也表示政府将全力投入所有可能的资源对其进行检测。\n";
    private String info_7 = "　　日前，中国品牌研究院对二千六百二十九位参加过广交会的外商进行了一项调查，主题为" +
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
