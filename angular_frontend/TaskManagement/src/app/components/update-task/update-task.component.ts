import { TaskService } from '../../services/task.service';
import { Task } from '../../task';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-task',
  templateUrl: './update-task.component.html',
  styleUrls: ['./update-task.component.css']
})
export class UpdateTaskComponent implements OnInit {

  _id: string;
  task: Task;

  constructor(private route: ActivatedRoute,private router: Router,
    private TaskService: TaskService) { }

  ngOnInit() {
    this.task = new Task();

    this._id = this.route.snapshot.params['_id'];
    
    this.TaskService.getTask(this._id)
      .subscribe(data => {
        this.task = data;
      }, error => console.log(error));
  }

  updateTask() {
    this.TaskService.updateTask(this._id, this.task)
      .subscribe(data => {
        console.log(data);
        this.task = new Task();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateTask();    
  }

  gotoList() {
    this.router.navigate(['/tasks']);
  }

}
