import { ListBugsComponent } from './list-bugs/list-bugs.component';
import { ListDevsComponent } from './list-devs/list-devs.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path: 'bug', component: ListBugsComponent},
  {path: '', redirectTo: 'index', pathMatch: 'full'},
  {path: 'dev', component: ListDevsComponent},
    {path: '', redirectTo: 'index', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
