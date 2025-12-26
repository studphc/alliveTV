package p000;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;

/* loaded from: classes2.dex */
public final class jd2 extends od2 {

    /* renamed from: d */
    public final Context f20470d;

    /* renamed from: e */
    public final PowerManager.WakeLock f20471e;

    /* renamed from: f */
    public final PowerManager.WakeLock f20472f;

    /* renamed from: g */
    public boolean f20473g;

    /* renamed from: h */
    public boolean f20474h;

    public jd2(Context context, ComponentName componentName) {
        super(componentName);
        this.f20470d = context.getApplicationContext();
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
        this.f20471e = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
        this.f20472f = newWakeLock2;
        newWakeLock2.setReferenceCounted(false);
    }

    @Override // p000.od2
    /* renamed from: a */
    public final void mo5437a(Intent intent) {
        Intent intent2 = new Intent(intent);
        intent2.setComponent(this.f23776a);
        if (this.f20470d.startService(intent2) != null) {
            synchronized (this) {
                try {
                    if (!this.f20473g) {
                        this.f20473g = true;
                        if (!this.f20474h) {
                            this.f20471e.acquire(60000L);
                        }
                    }
                } finally {
                }
            }
        }
    }

    @Override // p000.od2
    /* renamed from: c */
    public final void mo5438c() {
        synchronized (this) {
            try {
                if (this.f20474h) {
                    if (this.f20473g) {
                        this.f20471e.acquire(60000L);
                    }
                    this.f20474h = false;
                    this.f20472f.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p000.od2
    /* renamed from: d */
    public final void mo5439d() {
        synchronized (this) {
            try {
                if (!this.f20474h) {
                    this.f20474h = true;
                    this.f20472f.acquire(600000L);
                    this.f20471e.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p000.od2
    /* renamed from: e */
    public final void mo5440e() {
        synchronized (this) {
            this.f20473g = false;
        }
    }
}
