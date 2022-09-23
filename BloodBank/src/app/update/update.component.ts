import { BloodbankService } from './../bloodbank.service';
import { Donor } from './../donor';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit {

donor: Donor=new Donor();


  constructor(private bloodBankService: BloodbankService, private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.bloodBankService.findById(this.route.snapshot.params['donorId']).subscribe(result=> this.donor=result)

  }

  update(value: Donor){
    let body= {
      donorName: value.donorName,
      dateOfBirth: value.dateOfBirth,
      gender: value.gender,
      address: value.address,
      pincode: value.pincode,
      contactNumber: value.contactNumber,
      bloodGroup: value.bloodGroup }
      this.bloodBankService.update(body, this.donor.donorId).subscribe(result =>
        { alert('Your ID '+this.route.snapshot.params['donorId']+' Updated Successfully');
        console.log(result);
        },
        error=>{alert('Invalid Inputs'); console.log(error)}
        )

  }


}
