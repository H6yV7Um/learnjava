package com.memcached.vo;

import java.util.Date;
import java.util.List;



/**
 * 点评上传的图片实体
 * @author liuyi
 *
 */
public class CmtPictureVO implements java.io.Serializable {
	/**
	 * 序列
	 */
	private static final long serialVersionUID = 7437717277264297665L;
	/**
	 * 图片标识
	 */
	private Long pictureId;
	/**
	 * 点评标识
	 */
	private Long commentId;
	/**
	 * 图片存放路径
	 */
	private String picUrl;
	/**
	 * 审核状态
	 */
	private String isAudit = Constant.CMT_AUDIT_STATUS.AUDIT_SUCCESS.name();
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 用户标识
	 */
	private Long userId;
	/**
	 * 景区名称
	 */
	private String placeName;
	/**
	 * 上传时间
	 */
	private Date createDate;
	/**
	 * 描述
	 */
	private String description;
	
	private List<Long> commentIds;

    /**
     * 更新时间
     */
    private Date updateTime;

	/**
	 * 点评图片绑定目的地id
	 */
	private Long poi;
	/**
	 * 是否可审核
	 */
	public Boolean isAuditFlog() {
		Boolean isAuditFlog = Boolean.FALSE;
		
		if (Constant.CMT_AUDIT_STATUS.AUDIT_GOING.name().equals(this.isAudit)) {
			isAuditFlog = Boolean.FALSE;
		} 
		if (Constant.CMT_AUDIT_STATUS.AUDIT_FAILED.name().equals(this.isAudit)) {
			isAuditFlog = Boolean.TRUE;
		}
		if (Constant.CMT_AUDIT_STATUS.AUDIT_SUCCESS.name().equals(this.isAudit)) {
			isAuditFlog = Boolean.TRUE;
		}
		return isAuditFlog;
	}
	
	public String getChIsAudit() {
		if (Constant.CMT_AUDIT_STATUS.AUDIT_GOING.name().equals(this.isAudit)) {
			return "待审核";
		} 
		if (Constant.CMT_AUDIT_STATUS.AUDIT_FAILED.name().equals(this.isAudit)) {
			return "审核未通过";
		}
		if (Constant.CMT_AUDIT_STATUS.AUDIT_SUCCESS.name().equals(this.isAudit)) {
			return "审核通过";
		}
		return isAudit;
	}	
	
	/**
	 * 获取图片的绝对路径
	 * @return
	 */
	public String getAbsoluteUrl() {
		return "http://pic.lvmama.com" + picUrl;
	}
	
	public Long getPictureId() {
		return pictureId;
	}

	public void setPictureId(Long pictureId) {
		this.pictureId = pictureId;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getIsAudit() {
		return isAudit;
	}

	public void setIsAudit(String isAudit) {
		this.isAudit = isAudit;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getHideUserName(String userName){
		return "";
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public List<Long> getCommentIds() {
		return commentIds;
	}

	public void setCommentIds(List<Long> commentIds) {
		this.commentIds = commentIds;
	}

    public Long getPoi() {
		return poi;
	}

	public void setPoi(Long poi) {
		this.poi = poi;
	}

	public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "CmtPictureVO [pictureId=" + pictureId + ", commentId="
                + commentId + ", picUrl=" + picUrl + ", isAudit=" + isAudit
                + ", userName=" + userName + ", userId=" + userId
                + ", placeName=" + placeName + ", createDate=" + createDate
                + ", description=" + description + ", commentIds=" + commentIds
                +", poi="+poi+ "]";
    }
}

