package p000;

import android.content.ComponentName;
import android.content.Intent;

/* loaded from: classes.dex */
public abstract class o61 {

    /* renamed from: a */
    public final ComponentName f23615a;

    /* renamed from: b */
    public boolean f23616b;

    /* renamed from: c */
    public int f23617c;

    public o61(ComponentName componentName) {
        this.f23615a = componentName;
    }

    /* renamed from: a */
    public abstract void mo5164a(Intent intent);

    /* renamed from: b */
    public final void m6445b(int i) {
        if (!this.f23616b) {
            this.f23616b = true;
            this.f23617c = i;
        } else {
            if (this.f23617c == i) {
                return;
            }
            StringBuilder m8299s = ye0.m8299s(i, "Given job ID ", " is different than previous ");
            m8299s.append(this.f23617c);
            throw new IllegalArgumentException(m8299s.toString());
        }
    }

    /* renamed from: c */
    public void mo5165c() {
    }

    /* renamed from: d */
    public void mo5166d() {
    }

    /* renamed from: e */
    public void mo5167e() {
    }
}
