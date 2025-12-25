package com.bumptech.glide;

import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Queue;
import p000.C0559bj;
import p000.r91;

/* loaded from: classes.dex */
public class ListPreloader<T> implements AbsListView.OnScrollListener {

    /* renamed from: a */
    public final int f8493a;

    /* renamed from: b */
    public final C0559bj f8494b;

    /* renamed from: c */
    public final RequestManager f8495c;

    /* renamed from: d */
    public final PreloadModelProvider f8496d;

    /* renamed from: e */
    public final PreloadSizeProvider f8497e;

    /* renamed from: f */
    public int f8498f;

    /* renamed from: g */
    public int f8499g;

    /* renamed from: i */
    public int f8501i;

    /* renamed from: h */
    public int f8500h = -1;

    /* renamed from: j */
    public boolean f8502j = true;

    /* loaded from: classes.dex */
    public interface PreloadModelProvider<U> {
        @NonNull
        List<U> getPreloadItems(int i);

        @Nullable
        RequestBuilder<?> getPreloadRequestBuilder(@NonNull U u);
    }

    /* loaded from: classes.dex */
    public interface PreloadSizeProvider<T> {
        @Nullable
        int[] getPreloadSize(@NonNull T t, int i, int i2);
    }

    public ListPreloader(@NonNull RequestManager requestManager, @NonNull PreloadModelProvider<T> preloadModelProvider, @NonNull PreloadSizeProvider<T> preloadSizeProvider, int i) {
        this.f8495c = requestManager;
        this.f8496d = preloadModelProvider;
        this.f8497e = preloadSizeProvider;
        this.f8493a = i;
        this.f8494b = new C0559bj(i + 1);
    }

    /* renamed from: a */
    public final void m2275a(int i, boolean z) {
        int min;
        int i2;
        if (this.f8502j != z) {
            this.f8502j = z;
            int i3 = 0;
            while (true) {
                C0559bj c0559bj = this.f8494b;
                if (i3 >= c0559bj.f8031a.size()) {
                    break;
                }
                Queue queue = c0559bj.f8031a;
                r91 r91Var = (r91) queue.poll();
                queue.offer(r91Var);
                r91Var.f25910b = 0;
                r91Var.f25909a = 0;
                this.f8495c.clear(r91Var);
                i3++;
            }
        }
        int i4 = this.f8493a;
        if (!z) {
            i4 = -i4;
        }
        int i5 = i4 + i;
        if (i < i5) {
            i2 = Math.max(this.f8498f, i);
            min = i5;
        } else {
            min = Math.min(this.f8499g, i);
            i2 = i5;
        }
        int min2 = Math.min(this.f8501i, min);
        int min3 = Math.min(this.f8501i, Math.max(0, i2));
        PreloadModelProvider preloadModelProvider = this.f8496d;
        if (i < i5) {
            for (int i6 = min3; i6 < min2; i6++) {
                m2276b(i6, preloadModelProvider.getPreloadItems(i6), true);
            }
        } else {
            for (int i7 = min2 - 1; i7 >= min3; i7--) {
                m2276b(i7, preloadModelProvider.getPreloadItems(i7), false);
            }
        }
        this.f8499g = min3;
        this.f8498f = min2;
    }

    /* renamed from: b */
    public final void m2276b(int i, List list, boolean z) {
        int size = list.size();
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                m2277c(i, i2, list.get(i2));
            }
            return;
        }
        for (int i3 = size - 1; i3 >= 0; i3--) {
            m2277c(i, i3, list.get(i3));
        }
    }

    /* renamed from: c */
    public final void m2277c(int i, int i2, Object obj) {
        int[] preloadSize;
        RequestBuilder<?> preloadRequestBuilder;
        if (obj == null || (preloadSize = this.f8497e.getPreloadSize(obj, i, i2)) == null || (preloadRequestBuilder = this.f8496d.getPreloadRequestBuilder(obj)) == null) {
            return;
        }
        int i3 = preloadSize[0];
        int i4 = preloadSize[1];
        Queue queue = this.f8494b.f8031a;
        r91 r91Var = (r91) queue.poll();
        queue.offer(r91Var);
        r91Var.f25910b = i3;
        r91Var.f25909a = i4;
        preloadRequestBuilder.into((RequestBuilder<?>) r91Var);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.f8501i = i3;
        int i4 = this.f8500h;
        if (i > i4) {
            m2275a(i2 + i, true);
        } else if (i < i4) {
            m2275a(i, false);
        }
        this.f8500h = i;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
