package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.GravityCompat;
import p000.gn1;
import p000.hn1;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MenuPopupHelper {

    /* renamed from: a */
    public final Context f946a;

    /* renamed from: b */
    public final MenuBuilder f947b;

    /* renamed from: c */
    public final boolean f948c;

    /* renamed from: d */
    public final int f949d;

    /* renamed from: e */
    public final int f950e;

    /* renamed from: f */
    public View f951f;

    /* renamed from: g */
    public int f952g;

    /* renamed from: h */
    public boolean f953h;

    /* renamed from: i */
    public MenuPresenter.Callback f954i;

    /* renamed from: j */
    public gn1 f955j;

    /* renamed from: k */
    public PopupWindow.OnDismissListener f956k;

    /* renamed from: l */
    public final hn1 f957l;

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this(context, menuBuilder, null, false, R.attr.popupMenuStyle, 0);
    }

    /* renamed from: a */
    public final void m220a(int i, int i2, boolean z, boolean z2) {
        gn1 popup = getPopup();
        popup.mo227h(z2);
        if (z) {
            if ((GravityCompat.getAbsoluteGravity(this.f952g, this.f951f.getLayoutDirection()) & 7) == 5) {
                i -= this.f951f.getWidth();
            }
            popup.mo225f(i);
            popup.mo228i(i2);
            int i3 = (int) ((this.f946a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            popup.f17775a = new Rect(i - i3, i2 - i3, i + i3, i2 + i3);
        }
        popup.show();
    }

    public void dismiss() {
        if (isShowing()) {
            this.f955j.dismiss();
        }
    }

    public int getGravity() {
        return this.f952g;
    }

    public ListView getListView() {
        return getPopup().getListView();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public gn1 getPopup() {
        gn1 viewOnKeyListenerC0091e;
        if (this.f955j == null) {
            Context context = this.f946a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                viewOnKeyListenerC0091e = new ViewOnKeyListenerC0088b(this.f946a, this.f951f, this.f949d, this.f950e, this.f948c);
            } else {
                View view = this.f951f;
                int i = this.f950e;
                viewOnKeyListenerC0091e = new ViewOnKeyListenerC0091e(this.f946a, this.f947b, view, this.f948c, this.f949d, i);
            }
            viewOnKeyListenerC0091e.mo221a(this.f947b);
            viewOnKeyListenerC0091e.mo226g(this.f957l);
            viewOnKeyListenerC0091e.mo222c(this.f951f);
            viewOnKeyListenerC0091e.setCallback(this.f954i);
            viewOnKeyListenerC0091e.mo223d(this.f953h);
            viewOnKeyListenerC0091e.mo224e(this.f952g);
            this.f955j = viewOnKeyListenerC0091e;
        }
        return this.f955j;
    }

    public boolean isShowing() {
        gn1 gn1Var = this.f955j;
        if (gn1Var != null && gn1Var.isShowing()) {
            return true;
        }
        return false;
    }

    public void onDismiss() {
        this.f955j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f956k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void setAnchorView(@NonNull View view) {
        this.f951f = view;
    }

    public void setForceShowIcon(boolean z) {
        this.f953h = z;
        gn1 gn1Var = this.f955j;
        if (gn1Var != null) {
            gn1Var.mo223d(z);
        }
    }

    public void setGravity(int i) {
        this.f952g = i;
    }

    public void setOnDismissListener(@Nullable PopupWindow.OnDismissListener onDismissListener) {
        this.f956k = onDismissListener;
    }

    public void setPresenterCallback(@Nullable MenuPresenter.Callback callback) {
        this.f954i = callback;
        gn1 gn1Var = this.f955j;
        if (gn1Var != null) {
            gn1Var.setCallback(callback);
        }
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.f951f == null) {
            return false;
        }
        m220a(0, 0, false, false);
        return true;
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view) {
        this(context, menuBuilder, view, false, R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view, boolean z, @AttrRes int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    public void show(int i, int i2) {
        if (!tryShow(i, i2)) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public MenuPopupHelper(@NonNull Context context, @NonNull MenuBuilder menuBuilder, @NonNull View view, boolean z, @AttrRes int i, @StyleRes int i2) {
        this.f952g = GravityCompat.START;
        this.f957l = new hn1(this);
        this.f946a = context;
        this.f947b = menuBuilder;
        this.f951f = view;
        this.f948c = z;
        this.f949d = i;
        this.f950e = i2;
    }

    public boolean tryShow(int i, int i2) {
        if (isShowing()) {
            return true;
        }
        if (this.f951f == null) {
            return false;
        }
        m220a(i, i2, true, true);
        return true;
    }
}
