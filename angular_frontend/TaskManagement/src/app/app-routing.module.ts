import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddTaskComponent } from './components/add-task/add-task.component';
import { TaskDetailsComponent } from './components/task-details/task-details.component';
import { TaskListComponent } from './components/task-list/task-list.component';
import { UpdateTaskComponent } from './components/update-task/update-task.component';

const routes: Routes = [
  { path:'', redirectTo: 'task', pathMatch: 'full' },
  { path: 'tasks', component: TaskListComponent },
  { path: 'add', component: AddTaskComponent },
  { path: 'update/:_id', component: UpdateTaskComponent },
  { path: 'details/:_id', component: TaskDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
