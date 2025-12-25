package androidx.appcompat.widget;

import android.widget.PopupWindow;
import androidx.appcompat.widget.PopupMenu;

/* renamed from: androidx.appcompat.widget.i */
/* loaded from: classes.dex */
public final class C0100i implements PopupWindow.OnDismissListener {

    /* renamed from: a */
    public final /* synthetic */ PopupMenu f1621a;

    public C0100i(PopupMenu popupMenu) {
        this.f1621a = popupMenu;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        PopupMenu popupMenu = this.f1621a;
        PopupMenu.OnDismissListener onDismissListener = popupMenu.f1334f;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(popupMenu);
        }
    }
}
