import { Component, OnInit } from '@angular/core';
import { Outcomes } from 'src/app/models/outcomes.model';
import { OutcomeService } from 'src/app/services/outcome.service';

@Component({
  selector: 'app-outcomelist',
  templateUrl: './outcomelist.component.html',
  styleUrls: ['./outcomelist.component.css']
})
export class OutcomelistComponent implements OnInit {
  public outcomes: Outcomes[];
  constructor(private outcomeService:OutcomeService) { }

  ngOnInit(): void {
    this.getAllOutcomes();
  }

  
  getAllOutcomes(){
    let request=this.outcomeService.getAllOutcomes();

    request.subscribe((data)=>{
       this.outcomes=data;
    })
}

}
