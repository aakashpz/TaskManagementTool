import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddTaskComponent } from './components/add-task/add-task.component';
import { TaskDetailsComponent } from './components/task-details/task-details.component';
import { TaskListComponent } from './components/task-list/task-list.component';
import { UpdateTaskComponent } from './components/update-task/update-task.component';
import { TaskDueComponent } from './components/task-due/task-due.component';
import { TaskOverdueComponent } from './components/task-overdue/task-overdue.component';

@NgModule({
  declarations: [
    AppComponent,
    AddTaskComponent,
    TaskDetailsComponent,
    TaskListComponent,
    UpdateTaskComponent,
    TaskDueComponent,
    TaskOverdueComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
