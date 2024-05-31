export class Userair {
    userid: number ;
    first_name: string;
    last_name: string;
    password: string;
    username:String;
    address:String;
    email : string;
    date_of_birth:any;
    constructor(userid:number, first_name:string, last_name:string,password:string , username:string,address:String,  email : string,date_of_birth:string) {
            this.userid = userid;
            this.first_name = first_name;
            this.last_name = last_name;
            this.username = username;
            this.address=address;
            this.password = password;
            this.email=email;
            this.date_of_birth=date_of_birth;

    }
}
