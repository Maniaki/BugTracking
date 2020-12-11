import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ListDevsComponent } from './display-dev/display-devs.component';
import { ListBugsComponent } from './display-bug/display-bugs.component';

@NgModule({
  declarations: [
    AppComponent,
    ListDevComponent,
    ListBugComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
