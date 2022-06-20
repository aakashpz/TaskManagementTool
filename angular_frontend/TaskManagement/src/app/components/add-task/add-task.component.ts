import { TaskService } from '../../services/task.service';
import { Task } from '../../task';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent implements OnInit {

  
  task: Task = new Task();
  submitted = false;

  constructor(private taskService: TaskService,
    private router: Router) { }

  ngOnInit() {
  }
  newTask(): void {
    this.submitted = false;
    this.task = new Task();
  }

  save() {
    this.taskService
    .createTask(this.task).subscribe(data => {
      console.log(data)
      this.task = new Task();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/tasks']);
  }

}
