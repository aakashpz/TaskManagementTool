import { Observable } from "rxjs";
import { TaskService } from '../../services/task.service';
import { Task } from '../../task';
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';


@Component({
  selector: 'app-task-overdue',
  templateUrl: './task-overdue.component.html',
  styleUrls: ['./task-overdue.component.css']
})
export class TaskOverdueComponent implements OnInit {
  tasks: Observable<Task[]>;

  constructor(private taskService: TaskService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }
  reloadData() {
    this.tasks = this.taskService.getOverDueTasksList();;
  }
  list(){
    this.router.navigate(['tasks']);
  }

}
