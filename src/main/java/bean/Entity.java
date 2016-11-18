package bean;


import java.util.Date;

/**
 * Created by Administrator on 2016/11/11 0011.
 */
public class Entity {
    private String name;//货币名称
    private Double spotpurchase;//现汇买入价
    private Double cashpurchase;//现钞买入价
    private Double spotsellout;//现汇卖出价
    private Double cashsellout;//现钞卖出价
    private Double discountprice;//折算价
    private Date releasedate;//发布日期
    private Date releasetime;//发布时间

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSpotpurchase() {
        return spotpurchase;
    }

    public void setSpotpurchase(Double spotpurchase) {
        this.spotpurchase = spotpurchase;
    }

    public Double getCashpurchase() {
        return cashpurchase;
    }

    public void setCashpurchase(Double cashpurchase) {
        this.cashpurchase = cashpurchase;
    }

    public Double getSpotsellout() {
        return spotsellout;
    }

    public void setSpotsellout(Double spotsellout) {
        this.spotsellout = spotsellout;
    }

    public Double getCashsellout() {
        return cashsellout;
    }

    public void setCashsellout(Double cashsellout) {
        this.cashsellout = cashsellout;
    }

    public Double getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(Double discountprice) {
        this.discountprice = discountprice;
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

}
