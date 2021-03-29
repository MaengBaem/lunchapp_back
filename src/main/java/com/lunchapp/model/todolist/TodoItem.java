package com.lunchapp.model.todolist;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.lunchapp.model.BaseTimeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class TodoItem extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)")
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name="master")
	private TodoList master;

	@ManyToOne
	@JoinColumn(name="parent")
	private TodoItem parent;
	
	@OneToMany(mappedBy = "parent")
	private List<TodoItem> children;
	
	@Enumerated(EnumType.STRING)
	private ILEVEL level;
	
}
