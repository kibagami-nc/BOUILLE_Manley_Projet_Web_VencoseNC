import { Routes } from '@angular/router';

import { Main } from './features/main/main/main';
import { Profil } from './features/profil/profil/profil';
import { Messages } from './features/messages/messages';
import { AdminAccounts } from './features/admin/admin-accounts/admin-accounts';
import { AdminStats } from './features/admin/admin-stats/admin-stats';
import { authGuard } from './shared/guards/auth.guard';

export const routes: Routes = [
  { path: '', component: Main },
  { path: 'profil', component: Profil, canActivate: [authGuard] },
  { path: 'messages', component: Messages, canActivate: [authGuard] },
  { path: 'admin/accounts', component: AdminAccounts },
  { path: 'admin/stats', component: AdminStats },
  { path: '**', redirectTo: '' },
];
