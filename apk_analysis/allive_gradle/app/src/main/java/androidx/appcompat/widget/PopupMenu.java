package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import p000.C1341j4;

/* loaded from: classes.dex */
public class PopupMenu {

    /* renamed from: a */
    public final Context f1329a;

    /* renamed from: b */
    public final MenuBuilder f1330b;

    /* renamed from: c */
    public final View f1331c;

    /* renamed from: d */
    public final MenuPopupHelper f1332d;

    /* renamed from: e */
    public OnMenuItemClickListener f1333e;

    /* renamed from: f */
    public OnDismissListener f1334f;

    /* renamed from: g */
    public C1341j4 f1335g;

    /* loaded from: classes.dex */
    public interface OnDismissListener {
        void onDismiss(PopupMenu popupMenu);
    }

    /* loaded from: classes.dex */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public PopupMenu(@NonNull Context context, @NonNull View view) {
        this(context, view, 0);
    }

    public void dismiss() {
        this.f1332d.dismiss();
    }

    @NonNull
    public View.OnTouchListener getDragToOpenListener() {
        if (this.f1335g == null) {
            this.f1335g = new C1341j4(this, this.f1331c, 3);
        }
        return this.f1335g;
    }

    public int getGravity() {
        return this.f1332d.getGravity();
    }

    @NonNull
    public Menu getMenu() {
        return this.f1330b;
    }

    @NonNull
    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.f1329a);
    }

    public void inflate(@MenuRes int i) {
        getMenuInflater().inflate(i, this.f1330b);
    }

    public void setForceShowIcon(boolean z) {
        this.f1332d.setForceShowIcon(z);
    }

    public void setGravity(int i) {
        this.f1332d.setGravity(i);
    }

    public void setOnDismissListener(@Nullable OnDismissListener onDismissListener) {
        this.f1334f = onDismissListener;
    }

    public void setOnMenuItemClickListener(@Nullable OnMenuItemClickListener onMenuItemClickListener) {
        this.f1333e = onMenuItemClickListener;
    }

    public void show() {
        this.f1332d.show();
    }

    public PopupMenu(@NonNull Context context, @NonNull View view, int i) {
        this(context, view, i, R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(@NonNull Context context, @NonNull View view, int i, @AttrRes int i2, @StyleRes int i3) {
        this.f1329a = context;
        this.f1331c = view;
        MenuBuilder menuBuilder = new MenuBuilder(context);
        this.f1330b = menuBuilder;
        menuBuilder.setCallback(new C0099h(this));
        MenuPopupHelper menuPopupHelper = new MenuPopupHelper(context, menuBuilder, view, false, i2, i3);
        this.f1332d = menuPopupHelper;
        menuPopupHelper.setGravity(i);
        menuPopupHelper.setOnDismissListener(new C0100i(this));
    }
}
