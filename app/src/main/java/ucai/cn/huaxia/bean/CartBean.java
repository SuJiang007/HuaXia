package ucai.cn.huaxia.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/29.
 */
public class CartBean implements Serializable{

    /**
     * id : 147183851
     * photoAddress : http:img.hx2cars.com/upload/newimg1/M02/05/C2/Clo8w1dzhCyAeT1JAAIAv9bl4gw085_small_300_200.jpg
     * buyDate : 2011年11月
     * seriesBrandCarStyle : 别克君越君越 2011款 2.4L SIDI舒适天窗版
     * isDanbao : 0
     * price : 12.5
     * mileAge : 11.0
     * credit : 0
     * retailPrice : 0.87
     * location : 江苏苏州
     * publishDate : 2016-06-29
     * createTime : null
     * userId : null
     * photoList : null
     * state : 0
     */

    private String id;
    private String photoAddress;
    private String buyDate;
    private String seriesBrandCarStyle;
    private int isDanbao;
    private String price;
    private double mileAge;
    private int credit;
    private double retailPrice;
    private String location;
    private String publishDate;
    private String createTime;
    private String userId;
    private String photoList;
    private int state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhotoAddress() {
        return photoAddress;
    }

    public void setPhotoAddress(String photoAddress) {
        this.photoAddress = photoAddress;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public String getSeriesBrandCarStyle() {
        return seriesBrandCarStyle;
    }

    public void setSeriesBrandCarStyle(String seriesBrandCarStyle) {
        this.seriesBrandCarStyle = seriesBrandCarStyle;
    }

    public int getIsDanbao() {
        return isDanbao;
    }

    public void setIsDanbao(int isDanbao) {
        this.isDanbao = isDanbao;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public double getMileAge() {
        return mileAge;
    }

    public void setMileAge(double mileAge) {
        this.mileAge = mileAge;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhotoList() {
        return photoList;
    }

    public void setPhotoList(String photoList) {
        this.photoList = photoList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "CartBean{" +
                "id='" + id + '\'' +
                ", photoAddress='" + photoAddress + '\'' +
                ", buyDate='" + buyDate + '\'' +
                ", seriesBrandCarStyle='" + seriesBrandCarStyle + '\'' +
                ", isDanbao=" + isDanbao +
                ", price='" + price + '\'' +
                ", mileAge=" + mileAge +
                ", credit=" + credit +
                ", retailPrice=" + retailPrice +
                ", location='" + location + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", createTime='" + createTime + '\'' +
                ", userId='" + userId + '\'' +
                ", photoList='" + photoList + '\'' +
                ", state=" + state +
                '}';
    }
}
