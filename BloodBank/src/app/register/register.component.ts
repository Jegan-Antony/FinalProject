import { BloodbankService } from './../bloodbank.service';
import { Component, OnInit } from '@angular/core';
import { Donor } from '../donor';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  bloodGroupName=['O+ve','O-ve','A+ve','A-ve','B+ve','B-ve','AB+ve','AB-ve'];
  donor: Donor=new Donor();

  constructor(private bloodBankService: BloodbankService) {

  }

  ngOnInit(): void {

  }

  submit(){
    console.log(this.donor);
    this.bloodBankService.save(this.donor).subscribe((result)=> {
      alert('Donor ID : '+result.donorId+' inserted sucessfully');
      console.log('Record Inserted Successfully');},
      error =>{alert('Invalid Inputs');
      console.log(error);} );

  }

}
