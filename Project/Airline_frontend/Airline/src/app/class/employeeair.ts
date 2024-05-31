export class Employeeair {
    empid:number
    first_name:string
    last_name:string
    empname:string
    password:string
    emp_role:string
    date_of_birth:any
    address:string
    constructor(empid:number, first_name:string, last_name:string,empname:string,password:string ,emp_role: string,date_of_birth:string,address:string) {
        this.empid = empid;
        this.first_name = first_name;
        this.last_name = last_name;
        this.empname = empname;
        this.address=address;
        this.password = password;
        this.emp_role=emp_role;
        this.date_of_birth=date_of_birth;
    }
}
