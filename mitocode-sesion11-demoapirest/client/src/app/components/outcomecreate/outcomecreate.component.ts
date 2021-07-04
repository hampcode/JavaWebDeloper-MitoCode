import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Outcomes } from 'src/app/models/outcomes.model';
import { OutcomeService } from 'src/app/services/outcome.service';

@Component({
  selector: 'app-outcomecreate',
  templateUrl: './outcomecreate.component.html',
  styleUrls: ['./outcomecreate.component.css']
})
export class OutcomecreateComponent implements OnInit {

  public outcome: Outcomes=new Outcomes();
  public loading:boolean=false;
 
  constructor(private outcomeService:OutcomeService,
      private router:Router) { }

  ngOnInit(): void {
    
    
  }

  onSubmit():void{
    this.loading=true;

    this.outcomeService.createOutcome(this.outcome)
      .subscribe(()=>{
        this.router.navigate(["/outcomes"]);
      })
  }

}
