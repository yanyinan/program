package System;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Movie {
    private String name;
    private double price;
    private Integer date;
    private String director;

    public Movie(String name, double price, Integer date, String director) {
        setName(name);
        setPrice(price);
        setDate(date);
        setDirector(director);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "电影：" + name  +
                ", 价格：" + price +
                ", 上映时间" + date +
                ", 导演" + director ;
    }
}
