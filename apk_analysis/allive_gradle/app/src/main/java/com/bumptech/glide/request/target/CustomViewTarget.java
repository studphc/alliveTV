package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.R;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import p000.C1564mx;
import p000.ViewOnAttachStateChangeListenerC1162el;
import p000.ViewTreeObserverOnPreDrawListenerC1527lx;

/* loaded from: classes.dex */
public abstract class CustomViewTarget<T extends View, Z> implements Target<Z> {

    /* renamed from: e */
    public static final int f9104e = R.id.glide_custom_view_target_tag;

    /* renamed from: a */
    public final C1564mx f9105a;

    /* renamed from: b */
    public ViewOnAttachStateChangeListenerC1162el f9106b;

    /* renamed from: c */
    public boolean f9107c;

    /* renamed from: d */
    public boolean f9108d;
    protected final T view;

    public CustomViewTarget(@NonNull T t) {
        this.view = (T) Preconditions.checkNotNull(t);
        this.f9105a = new C1564mx(t);
    }

    @NonNull
    public final CustomViewTarget<T, Z> clearOnDetach() {
        if (this.f9106b != null) {
            return this;
        }
        ViewOnAttachStateChangeListenerC1162el viewOnAttachStateChangeListenerC1162el = new ViewOnAttachStateChangeListenerC1162el(1, this);
        this.f9106b = viewOnAttachStateChangeListenerC1162el;
        if (!this.f9108d) {
            this.view.addOnAttachStateChangeListener(viewOnAttachStateChangeListenerC1162el);
            this.f9108d = true;
        }
        return this;
    }

    @Override // com.bumptech.glide.request.target.Target
    @Nullable
    public final Request getRequest() {
        Object tag = this.view.getTag(f9104e);
        if (tag != null) {
            if (tag instanceof Request) {
                return (Request) tag;
            }
            throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
        }
        return null;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        int i;
        C1564mx c1564mx = this.f9105a;
        View view = c1564mx.f23148a;
        int paddingRight = view.getPaddingRight() + view.getPaddingLeft();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i2 = 0;
        if (layoutParams != null) {
            i = layoutParams.width;
        } else {
            i = 0;
        }
        int m6261a = c1564mx.m6261a(view.getWidth(), i, paddingRight);
        View view2 = c1564mx.f23148a;
        int paddingBottom = view2.getPaddingBottom() + view2.getPaddingTop();
        ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
        if (layoutParams2 != null) {
            i2 = layoutParams2.height;
        }
        int m6261a2 = c1564mx.m6261a(view2.getHeight(), i2, paddingBottom);
        if ((m6261a <= 0 && m6261a != Integer.MIN_VALUE) || (m6261a2 <= 0 && m6261a2 != Integer.MIN_VALUE)) {
            ArrayList arrayList = c1564mx.f23149b;
            if (!arrayList.contains(sizeReadyCallback)) {
                arrayList.add(sizeReadyCallback);
            }
            if (c1564mx.f23151d == null) {
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                ViewTreeObserverOnPreDrawListenerC1527lx viewTreeObserverOnPreDrawListenerC1527lx = new ViewTreeObserverOnPreDrawListenerC1527lx(c1564mx);
                c1564mx.f23151d = viewTreeObserverOnPreDrawListenerC1527lx;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC1527lx);
                return;
            }
            return;
        }
        sizeReadyCallback.onSizeReady(m6261a, m6261a2);
    }

    @NonNull
    public final T getView() {
        return this.view;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(@Nullable Drawable drawable) {
        ViewOnAttachStateChangeListenerC1162el viewOnAttachStateChangeListenerC1162el;
        C1564mx c1564mx = this.f9105a;
        ViewTreeObserver viewTreeObserver = c1564mx.f23148a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(c1564mx.f23151d);
        }
        c1564mx.f23151d = null;
        c1564mx.f23149b.clear();
        onResourceCleared(drawable);
        if (!this.f9107c && (viewOnAttachStateChangeListenerC1162el = this.f9106b) != null && this.f9108d) {
            this.view.removeOnAttachStateChangeListener(viewOnAttachStateChangeListenerC1162el);
            this.f9108d = false;
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadStarted(@Nullable Drawable drawable) {
        ViewOnAttachStateChangeListenerC1162el viewOnAttachStateChangeListenerC1162el = this.f9106b;
        if (viewOnAttachStateChangeListenerC1162el != null && !this.f9108d) {
            this.view.addOnAttachStateChangeListener(viewOnAttachStateChangeListenerC1162el);
            this.f9108d = true;
        }
        onResourceLoading(drawable);
    }

    public abstract void onResourceCleared(@Nullable Drawable drawable);

    public void onResourceLoading(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.f9105a.f23149b.remove(sizeReadyCallback);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void setRequest(@Nullable Request request) {
        this.view.setTag(f9104e, request);
    }

    public String toString() {
        return "Target for: " + this.view;
    }

    @Deprecated
    public final CustomViewTarget<T, Z> useTagId(@IdRes int i) {
        return this;
    }

    @NonNull
    public final CustomViewTarget<T, Z> waitForLayout() {
        this.f9105a.f23150c = true;
        return this;
    }
}
