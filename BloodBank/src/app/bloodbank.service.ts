import { Observable } from 'rxjs';
import { Donor } from './donor';
import { HttpClient, HttpParams} from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BloodbankService {

  private url1: string;
  private url2: string;
  private url3: string;
  private url4: string;
  private url5: string;

  constructor(private http: HttpClient) {
    this.url1='http://localhost:8080/insertDonorDetails';
    this.url2='http://localhost:8080/fetchAllDonorDetails';
    this.url3='http://localhost:8080/fetchDonorDetailsByDonorId';
    this.url4='http://localhost:8080/updateDonorDetails';
    this.url5='http://localhost:8080/deleteDonorByDonorId/';
  }

  public save(donor: any): Observable<any>{
    return this.http.post<Donor>(this.url1, donor);
  }

  public findAll(): Observable<any>{
    return this.http.get<any>(this.url2);
  }

  public findById(donorId: number): Observable<Donor> {

    return this.http.get<Donor>(this.url3,{params :{donorId: donorId}});
  }

  public update(donor: any, donorId: number) : Observable<any>{

    return this.http.put(this.url4,donor,{ params: { donorId: donorId} } );
  }

  public delete(donorId: number): Observable<any> {

    return this.http.delete(this.url5+donorId);
  }


}
