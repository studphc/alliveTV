package androidx.appcompat.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.TintTypedArray;

/* renamed from: androidx.appcompat.app.c */
/* loaded from: classes.dex */
public final class C0082c implements ActionBarDrawerToggle.Delegate {

    /* renamed from: a */
    public final /* synthetic */ LayoutInflaterFactory2C0084e f682a;

    public C0082c(LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e) {
        this.f682a = layoutInflaterFactory2C0084e;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public final Context getActionBarThemedContext() {
        return this.f682a.m188q();
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public final Drawable getThemeUpIndicator() {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f682a.m188q(), (AttributeSet) null, new int[]{R.attr.homeAsUpIndicator});
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public final boolean isNavigationVisible() {
        LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e = this.f682a;
        layoutInflaterFactory2C0084e.m191u();
        ActionBar actionBar = layoutInflaterFactory2C0084e.f725o;
        if (actionBar != null && (actionBar.getDisplayOptions() & 4) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public final void setActionBarDescription(int i) {
        LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e = this.f682a;
        layoutInflaterFactory2C0084e.m191u();
        ActionBar actionBar = layoutInflaterFactory2C0084e.f725o;
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i);
        }
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public final void setActionBarUpIndicator(Drawable drawable, int i) {
        LayoutInflaterFactory2C0084e layoutInflaterFactory2C0084e = this.f682a;
        layoutInflaterFactory2C0084e.m191u();
        ActionBar actionBar = layoutInflaterFactory2C0084e.f725o;
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setHomeActionContentDescription(i);
        }
    }
}
