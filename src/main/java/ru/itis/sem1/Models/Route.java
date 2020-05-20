package ru.itis.sem1.Models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dp1_id")
    private DestinationPoint dp1;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dp2_id")
    private DestinationPoint dp2;

    private Integer distance;
    private Integer cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public DestinationPoint getDp2() {
        return dp2;
    }

    public void setDp2(DestinationPoint dp2) {
        this.dp2 = dp2;
    }

    public DestinationPoint getDp1() {
        return dp1;
    }

    public void setDp1(DestinationPoint dp1) {
        this.dp1 = dp1;
    }



    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", dp1=" + dp1 +
                ", dp2=" + dp2 +
                ", distance=" + distance +
                ", cost=" + cost +
                '}';
    }
}

