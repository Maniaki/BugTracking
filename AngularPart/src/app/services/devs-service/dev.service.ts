import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Dev } from '../../models/Dev';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DevService {

  constructor(private http: HttpClient) { }

  public getDevsList(): Observable<Dev[]> {
    return this.http.get<Dev[]>(`${environment.url}/dev/all`);
  }

   public deleteBug(id: number): Observable<any> {
    return this.http.delete(`${environment.url}/dev/delete/${id}`);
  }
  public createBug(dev: Dev): Observable<Dev> {
    return this.http.post<Dev>(`${environment.url}/dev/create`, dev);
  }

}
