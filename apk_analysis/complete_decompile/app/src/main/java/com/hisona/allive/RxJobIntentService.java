package com.hisona.allive;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import p000.C1294i5;
import p000.C1540m9;
import p000.jd2;
import p000.kd2;
import p000.m61;
import p000.nd2;
import p000.od2;
import p000.r32;
import p000.tt1;

/* loaded from: classes2.dex */
public abstract class RxJobIntentService extends Service {

    /* renamed from: h */
    public static final Object f15919h = new Object();

    /* renamed from: i */
    public static final HashMap f15920i = new HashMap();

    /* renamed from: a */
    public m61 f15921a;

    /* renamed from: b */
    public od2 f15922b;

    /* renamed from: c */
    public C1540m9 f15923c;

    /* renamed from: d */
    public boolean f15924d = false;

    /* renamed from: e */
    public boolean f15925e = false;

    /* renamed from: f */
    public boolean f15926f = false;

    /* renamed from: g */
    public final ArrayList f15927g;

    public RxJobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f15927g = null;
        } else {
            this.f15927g = new ArrayList();
        }
    }

    /* renamed from: b */
    public static od2 m4466b(Context context, ComponentName componentName, boolean z, int i) {
        od2 jd2Var;
        HashMap hashMap = f15920i;
        od2 od2Var = (od2) hashMap.get(componentName);
        if (od2Var == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                if (z) {
                    jd2Var = new nd2(context, componentName, i);
                } else {
                    throw new IllegalArgumentException("Can't be here without a job id");
                }
            } else {
                jd2Var = new jd2(context, componentName);
            }
            od2Var = jd2Var;
            hashMap.put(componentName, od2Var);
        }
        return od2Var;
    }

    public static void enqueueWork(@NonNull Context context, @NonNull Class<?> cls, int i, @NonNull Intent intent) {
        enqueueWork(context, new ComponentName(context, cls), i, intent);
    }

    /* renamed from: a */
    public final void m4467a(boolean z) {
        if (this.f15923c == null) {
            this.f15923c = new C1540m9((Object) this, 20, false);
            od2 od2Var = this.f15922b;
            if (od2Var != null && z) {
                od2Var.mo5439d();
            }
            C1540m9 c1540m9 = this.f15923c;
            c1540m9.getClass();
            Observable create = Observable.create(new C1294i5(19, c1540m9));
            c1540m9.f22854b = new tt1(c1540m9);
            create.subscribeOn(Schedulers.m5318io()).observeOn(AndroidSchedulers.mainThread()).subscribe((tt1) c1540m9.f22854b);
        }
    }

    /* renamed from: c */
    public final void m4468c() {
        ArrayList arrayList = this.f15927g;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.f15923c = null;
                    ArrayList arrayList2 = this.f15927g;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        m4467a(false);
                    } else if (!this.f15926f) {
                        this.f15922b.mo5438c();
                    }
                } finally {
                }
            }
        }
    }

    public boolean isStopped() {
        return this.f15925e;
    }

    @Override // android.app.Service
    public IBinder onBind(@NonNull Intent intent) {
        m61 m61Var = this.f15921a;
        if (m61Var != null) {
            return r32.m7197i(m61Var);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f15921a = new m61(this);
            this.f15922b = null;
        } else {
            this.f15921a = null;
            this.f15922b = m4466b(this, new ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = this.f15927g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f15926f = true;
                this.f15922b.mo5438c();
            }
        }
    }

    public abstract void onHandleWork(@NonNull Intent intent);

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i, int i2) {
        if (this.f15927g != null) {
            this.f15922b.mo5440e();
            synchronized (this.f15927g) {
                ArrayList arrayList = this.f15927g;
                if (intent == null) {
                    intent = new Intent();
                }
                arrayList.add(new kd2(this, intent, i2));
                m4467a(true);
            }
            return 3;
        }
        return 2;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    public void setInterruptIfStopped(boolean z) {
        this.f15924d = z;
    }

    public static void enqueueWork(@NonNull Context context, @NonNull ComponentName componentName, int i, @NonNull Intent intent) {
        if (intent != null) {
            synchronized (f15919h) {
                od2 m4466b = m4466b(context, componentName, true, i);
                m4466b.m6563b(i);
                m4466b.mo5437a(intent);
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }
}
