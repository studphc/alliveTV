package androidx.appcompat.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

/* renamed from: androidx.appcompat.app.b */
/* loaded from: classes.dex */
public final class C0081b implements ActionBarDrawerToggle.Delegate {

    /* renamed from: a */
    public final Toolbar f679a;

    /* renamed from: b */
    public final Drawable f680b;

    /* renamed from: c */
    public final CharSequence f681c;

    public C0081b(Toolbar toolbar) {
        this.f679a = toolbar;
        this.f680b = toolbar.getNavigationIcon();
        this.f681c = toolbar.getNavigationContentDescription();
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public final Context getActionBarThemedContext() {
        return this.f679a.getContext();
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public final Drawable getThemeUpIndicator() {
        return this.f680b;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public final boolean isNavigationVisible() {
        return true;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public final void setActionBarDescription(int i) {
        Toolbar toolbar = this.f679a;
        if (i == 0) {
            toolbar.setNavigationContentDescription(this.f681c);
        } else {
            toolbar.setNavigationContentDescription(i);
        }
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public final void setActionBarUpIndicator(Drawable drawable, int i) {
        this.f679a.setNavigationIcon(drawable);
        setActionBarDescription(i);
    }
}
