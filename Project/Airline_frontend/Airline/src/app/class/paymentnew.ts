import { Userair } from "./userair"

export class Paymentnew {
    payment_id:number
    amount:number
    //method:string
    nameOnCard:string
    cardNumber:string
    expYear:string
    cvv:string
    paidDate:Date//any
    paidAmount:number;

    booking_id:number;
     userair: Userair;

    constructor(payment_id: number,amount:number, nameOnCard: string,
        cardNumber: string, expYear: string, cvv: string, paidDate: Date,paidAmount: number, booking_id:number,userair:Userair)
        {

        }
    }
