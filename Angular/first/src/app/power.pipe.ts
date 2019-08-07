import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'power'
})
export class PowerPipe implements PipeTransform {

  transform(number: number, n2:number): number {
    return Math.pow(number,n2);
  }

}
