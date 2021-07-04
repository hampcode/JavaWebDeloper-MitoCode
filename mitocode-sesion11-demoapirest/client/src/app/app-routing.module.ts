import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DefaultComponent } from './components/default/default.component';
import { OutcomecreateComponent } from './components/outcomecreate/outcomecreate.component';
import { OutcomelistComponent } from './components/outcomelist/outcomelist.component';

const routes: Routes = [
  {path:'', component: DefaultComponent},
  {path:'outcomes', 
   children:[
    {path:'',component:OutcomelistComponent},
    {path:'create', component:OutcomecreateComponent},
   ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
