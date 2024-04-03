package br.infnet.at.cinema;

import br.infnet.at.movie.Movie;
import br.infnet.at.user.workerUser.WorkerUser;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private Integer id;
    private String name;
    private String address;
    private Integer openingDate;
    private WorkerUser workerUser;
    private List<Movie> movies;

    public Cinema() {
        this.setName("CWB Filmes");
        this.setAddress("Rio Japura, 427 - Bairro Alto");
        this.setOpeningDate(2023);
        this.setWorkerUser(new WorkerUser());
        this.setMovies(new ArrayList<Movie>());
    }

    public Cinema(String name, String address, Integer openingDate, WorkerUser workerUser, List<Movie> movies) {
        this.name = name;
        this.address = address;
        this.openingDate = openingDate;
        this.workerUser = workerUser;
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", openingDate=" + openingDate +
                ", workerUser=" + workerUser +
                ", movies=" + movies +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Integer openingDate) {
        this.openingDate = openingDate;
    }

    public WorkerUser getWorkerUser() {
        return workerUser;
    }

    public void setWorkerUser(WorkerUser workerUser) {
        this.workerUser = workerUser;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
