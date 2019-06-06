package com.common.apicommon;

public interface Constants {

    /**
     * 短信模板常量
     * */
    public static final String SMS_VERIFY_CODE_TEMP = "VERIFICATION_CODE_TEMP";
    public static final String SMS_NOTIFY_TEMP = "SMS_NOTIFY_TEMP";

    public static final String KAIPANGAO5TIANXIAN = "开盘高于5天线"; // 正常用户状态
    public static final String KAIPANDI5TIANXIAN= "开盘底于5天线"; // 正常用户状态
    public static final String KAIPANGAO10TIANXIAN = "开盘高于10天线"; // 正常用户状态
    public static final String KAIPANDI10TIANXIAN= "开盘底于10天线"; // 正常用户状态
    public static final String KAIPANGAO20TIANXIAN = "开盘高于20天线"; // 正常用户状态
    public static final String KAIPANDI20TIANXIAN= "开盘底于20天线"; // 正常用户状态
    public static final String KAIPANGAO30TIANXIAN = "开盘高于30天线"; // 正常用户状态
    public static final String KAIPANDI30TIANXIAN= "开盘底于30天线"; // 正常用户状态
    public static final String KAIPANGAO60TIANXIAN = "开盘高于60天线"; // 正常用户状态
    public static final String KAIPANDI60TIANXIAN= "开盘底于60天线"; // 正常用户状态

    public static final String SHOUPANGAO5TIANXIAN = "收盘高于5天线"; // 正常用户状态
    public static final String SHOUPANDI5TIANXIAN= "收盘底于5天线"; // 正常用户状态
    public static final String SHOUPANGAO10TIANXIAN = "收盘高于10天线"; // 正常用户状态
    public static final String SHOUPANDI10TIANXIAN= "收盘底于10天线"; // 正常用户状态
    public static final String SHOUPANGAO20TIANXIAN = "收盘高于20天线"; // 正常用户状态
    public static final String SHOUPANDI20TIANXIAN= "收盘底于20天线"; // 正常用户状态
    public static final String SHOUPANGAO30TIANXIAN = "收盘高于30天线"; // 正常用户状态
    public static final String SHOUPANDI30TIANXIAN= "收盘底于30天线"; // 正常用户状态
    public static final String SHOUPANGAO60TIANXIAN = "收盘高于60天线"; // 正常用户状态
    public static final String SHOUPANDI60TIANXIAN= "收盘底于60天线"; // 正常用户状态

    public static final String DANGTIANZHENGZAI20DUNHUA= "当天正在20下钝化"; // 正常用户状态
    public static final String QIANYITIANZHENGZAI20DUNHUA= "前一天正在20下钝化"; // 正常用户状态
    public static final String QIANLIANGTIANZHENGZAI20DUNHUA= "前两天正在20下钝化"; // 正常用户状态
    public static final String QIANSHANTIANZHENGZAI20DUNHUA= "前三天正在20下钝化"; // 正常用户状态

    public static final String DANGTIANZHENGZAI80DUNHUA= "当天正在80上钝化"; // 正常用户状态
    public static final String QIANYITIANZHENGZAI80DUNHUA= "前一天正在80上钝化"; // 正常用户状态
    public static final String QIANLIANGTIANZHENGZAI80DUNHUA= "前两天正在80上钝化"; // 正常用户状态
    public static final String QIANSHANTIANZHENGZAI80DUNHUA= "前三天正在80上钝化"; // 正常用户状态

    public static final String DANGTIANZHENGZAI80BEILI= "当天正在80上背离"; // 正常用户状态
    public static final String QIANYITIANZHENGZAI80BEILI= "前一天正在80上背离"; // 正常用户状态
    public static final String QIANLIANGTIANZHENGZAI80BEILI= "前两天正在80上背离"; // 正常用户状态
    public static final String QIANSHANTIANZHENGZAI80BEILI= "前三天正在80上背离"; // 正常用户状态

