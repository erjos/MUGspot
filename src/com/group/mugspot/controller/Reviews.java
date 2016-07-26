package com.group.mugspot.controller;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Table;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.OneToOne;
	import org.hibernate.annotations.Columns;

	@Entity
	@Table(name = "reviews")
	public class Reviews {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column   (name = "user_id")
		private int user_id;
		
		@Column(name = "reviews")
		private String review;
		
		@Column(name = "ratings")
		private int rating;
		

		@Column(name = "shop_id")
		private String shop_id;
		


		public Reviews() {}

		public Reviews(int id, int user_id, String review, int rating, String shop_id) {
			super();
			this.id = id;
			this.user_id = user_id;
			this.review = review;
			this.rating = rating;
			this.shop_id = shop_id;
		}

		public int getId() {
			return id;
		}

		public int getUser_id() {
			return user_id;
		}

		public String getReview() {
			return review;
		}

		public int getRating() {
			return rating;
		}


		public void setId(int id) {
			this.id = id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public void setReview(String review) {
			this.review = review;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

		public void setPlace_id(String place_id) {
			this.shop_id = place_id;
		}
		
		public String getShop_id() {
			return shop_id;
		}

		public void setShop_id(String shop_id) {
			this.shop_id = shop_id;
		}

		@Override
		public String toString() {
			return "Reviews [id=" + id + ", user_id=" + user_id + ", review=" + review + ", rating=" + rating
					+ ", shop_id=" + shop_id + "]";
		}
		
	}
	

