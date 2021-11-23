package com.oburnett127.lms.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
	private int accountId;
	private ArrayList<Integer> productIds; //the product IDs of the products that are in the account's cart
}