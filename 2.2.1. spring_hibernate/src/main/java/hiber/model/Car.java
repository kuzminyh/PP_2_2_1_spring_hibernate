package hiber.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Car implements Serializable {
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    public Car(){

    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public User getUserId() {
        return userId;
    }

    public int getSeries() {
        return series;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
