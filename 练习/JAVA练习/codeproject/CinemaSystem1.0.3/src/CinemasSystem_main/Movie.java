package CinemasSystem_main;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Movie {
    private String name;
    private Integer date;
    private Double price;
    private String director;
    private int ticketCount;

    public Movie() {
    }

    public Movie(String name, Double price, String director, int date) {
        this(name, date, price, director, 0);
    }

    public Movie(String name, Integer date, Double price, String director, int ticketCount) {
        this.name = name;
        this.date = date;
        this.price = price;
        this.director = director;
        this.ticketCount = ticketCount;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "电影名：'" + name + '\'' +
                ", 导演：'" + director + '\'' +
                ", 上映时间：" + date +
                ", 价格：" + price +
                ", 数量： " + ticketCount;
    }
}
