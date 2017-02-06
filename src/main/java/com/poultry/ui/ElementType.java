package com.poultry.ui;

public enum ElementType {
	TEXT(1), PASSWORD(2), TEXTAREA(3), DROPDOWN(4);
	private int order;

	ElementType(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}

}
