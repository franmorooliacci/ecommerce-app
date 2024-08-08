import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map, of } from 'rxjs';
import { Province } from '../common/province';

@Injectable({
  providedIn: 'root'
})
export class FormService {
  
  provincesUrl = "http://localhost:8080/api/provinces"; 

  constructor(private httpClient: HttpClient) { }

  getProvinces(): Observable<Province[]> {
    return this.httpClient.get<Province[]>(this.provincesUrl);
  }

  getCreditCardMonths(startMonth: number): Observable<number[]> {
    let data: number[] = [];

    for(let theMonth = startMonth; theMonth <= 12; theMonth++){
      data.push(theMonth);
    }

    return of(data);
  }

  getCreditCardYears(): Observable<number[]> {
    let data: number[] = [];
    const startYear: number = new Date().getFullYear();
    const endYear: number = startYear + 10;

    for(let theYear = startYear; theYear <= endYear; theYear++){
      data.push(theYear);
    }

    return of(data);
  }
}

interface GetResponseProvinces {
  _embedded: {
    provinces: Province[];
  }
}