package crud.online_mus_store.models;

import jakarta.persistence.*;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int status_id;

    private String statusName;

    // Getters and setters
    public int getStatusId() {
        return status_id;
    }

    public void setStatusId(int statusId) {
        this.status_id = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}