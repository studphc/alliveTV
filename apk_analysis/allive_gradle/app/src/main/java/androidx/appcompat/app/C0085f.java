package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.ActionBar;

/* renamed from: androidx.appcompat.app.f */
/* loaded from: classes.dex */
public final class C0085f implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    public final ActionBar.OnNavigationListener f737a;

    public C0085f(ActionBar.OnNavigationListener onNavigationListener) {
        this.f737a = onNavigationListener;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        ActionBar.OnNavigationListener onNavigationListener = this.f737a;
        if (onNavigationListener != null) {
            onNavigationListener.onNavigationItemSelected(i, j);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
