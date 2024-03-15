package ru.itfb.model;


import lombok.*;

import java.util.Objects;

@Getter
@Setter
@Builder
public class CustomerWithOutToString {
    private Long id;
    private String fName;
    private String lName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerWithOutToString customer = (CustomerWithOutToString) o;

        if (!Objects.equals(id, customer.id)) return false;
        if (!Objects.equals(fName, customer.fName)) return false;
        return Objects.equals(lName, customer.lName);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fName != null ? fName.hashCode() : 0);
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        return result;
    }
}
