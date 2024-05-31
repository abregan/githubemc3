
package com.bean.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Payment")
public class Payment {



	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="payment_id")
    private int payment_id;
	
	 @NotNull(message = "Amount can not be empty")
    @Column(name="amount")
    private double amount;
    
    @Column(name="method")
    private String method;
    
    @NotNull(message = "nameOnCard can not be empty")
	@Size(max = 20,message = "nameOnCard can't be more than 20 characters")
	@Size(min=4, message="nameOnCard  must be more than 4 characters")	
    @Column(name="name_on_card") 	
    private String nameOnCard;

    @NotNull(message = "cardNumber can not be empty")
	@Size(min = 16, max =16,message = "cardNumber must be between 16 to 16 characters long.")	
    @Column(name="cardNumber")
    private String cardNumber;
    
    @NotNull(message = "expYear can not be empty")
	@Size(message = "expYear must be between 4 digits long.")	
    @Column(name="expYear")
    private String expYear;
    
    @NotNull(message = "cvv can not be empty")
	@Size(min = 3, max =3,message = "expYear must be 3 digits long.")	
    @Column(name="cvv")
    private String cvv;
    
    @Column(name="paidDate")
    private LocalDate paidDate;
    
    @NotNull(message = "paidAmount can not be empty")
    @Column(name = "paid_amount", nullable = false)
    private double paidAmount;
    
    @OneToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
	private Booking booking;

    @ManyToOne( cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="userid")

   
    
  
    private UserAir user;
    
    public Payment()
    {

    }
    

    public Payment(int payment_id, double amount,int booking_id, String method,String nameOnCard,  String cardNumber,
			String expYear, String cvv, LocalDate paidDate,double paidAmount, Booking booking,UserAir user) {
		super();
		this.payment_id = payment_id;
		this.amount = amount;
		this.method = method;
		this.nameOnCard = nameOnCard;
		this.cardNumber = cardNumber;
		this.expYear = expYear;
		this.cvv = cvv;
		this.paidDate = paidDate;
		this.paidAmount = paidAmount;
		this.booking=booking;
		this.user=user;
	}
    
    
    


	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

	

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	
	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public LocalDate getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(LocalDate paidDate) {
		this.paidDate = paidDate;
	}

	
	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}
	
	public UserAir getUser() {
		return user;
	}


	public void setUser(UserAir user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ",booking="+booking+", amount=" + amount + ", method=" + method + ", cardNumber="
				+ cardNumber + ", expYear=" + expYear + ", cvv=" + cvv + ", paidDate=" + paidDate +" ,paidAmount=" + paidAmount +",user="+ user +"]";
	}

}
