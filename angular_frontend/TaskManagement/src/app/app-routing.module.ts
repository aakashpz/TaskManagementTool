import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddTaskComponent } from './components/add-task/add-task.component';
import { TaskDetailsComponent } from './components/task-details/task-details.component';
import { TaskDueComponent } from './components/task-due/task-due.component';
import { TaskListComponent } from './components/task-list/task-list.component';
import { TaskOverdueComponent } from './components/task-overdue/task-overdue.component';
import { UpdateTaskComponent } from './components/update-task/update-task.component';

const routes: Routes = [
  { path:'', redirectTo: 'task', pathMatch: 'full' },
  { path: 'tasks', component: TaskListComponent },
  { path: 'add', component: AddTaskComponent },
  { path: 'update/:_id', component: UpdateTaskComponent },
  { path: 'details/:_id', component: TaskDetailsComponent },
  { path: 'due', component: TaskDueComponent},
  { path: 'overdue', component: TaskOverdueComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
