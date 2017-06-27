package com.memcached.vo;

import java.io.Serializable;

public class CmtPictureMarkVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;                    // 关联表ID
    private Long commentId;             // 点评ID
    private Long pictureId;             // 图片ID
    private Long cmtPictureMarkId;      // 图片标签ID
    private String vstType;             // 品类
    private String cmtPictureMarkName;  // 图片标签名称

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCommentId() {
        return commentId;
    }
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
    public Long getPictureId() {
        return pictureId;
    }
    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }
    public Long getCmtPictureMarkId() {
        return cmtPictureMarkId;
    }
    public void setCmtPictureMarkId(Long cmtPictureMarkId) {
        this.cmtPictureMarkId = cmtPictureMarkId;
    }
    public String getVstType() {
        return vstType;
    }
    public void setVstType(String vstType) {
        this.vstType = vstType;
    }
    public String getCmtPictureMarkName() {
        return cmtPictureMarkName;
    }
    public void setCmtPictureMarkName(String cmtPictureMarkName) {
        this.cmtPictureMarkName = cmtPictureMarkName;
    }
	@Override
	public String toString() {
		return "CmtPictureMarkVO [id=" + id + ", commentId=" + commentId
				+ ", pictureId=" + pictureId + ", cmtPictureMarkId="
				+ cmtPictureMarkId + ", vstType=" + vstType
				+ ", cmtPictureMarkName=" + cmtPictureMarkName + "]";
	}
}
