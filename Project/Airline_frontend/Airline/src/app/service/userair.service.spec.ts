import { TestBed } from '@angular/core/testing';

import { UserairService } from './userair.service';

describe('UserairService', () => {
  let service: UserairService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserairService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
