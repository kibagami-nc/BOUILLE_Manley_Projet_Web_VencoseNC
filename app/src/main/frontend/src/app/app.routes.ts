import { Routes } from '@angular/router';

import { MainHero } from './features/main/main-hero/main-hero';
import { Profil } from './features/profil/profil/profil';
import { AdminAccounts } from './features/admin/admin-accounts/admin-accounts';
import { AdminStats } from './features/admin/admin-stats/admin-stats';

export const routes: Routes = [
  { path: '', component: MainHero },
  { path: 'profil', component: Profil },
  { path: 'admin/accounts', component: AdminAccounts },
  { path: 'admin/stats', component: AdminStats },
  { path: '**', redirectTo: '' },
];
