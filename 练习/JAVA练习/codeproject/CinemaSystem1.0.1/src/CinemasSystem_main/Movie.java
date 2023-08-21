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

    public Movie(String name, Integer date, Double price, String director) {
        this.name = name;
        this.date = date;
        this.price = price;
        this.director = director;
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
        return "Movie{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", director='" + director + '\'' +
                '}';
    }
}