    public static final String DANGTIANZHENGZAI20BEILI= "当天正在20下背离"; // 正常用户状态
    public static final String QIANYITIANZHENGZAI20BEILI= "前一天正在20下背离"; // 正常用户状态
    public static final String QIANLIANGTIANZHENGZAI20BEILI= "前两天正在20下背离"; // 正常用户状态
    public static final String QIANSHANTIANZHENGZAI20BEILI= "前三天正在20下背离"; // 正常用户状态


    public static final String XIAOYANG = "小阳"; // 正常用户状态
    public static final String ZHONGYANG = "中阳"; // 正常用户状态
    public static final String DAYANG = "大阳"; // 正常用户状态
    public static final String XIAOYIN = "小阴"; // 正常用户状态
    public static final String ZHONGYIN = "中阴"; // 正常用户状态
    public static final String DAYIN = "大阴"; // 正常用户状态

    /**
     *
     * 乌云常量
     * */
    public static final String WYGD = "乌云盖顶"; // 正常用户状态
    public static final String TYFG = "谈友反攻"; // 用户挂起状态
    public static final String QPDY = "倾盆大雨"; // 用户删除状态
    public static final String CTPJ  = "穿头破脚"; // 用户编码
    public static final String SUANGFWY = "双飞乌鸦"; // 用户编码
    public static final String SHANFWY = "三飞乌鸦"; // 用户编码
    public static final String JYBGZ = "JYBGZ"; // 用户编码
    public static final String XDSLY = "下跌三连阴"; // 用户编码
    public static final String HSB = "黑三兵"; // 用户编码
    public static final String LYangJY = "两阳夹阴"; // 用户编码

    public static final String QKWL = "晴空万里"; // 正常用户状态
    public static final String SGCX = "曙光初现"; // 用户挂起状态
    public static final String YGPZ = "阳光普照"; // 用户删除状态
    public static final String GTCY  = "光头穿云"; // 用户编码
    public static final String LGTY = "两个太阳"; // 用户编码
    public static final String SGTY = "三个太阳"; // 用户编码
    public static final String SSSLY = "上升三烈阳"; // 用户编码
    public static final String HONGSB = "红三兵"; // 用户编码
    public static final String JDST = "九鼎升天"; // 用户编码
    public static final String LYinJY = "两阴夹阳"; // 用户编码
    public static final String MUZI= "子母线"; // 用户编码
    public static final String BINPAILV= "并排绿"; // 用户编码
    public static final String BINPAIHONG= "并排红"; // 用户编码
    public static final String XIADIESANKEXING= "XIADIESANKEXING"; // 用户编码
    public static final String SHANGSHENSANKEXING= "SHANGSHENSANKEXING"; // 用户编码

    public static final String SHANGYINGXIAN100= "上影线大于100"; // 用户编码
    public static final String SHANGYINGXIAN20= "上影线大于20"; // 用户编码
    public static final String SHANGYINGXIAN10= "上影线大于10"; // 用户编码
    public static final String SHANGYINGXIAN3= "上影线大于3"; // 用户编码
    public static final String SHANGYINGXIAN1= "上影线大于1"; // 用户编码
    public static final String SHANGYINGXIAN0_5= "上影线大于50%"; // 用户编码
    public static final String SHANGYINGXIAN0= "上影线小于50%"; // 用户编码

    public static final String XIAYINGXIAN100= "下影线大于100"; // 用户编码
    public static final String XIAYINGXIAN20= "下影线大于20"; // 用户编码
    public static final String XIAYINGXIAN10= "下影线大于10"; // 用户编码
    public static final String XIAYINGXIAN3= "下影线大于3"; // 用户编码
    public static final String XIAYINGXIAN1= "下影线大于1"; // 用户编码
    public static final String XIAYINGXIAN0_5= "下影线大于50%"; // 用户编码
    public static final String XIAYINGXIAN0= "下影线小于50%"; // 用户编码

