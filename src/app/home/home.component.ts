import { Component, Input, OnInit } from '@angular/core';
import { BehaviorSubject, Observable, catchError, map, of, startWith } from 'rxjs';
import { AppState } from '../interface/app-state';
import { CustomResponse } from '../interface/custome-response';
import { DataState } from '../enum/data-state';
import { Student } from '../interface/student';
import { StudentService } from '../service/student.service';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  title = "e-school";
  appState$: Observable<AppState<CustomResponse>>;
  readonly DataState = DataState;
  private dataObject = new BehaviorSubject<CustomResponse>(null);
  private isLoading = new BehaviorSubject<boolean>(false);
  isLoading$ = this.isLoading.asObservable();
  @Input() selectedStudent: Student;
  readonly username = this.route.snapshot.queryParamMap.get('username');

  constructor(private studentService: StudentService, private route: ActivatedRoute) { }

  ngOnInit(): void {
      this.appState$ = this.studentService.students$
      .pipe(
        map(response =>{
          this.dataObject.next(response);
          return { dataState: DataState.LOADED_STATE, appData: {...response, data: { students: response.data.students.reverse() } } };
        }),
        startWith({ dataState: DataState.LOADING_STATE }),
        catchError((error: string) => {
          return of({ dataState: DataState.ERROR_STATE, error: error })
        })
      );
  }

  addStudent(studentForm: NgForm ): void {
    this.isLoading.next(true);
    this.appState$ = this.studentService.add$(studentForm.value as Student)
    .pipe(
      map(response => {
        console.log(this.dataObject);
        this.dataObject.next(
          {...response, data: { students: [response.data.student, ...this.dataObject.value.data.students] }}
        );
        document.getElementById('closeModal').click();
        this.isLoading.next(false);
        return { dataState: DataState.LOADED_STATE, appData: this.dataObject.value };
      }),
      startWith({ dataState: DataState.LOADED_STATE, appData: this.dataObject.value }),
      catchError((error: string) => {
        this.isLoading.next(false);
        return of({ dataState: DataState.ERROR_STATE, error: error })
      })
    );
    }

  deleteStudent(student: Student): void {
    this.appState$ = this.studentService.delete$(student.id)
      .pipe(
        map(response => {
          this.dataObject.next(
            {
              ...response, data:
                { students: this.dataObject.value.data.students.filter(s => s.id !== student.id) }
            }
          )
          return { dataState: DataState.LOADED_STATE, appData: this.dataObject.value };
        }),
        startWith({ dataState: DataState.LOADED_STATE, appData: this.dataObject.value }),
        catchError((error: string) => {
          return of({ dataState: DataState.ERROR_STATE, error })
        })
      );
  }
}

