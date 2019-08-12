import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModufyComponent } from './modufy.component';

describe('ModufyComponent', () => {
  let component: ModufyComponent;
  let fixture: ComponentFixture<ModufyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModufyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModufyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
