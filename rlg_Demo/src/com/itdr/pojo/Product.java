package com.itdr.pojo;

/**
 * @author WangCX
 * @date 2019/8/3 9:16
 */
public class Product {
    //商品ID
    private Integer p_id;
    //分类ID
    private Integer p_categrouyId;
    //商品名称
    private String p_name ;
    //副标题
    private String p_subtitle;
    //商品图片
    private String p_mainImage;
    //是否上架
    private Integer p_status;
    //商品价格
    private Double p_price;

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public Integer getP_categrouyId() {
        return p_categrouyId;
    }

    public void setP_categrouyId(Integer p_categroyId) {
        this.p_categrouyId = p_categroyId;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_subtitle() {
        return p_subtitle;
    }

    public void setP_subtitle(String p_subtitle) {
        this.p_subtitle = p_subtitle;
    }

    public String getP_mainImage() {
        return p_mainImage;
    }

    public void setP_mainImage(String p_mainImage) {
        this.p_mainImage = p_mainImage;
    }

    public Integer getP_status() {
        return p_status;
    }

    public void setP_status(Integer p_status) {
        this.p_status = p_status;
    }

    public Double getP_price() {
        return p_price;
    }

    public void setP_price(Double p_price) {
        this.p_price = p_price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "p_id=" + p_id +
                ", p_categroyId=" + p_categrouyId +
                ", p_name='" + p_name + '\'' +
                ", p_subtitle='" + p_subtitle + '\'' +
                ", p_mainImage='" + p_mainImage + '\'' +
                ", p_status=" + p_status +
                ", p_price=" + p_price +
                '}';
    }
}
