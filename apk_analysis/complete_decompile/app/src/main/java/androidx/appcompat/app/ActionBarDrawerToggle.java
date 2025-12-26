package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import p000.ViewOnClickListenerC1109d4;

/* loaded from: classes.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {

    /* renamed from: a */
    public final Delegate f576a;

    /* renamed from: b */
    public final DrawerLayout f577b;

    /* renamed from: c */
    public DrawerArrowDrawable f578c;

    /* renamed from: d */
    public boolean f579d;

    /* renamed from: e */
    public Drawable f580e;

    /* renamed from: f */
    public boolean f581f;

    /* renamed from: g */
    public boolean f582g;

    /* renamed from: h */
    public final int f583h;

    /* renamed from: i */
    public final int f584i;

    /* renamed from: j */
    public View.OnClickListener f585j;

    /* renamed from: k */
    public boolean f586k;

    /* loaded from: classes.dex */
    public interface Delegate {
        Context getActionBarThemedContext();

        Drawable getThemeUpIndicator();

        boolean isNavigationVisible();

        void setActionBarDescription(@StringRes int i);

        void setActionBarUpIndicator(Drawable drawable, @StringRes int i);
    }

    /* loaded from: classes.dex */
    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, @StringRes int i, @StringRes int i2) {
        this(activity, (Toolbar) null, drawerLayout, i, i2);
    }

    /* renamed from: a */
    public final void m155a(Drawable drawable, int i) {
        boolean z = this.f586k;
        Delegate delegate = this.f576a;
        if (!z && !delegate.isNavigationVisible()) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.f586k = true;
        }
        delegate.setActionBarUpIndicator(drawable, i);
    }

    /* renamed from: b */
    public final void m156b(float f) {
        if (f == 1.0f) {
            this.f578c.setVerticalMirror(true);
        } else if (f == RecyclerView.f7068F0) {
            this.f578c.setVerticalMirror(false);
        }
        this.f578c.setProgress(f);
    }

    @NonNull
    public DrawerArrowDrawable getDrawerArrowDrawable() {
        return this.f578c;
    }

    public View.OnClickListener getToolbarNavigationClickListener() {
        return this.f585j;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.f581f;
    }

    public boolean isDrawerSlideAnimationEnabled() {
        return this.f579d;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.f582g) {
            this.f580e = this.f576a.getThemeUpIndicator();
        }
        syncState();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View view) {
        m156b(RecyclerView.f7068F0);
        if (this.f581f) {
            this.f576a.setActionBarDescription(this.f583h);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View view) {
        m156b(1.0f);
        if (this.f581f) {
            this.f576a.setActionBarDescription(this.f584i);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View view, float f) {
        if (this.f579d) {
            m156b(Math.min(1.0f, Math.max(RecyclerView.f7068F0, f)));
        } else {
            m156b(RecyclerView.f7068F0);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int i) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem != null && menuItem.getItemId() == 16908332 && this.f581f) {
            DrawerLayout drawerLayout = this.f577b;
            int drawerLockMode = drawerLayout.getDrawerLockMode(GravityCompat.START);
            if (drawerLayout.isDrawerVisible(GravityCompat.START) && drawerLockMode != 2) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else if (drawerLockMode != 1) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
            return true;
        }
        return false;
    }

    public void setDrawerArrowDrawable(@NonNull DrawerArrowDrawable drawerArrowDrawable) {
        this.f578c = drawerArrowDrawable;
        syncState();
    }

    public void setDrawerIndicatorEnabled(boolean z) {
        int i;
        if (z != this.f581f) {
            if (z) {
                DrawerArrowDrawable drawerArrowDrawable = this.f578c;
                if (this.f577b.isDrawerOpen(GravityCompat.START)) {
                    i = this.f584i;
                } else {
                    i = this.f583h;
                }
                m155a(drawerArrowDrawable, i);
            } else {
                m155a(this.f580e, 0);
            }
            this.f581f = z;
        }
    }

    public void setDrawerSlideAnimationEnabled(boolean z) {
        this.f579d = z;
        if (!z) {
            m156b(RecyclerView.f7068F0);
        }
    }

    public void setHomeAsUpIndicator(int i) {
        setHomeAsUpIndicator(i != 0 ? this.f577b.getResources().getDrawable(i) : null);
    }

    public void setToolbarNavigationClickListener(View.OnClickListener onClickListener) {
        this.f585j = onClickListener;
    }

    public void syncState() {
        int i;
        DrawerLayout drawerLayout = this.f577b;
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            m156b(1.0f);
        } else {
            m156b(RecyclerView.f7068F0);
        }
        if (this.f581f) {
            DrawerArrowDrawable drawerArrowDrawable = this.f578c;
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                i = this.f584i;
            } else {
                i = this.f583h;
            }
            m155a(drawerArrowDrawable, i);
        }
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, @StringRes int i, @StringRes int i2) {
        this(activity, toolbar, drawerLayout, i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionBarDrawerToggle(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, int i, int i2) {
        this.f579d = true;
        this.f581f = true;
        this.f586k = false;
        if (toolbar != null) {
            this.f576a = new C0081b(toolbar);
            toolbar.setNavigationOnClickListener(new ViewOnClickListenerC1109d4(1, this));
        } else if (activity instanceof DelegateProvider) {
            this.f576a = ((DelegateProvider) activity).getDrawerToggleDelegate();
        } else {
            this.f576a = new C0080a(activity);
        }
        this.f577b = drawerLayout;
        this.f583h = i;
        this.f584i = i2;
        this.f578c = new DrawerArrowDrawable(this.f576a.getActionBarThemedContext());
        this.f580e = this.f576a.getThemeUpIndicator();
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        if (drawable == null) {
            this.f580e = this.f576a.getThemeUpIndicator();
            this.f582g = false;
        } else {
            this.f580e = drawable;
            this.f582g = true;
        }
        if (this.f581f) {
            return;
        }
        m155a(this.f580e, 0);
    }
}
