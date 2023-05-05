import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, tap, throwError } from 'rxjs';
import { CustomResponse } from '../interface/custome-response';
import { Student } from '../interface/student';

@Injectable({  providedIn: 'root'})
export class StudentService {

  private readonly apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  students$ = <Observable<CustomResponse>> this.http.get<CustomResponse>(`${this.apiUrl}/students/list`)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  );
  

  public getStudents(): Observable<CustomResponse>{
    return this.http.get<CustomResponse>(`${this.apiUrl}/students/list`)
  }

  add$ = (student: Student) => <Observable<CustomResponse>> this.http.post<CustomResponse>(`${this.apiUrl}/students/add`, student)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  delete$ = (id: number) => <Observable<CustomResponse>> this.http.delete<CustomResponse>(`${this.apiUrl}/students/delete/${id}`)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  getById$ = (id: number) => <Observable<CustomResponse>> this.http.get<CustomResponse>(`${this.apiUrl}/students/get/${id}`)
  .pipe(
    tap(console.log),
    catchError(this.handleError)
  );

  private handleError(error: HttpErrorResponse): Observable<never> {
    console.log(error);
    return throwError(`An error occurered - Error code: ${error.status}`);
  }


}
