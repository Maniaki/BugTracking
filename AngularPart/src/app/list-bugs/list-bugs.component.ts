import { Component, OnInit } from '@angular/core';
import { BugService } from '../services/bugs-service/bug.service';
import { Bug } from '../models/Bug';
import { delay } from 'rxjs/operators';

@Component({
  selector: 'app-list-bugs',
  templateUrl: './list-bugs.component.html',
  styleUrls: ['./list-bugs.component.css']
})
export class ListBugsComponent implements OnInit {

public bugs: Bug[];

  public showSpinner: boolean;

  constructor(private bugService: BugService) { }

  ngOnInit(): void {

    this.showSpinner = true;
    this.bugService.getBugsList()
    .pipe(delay(2000))
    .subscribe((bugsResponse => {
      this.bugs = bugsResponse;
      this.showSpinner = false;
    }));

  }

    deleteBug(id: number): void {
      this.bugService.deleteBug(id).subscribe((deleteResponse) => {
        this.bugs = this.bugs.filter(s => s.id !== id);
      }, (error) => {
        // TODO
      });
    }
    /* Callback of child component */
    addBug(newBug: Bug): void {
      this.bugs.push(newBug);
    }

}
