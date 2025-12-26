package androidx.core.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import p000.AsyncTaskC1822t4;
import p000.i61;
import p000.j61;
import p000.m61;
import p000.n61;
import p000.o61;

@Deprecated
/* loaded from: classes.dex */
public abstract class JobIntentService extends Service {

    /* renamed from: h */
    public static final Object f3276h = new Object();

    /* renamed from: i */
    public static final HashMap f3277i = new HashMap();

    /* renamed from: a */
    public m61 f3278a;

    /* renamed from: b */
    public o61 f3279b;

    /* renamed from: c */
    public AsyncTaskC1822t4 f3280c;

    /* renamed from: d */
    public boolean f3281d = false;

    /* renamed from: e */
    public boolean f3282e = false;

    /* renamed from: f */
    public boolean f3283f = false;

    /* renamed from: g */
    public final ArrayList f3284g;

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f3284g = null;
        } else {
            this.f3284g = new ArrayList();
        }
    }

    /* renamed from: b */
    public static o61 m689b(Context context, ComponentName componentName, boolean z, int i) {
        o61 i61Var;
        HashMap hashMap = f3277i;
        o61 o61Var = (o61) hashMap.get(componentName);
        if (o61Var == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                if (z) {
                    i61Var = new n61(context, componentName, i);
                } else {
                    throw new IllegalArgumentException("Can't be here without a job id");
                }
            } else {
                i61Var = new i61(context, componentName);
            }
            o61Var = i61Var;
            hashMap.put(componentName, o61Var);
        }
        return o61Var;
    }

    public static void enqueueWork(@NonNull Context context, @NonNull Class<?> cls, int i, @NonNull Intent intent) {
        enqueueWork(context, new ComponentName(context, cls), i, intent);
    }

    /* renamed from: a */
    public final void m690a(boolean z) {
        if (this.f3280c == null) {
            this.f3280c = new AsyncTaskC1822t4(1, this);
            o61 o61Var = this.f3279b;
            if (o61Var != null && z) {
                o61Var.mo5166d();
            }
            this.f3280c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* renamed from: c */
    public final void m691c() {
        ArrayList arrayList = this.f3284g;
        if (arrayList != null) {
            synchronized (arrayList) {
                try {
                    this.f3280c = null;
                    ArrayList arrayList2 = this.f3284g;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        m690a(false);
                    } else if (!this.f3283f) {
                        this.f3279b.mo5165c();
                    }
                } finally {
                }
            }
        }
    }

    public boolean isStopped() {
        return this.f3282e;
    }

    @Override // android.app.Service
    public IBinder onBind(@NonNull Intent intent) {
        IBinder binder;
        m61 m61Var = this.f3278a;
        if (m61Var != null) {
            binder = m61Var.getBinder();
            return binder;
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f3278a = new m61(this);
            this.f3279b = null;
        } else {
            this.f3278a = null;
            this.f3279b = m689b(this, new ComponentName(this, getClass()), false, 0);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList arrayList = this.f3284g;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f3283f = true;
                this.f3279b.mo5165c();
            }
        }
    }

    public abstract void onHandleWork(@NonNull Intent intent);

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i, int i2) {
        if (this.f3284g != null) {
            this.f3279b.mo5167e();
            synchronized (this.f3284g) {
                ArrayList arrayList = this.f3284g;
                if (intent == null) {
                    intent = new Intent();
                }
                arrayList.add(new j61(this, intent, i2));
                m690a(true);
            }
            return 3;
        }
        return 2;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    public void setInterruptIfStopped(boolean z) {
        this.f3281d = z;
    }

    public static void enqueueWork(@NonNull Context context, @NonNull ComponentName componentName, int i, @NonNull Intent intent) {
        if (intent != null) {
            synchronized (f3276h) {
                o61 m689b = m689b(context, componentName, true, i);
                m689b.m6445b(i);
                m689b.mo5164a(intent);
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }
}
