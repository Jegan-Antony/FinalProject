import { BloodbankService } from './../bloodbank.service';
import { Donor } from './../donor';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-fetchalldonor',
  templateUrl: './fetchalldonor.component.html',
  styleUrls: ['./fetchalldonor.component.scss']
})
export class FetchalldonorComponent implements OnInit {

  donorList: Donor[]=[];
  result="Record Deleted Successfully";
  constructor(private bloodBankService: BloodbankService) { }

  ngOnInit(): void {

    this.bloodBankService.findAll().subscribe(data => {
      this.donorList = data;
    console.log(data)});
  }

  currentData(donorId: number){
    this.bloodBankService.findById(donorId);
  }

  deleteData(donorId: number){

    this.bloodBankService.delete(donorId).subscribe(()=> {console.log(this.result);
      this.bloodBankService.findAll().subscribe(result => this.donorList=result)});
  }

}
