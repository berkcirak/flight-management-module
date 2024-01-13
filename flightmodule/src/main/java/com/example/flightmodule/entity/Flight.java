package com.example.flightmodule.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "flight_no")
    private String flightNo;
    @JoinColumn(name = "airline_id",referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Airline airline;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "aircraft_id",referencedColumnName = "id")
    private Aircraft aircraft;
    @Column(name = "flight_date")
    private LocalDate flightDate;

    //flightleg enum sekilde tanımlanacak

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "system_airport_id",referencedColumnName = "id")
    private Station systemAirport;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "origin_station_id",referencedColumnName = "id")
    private Station originStation;

    @Column(name = "cretime")
    @CreationTimestamp
    private LocalDateTime creTime;
    @Column(name = "update_time")
    @UpdateTimestamp
    private LocalDateTime updateTime;
    @Column(name = "update_user")
    private String updateUser;

    public Flight(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public Station getSystemAirport() {
        return systemAirport;
    }

    public void setSystemAirport(Station systemAirport) {
        this.systemAirport = systemAirport;
    }

    public Station getOriginStation() {
        return originStation;
    }

    public void setOriginStation(Station originStation) {
        this.originStation = originStation;
    }

    public LocalDateTime getCreTime() {
        return creTime;
    }

    public void setCreTime(LocalDateTime creTime) {
        this.creTime = creTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
