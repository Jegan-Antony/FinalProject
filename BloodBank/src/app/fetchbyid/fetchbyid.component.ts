import { Component, OnInit } from '@angular/core';
import { BloodbankService } from '../bloodbank.service';
import { Donor } from '../donor';

@Component({
  selector: 'app-fetchbyid',
  templateUrl: './fetchbyid.component.html',
  styleUrls: ['./fetchbyid.component.scss']
})
export class FetchbyidComponent implements OnInit {

donor: Donor= new Donor();
result="";

  constructor(private bloodBankService: BloodbankService) { }

  ngOnInit(): void {  }

  fetch() {
    this.bloodBankService.findById(this.donor.donorId).subscribe(data =>{this.donor=data;
    console.log(data); this.result=''}, error =>{console.log(error); this.result="No record found";
    this.donor=new Donor()});
  }

}
