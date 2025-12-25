package p000;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;

/* loaded from: classes.dex */
public final class i61 extends o61 {

    /* renamed from: d */
    public final Context f18317d;

    /* renamed from: e */
    public final PowerManager.WakeLock f18318e;

    /* renamed from: f */
    public final PowerManager.WakeLock f18319f;

    /* renamed from: g */
    public boolean f18320g;

    /* renamed from: h */
    public boolean f18321h;

    public i61(Context context, ComponentName componentName) {
        super(componentName);
        this.f18317d = context.getApplicationContext();
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
        this.f18318e = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
        this.f18319f = newWakeLock2;
        newWakeLock2.setReferenceCounted(false);
    }

    @Override // p000.o61
    /* renamed from: a */
    public final void mo5164a(Intent intent) {
        Intent intent2 = new Intent(intent);
        intent2.setComponent(this.f23615a);
        if (this.f18317d.startService(intent2) != null) {
            synchronized (this) {
                try {
                    if (!this.f18320g) {
                        this.f18320g = true;
                        if (!this.f18321h) {
                            this.f18318e.acquire(60000L);
                        }
                    }
                } finally {
                }
            }
        }
    }

    @Override // p000.o61
    /* renamed from: c */
    public final void mo5165c() {
        synchronized (this) {
            try {
                if (this.f18321h) {
                    if (this.f18320g) {
                        this.f18318e.acquire(60000L);
                    }
                    this.f18321h = false;
                    this.f18319f.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p000.o61
    /* renamed from: d */
    public final void mo5166d() {
        synchronized (this) {
            try {
                if (!this.f18321h) {
                    this.f18321h = true;
                    this.f18319f.acquire(600000L);
                    this.f18318e.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p000.o61
    /* renamed from: e */
    public final void mo5167e() {
        synchronized (this) {
            this.f18320g = false;
        }
    }
}
