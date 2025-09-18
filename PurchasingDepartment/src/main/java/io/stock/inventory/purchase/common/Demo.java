package io.stock.inventory.purchase.common;

import java.security.SecureRandom;
import java.util.UUID;

public class Demo {
	private  String id;
	public void generateId() {
        this.id = "PRD-" + getRandomAlphaNumeric(6);
        System.out.println(id);
    }

	 private String getRandomAlphaNumeric(int length) {
	        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	        SecureRandom random = new SecureRandom();
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < length; i++) {
	            sb.append(chars.charAt(random.nextInt(chars.length())));
	        }
	        return sb.toString();
	    }
	 
	 private String generateRandomAlphanumeric(int length) {
		    return UUID.randomUUID().toString().replace("-", "").substring(0, length).toUpperCase();
		  }

		  public void generateCaseId() {
		    this.id = "CAS" + generateRandomAlphanumeric(8);
		    System.out.println(id);
		  }

		  public void generatePatientId() {
		    this.id = "PAT" + generateRandomAlphanumeric(8);
		    System.out.println(id);
		  }

	public static void main(String[] args) {
		Demo d1=new Demo();
		d1.generateId();
		d1.generateCaseId();
		d1.generatePatientId();
		
		 
		  

		   
	}

}
