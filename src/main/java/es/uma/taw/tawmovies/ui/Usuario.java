package es.uma.taw.tawmovies.ui;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class Usuario {
    protected String username;
    protected String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
