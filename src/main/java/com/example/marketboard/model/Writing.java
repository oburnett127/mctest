/**
 * 
 */
package com.example.marketboard.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author 2ndco
 *
 */

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="writing_type", 
discriminatorType = DiscriminatorType.INTEGER)
public class Writing {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String content;
	@OneToMany(mappedBy="writing")
	@ToString.Exclude
	private List<Stock> stocks;
	//(Optional) Whether the association is optional. If set to false then a non-null relationship must always exist.
	@ManyToOne(optional=false)
	private Account account;
}
////Hello world