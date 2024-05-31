export class Admin {
    adminid:number;
    adminName:string;
    adminPassword:string;
    address:string;
    mobile:string;
    constructor(adminid:number,adminName:string,adminPassword:string,address:string,mobile:string){
        this.adminid=adminid;
        this.adminName=adminName;
        this.adminPassword=adminPassword;
        this.address=address;
        this.mobile=mobile;

    }
}
