package ru.itfb.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class CustomerWithOutEqualsAndHashCode {
    private Long id;
    private String fName;
    private String lName;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}
