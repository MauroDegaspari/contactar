import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FooterComponent } from './footer/footer.component';
import { CardComponent } from './card/card.component';



@NgModule({
  declarations: [
    FooterComponent,
    CardComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[
    FooterComponent,
    CardComponent
  ]
})
export class TemplateModule { }
