import { Component, OnInit } from '@angular/core';
import { DevService } from '../services/devs-service/dev.service';
import { Dev } from '../models/Dev';
import { delay } from 'rxjs/operators';

@Component({
  selector: 'app-list-devs',
  templateUrl: './list-devs.component.html',
  styleUrls: ['./list-devs.component.css']
})
export class ListDevsComponent implements OnInit {

public devs: Dev[];

  public showSpinner: boolean;

  constructor(private devService: DevService) { }

  ngOnInit(): void {

    this.showSpinner = true;
    this.devService.getDevsList()
    .pipe(delay(2000))
    .subscribe((devsResponse => {
      this.devs = devsResponse;
      this.showSpinner = false;
    }));

  }

    deleteDev(id: number): void {
      this.devService.deleteBug(id).subscribe((deleteResponse) => {
        this.devs = this.devs.filter(s => s.id !== id);
      }, (error) => {
        // TODO
      });
    }
    /* Callback of child component */
    addBug(newDev: Dev): void {
      this.devs.push(newDev);
    }

}
