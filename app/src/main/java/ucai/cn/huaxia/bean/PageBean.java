package ucai.cn.huaxia.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/29.
 */
public class PageBean implements Serializable{

    /**
     * total : 220000
     * currpage : 1
     * nextpage : 2
     * lastpage : 14667
     */

    private int total;
    private int currpage;
    private int nextpage;
    private int lastpage;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurrpage() {
        return currpage;
    }

    public void setCurrpage(int currpage) {
        this.currpage = currpage;
    }

    public int getNextpage() {
        return nextpage;
    }

    public void setNextpage(int nextpage) {
        this.nextpage = nextpage;
    }

    public int getLastpage() {
        return lastpage;
    }

    public void setLastpage(int lastpage) {
        this.lastpage = lastpage;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "total=" + total +
                ", currpage=" + currpage +
                ", nextpage=" + nextpage +
                ", lastpage=" + lastpage +
                '}';
    }
}