    public static final String SHIZIXING50= "十字星大于50"; // 用户编码
    public static final String SHIZIXING10= "十字星大于10"; // 用户编码
    public static final String SHIZIXING3= "十字星大于3"; // 用户编码
    public static final String SHIZIXING1= "十字星大于1"; // 用户编码
    public static final String SHIZIXING0_5= "十字星大于50%"; // 用户编码
    public static final String SHIZIXING0= "十字星小于50%"; // 用户编码

    public static final String CHUSHUIFURONG= "出水芙蓉"; // 用户编码
    public static final String DUANTOUCHEDAO= "断头测刀"; // 用户编码

    public static final String DINGPING2= "平顶2"; // 用户编码
    public static final String DIPING2= "底平2"; // 用户编码
    public static final String DINGPING3= "平顶3"; // 用户编码
    public static final String DIPING3= "底平3"; // 用户编码
    public static final String DINGPING4= "平顶4"; // 用户编码
    public static final String DIPING4= "底平4"; // 用户编码
    public static final String DINGPING5= "平顶5"; // 用户编码
    public static final String DIPING5= "底平5"; // 用户编码

    public static final String DUOFANGPAO= "层叠多方炮"; // 用户编码
    public static final String KONGFANGPAO= "层叠空方炮"; // 用户编码


    public static final String XIACHUANG0ZHOU ="下穿0轴"; // 用户编码
    //下穿0轴
    public static final String SHNAGCHUAN0ZHOU ="上窜0轴"; // 用户编码
    //上窜0轴
    public static final String ZHOUFUJINJINCHA ="0轴附近金叉"; // 用户编码
    //0轴附近金叉
    public static final String ZHOUXIAJINCHA ="0轴一下金叉"; // 用户编码
    //0轴一下金叉
    public static final String ZHOUSHANGJINCHA ="0轴以上金叉"; // 用户编码
    //0轴以上金叉
    public static final String ZHOUXIASICHA ="0轴一下死叉"; // 用户编码
    //0轴一下死叉
    public static final String ZHOUSHANGSICHA ="0轴以上死叉"; // 用户编码
    //0轴以上死叉
    public static final String ZHOUXIAXIANGSHANG ="0轴一下向上"; // 用户编码
    //0轴一下向上
    public static final String ZHOUSHANGXIANGSHANG ="0轴以上向上"; // 用户编码
    //0轴以上向上
    public static final String ZHOUXIAXIANGXIA ="0轴一下向下"; // 用户编码
    //0轴一下向下
    public static final String ZHOUSHANGXIANGXIA ="0轴以上向下"; // 用户编码

    //金叉
    public static final String JINCHA ="金叉"; // 用户编码
    //死叉
    public static final String SICHA ="死叉"; // 用户编码
    //向下
    public static final String XIANGXIA ="向下"; // 用户编码
    //向上
    public static final String XIANGSHANG ="向上"; // 用户编码
    //20一下向下
    public static final String XIANGXIA20 ="20一下向下"; // 用户编码
    //20一下向上
    public static final String XIANGSHANG20 ="20一下向上"; // 用户编码
    //20一下金叉
    public static final String JINCHA20 ="20一下金叉"; // 用户编码
    //20一下死叉
    public static final String SICHA20 ="20一下死叉"; // 用户编码
    //80一上向下
    public static final String XIANGXIA80 ="80一上向下"; // 用户编码
    //80一上向上
    public static final String XIANGSHANG80 ="80一上向上"; // 用户编码
    //80一上金叉
    public static final String JINCHA80 ="80一上金叉"; // 用户编码
    //80一上死叉
    public static final String SICHA80 ="80一上死叉"; // 用户编码
    //30一下向下
    public static final String XIANGXIA30 ="30一下向下"; // 用户编码
    //30一下向上
    public static final String XIANGSHANG30 ="30一下向上"; // 用户编码
    //30一下金叉
    public static final String JINCHA30 ="30一下金叉"; // 用户编码
    //30一下死叉
    public static final String SICHA30 ="30一下死叉"; // 用户编码
    //70一上向下
    public static final String XIANGXIA70 ="70一上向下"; // 用户编码
    //70一上向上
    public static final String XIANGSHANG70 ="70一上向上"; // 用户编码
    //70一上金叉
    public static final String JINCHA70 ="70一上金叉"; // 用户编码
    //70一上死叉
    public static final String SICHA70 ="70一上死叉"; // 用户编码

