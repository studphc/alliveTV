package p000;

import android.view.MenuItem;
import androidx.appcompat.app.C0086g;
import androidx.appcompat.widget.Toolbar;

/* loaded from: classes.dex */
public final class lu2 implements Toolbar.OnMenuItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ C0086g f22674a;

    public lu2(C0086g c0086g) {
        this.f22674a = c0086g;
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return this.f22674a.f739b.onMenuItemSelected(0, menuItem);
    }
}
