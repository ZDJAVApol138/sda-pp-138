package pl.sda.bankapp.model;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String city;
    private String street;
    private String postCode;

}
