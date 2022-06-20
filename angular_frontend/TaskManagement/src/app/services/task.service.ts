import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private baseUrl = 'http://localhost:8080/api/v1/tasks';

  constructor(private http: HttpClient) { }

  getTask(_id: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${_id}`);
  }

  createTask(Task: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, Task);
  }

  updateTask(_id: string, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${_id}`, value);
  }

  deleteTask(_id: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${_id}`, { responseType: 'text' });
  }

  getTasksList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
