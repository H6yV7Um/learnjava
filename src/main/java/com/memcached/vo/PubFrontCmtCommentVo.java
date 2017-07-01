package com.memcached.vo;

import java.util.List;
import java.util.Map;

/***
 * 前台点评通用字段
 * @author liudong
 */
public class PubFrontCmtCommentVo extends CmtComment {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8377372702877176839L;
	/**
	 * 判断是否有图片
	 */
	private String isPicture;
	/**
	 * 上传图片数
	 */
	private Long pictureCount;
	
	/**
	 * 总体点评
	 */
	private CmtLatitudeVO sumaryLatitude;
	/**
	 * 点评维度
	 */
	private List<CmtLatitudeVO> cmtLatitudes;
	/**
	 * 商家点评回复
	 */
	private List<CmtReplyVO> replies;
	/**
	 * 商家回复
	 */
	private List<CmtReplyVO> merchantReplies;
	/**
	 * lvmama回复
	 */
	private List<CmtReplyVO> lvmamaReplies;
//	
	/**
	 * 点评发布的图片
	 */
	private List<CmtPictureVO> cmtPictureList;
	/**
	 * 点评是否含有关键词
	 */
	private String isHasSensitivekey="N";
	/**
	 * 回复点评list
	 */
	private List<CmtReplyVO> cmtReplyVOList;
	
	/**
	 * 是否手机客户端
	 */
	private String isMoblie ="N";
	/**
	 * 目的地跳转链接(自己组装)
	 */
	private String destUrl;

	/**
     * 客户端版本号
     */
    private String appVersion;
    
    /**
     * 设备型号
     */
    private String phoneModel; // 2016/07/29 added by zll


	/**
	 * 图片标签
	 */
	private Map<String, List<CmtPictureMarkVO>> cmtPictureMarkMap;
	
	public String getIsPicture() {
		return isPicture;
	}

	public void setIsPicture(String isPicture) {
		this.isPicture = isPicture;
	}
	
	public Long getPictureCount() {
		return pictureCount;
	}

	public void setPictureCount(Long pictureCount) {
		this.pictureCount = pictureCount;
	}

	public CmtLatitudeVO getSumaryLatitude() {
		return sumaryLatitude;
	}

	public void setSumaryLatitude(CmtLatitudeVO sumaryLatitude) {
		this.sumaryLatitude = sumaryLatitude;
	}

	public List<CmtLatitudeVO> getCmtLatitudes() {
		return cmtLatitudes;
	}

	public void setCmtLatitudes(List<CmtLatitudeVO> cmtLatitudes) {
		this.cmtLatitudes = cmtLatitudes;
	}

	public List<CmtReplyVO> getReplies() {
		return replies;
	}

	public void setReplies(List<CmtReplyVO> replies) {
		this.replies = replies;
	}

	public List<CmtReplyVO> getMerchantReplies() {
		return merchantReplies;
	}

	public void setMerchantReplies(List<CmtReplyVO> merchantReplies) {
		this.merchantReplies = merchantReplies;
	}

	public List<CmtReplyVO> getLvmamaReplies() {
		return lvmamaReplies;
	}

	public void setLvmamaReplies(List<CmtReplyVO> lvmamaReplies) {
		this.lvmamaReplies = lvmamaReplies;
	}

	public List<CmtPictureVO> getCmtPictureList() {
		return cmtPictureList;
	}

	public void setCmtPictureList(List<CmtPictureVO> cmtPictureList) {
		this.cmtPictureList = cmtPictureList;
	}

	public String getIsHasSensitivekey() {
		return isHasSensitivekey;
	}

	public void setIsHasSensitivekey(String isHasSensitivekey) {
		this.isHasSensitivekey = isHasSensitivekey;
	}

	public List<CmtReplyVO> getCmtReplyVOList() {
		return cmtReplyVOList;
	}

	public void setCmtReplyVOList(List<CmtReplyVO> cmtReplyVOList) {
		this.cmtReplyVOList = cmtReplyVOList;
	}

	
	public String getIsMoblie() {
		if(Constant.CHANNEL.BACKEND.name().equalsIgnoreCase(this.channel) || 
				Constant.CHANNEL.FRONTEND.name().equalsIgnoreCase(this.channel) || 
				"ELONG".equalsIgnoreCase(this.channel)){
			this.isMoblie = "N";
		}else{//手机端
			this.isMoblie = "Y";;
		}
		return isMoblie;
	}

	public void setIsMoblie(String isMoblie) {
		this.isMoblie = isMoblie;
	}

	public String getDestUrl() {
		return destUrl;
	}

	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
	}

    public Map<String, List<CmtPictureMarkVO>> getCmtPictureMarkMap() {
        return cmtPictureMarkMap;
    }

    public void setCmtPictureMarkMap(
            Map<String, List<CmtPictureMarkVO>> cmtPictureMarkMap) {
        this.cmtPictureMarkMap = cmtPictureMarkMap;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }
    
    public String getPhoneModel() {
		return phoneModel;
	}

	public void setPhoneModel(String phoneModel) {
		this.phoneModel = phoneModel;
	}	

	@Override
    public String toString() {
        return "CmtComment [commentId=" + super.getCommentId() + ", placeId=" + super.getPlaceId() + ", productId=" + super.getProductId()
                + ", orderId=" + super.getOrderId() + ", userId=" + super.getUserId() + ", userName="
                + super.getUserName() + ", cancel=" + super.getChannel() + ", cmtEffectType="
                + super.getCmtEffectType() + ", reqIp=" + super.getReqIp() + ", appVersion=" + this.getAppVersion() 
                + ", phoneModel=" + this.getPhoneModel() + "]";
	}
}
