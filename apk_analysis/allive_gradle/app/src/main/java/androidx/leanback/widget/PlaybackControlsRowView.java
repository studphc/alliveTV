package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
class PlaybackControlsRowView extends LinearLayout {

    /* renamed from: a */
    public C0327d2 f6030a;

    /* loaded from: classes.dex */
    public interface OnUnhandledKeyListener {
        boolean onUnhandledKey(@NonNull KeyEvent keyEvent);
    }

    public PlaybackControlsRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        C0327d2 c0327d2 = this.f6030a;
        if (c0327d2 != null && c0327d2.onUnhandledKey(keyEvent)) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        View findFocus = findFocus();
        if (findFocus != null && findFocus.requestFocus(i, rect)) {
            return true;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }
}
