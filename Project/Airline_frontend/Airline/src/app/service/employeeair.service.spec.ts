import { TestBed } from '@angular/core/testing';

import { EmployeeairService } from './employeeair.service';

describe('EmployeeairService', () => {
  let service: EmployeeairService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmployeeairService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
