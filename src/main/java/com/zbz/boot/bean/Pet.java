package com.zbz.boot.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@ConfigurationProperties(prefix ="pet")
public class Pet {
    private String name;
}
