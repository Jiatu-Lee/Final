package cc.worksite.aoko.util;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by Lee on 2016/8/31 0031.
 */
public class Infos extends BmobObject {

//    public Infos() {
//        this.setTableName("Infos");
//    }
    private String title,summary, describe, phone,photo_uri;
    private BmobFile file;

    public BmobFile getFile() {
        return file;
    }

    public void setFile(BmobFile file) {
        this.file = file;
    }

    public String getPhoto_uri() {
        return photo_uri;
    }

    public void setPhoto_uri(String photo_uri) {
        this.photo_uri = photo_uri;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescribe() {
        return describe;
    }

    public String getPhone() {
        return phone;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
