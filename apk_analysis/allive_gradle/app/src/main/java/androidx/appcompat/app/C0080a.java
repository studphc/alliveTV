package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.ActionBarDrawerToggle;

/* renamed from: androidx.appcompat.app.a */
/* loaded from: classes.dex */
public final class C0080a implements ActionBarDrawerToggle.Delegate {

    /* renamed from: a */
    public final Activity f678a;

    public C0080a(Activity activity) {
        this.f678a = activity;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public final Context getActionBarThemedContext() {
        Activity activity = this.f678a;
        android.app.ActionBar actionBar = activity.getActionBar();
        if (actionBar != null) {
            return actionBar.getThemedContext();
        }
        return activity;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public final Drawable getThemeUpIndicator() {
        TypedArray obtainStyledAttributes = getActionBarThemedContext().obtainStyledAttributes(null, new int[]{R.attr.homeAsUpIndicator}, R.attr.actionBarStyle, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public final boolean isNavigationVisible() {
        android.app.ActionBar actionBar = this.f678a.getActionBar();
        if (actionBar != null && (actionBar.getDisplayOptions() & 4) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public final void setActionBarDescription(int i) {
        android.app.ActionBar actionBar = this.f678a.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeActionContentDescription(i);
        }
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public final void setActionBarUpIndicator(Drawable drawable, int i) {
        android.app.ActionBar actionBar = this.f678a.getActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setHomeActionContentDescription(i);
        }
    }
}
