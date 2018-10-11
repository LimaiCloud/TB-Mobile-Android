package com.device.limaiyun.thingsboard.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${Winter} on 2018/9/29.
 */
public class SupervisionDetilsBean {

    /**
     * _id : dQGWpfXSbK6hFBBnX
     * title : 暂不处理测试
     * members : []
     * labelIds : []
     * customFields : []
     * listId : CzRH95NthLDNvvS4S
     * boardId : kEZAvHmggGDpufvJ8
     * sort : -1
     * swimlaneId : P4FjrFu6SL98E5dNr
     * type : cardType-card
     * archived : false
     * parentId :
     * coverId :
     * createdAt : 2018-09-28T07:15:03.897Z
     * dateLastActivity : 2018-09-28T07:22:37.835Z
     * description : 暂不处理
     * requestedBy :
     * assignedBy :
     * spentTime : 0
     * isOvertime : false
     * userId : 6zAdix88mzTZNYWB6
     * subtaskSort : -1
     * linkedId :
     */

    private String _id;
    private String title;
    private String listId;
    private String boardId;
    private int sort;
    private String swimlaneId;
    private String type;
    private boolean archived;
    private String parentId;
    private String coverId;
    private String createdAt;
    private String dateLastActivity;
    private String description;
    private String requestedBy;
    private String assignedBy;
    private int spentTime;
    private boolean isOvertime;
    private String userId;
    private int subtaskSort;
    private String linkedId;
    private List<?> members;
    private List<?> labelIds;
    private List<?> customFields;

    public static List<SupervisionDetilsBean> arraySupervisionDetilsBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<SupervisionDetilsBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<SupervisionDetilsBean> arraySupervisionDetilsBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<SupervisionDetilsBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getSwimlaneId() {
        return swimlaneId;
    }

    public void setSwimlaneId(String swimlaneId) {
        this.swimlaneId = swimlaneId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCoverId() {
        return coverId;
    }

    public void setCoverId(String coverId) {
        this.coverId = coverId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDateLastActivity() {
        return dateLastActivity;
    }

    public void setDateLastActivity(String dateLastActivity) {
        this.dateLastActivity = dateLastActivity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(String assignedBy) {
        this.assignedBy = assignedBy;
    }

    public int getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(int spentTime) {
        this.spentTime = spentTime;
    }

    public boolean isIsOvertime() {
        return isOvertime;
    }

    public void setIsOvertime(boolean isOvertime) {
        this.isOvertime = isOvertime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getSubtaskSort() {
        return subtaskSort;
    }

    public void setSubtaskSort(int subtaskSort) {
        this.subtaskSort = subtaskSort;
    }

    public String getLinkedId() {
        return linkedId;
    }

    public void setLinkedId(String linkedId) {
        this.linkedId = linkedId;
    }

    public List<?> getMembers() {
        return members;
    }

    public void setMembers(List<?> members) {
        this.members = members;
    }

    public List<?> getLabelIds() {
        return labelIds;
    }

    public void setLabelIds(List<?> labelIds) {
        this.labelIds = labelIds;
    }

    public List<?> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(List<?> customFields) {
        this.customFields = customFields;
    }
}
