import { TaskService } from '../../services/task.service';
import { Task } from '../../task';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-task-details',
  templateUrl: './task-details.component.html',
  styleUrls: ['./task-details.component.css']
})
export class TaskDetailsComponent implements OnInit {

  _id: string;
  task: Task;

  constructor(private route: ActivatedRoute,private router: Router,
    private taskService: TaskService) { }

  ngOnInit() {
    this.task = new Task();

    this._id = this.route.snapshot.params['_id'];
    console.log("gh"+this._id);
    this.taskService.getTask(this._id)
      .subscribe(data => {
        console.log(data)
        this.task = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['tasks']);
  }

}
