import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListBugComponent } from './list-bugs.component';

describe('ListBugsComponent', () => {
  let component: DisplayBugsComponent;
  let fixture: ComponentFixture<DisplayBugsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListBugsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListBugsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
