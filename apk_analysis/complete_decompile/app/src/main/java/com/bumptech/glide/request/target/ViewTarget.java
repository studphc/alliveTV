package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.R;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import p000.ViewOnAttachStateChangeListenerC1162el;
import p000.ViewTreeObserverOnPreDrawListenerC1527lx;
import p000.y33;

@Deprecated
/* loaded from: classes.dex */
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {

    /* renamed from: f */
    public static boolean f9126f;

    /* renamed from: g */
    public static int f9127g = R.id.glide_custom_view_target_tag;

    /* renamed from: b */
    public final y33 f9128b;

    /* renamed from: c */
    public ViewOnAttachStateChangeListenerC1162el f9129c;

    /* renamed from: d */
    public boolean f9130d;

    /* renamed from: e */
    public boolean f9131e;
    protected final T view;

    public ViewTarget(@NonNull T t) {
        this.view = (T) Preconditions.checkNotNull(t);
        this.f9128b = new y33(t);
    }

    @Deprecated
    public static void setTagId(int i) {
        if (!f9126f) {
            f9127g = i;
            return;
        }
        throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
    }

    @NonNull
    public final ViewTarget<T, Z> clearOnDetach() {
        if (this.f9129c != null) {
            return this;
        }
        ViewOnAttachStateChangeListenerC1162el viewOnAttachStateChangeListenerC1162el = new ViewOnAttachStateChangeListenerC1162el(4, this);
        this.f9129c = viewOnAttachStateChangeListenerC1162el;
        if (!this.f9131e) {
            this.view.addOnAttachStateChangeListener(viewOnAttachStateChangeListenerC1162el);
            this.f9131e = true;
        }
        return this;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @Nullable
    public Request getRequest() {
        Object tag = this.view.getTag(f9127g);
        if (tag != null) {
            if (tag instanceof Request) {
                return (Request) tag;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    @Override // com.bumptech.glide.request.target.Target
    @CallSuper
    public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        int i;
        y33 y33Var = this.f9128b;
        View view = y33Var.f28825a;
        int paddingRight = view.getPaddingRight() + view.getPaddingLeft();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i2 = 0;
        if (layoutParams != null) {
            i = layoutParams.width;
        } else {
            i = 0;
        }
        int m8216a = y33Var.m8216a(view.getWidth(), i, paddingRight);
        View view2 = y33Var.f28825a;
        int paddingBottom = view2.getPaddingBottom() + view2.getPaddingTop();
        ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
        if (layoutParams2 != null) {
            i2 = layoutParams2.height;
        }
        int m8216a2 = y33Var.m8216a(view2.getHeight(), i2, paddingBottom);
        if ((m8216a <= 0 && m8216a != Integer.MIN_VALUE) || (m8216a2 <= 0 && m8216a2 != Integer.MIN_VALUE)) {
            ArrayList arrayList = y33Var.f28826b;
            if (!arrayList.contains(sizeReadyCallback)) {
                arrayList.add(sizeReadyCallback);
            }
            if (y33Var.f28828d == null) {
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                ViewTreeObserverOnPreDrawListenerC1527lx viewTreeObserverOnPreDrawListenerC1527lx = new ViewTreeObserverOnPreDrawListenerC1527lx(y33Var);
                y33Var.f28828d = viewTreeObserverOnPreDrawListenerC1527lx;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC1527lx);
                return;
            }
            return;
        }
        sizeReadyCallback.onSizeReady(m8216a, m8216a2);
    }

    @NonNull
    public T getView() {
        return this.view;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @CallSuper
    public void onLoadCleared(@Nullable Drawable drawable) {
        ViewOnAttachStateChangeListenerC1162el viewOnAttachStateChangeListenerC1162el;
        super.onLoadCleared(drawable);
        y33 y33Var = this.f9128b;
        ViewTreeObserver viewTreeObserver = y33Var.f28825a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(y33Var.f28828d);
        }
        y33Var.f28828d = null;
        y33Var.f28826b.clear();
        if (!this.f9130d && (viewOnAttachStateChangeListenerC1162el = this.f9129c) != null && this.f9131e) {
            this.view.removeOnAttachStateChangeListener(viewOnAttachStateChangeListenerC1162el);
            this.f9131e = false;
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    @CallSuper
    public void onLoadStarted(@Nullable Drawable drawable) {
        super.onLoadStarted(drawable);
        ViewOnAttachStateChangeListenerC1162el viewOnAttachStateChangeListenerC1162el = this.f9129c;
        if (viewOnAttachStateChangeListenerC1162el != null && !this.f9131e) {
            this.view.addOnAttachStateChangeListener(viewOnAttachStateChangeListenerC1162el);
            this.f9131e = true;
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    @CallSuper
    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f9128b.f28826b.remove(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void setRequest(@Nullable Request request) {
        f9126f = true;
        this.view.setTag(f9127g, request);
    }

    public String toString() {
        return "Target for: " + this.view;
    }

    @NonNull
    public final ViewTarget<T, Z> waitForLayout() {
        this.f9128b.f28827c = true;
        return this;
    }

    @Deprecated
    public ViewTarget(@NonNull T t, boolean z) {
        this(t);
        if (z) {
            waitForLayout();
        }
    }
}
