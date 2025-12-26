package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p000.qp1;
import p000.rp1;

/* loaded from: classes.dex */
public class MultiModelLoaderFactory {

    /* renamed from: e */
    public static final rp1 f8802e = new Object();

    /* renamed from: f */
    public static final C0626j f8803f = new Object();

    /* renamed from: a */
    public final ArrayList f8804a;

    /* renamed from: b */
    public final rp1 f8805b;

    /* renamed from: c */
    public final HashSet f8806c;

    /* renamed from: d */
    public final Pools.Pool f8807d;

    public MultiModelLoaderFactory(@NonNull Pools.Pool<List<Throwable>> pool) {
        rp1 rp1Var = f8802e;
        this.f8804a = new ArrayList();
        this.f8806c = new HashSet();
        this.f8807d = pool;
        this.f8805b = rp1Var;
    }

    /* renamed from: a */
    public final synchronized void m2337a(Class cls, Class cls2, ModelLoaderFactory modelLoaderFactory) {
        qp1 qp1Var = new qp1(cls, cls2, modelLoaderFactory);
        ArrayList arrayList = this.f8804a;
        arrayList.add(arrayList.size(), qp1Var);
    }

    /* renamed from: b */
    public final synchronized ArrayList m2338b(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator it = this.f8804a.iterator();
            while (it.hasNext()) {
                qp1 qp1Var = (qp1) it.next();
                if (!this.f8806c.contains(qp1Var) && qp1Var.f25710a.isAssignableFrom(cls)) {
                    this.f8806c.add(qp1Var);
                    arrayList.add((ModelLoader) Preconditions.checkNotNull(qp1Var.f25712c.build(this)));
                    this.f8806c.remove(qp1Var);
                }
            }
        } catch (Throwable th) {
            this.f8806c.clear();
            throw th;
        }
        return arrayList;
    }

    @NonNull
    public synchronized <Model, Data> ModelLoader<Model, Data> build(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f8804a.iterator();
            boolean z = false;
            while (true) {
                boolean z2 = true;
                if (!it.hasNext()) {
                    break;
                }
                qp1 qp1Var = (qp1) it.next();
                if (this.f8806c.contains(qp1Var)) {
                    z = true;
                } else {
                    if (!qp1Var.f25710a.isAssignableFrom(cls) || !qp1Var.f25711b.isAssignableFrom(cls2)) {
                        z2 = false;
                    }
                    if (z2) {
                        this.f8806c.add(qp1Var);
                        arrayList.add((ModelLoader) Preconditions.checkNotNull(qp1Var.f25712c.build(this)));
                        this.f8806c.remove(qp1Var);
                    }
                }
            }
            if (arrayList.size() > 1) {
                rp1 rp1Var = this.f8805b;
                Pools.Pool pool = this.f8807d;
                rp1Var.getClass();
                return new C0625i(arrayList, pool);
            }
            if (arrayList.size() == 1) {
                return (ModelLoader) arrayList.get(0);
            }
            if (z) {
                return f8803f;
            }
            throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
        } catch (Throwable th) {
            this.f8806c.clear();
            throw th;
        }
    }

    /* renamed from: c */
    public final synchronized ArrayList m2339c(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f8804a.iterator();
        while (it.hasNext()) {
            qp1 qp1Var = (qp1) it.next();
            if (!arrayList.contains(qp1Var.f25711b) && qp1Var.f25710a.isAssignableFrom(cls)) {
                arrayList.add(qp1Var.f25711b);
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public final synchronized void m2340d(Class cls, Class cls2, ModelLoaderFactory modelLoaderFactory) {
        this.f8804a.add(0, new qp1(cls, cls2, modelLoaderFactory));
    }

    /* renamed from: e */
    public final synchronized ArrayList m2341e(Class cls, Class cls2) {
        ArrayList arrayList;
        boolean z;
        arrayList = new ArrayList();
        Iterator it = this.f8804a.iterator();
        while (it.hasNext()) {
            qp1 qp1Var = (qp1) it.next();
            if (qp1Var.f25710a.isAssignableFrom(cls) && qp1Var.f25711b.isAssignableFrom(cls2)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                it.remove();
                arrayList.add(qp1Var.f25712c);
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    public final synchronized ArrayList m2342f(Class cls, Class cls2, ModelLoaderFactory modelLoaderFactory) {
        ArrayList m2341e;
        m2341e = m2341e(cls, cls2);
        m2337a(cls, cls2, modelLoaderFactory);
        return m2341e;
    }
}
