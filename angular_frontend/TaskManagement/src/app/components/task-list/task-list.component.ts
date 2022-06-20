import { Observable } from "rxjs";
import { TaskService } from '../../services/task.service';
import { Task } from '../../task';
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

  tasks: Observable<Task[]>;

  constructor(private taskService: TaskService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.tasks = this.taskService.getTasksList();
  }

  deleteTask(_id: string) {
  
    this.taskService.deleteTask(_id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
  updateTask(_id: string){
    this.router.navigate(['update', _id]);
  }
  taskDetails(_id: string){
    this.router.navigate(['details', _id]);
  }
}
