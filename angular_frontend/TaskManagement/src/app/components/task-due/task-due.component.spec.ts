import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskDueComponent } from './task-due.component';

describe('TaskDueComponent', () => {
  let component: TaskDueComponent;
  let fixture: ComponentFixture<TaskDueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TaskDueComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TaskDueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
