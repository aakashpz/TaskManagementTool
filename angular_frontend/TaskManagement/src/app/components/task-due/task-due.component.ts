import { Observable } from "rxjs";
import { TaskService } from '../../services/task.service';
import { Task } from '../../task';
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: 'app-task-due',
  templateUrl: './task-due.component.html',
  styleUrls: ['./task-due.component.css']
})
export class TaskDueComponent implements OnInit {

  tasks: Observable<Task[]>;

  constructor(private taskService: TaskService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.tasks = this.taskService.getDueTasksList();
  }

  list(){
    this.router.navigate(['tasks']);
  }
}
