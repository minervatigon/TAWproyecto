package es.uma.taw.tawmovies.movies;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Friendship {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id1", nullable = false)
    private es.uma.taw.tawmovies.movies.UserType userId1;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id2", nullable = false)
    private es.uma.taw.tawmovies.movies.UserType userId2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserType getUserId1() {
        return userId1;
    }

    public void setUserId1(UserType userId1) {
        this.userId1 = userId1;
    }

    public UserType getUserId2() {
        return userId2;
    }

    public void setUserId2(UserType userId2) {
        this.userId2 = userId2;
    }
}