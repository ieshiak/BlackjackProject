package com.skilldistillery.blackjack.entities;

public enum Color {
	 RED("\u001B[31m"),
	    BLACK("\u001B[30m");

	    private final String code;

	    Color(String code) {
	        this.code = code;
	    }

	    public String getCode() {
	        return code;
	    }
	}