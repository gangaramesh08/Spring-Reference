package spring.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@PropertySource("{classpath:application.properties}")
public class Account {
    private long id;
    @Value("${owner}")
    private String ownerName;
    private double balance;
    private LocalDateTime accessTime;

    public Account() {
    }

    public Account(long id, String ownerName, double balance, LocalDateTime accessTime) {
        this.id = id;
        this.ownerName = ownerName;
        this.balance = balance;
        this.accessTime = accessTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDateTime getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(LocalDateTime accessTime) {
        this.accessTime = accessTime;
    }
}
