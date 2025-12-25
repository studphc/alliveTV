package p000;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.FragmentManager;

/* loaded from: classes.dex */
public final class st0 implements MenuProvider {

    /* renamed from: a */
    public final /* synthetic */ FragmentManager f26552a;

    public st0(FragmentManager fragmentManager) {
        this.f26552a = fragmentManager;
    }

    @Override // androidx.core.view.MenuProvider
    public final void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        this.f26552a.m1187k(menu, menuInflater);
    }

    @Override // androidx.core.view.MenuProvider
    public final void onMenuClosed(Menu menu) {
        this.f26552a.m1193q(menu);
    }

    @Override // androidx.core.view.MenuProvider
    public final boolean onMenuItemSelected(MenuItem menuItem) {
        return this.f26552a.m1192p(menuItem);
    }

    @Override // androidx.core.view.MenuProvider
    public final void onPrepareMenu(Menu menu) {
        this.f26552a.m1196t(menu);
    }
}
