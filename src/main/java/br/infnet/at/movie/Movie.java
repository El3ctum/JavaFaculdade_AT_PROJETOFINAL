package br.infnet.at.movie;

public class Movie {
    private Integer id;
    private String name;
    private Integer releaseDate;
    private String timeDuration;
    private Integer minimumAge;

    public Movie() {
        this.setName("Os Trapalhoes");
        this.setReleaseDate(1980);
        this.setTimeDuration("2 horas");
        this.setMinimumAge(16);
    }

    public Movie(Integer id, String name, Integer releaseDate, String timeDuration, Integer minimumAge) {
        this.setName(name);
        this.setReleaseDate(releaseDate);
        this.setTimeDuration(timeDuration);
        this.setMinimumAge(minimumAge);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", timeDuration='" + timeDuration + '\'' +
                ", minimumAge=" + minimumAge +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Integer releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(String timeDuration) {
        this.timeDuration = timeDuration;
    }

    public Integer getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(Integer minimumAge) {
        this.minimumAge = minimumAge;
    }
}
