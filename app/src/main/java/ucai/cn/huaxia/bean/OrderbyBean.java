package ucai.cn.huaxia.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/29.
 */
public class OrderbyBean implements Serializable{
    private String dir;
    private String sort;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "OrderByBean{" +
                "dir='" + dir + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }
}
