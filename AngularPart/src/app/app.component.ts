import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularProject';
    goToLink(url: string): void{
    window.open(url, '_blank');
}
goToLinkNoPopup(url: string): void{ //Open link in the same window
    open(url, '_self');
}
}
