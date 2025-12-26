package androidx.leanback.widget;

import android.graphics.drawable.Drawable;
import android.widget.Button;
import androidx.leanback.widget.Presenter;

/* renamed from: androidx.leanback.widget.g */
/* loaded from: classes.dex */
public abstract class AbstractC0336g extends Presenter {
    @Override // androidx.leanback.widget.Presenter
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        C0340h c0340h = (C0340h) viewHolder;
        c0340h.getClass();
        Drawable icon = ((Action) obj).getIcon();
        if (icon != null) {
            c0340h.view.setPaddingRelative(c0340h.view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_action_with_icon_padding_start), 0, c0340h.view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_action_with_icon_padding_end), 0);
        } else {
            int dimensionPixelSize = c0340h.view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_action_padding_horizontal);
            c0340h.view.setPaddingRelative(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
        int i = c0340h.f6301c;
        Button button = c0340h.f6300b;
        if (i == 1) {
            button.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, icon, (Drawable) null);
        } else {
            button.setCompoundDrawablesWithIntrinsicBounds(icon, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        C0340h c0340h = (C0340h) viewHolder;
        c0340h.f6300b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        c0340h.view.setPadding(0, 0, 0, 0);
    }
}
