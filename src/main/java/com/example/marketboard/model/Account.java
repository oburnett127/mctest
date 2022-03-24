package com.example.marketboard.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true, length = 50, name = "email")
	private String email;
	@Column(nullable = false, length = 50, name = "first_name")
	private String firstName;
	@Column(nullable = false, length = 50, name = "last_name")
	private String lastName;
	@OneToMany(mappedBy="account")
	@ToString.Exclude
	private List<com.example.marketboard.model.Post> posts;
	@OneToMany(mappedBy="account")
	@ToString.Exclude
	private List<com.example.marketboard.model.Comment> comments;
}