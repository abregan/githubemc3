import { Time } from "@angular/common";

export class Flight {
    flightId :number;
	flightName :string;
	arrival_time :string;
	depature_time :string;
	start_place :string;
	endPlace :string;
	noOfSeats :number;
    price:number;
    constructor(flightId :number,flightName :string,arrival_time :string,depature_time :string,start_place :string,endPlace :string,noOfSeats :number,price:number){
        this.flightId=flightId;
        this.flightName=flightName;
        this.arrival_time=arrival_time;
        this.depature_time=depature_time;
        this.start_place=start_place;
        this.endPlace=endPlace;
        this.noOfSeats=noOfSeats;
        this.price=price;
    }
    
}
