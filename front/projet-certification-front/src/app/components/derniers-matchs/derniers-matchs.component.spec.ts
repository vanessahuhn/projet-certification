import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DerniersMatchsComponent } from './derniers-matchs.component';

describe('DerniersMatchsComponent', () => {
  let component: DerniersMatchsComponent;
  let fixture: ComponentFixture<DerniersMatchsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DerniersMatchsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DerniersMatchsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
