package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DiffUtil;
import java.util.Collections;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.c */
/* loaded from: classes.dex */
public final class RunnableC0462c implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ DiffUtil.DiffResult f7329a;

    /* renamed from: b */
    public final /* synthetic */ RunnableC0465d f7330b;

    public RunnableC0462c(RunnableC0465d runnableC0465d, DiffUtil.DiffResult diffResult) {
        this.f7330b = runnableC0465d;
        this.f7329a = diffResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RunnableC0465d runnableC0465d = this.f7330b;
        AsyncListDiffer asyncListDiffer = runnableC0465d.f7336e;
        if (asyncListDiffer.f6937g == runnableC0465d.f7334c) {
            List list = runnableC0465d.f7333b;
            Runnable runnable = runnableC0465d.f7335d;
            List list2 = asyncListDiffer.f6936f;
            asyncListDiffer.f6935e = list;
            asyncListDiffer.f6936f = Collections.unmodifiableList(list);
            this.f7329a.dispatchUpdatesTo(asyncListDiffer.f6931a);
            asyncListDiffer.m1604a(list2, runnable);
        }
    }
}
