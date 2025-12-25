package p000;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import java.lang.reflect.Constructor;

/* loaded from: classes.dex */
public final class yq2 {

    /* renamed from: A */
    public CharSequence f29074A;

    /* renamed from: B */
    public CharSequence f29075B;

    /* renamed from: E */
    public final /* synthetic */ SupportMenuInflater f29078E;

    /* renamed from: a */
    public final Menu f29079a;

    /* renamed from: h */
    public boolean f29086h;

    /* renamed from: i */
    public int f29087i;

    /* renamed from: j */
    public int f29088j;

    /* renamed from: k */
    public CharSequence f29089k;

    /* renamed from: l */
    public CharSequence f29090l;

    /* renamed from: m */
    public int f29091m;

    /* renamed from: n */
    public char f29092n;

    /* renamed from: o */
    public int f29093o;

    /* renamed from: p */
    public char f29094p;

    /* renamed from: q */
    public int f29095q;

    /* renamed from: r */
    public int f29096r;

    /* renamed from: s */
    public boolean f29097s;

    /* renamed from: t */
    public boolean f29098t;

    /* renamed from: u */
    public boolean f29099u;

    /* renamed from: v */
    public int f29100v;

    /* renamed from: w */
    public int f29101w;

    /* renamed from: x */
    public String f29102x;

    /* renamed from: y */
    public String f29103y;

    /* renamed from: z */
    public ActionProvider f29104z;

    /* renamed from: C */
    public ColorStateList f29076C = null;

    /* renamed from: D */
    public PorterDuff.Mode f29077D = null;

    /* renamed from: b */
    public int f29080b = 0;

    /* renamed from: c */
    public int f29081c = 0;

    /* renamed from: d */
    public int f29082d = 0;

    /* renamed from: e */
    public int f29083e = 0;

    /* renamed from: f */
    public boolean f29084f = true;

    /* renamed from: g */
    public boolean f29085g = true;

    public yq2(SupportMenuInflater supportMenuInflater, Menu menu) {
        this.f29078E = supportMenuInflater;
        this.f29079a = menu;
    }

    /* renamed from: a */
    public final Object m8315a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.f29078E.f807c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }

    /* renamed from: b */
    public final void m8316b(MenuItem menuItem) {
        boolean z;
        MenuItem enabled = menuItem.setChecked(this.f29097s).setVisible(this.f29098t).setEnabled(this.f29099u);
        boolean z2 = false;
        if (this.f29096r >= 1) {
            z = true;
        } else {
            z = false;
        }
        enabled.setCheckable(z).setTitleCondensed(this.f29090l).setIcon(this.f29091m);
        int i = this.f29100v;
        if (i >= 0) {
            menuItem.setShowAsAction(i);
        }
        String str = this.f29103y;
        SupportMenuInflater supportMenuInflater = this.f29078E;
        if (str != null) {
            if (!supportMenuInflater.f807c.isRestricted()) {
                if (supportMenuInflater.f808d == null) {
                    supportMenuInflater.f808d = SupportMenuInflater.m206a(supportMenuInflater.f807c);
                }
                Object obj = supportMenuInflater.f808d;
                String str2 = this.f29103y;
                xq2 xq2Var = new xq2();
                xq2Var.f28707b = obj;
                Class<?> cls = obj.getClass();
                try {
                    xq2Var.f28708c = cls.getMethod(str2, xq2.f28705d);
                    menuItem.setOnMenuItemClickListener(xq2Var);
                } catch (Exception e) {
                    StringBuilder m7065u = AbstractC1726qj.m7065u("Couldn't resolve menu item onClick handler ", str2, " in class ");
                    m7065u.append(cls.getName());
                    InflateException inflateException = new InflateException(m7065u.toString());
                    inflateException.initCause(e);
                    throw inflateException;
                }
            } else {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
        }
        if (this.f29096r >= 2) {
            if (menuItem instanceof MenuItemImpl) {
                ((MenuItemImpl) menuItem).setExclusiveCheckable(true);
            } else if (menuItem instanceof MenuItemWrapperICS) {
                ((MenuItemWrapperICS) menuItem).setExclusiveCheckable(true);
            }
        }
        String str3 = this.f29102x;
        if (str3 != null) {
            menuItem.setActionView((View) m8315a(str3, SupportMenuInflater.f803e, supportMenuInflater.f805a));
            z2 = true;
        }
        int i2 = this.f29101w;
        if (i2 > 0) {
            if (!z2) {
                menuItem.setActionView(i2);
            } else {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            }
        }
        ActionProvider actionProvider = this.f29104z;
        if (actionProvider != null) {
            MenuItemCompat.setActionProvider(menuItem, actionProvider);
        }
        MenuItemCompat.setContentDescription(menuItem, this.f29074A);
        MenuItemCompat.setTooltipText(menuItem, this.f29075B);
        MenuItemCompat.setAlphabeticShortcut(menuItem, this.f29092n, this.f29093o);
        MenuItemCompat.setNumericShortcut(menuItem, this.f29094p, this.f29095q);
        PorterDuff.Mode mode = this.f29077D;
        if (mode != null) {
            MenuItemCompat.setIconTintMode(menuItem, mode);
        }
        ColorStateList colorStateList = this.f29076C;
        if (colorStateList != null) {
            MenuItemCompat.setIconTintList(menuItem, colorStateList);
        }
    }
}
