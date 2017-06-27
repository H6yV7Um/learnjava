package com.memcached.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.memcached.vo.Constant;

public class CmtComment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3452143241941307589L;
	
	/**
	 * 点评ID
	 */
	private Long commentId;
	
	/**
	 * 目的地ID(邮轮id)
	 */
	private Long placeId;
	
	/**
	 * 产品ID
	 */
	private Long productId;
	
	/**
	 * 订单ID
	 */
	private Long orderId;
	
	/**
	 * 用户ID
	 */
	private Long userId;
	
	/**
	 * 是否精华
	 */
	private String isBest = "N";
	
	/**
	 * 是否审核
	 */
	private String isAudit = Constant.CMT_AUDIT_STATUS.AUDIT_GOING.name();
	
	/**
	 * 点评内容
	 */
	private String content;
	
	/**
	 * 返现金额
	 */
	private Long cashRefund;
	
	/**
	 * 有用数
	 */
	private Long usefulCount = 0L;
	
	/**
	 * 点评类型
	 */
	private String cmtType = Constant.COMMON_COMMENT_TYPE;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 回复数
	 */
	private Long replyCount = 0L;
	
	/**
	 * 审核时间
	 */
	private Date auditTime;
	
	/**
	 * 是否隐藏显示
	 * Y 为前台隐藏
	 * N 为前台显示
	 */
	private String isHide = "N";
	
	/**
	 * 虚假有用数
	 */
	private Long shamUsefulCount;
	
	/**
	 * 是否需要后台关注
	 */
	private String needManageAttention = "Y";
	
	/**
	 * 驴妈妈商家回复数
	 */
	private Long lvmamaReplyCount = 0L;
	
	/**
	 * 普通商家回复数
	 */
	private Long merchantReplyCount = 0L;
	
	/**
	 * 创建时间
	 */
	private Date createdTime;
	
	/**
	 * 来源渠道，默认前台
	 */
	protected String channel = Constant.CHANNEL.FRONTEND.getCode();
	
	/**
	 * 点评功能类型(常规,投诉,建议)
	 */
	private String cmtEffectType = Constant.CMT_EFFECT_TYPE.NORMAL.getCode();
	
	/**
	 * 点评是否含有敏感词
	 */
	private String isHasSensitivekey="N";
	
	/**
	 * 发点评用户端IP(用来限制批量发点评)
	 */
	private String reqIp;
	
	/**
	 * 审核状态
	 */
	private long reviewStatus = 5;
	
	/**
	 * VST品类类型 
	 */
	private String vstType;
	
	/**
	 * VST品类产品名称
	 */
	private String vstName;
	
	/**
	 * VST图片
	 */
	private String vstPicture;
	
	/**
	 * VST URL
	 */
	private String vstUrl;
	
	/**
	 * VST 商品名称    
	 * eg: VSTName=如家酒店   vstSpName=大床房
	 */
	private String vstSpName;
	
	/**
	 * 保留super的点评productId
	 */
	private Long superProductId;
	
	/**
	 * 保留super的点评placeId
	 */
	private Long superPlaceId;
	
	/**
	 * placeId存的是目的地id还是产品id,邮轮id(PLACE/PRODUCT)
	 */
	private String placeIdType;
	
	/**
	 * 平台类型VST,SUPER
	 */
	private String platform ="VST";
	
	/**
	 * 目的地类型
	 */
	private String placeType;
	
	/**
	 * 审核人ID
	 */
	private Long auditId;
	
	/**
	 * 目的地名称
	 */
	private String placeName;

	/**
	 * 更新时间
	 */
	private Date updateTime;
	
	/**
	 * 积分
	 */
	private Long point;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getIsBest() {
		return isBest;
	}

	public void setIsBest(String isBest) {
		this.isBest = isBest;
	}

	public String getIsAudit() {
		return isAudit;
	}

	public void setIsAudit(String isAudit) {
		this.isAudit = isAudit;
	}

	public String getContent() {
		return content;
	}
	public int getContentSize() {
		if(null ==content || "".equals(content.trim())){
			return 0;
		}
		return content.replaceAll("[^\\x00-\\xff]", "aa").length();
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Long getCashRefund() {
		return cashRefund;
	}
	
	public float getCashRefundYuan() {
		
		if (null == this.cashRefund) {
			return 0f;
		} else {
			BigDecimal p = new BigDecimal(cashRefund);
			return p.divide(new BigDecimal(100),2,BigDecimal.ROUND_UP).floatValue();
		
		}
	}
	
	public void setCashRefund(Long cashRefund) {
		this.cashRefund = cashRefund;
	}

	public Long getUsefulCount() {
		return usefulCount;
	}

	public void setUsefulCount(Long usefulCount) {
		this.usefulCount = usefulCount;
	}

	public String getCmtType() {
		return cmtType;
	}

	public void setCmtType(String cmtType) {
		this.cmtType = cmtType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Long replyCount) {
		this.replyCount = replyCount;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public String getIsHide() {
		return isHide;
	}

	public void setIsHide(String isHide) {
		this.isHide = isHide;
	}

	public Long getShamUsefulCount() {
		return shamUsefulCount;
	}

	public void setShamUsefulCount(Long shamUsefulCount) {
		this.shamUsefulCount = shamUsefulCount;
	}

	public String getNeedManageAttention() {
		return needManageAttention;
	}

	public void setNeedManageAttention(String needManageAttention) {
		this.needManageAttention = needManageAttention;
	}

	public Long getLvmamaReplyCount() {
		return lvmamaReplyCount;
	}

	public void setLvmamaReplyCount(Long lvmamaReplyCount) {
		this.lvmamaReplyCount = lvmamaReplyCount;
	}

	public Long getMerchantReplyCount() {
		return merchantReplyCount;
	}

	public void setMerchantReplyCount(Long merchantReplyCount) {
		this.merchantReplyCount = merchantReplyCount;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getCmtEffectType() {
		return cmtEffectType;
	}

	public void setCmtEffectType(String cmtEffectType) {
		this.cmtEffectType = cmtEffectType;
	}

	public String getIsHasSensitivekey() {
		return isHasSensitivekey;
	}

	public void setIsHasSensitivekey(String isHasSensitivekey) {
		this.isHasSensitivekey = isHasSensitivekey;
	}

	public String getReqIp() {
		return reqIp;
	}

	public void setReqIp(String reqIp) {
		this.reqIp = reqIp;
	}

	public long getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(long reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public String getVstType() {
		return vstType;
	}

	public void setVstType(String vstType) {
		this.vstType = vstType;
	}

	public String getVstName() {
		return vstName;
	}

	public void setVstName(String vstName) {
		this.vstName = vstName;
	}

	public String getVstPicture() {
		return vstPicture;
	}

	public void setVstPicture(String vstPicture) {
		this.vstPicture = vstPicture;
	}

	public String getVstUrl() {
		return vstUrl;
	}

	public void setVstUrl(String vstUrl) {
		this.vstUrl = vstUrl;
	}

	public String getVstSpName() {
		return vstSpName;
	}

	public void setVstSpName(String vstSpName) {
		this.vstSpName = vstSpName;
	}

	public Long getSuperProductId() {
		return superProductId;
	}

	public void setSuperProductId(Long superProductId) {
		this.superProductId = superProductId;
	}

	public Long getSuperPlaceId() {
		return superPlaceId;
	}

	public void setSuperPlaceId(Long superPlaceId) {
		this.superPlaceId = superPlaceId;
	}

	public String getPlaceIdType() {
		return placeIdType;
	}

	public void setPlaceIdType(String placeIdType) {
		this.placeIdType = placeIdType;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	public Long getAuditId() {
		return auditId;
	}

	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public Long getPoint() {
		return point;
	}

	public void setPoint(Long point) {
		this.point = point;
	}

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
	
	

}
