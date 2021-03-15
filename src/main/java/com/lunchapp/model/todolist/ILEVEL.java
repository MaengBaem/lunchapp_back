package com.lunchapp.model.todolist;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ILEVEL {
	TOP(1), SUB(2), S_SUB(3);

	private int level;

	public int getLevel() {
		return level;
	}
}
