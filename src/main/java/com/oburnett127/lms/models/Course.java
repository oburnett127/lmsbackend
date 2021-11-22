package com.oburnett127.lms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
	private int id;
	private String name;
	private String description;
	private BigDecimal price;
	private String author;
	private ImageIcon image;
	private String category;
	private List<String> tags;
	private List<Rating> ratings;
	private List<Video> videos;
}