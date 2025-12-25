package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class BrowseFrameLayout extends FrameLayout {

    /* renamed from: a */
    public OnFocusSearchListener f5595a;

    /* renamed from: b */
    public OnChildFocusListener f5596b;

    /* renamed from: c */
    public View.OnKeyListener f5597c;

    /* loaded from: classes.dex */
    public interface OnChildFocusListener {
        void onRequestChildFocus(@Nullable View view, @Nullable View view2);

        boolean onRequestFocusInDescendants(int i, @Nullable Rect rect);
    }

    /* loaded from: classes.dex */
    public interface OnFocusSearchListener {
        @Nullable
        View onFocusSearch(@Nullable View view, int i);
    }

    public BrowseFrameLayout(@NonNull Context context) {
        this(context, null, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        View.OnKeyListener onKeyListener = this.f5597c;
        if (onKeyListener != null && !dispatchKeyEvent) {
            return onKeyListener.onKey(getRootView(), keyEvent.getKeyCode(), keyEvent);
        }
        return dispatchKeyEvent;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(@Nullable View view, int i) {
        View onFocusSearch;
        OnFocusSearchListener onFocusSearchListener = this.f5595a;
        if (onFocusSearchListener != null && (onFocusSearch = onFocusSearchListener.onFocusSearch(view, i)) != null) {
            return onFocusSearch;
        }
        return super.focusSearch(view, i);
    }

    @Nullable
    public OnChildFocusListener getOnChildFocusListener() {
        return this.f5596b;
    }

    @Nullable
    public OnFocusSearchListener getOnFocusSearchListener() {
        return this.f5595a;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, @Nullable Rect rect) {
        OnChildFocusListener onChildFocusListener = this.f5596b;
        if (onChildFocusListener != null && onChildFocusListener.onRequestFocusInDescendants(i, rect)) {
            return true;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        OnChildFocusListener onChildFocusListener = this.f5596b;
        if (onChildFocusListener != null) {
            onChildFocusListener.onRequestChildFocus(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public void setOnChildFocusListener(@Nullable OnChildFocusListener onChildFocusListener) {
        this.f5596b = onChildFocusListener;
    }

    public void setOnDispatchKeyListener(@Nullable View.OnKeyListener onKeyListener) {
        this.f5597c = onKeyListener;
    }

    public void setOnFocusSearchListener(@Nullable OnFocusSearchListener onFocusSearchListener) {
        this.f5595a = onFocusSearchListener;
    }

    public BrowseFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BrowseFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
