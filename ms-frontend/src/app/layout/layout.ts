import { Component } from '@angular/core';

import { Navbar } from '../shared/navbar/navbar';
import { Footer } from '../shared/footer/footer';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-layout',
  imports: [Navbar, Footer, RouterModule],
  templateUrl: './layout.html',
  styleUrls: ['./layout.css'],
  standalone: true,
})
export class Layout {

}
