import { Flight } from "./flight";
import { Userair } from "./userair";

export class Booking {
  booking_id:number;
  date:Date;
  passengerName:string;
  passengerAge:number;
  seatstobook:number;
  amount:number;
  //status:string;
  flightId:number;
  flight:Flight;
  userid:number;
  userair:Userair;

  constructor(booking_id: number,date: Date,passengerName: string,passengerAge: number,  seatstobook:number,amount: number,status: string,flightId: number,flight: Flight,userid:number,userair:Userair)
  {
    

  }
}