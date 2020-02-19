import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { BoardComponent } from './board/board.component';
import { PoststhComponent } from './poststh/poststh.component';
import { TestserverComponent } from './testserver/testserver.component';
import { NewaccountComponent } from './newaccount/newaccount.component';
import { AllusersComponent } from './allusers/allusers.component';
import { LoginComponent } from './login/login.component';



const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'board', component: BoardComponent },
  { path: 'poststh', component: PoststhComponent },
  { path: 'testserver',component: TestserverComponent},
  { path: 'newaccount',component: NewaccountComponent},
  { path: 'allusers',component: AllusersComponent},
  { path: 'login',component: LoginComponent}



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
