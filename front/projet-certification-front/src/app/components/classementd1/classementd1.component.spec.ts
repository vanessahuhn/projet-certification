import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Classementd1Component } from './classementd1.component';

describe('Classementd1Component', () => {
  let component: Classementd1Component;
  let fixture: ComponentFixture<Classementd1Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Classementd1Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Classementd1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
