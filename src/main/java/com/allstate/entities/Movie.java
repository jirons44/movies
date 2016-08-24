package com.allstate.entities;

import com.allstate.enums.Genre;
import com.allstate.enums.Rating;

import javax.naming.NamingEnumeration;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    @Column(nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    private Date released;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('ACTION', 'SCIFI', 'HORROR')")
    private Genre genre;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('P', 'PG', 'R')")
    private Rating rating;

    @ManyToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "studio_id")
    private Studio studio;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "actors_movies",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"))
    private List<Actor> actors;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    public Movie() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Studio getStudio() { return studio; }

    public void setStudio(Studio studio) { this.studio = studio; }

    public List<Actor> getActors() { return actors; }

    public void setActors(List<Actor> actors) { this.actors = actors; }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