    public static final String PRICEXIANGXIA5="5日向下"; // 用户编码
    public static final String PRICEXIANGSHANG5="5日向上"; // 用户编码
    public static final String PRICEXIANGXIA10="10日向下"; // 用户编码
    public static final String PRICEXIANGSHANG10="10日向上"; // 用户编码
    public static final String PRICEXIANGXIA20="20日向下"; // 用户编码
    public static final String PRICEXIANGSHANG20="20日向上"; // 用户编码
    public static final String PRICEXIANGXIA30="30日向下"; // 用户编码
    public static final String PRICEXIANGSHANG30="30日向上"; // 用户编码
    public static final String PRICEXIANGXIA60="60日向下"; // 用户编码
    public static final String PRICEXIANGSHANG60="60日向上"; // 用户编码

    public static final String shangzhangdayu50="上涨大于50%"; // 用户编码
    public static final String shangzhangdayu30="上涨大于30%"; // 用户编码
    public static final String shangzhangdayu20="上涨大于20%"; // 用户编码
    public static final String shangzhangdayu10="上涨大于10%"; // 用户编码
    public static final String shangzhangdayu5="上涨大于5%"; // 用户编码
    public static final String shangzhangdayu2="上涨大于2%"; // 用户编码
    public static final String shangzhangdayu0="上涨大于0%"; // 用户编码

    public static final String xiajiangdayu50="下跌大于50%"; // 用户编码
    public static final String xiajiangdayu30="下跌大于30%"; // 用户编码
    public static final String xiajiangdayu20="下跌大于20%"; // 用户编码
    public static final String xiajiangdayu10="下跌大于10%"; // 用户编码
    public static final String xiajiangdayu5="下跌大于5%"; // 用户编码
    public static final String xiajiangdayu2="下跌大于2%"; // 用户编码
    public static final String xiajiangdayu0="下跌大于0%"; // 用户编码

    public static final String TUXINGXIANGSHANG="向上"; // 用户编码
    public static final String TUXINGXIANGXIA="向下"; // 用户编码
    public static final String TUXINGPING="平"; // 用户编码

    //redis 常量
    public static final String SCIENCE="science"; // 用户编码
    /**
     *
     * 通用常量
     * */
    public static final String SUCCESS = "S"; //成功状态
    public static final String FAIL="F"; // 失败状态

    public static final String YES="Y";
    public static final String NO="N";

    public static final int ONE = 1;
    public static final int ZERO =0;

    /**
     *
     * 资讯常量
     * */
    public static final String DISCOVERY_TYPE_ARTICLE = "A"; //文章类资讯
    public static final String DISCOVERY_TYPE_VIDEO = "V"; //食品类资讯

    /**
     * 健康常量
     */
    public static final String ARM_LEFT = "L"; //左臂
    public static final String ARM_RIGHT = "R"; //右臂
    public static final String STROKE_RISK_ASSESSMENT = "脑卒中风险评估";
    public static final String STROKE_RECURRENCE_RISK_ASSESSMENT = "脑卒中复发风险评估";
    public static final String DIABETES_RISK_ASSESSMENT = "糖尿病风险评估";
    public static final String CORONARY_RISK_ASSESSMENT = "冠心病风险评估";

    public static final String MAN = "M"; //男
    public static final String FEMALE = "F"; //女

    public static final String BLOOD_SMS_NOTIFY = "BSN"; //血压异常通知
    public static final String FORGET_MED_NOTIFY  = "FMN"; //忘记吃药通知

    public static final String GRADE_ONE ="1";//1期
    public static final String GRADE_TWO ="2";//2期
    public static final String GRADE_THREE ="3";//3期
    public static final String GRADE_ONLY ="单纯收缩";//单纯收缩期

    /**
     * 设备常量
     * */
    public static final int ONE_DAY = 1000*60*60*24; // 一天的毫秒数



}
