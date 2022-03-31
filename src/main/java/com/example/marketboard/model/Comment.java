/**
 * 
 */
package com.example.marketboard.model;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author 2ndco
 *
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@DiscriminatorValue("2")
public class Comment extends Writing {
}
////Hello world