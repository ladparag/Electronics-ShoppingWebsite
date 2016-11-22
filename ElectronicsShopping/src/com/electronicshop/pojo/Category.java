package com.electronicshop.pojo;

public class Category {
	
	 	private int catId;
	    private String catName;
	    
		@Override
		public String toString() {
			return "Category [catId=" + catId + ", catName=" + catName + "]";
		}

		public int getCatId() {
			return catId;
		}

		public void setCatId(int catId) {
			this.catId = catId;
		}

		public String getCatName() {
			return catName;
		}

		public void setCatName(String catName) {
			this.catName = catName;
		}
	    
	    

}
