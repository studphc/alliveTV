package com.hisona.allive;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import defpackage.i5;
import defpackage.jd2;
import defpackage.kd2;
import defpackage.m61;
import defpackage.m9;
import defpackage.nd2;
import defpackage.od2;
import defpackage.r32;
import defpackage.tt1;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public abstract class RxJobIntentService extends Service {
    public static final Object h = new Object();
    public static final HashMap i = new HashMap();
    public m61 a;
    public od2 b;
    public m9 c;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public final ArrayList g;

    public RxJobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.g = null;
        } else {
            this.g = new ArrayList();
        }
    }

    public static od2 b(Context context, ComponentName componentName, boolean z, int i2) {
        od2 jd2Var;
        HashMap hashMap = i;
        od2 od2Var = (od2) hashMap.get(componentName);
        if (od2Var == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                if (z) {
                    jd2Var = new nd2(context, componentName, i2);
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

    public static void enqueueWork(@NonNull Context context, @NonNull Class<?> cls, int i2, @NonNull Intent intent) {
        enqueueWork(context, new ComponentName(context, cls), i2, intent);
    }

    public final void a(boolean z) {
        if (this.c == null) {
            this.c = new m9((Object) this, 20, false);
            od2 od2Var = this.b;
            if (od2Var != null && z) {
                od2Var.d();
            }
            m9 m9Var = this.c;
            m9Var.getClass();
            Observable create = Observable.create(new i5(19, m9Var));
            m9Var.b = new tt1(m9Var);
            create.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((tt1) m9Var.b);
        }
    }

    public final void c() {
        ArrayList arrayList = this.g;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.c = null;
                    ArrayList arrayList2 = this.g;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        a(false);
                    } else if (!this.f) {
                        this.b.c();
                    }
                } finally {
                }
            }
        }
    }

    public boolean isStopped() {
        return this.e;
    }

    @Override // android.app.Service
    public IBinder onBind(@NonNull Intent intent) {
        m61 m61Var = this.a;
        if (m61Var != null) {
            return r32.i(m61Var);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.a = new m61(this);
            this.b = null;
        } else {
            this.a = null;
            this.b = b(this, new ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = this.g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f = true;
                this.b.c();
            }
        }
    }

    public abstract void onHandleWork(@NonNull Intent intent);

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i2, int i3) {
        if (this.g != null) {
            this.b.e();
            synchronized (this.g) {
                ArrayList arrayList = this.g;
                if (intent == null) {
                    intent = new Intent();
                }
                arrayList.add(new kd2(this, intent, i3));
                a(true);
            }
            return 3;
        }
        return 2;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    public void setInterruptIfStopped(boolean z) {
        this.d = z;
    }

    public static void enqueueWork(@NonNull Context context, @NonNull ComponentName componentName, int i2, @NonNull Intent intent) {
        if (intent != null) {
            synchronized (h) {
                od2 b = b(context, componentName, true, i2);
                b.b(i2);
                b.a(intent);
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }
}
