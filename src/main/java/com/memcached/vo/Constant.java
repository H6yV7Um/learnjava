package com.memcached.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constant {
	
	/**
	 * 普通点评
	 */
	public static final String COMMON_COMMENT_TYPE = "COMMON";
	/**
	 * 体验点评
	 */
	public static final String EXPERIENCE_COMMENT_TYPE = "EXPERIENCE";
	
	/**
	 * 全部tab点评第一页缓存key
	 * */
	public static final String cmtFirstPageKey ="CMT_COMMENT_FIRST_PAGE";
	
	/**
	 * 驴妈妈官方回复 Session Key
	 */
	public static final String SESSION_CMT_BUSINESS_USER_KEY="SESSION_CMT_BUSINESS_USER_KEY";

    // 点评活动key 写点评框提示语
    public final static String LVMAMA_CMT_WRITE_ACTIVITY = "LVMAMA_CMT_WRITE_ACTIVITY";

    // 点评活动奖金token, MD5随机生成
    public final static String CMT_ACTIVITY_REFUND_TOKEN = "a093d9e86e3e405fec877F0Fa65e1ace";
    
    /**
     * 敏感词KEY
     */
    public static final String CMT_FRONT_COMMENT_SENSITIVEKEYS = "CMT_FRONT_COMMENT_SENSITIVEKEYS";

    // 点评活动排行返回值最多条数
    public final static long MAX_CMT_COUNT = 300L;
    
    /**
     * 前十名用户标志
     */
    public static final int TOP_NUMBER_OF_MAX__COMMENT = 10;
	
    public static final String CMT_SMS_INVITE = "INVITE";
    public static final String CMT_SMS_NOTICE = "NOTICE";
    
    
	//目的地品类
	public static enum DEST_TYPE_CATEGORY{
		DISTRICT,//行政区域
		POI,
		CRUISE//邮轮
	}
    // 点评目的地类型
 	public static enum CMT_DEST_TYPE {
 		CONTINENT(DEST_TYPE_CATEGORY.DISTRICT,"大洲"), 
 		SPAN_COUNTRY(DEST_TYPE_CATEGORY.DISTRICT,"跨国家地区"), 
 		COUNTRY(DEST_TYPE_CATEGORY.DISTRICT,"国家"), 
 		SPAN_PROVINCE(DEST_TYPE_CATEGORY.DISTRICT,"跨州省地区"), 
 		PROVINCE(DEST_TYPE_CATEGORY.DISTRICT,"州省"), 
 		SPAN_CITY(DEST_TYPE_CATEGORY.DISTRICT,"跨城市地区"), 
 		CITY(DEST_TYPE_CATEGORY.DISTRICT,"城市/直辖市/特区"), 
 		SPAN_COUNTY(DEST_TYPE_CATEGORY.DISTRICT,"跨区县地区"),
 		COUNTY(DEST_TYPE_CATEGORY.DISTRICT,"区/县"),
 		SPAN_TOWN(DEST_TYPE_CATEGORY.DISTRICT,"跨乡镇地区"),
 		TOWN(DEST_TYPE_CATEGORY.DISTRICT,"乡镇/街道"),
 		SCENIC(DEST_TYPE_CATEGORY.POI,"景区"),
 		VIEWSPOT(DEST_TYPE_CATEGORY.POI,"景点"),
 		RESTAURANT(DEST_TYPE_CATEGORY.POI,"餐厅"),
 		SHOP(DEST_TYPE_CATEGORY.POI,"购物地"),
 		HOTEL(DEST_TYPE_CATEGORY.POI,"酒店"),
 		SCENIC_ENTERTAINMENT(DEST_TYPE_CATEGORY.POI,"娱乐点"),
 		CRUISE(DEST_TYPE_CATEGORY.CRUISE,"邮轮");
 		private DEST_TYPE_CATEGORY category;
		private String cnName;

		public static String getCnName(String code) {
			for (CMT_DEST_TYPE item : CMT_DEST_TYPE.values()) {
				if (item.getCode().equalsIgnoreCase(code)) {
					return item.getCnName();
				}
			}
			return code;
		}
		
		public static List<CMT_DEST_TYPE> getObjectTypes(String category){
			List<CMT_DEST_TYPE> result = new ArrayList<CMT_DEST_TYPE>();
			for (CMT_DEST_TYPE item : CMT_DEST_TYPE.values()) {
				if (item.getCategory().name().equals(category)) {
					result.add(item);
				}
			}
			return result;
		}
		
		public static  Map<String,String> getkeyList(){
			Map<String,String> map=new HashMap<String,String>();
			for(CMT_DEST_TYPE item:CMT_DEST_TYPE.values()){
				map.put(item.getCode(),item.getCnName());
			}
			return map;
		}
		
		public static String getDestTypeCategory(String destType){
			for (CMT_DEST_TYPE item:CMT_DEST_TYPE.values()) {
				if(item.name().equalsIgnoreCase(destType)){
					return item.getCategory().name();
				}
			}
			return DEST_TYPE_CATEGORY.DISTRICT.name();
		}
		
		CMT_DEST_TYPE(DEST_TYPE_CATEGORY category, String name) {
			this.category = category;
			this.cnName = name;
		}

		public String getCode() {
			return this.name();
		}
		
		public DEST_TYPE_CATEGORY getCategory() {
			return this.category;
		}

		public String getCnName() {
			return this.cnName;
		}

		@Override
		public String toString() {
			return this.name();
		}
 	}
 	 /**
     * VST系统品类列表
     * 0为父品类
     */
    public static enum VST_CATEGORY{
    	CATEGORY_HOTEL("0","1","酒店"),
    	CATEGORY_CRUISE("0","2","邮轮"),
    	CATEGORY_INSURANCE("0","3","保险"),
    	CATEGORY_VISA("0","4","签证"),
    	CATEGORY_TICKET("0","5","门票 "),
    	CATEGORY_COMB("0","6","组合产品"),
    	CATEGORY_ADDITION("0","7","附加项目"),
    	//邮轮组合产品作为邮轮的子类，这里与vst不同
    	CATEGORY_COMB_CRUISE("2","8","邮轮组合产品"),
    	CATEGORY_SIGHTSEEING("7","9","岸上观光"),
    	CATEGORY_CRUISE_ADDITION("7","10","邮轮附加项"),
    	CATEGORY_SINGLE_TICKET("5","11","景点门票"),
    	CATEGORY_OTHER_TICKET("5","12","其它票"),
    	CATEGORY_COMB_TICKET("5","13","组合套餐票"),
    	CATEGORY_ROUTE("0","14","线路"),
    	CATEGORY_ROUTE_GROUP("14","15","跟团游"),
    	CATEGORY_ROUTE_LOCAL("14","16","当地游"),
    	CATEGORY_ROUTE_HOTELCOMB("14","17","酒店套餐"),
    	CATEGORY_ROUTE_FREEDOM("14","18","自由行"),
    	CATEGORY_ROUTE_AERO_HOTEL("14","29","交通+X"),
    	
    	CATEGORY_OTHER("0","90","其它"),
    	CATEGORY_TRAFFIC_AEROPLANE("19","20","机票"),
    	CATEGORY_TRAFFIC_AERO_OTHER("19","21","其它机票"),
    	CATEGORY_TRAFFIC_TRAIN("19","22","火车票"),
    	CATEGORY_TRAFFIC_TRAIN_OTHER("19","23","其它火车票"),
    	CATEGORY_TRAFFIC_BUS("19","24","巴士"),
    	CATEGORY_TRAFFIC_BUS_OTHER("19","25","其它巴士"),
    	CATEGORY_TRAFFIC_SHIP("19","26","船票"),
    	CATEGORY_TRAFFIC_SHIP_OTHER("19","27","其它船票"),
    	CATEGORY_WIFI("0","28","WIFI/电话卡"),
    	CATEGORY_LOCAL_PLAY("0","30","当地玩乐"),
    	CATEGORY_SHOW_TICKET("30","31","演出票"),
    	CATEGORY_CONNECTS("30","41","交通接驳"),
	    CATEGORY_FOOD("30","43","美食"),  
	    CATEGORY_SPORT("30","44","娱乐"), 
	    CATEGORY_SHOP("30","45","购物"),
		CATEGORY_PRESALE("0","99","预售");

    	private String fathercategoryId;
		private String categoryId;
		private String cnName;
		
		VST_CATEGORY(String fathercategoryId,String categoryId,String cnName){
			this.fathercategoryId = fathercategoryId;
			this.categoryId=categoryId;
			this.cnName=cnName;
		}
		
		public String getCode(){
			return this.name();
		}
		public String getFathercategoryId(){
			return this.fathercategoryId;
		}
		public String getCategoryId(){
			return this.categoryId;
		}
		public String getCnName(){
			return this.cnName;
		}
		
		public static String getCnNameByCode(String code){
			for(VST_CATEGORY item:VST_CATEGORY.values()){
				if(item.getCode().equalsIgnoreCase(code)) {
					return item.getCnName();
				}
			}
			return code;
		}
		
		public static String getCategoryIdByCode(String code){
			for(VST_CATEGORY item:VST_CATEGORY.values()){
				if(item.getCode().equalsIgnoreCase(code)){
					return item.categoryId;
				}
			}
			return null;
		}
		public static String getCnNameByStatus(String categoryId){
			for(VST_CATEGORY item:VST_CATEGORY.values()){
				if(item.categoryId.equals(categoryId)) {
					return item.getCnName();
				}
			}
			return categoryId;
		}
		public static String getCodeByCategoryId(String categoryId){
			for (VST_CATEGORY item:VST_CATEGORY.values()) {
				if(item.categoryId.equals(categoryId)){
					return item.name();
				}
			}
			return null;
		}
		
		public static String getfatherCategoryCode(String code){
			for (VST_CATEGORY item : VST_CATEGORY.values()) {
				if(item.getCode().equalsIgnoreCase(code)){
					if(item.fathercategoryId.equals("0")){
						return item.getCode();
					}
					for (VST_CATEGORY itemf : VST_CATEGORY.values()){
						if(itemf.categoryId.equals(item.fathercategoryId)){
							return itemf.getCode();
						}
					}
				}
			}
			return code;
		}
		
		public static String getCodeListByCategoryId(String categoryId){
			StringBuffer sb = new StringBuffer();
			for (VST_CATEGORY item : VST_CATEGORY.values()) {
				if(item.fathercategoryId.equals(categoryId)){
					sb.append(item.getCode()).append(",");
				}
			}
			
			return sb.toString();
		}
		
		public String toString(){
			return this.name();
		}
		
		public static  Map<String,String> getkeyList(){
			Map<String,String> map=new HashMap<String,String>();
			for(VST_CATEGORY item:VST_CATEGORY.values()){
				map.put(item.getCode(),item.getCnName());
			}
			return map;
		}
	}
    
    public static enum CHANNEL {
		WEIXIN("微信"),
		LIANTONG("联通"),
		TAOBAL("淘宝"),
		TAOBAO_DISTRIBUTOR("淘宝分销"), 
		TAOBAO_DISTRIBUTOR_CHANGLONG("淘宝分销长隆"), 
		ETICKET("淘宝电子平台"),
		OTHER("其它分销"),
		ZHONGKANG("中康分销"),
		BACKEND("驴妈妈后台"),
		FRONTEND("驴妈妈前台"),
		SMS("短信"),
		WAP("WAP"),
		WP8("WP8"),
		SERVICESTATION("服务站"),
		CLIENT("客户端"),
		TOUCH("触屏版"),
	    ANDROID("安卓"),
	    IPHONE("IPHONE"),
	    IPAD("IPAD"),
		HUANLEGU("上海欢乐谷"),
		CTRIP("携程分销"),
		//SYBAIN("赛班"),
		TUANGOU("特卖会"),
		OCJ("东方CJ"),
		HAOYIGO("好易购"),
		SANYA_QUNA("三亚去哪儿"),
		ZHEJIANGLVYOU_TIANMAO("浙江旅游局天猫店"),
        TCL_FX("TLC分销"),
		TAOBAO_ZHEKOUDIAN("旅游票务折扣店—总部淘宝"),
		TAOBAO_TEHUIWANG("特惠票务网—总部淘宝"),
		TAOBAO_GUDOU("古兜淘宝店"),
		EXPORT_DIEM("导码专用"),
		DIST_YUYUE("分销预约平台"),
		DISTRIBUTION_YIHAODIAN("1号店"),
		DISTRIBUTION_JINGDONG("京东分销"),
		DISTRIBUTION_YINLIAN("银联分销"),
		DISTRIBUTION_QUNA("去哪线路分销"),
		DISTRIBUTION_ZHOUWU("周五网分销"),
		DISTRIBUTION_QUNA_TUAN("去哪儿线路团购平台"),
		DISTRIBUTION_QUNA_TICKET("去哪门票分销"),
		DISTRIBUTION_QUNA_TICKET_TUAN("去哪儿门票团购平台"),
		DISTRIBUTION_JINZONGLV("金棕榈分销"),
		DISTRIBUTION_UNICOM114("联通114分销"),
		DISTRIBUTION_SHMOBILE("上海移动"),
		DISTRIBUTION_NAVIDOG("导航犬"),
		DISTRIBUTION_SUNING("苏宁易购"),
		DISTRIBUTION_XIEXIE("谢谢网团购分销"),
		DISTRIBUTION_LASHOU("拉手网团购分销"),
		DISTRIBUTION_YODODO("游多多分销"),
		DISTRIBUTION_WONJAM("河南万家分销"),
		DISTRIBUTION_114PIAOWU("分销支付-114票务分销"),
		DISTRIBUTION_CKDEVICE("立式设备"),
		DISTRIBUTION_RENWOYOU("任我游分销"),
		DISTRIBUTION_YIKUAIQU("一块去旅行分销"),
		DISTRIBUTION_PIAOGUANJIA("票管家分销"),
		DISTRIBUTION_MEITUAN("美团分销"),
		DISTRIBUTOR_CHERRY("樱桃旅行分销"),
		DISTRIBUTOR_B2B("分销平台"),
		TMALL_CHENGDU("天猫成都店"),
		WECHATE_STORE("微信小店"),
		LVTU_TEAM_BUYING("驴途团购"),
		//添加vst订单来源 zhangyong 2015年1月19日 16:57:22
        VST_DISTRIBUTOR_3("驴妈妈前台"),
        VST_DISTRIBUTOR_2("驴妈妈后台"),
        VST_DISTRIBUTOR_4("分销商"),
        VST_DISTRIBUTOR_5("兴旅同业中心");
		
		private String cnName;
		CHANNEL(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(CHANNEL item:CHANNEL.values()){
				if(item.getCode().equalsIgnoreCase(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		public String toString(){
			return this.name();
		}
	}
    
    /**
	 * 点评审核状态
	 */
	public static enum CMT_AUDIT_STATUS {
		/** 待审核 */
		AUDIT_GOING,
		/** 审核通过 */
		AUDIT_SUCCESS,
		/** 审核未通过 */
		AUDIT_FAILED
	}
	
	/**
	 * 点评构建状态 
	 * */
	public static enum CMT_BUILD_STATUS {
		/** 待构建 */
		BUILD_GOING,
		/** 构建成功 */
		BUILD_SUCCESS,
		/** 构建失败 */
		BUILD_FAILED,
		/** 不需要构建 */
		NO_BUILD
	}
	
	
	public static enum CMT_EFFECT_TYPE {
		NORMAL("常规"),
		PROPOSAL("建议"),
		COMPLAINT("投诉");
		
		private String cnName;
		
		CMT_EFFECT_TYPE(String name){
			this.cnName=name;
		}
		public String getCode(){
			return this.name();
		}
		public String getCnName(){
			return this.cnName;
		}
		public static String getCnName(String code){
			for(CMT_EFFECT_TYPE item: CMT_EFFECT_TYPE.values()){
				if(item.getCode().equalsIgnoreCase(code))
				{
					return item.getCnName();
				}
			}
			return code;
		}
		public String toString(){
			return "code:"+this.name()+",cnName:"+this.cnName;
		}
	}
	
	/**
	 * VST纬度
	 */
	public static enum PRODUCT_LATITUDE_VST {
		/**邮轮组合产品维度*/ 
		CATEGORY_COMB_CRUISE("邮轮产品"), 
		/**vst酒店产品维度*/ 
		CATEGORY_HOTEL("酒店和酒店产品"), 
		/**vst线路产品维度*/ 
		CATEGORY_ROUTE("线路产品"),
		/**其它票*/
		CATEGORY_OTHER_TICKET("其它票"),
		/** WIFI电话卡 */
		CATEGORY_WIFI("WIFI/电话卡"),
		/** 演出票*/
		CATEGORY_SHOW_TICKET("演出票"),
		/** 交通接驳*/
		CATEGORY_CONNECTS("交通接驳"),
		/** 签证*/
		CATEGORY_VISA("签证"),
		/** 跟团游*/
		CATEGORY_ROUTE_GROUP("跟团游"),
		/** 酒店套餐*/
        CATEGORY_ROUTE_HOTELCOMB("酒店套餐"),
        /** 自由行*/
        CATEGORY_ROUTE_FREEDOM("自由行"),
        /** 交通+X*/
		CATEGORY_ROUTE_AERO_HOTEL("交通+X"),
		/** 美食*/
	    CATEGORY_FOOD("美食"),  
	    /** 娱乐*/
	    CATEGORY_SPORT("娱乐"), 
	    /** 购物*/
	    CATEGORY_SHOP("购物");
		
		private String subject;
		
		PRODUCT_LATITUDE_VST(final String subject){
			this.subject = subject;
		}
		
		public String getCode(){
			return this.name();
		}
		public String getSubject(){
			return this.subject;
		}
		public static String getSubject(String code){
			for(PRODUCT_LATITUDE_VST item:PRODUCT_LATITUDE_VST.values()){
				if(item.getCode().equalsIgnoreCase(code))
				{
					return item.getSubject();
				}
			}
			return code;
		}
		public String toString(){
			return this.name();
		}
	}
	/**
	 * 点评回复类型
	 */
	public static enum CMT_REPLY_TYPE {
		/** 商家回复 */
		MERCHANT,
		/** 用户回复 */
		CUSTOMER,
		/** 用户回复 */
		LVMAMA
	}
	/**
     * 点评返积分规则
     */
    public static enum COMMENT_RULE {
        EXPERIENCE("POINT_FOR_EXPERIENCE_COMMENT", 100L),   // 体验点评返100积分
        COMMON("POINT_FOR_COMMON_COMMENT", 20L),            // 普通点评返20积分
        BEST("POINT_FOR_ESSENTIAL_COMMENT", 300L),          // 精华点评 300积分
        RECRUIT("POINT_FOR_RECRUIT_COMMENT", 30L);          // 前十名用户点评额外赠送30积分

        private String ruleId;
        private Long point;
        COMMENT_RULE(String ruleId, Long point) {
            this.ruleId = ruleId;
            this.point = point;
        }

        public String getRuleId() {
            return this.ruleId;
        }

        public Long getPoint() {
            return this.point;
        }

        public static Long getPoint(String ruleId) {
            for (COMMENT_RULE rule : COMMENT_RULE.values()) {
                if (rule.getRuleId() == ruleId) {
                    return rule.getPoint();
                }
            }
            return 0L;
        }
    }    
    
    public static enum MESSAGE_TEMPLATE_PC{
    	HOTEL("CATEGORY_HOTEL", "亲爱的{username}：你在{productName}入住还顺利吗？分享你的亲身体验，能为驴妈妈1000万驴友带来帮助，猛烈接受你的各种吐槽或者赞美 : ) " +
    			"发表点评http://www.lvmama.com/myspace/share/comment.do——即得￥{bonus}奖金，再赠100积分！！（积分可换超多礼品），奖金可用于二次抵扣支付。"),
    	CRUISE("CATEGORY_CRUISE", "亲爱的{username}：壕儿，你去邮轮了！返你￥{bonus}奖金，帮写条点评吧，奖金可支付抵扣，三句两句都是爱，评吧，谢谢你啦！" +
    			"发表点评http://www.lvmama.com/myspace/share/comment.do——即得￥{bonus}奖金，再赠100积分！！（积分可换超多礼品），奖金可用于二次抵扣支付。"),
    	ROUTE("CATEGORY_ROUTE", "亲爱的{username}：你在{productName}游玩还愉快吗？分享你的亲身体验，能为驴妈妈1000万驴友带来帮助，猛烈接受你的各种吐槽或者赞美 : ) " +
    			"发表点评http://www.lvmama.com/myspace/share/comment.do——即得￥{bonus}奖金，再赠100积分！！（积分可换超多礼品），奖金可用于二次抵扣支付。"),
    	LOCAL_PLAY("CATEGORY_LOCAL_PLAY", "亲爱的{username}：你在{productName}游玩还愉快吗？分享你的亲身体验，能为驴妈妈1000万驴友带来帮助，猛烈接受你的各种吐槽或者赞美 : ) " +
    			"发表点评http://www.lvmama.com/myspace/share/comment.do——即得￥{bonus}奖金，再赠100积分！！（积分可换超多礼品），奖金可用于二次抵扣支付。"),
    	VISA("CATEGORY_VISA", "亲爱的{username}：你的{productName}还未点评。分享你的亲身体验，能为驴妈妈1000万驴友带来帮助，猛烈接受你的各种吐槽或者赞美 : ) " +
    			"发表点评http://www.lvmama.com/myspace/share/comment.do——即得￥{bonus}奖金，再赠100积分！！（积分可换超多礼品），奖金可用于二次抵扣支付。"),
    	TICKET("CATEGORY_TICKET", "亲爱的{username}：你在{productName}游玩还愉快吗？分享你的亲身体验，能为驴妈妈1000万驴友带来帮助，猛烈接受你的各种吐槽或者赞美 : ) " +
    			"发表点评http://www.lvmama.com/myspace/share/comment.do——即得￥{bonus}奖金，再赠100积分！！（积分可换超多礼品），奖金可用于二次抵扣支付。");
    	private String code;
    	private String template;
    	MESSAGE_TEMPLATE_PC(String code, String template) {
    		this.code = code;
    		this.template = template;
    	}
    	
    	public static String getTemplateByCode(String code) {
    		for (MESSAGE_TEMPLATE_PC ct : values()) {
				if (ct.getCode().equals(code)) {
					return ct.getTemplate();
				}
			}
    		return null;
    	}
    	
    	public String getCode() {
			return code;
		}
		public String getTemplate() {
			return template;
		}
    }
    
    
    public static enum MESSAGE_TEMPLATE_APP {
    	HOTEL("CATEGORY_HOTEL", "在{productName}入住顺利吗，写点评返你￥{bonus}奖金，写写写拜托了！"),
    	CRUISE("CATEGORY_CRUISE", "壕儿，你去邮轮了！返你￥{bonus}奖金，帮写条点评吧，奖金可支付抵扣，评吧，谢谢你啦！"),
    	ROUTE("CATEGORY_ROUTE", "听说你去{productName}玩儿了，写点评返你￥{bonus}奖金，别拒绝好吗？"),
    	LOCAL_PLAY("CATEGORY_LOCAL_PLAY", "能用￥{bonus}奖金换你一条游玩点评吗？奖金可用于支付抵扣，现在就评，帮帮忙。"),
    	VISA("CATEGORY_VISA", "能用￥{bonus}奖金换你一条签证点评吗？奖金可用于支付抵扣，现在就评，帮帮忙。"),
    	TICKET("CATEGORY_TICKET", "{productName}景区返￥{bonus}奖金，让你帮写条好评，三句两句都是爱，点这里写>>");
    	
    	private String code;
    	private String template;
    	MESSAGE_TEMPLATE_APP(String code, String template) {
    		this.code = code;
    		this.template = template;
    	}
    	
    	public static String getTemplateByCode(String code) {
    		for (MESSAGE_TEMPLATE_APP mta : values()) {
				if (mta.getCode().equals(code)) {
					return mta.getTemplate();
				}
			}
    		return null;
    	}
    	
    	public String getCode() {
			return code;
		}
		public String getTemplate() {
			return template;
		}
    }
    
    public static enum MESSAGE_RULE_SERVICE {
    	APP, PC, PUSH;
    }
    
    public static enum CHANNEL_TEMPLATE {
     	BONUS_CATEGORY_TICKET1("CATEGORY_TICKET1", "CHANNEL_CMT_SCENIC"),
     	BONUS_CATEGORY_TICKET2("CATEGORY_TICKET2", "CHANNEL_CMT_TICKET"),	//门票有两种模板,任选其一
    	BONUS_CATEGORY_HOTEL("CATEGORY_HOTEL", "CHANNEL_CMT_HOTEL"),
    	BONUS_CATEGORY_CRUISE("CATEGORY_CRUISE", "CHANNEL_CMT_CRUISE"),
    	BONUS_CATEGORY_ROUTE("CATEGORY_ROUTE", "CHANNEL_CMT_ROUTE"),
    	BONUS_CATEGORY_LOCAL_PLAY("CATEGORY_LOCAL_PLAY", "CHANNEL_CMT_PLAY"),
    	BONUS_CATEGORY_VISA("CATEGORY_VISA", "CHANNEL_CMT_VISA"),
    	SCORE_CATEGORY_ALL("SCORE_CATEGORY_ALL", "CHANNEL_CMT_NO_BONUS"),	//积分的
    	REINVITE_BONUS_CATEGORY_ALL("NOTICE_BONUS_CATEGORY_ALL", "CHANNEL_CMT_BONUS_NOTICE"); //到期前提醒的
     	
    	private String code;
    	private String channelTemplateCode;
    	CHANNEL_TEMPLATE(String code, String channelTemplateCode) {
    		this.code = code;
    		this.channelTemplateCode = channelTemplateCode;
    	}
    	
    	public static String getChannelTemplateCodeByCode(String code) {
    		for (CHANNEL_TEMPLATE ct : values()) {
				if (ct.getCode().equals(code)) {
					return ct.getChannelTemplateCode();
				}
			}
    		return null;
    	}

		public String getCode() {
			return code;
		}

		public String getChannelTemplateCode() {
			return channelTemplateCode;
		}
    }
}
