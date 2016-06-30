package ucai.cn.huaxia.bean;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Administrator on 2016/6/29.
 */
public class ResultBean implements Serializable{
    private CartBean[] carList;
    private int danbaoTotal;
    private String message;
    private PageBean page;
    private SearchBean searchVo;

    public CartBean[] getCarList() {
        return carList;
    }

    public void setCarList(CartBean[] carList) {
        this.carList = carList;
    }

    public int getDanbaoTotal() {
        return danbaoTotal;
    }

    public void setDanbaoTotal(int danbaoTotal) {
        this.danbaoTotal = danbaoTotal;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public SearchBean getSearchVo() {
        return searchVo;
    }

    public void setSearchVo(SearchBean searchVo) {
        this.searchVo = searchVo;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "carList=" + Arrays.toString(carList) +
                ", danbaoTotal=" + danbaoTotal +
                ", message='" + message + '\'' +
                ", page=" + page +
                ", searchVo=" + searchVo +
                '}';
    }
}
