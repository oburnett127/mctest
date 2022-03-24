/**
 * 
 */
package com.example.marketboard.model;

import lombok.*;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

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
@DiscriminatorValue("1")
public class Post extends Writing {
}
//