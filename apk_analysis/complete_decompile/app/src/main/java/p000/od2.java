package p000;

import android.content.ComponentName;
import android.content.Intent;

/* loaded from: classes2.dex */
public abstract class od2 {

    /* renamed from: a */
    public final ComponentName f23776a;

    /* renamed from: b */
    public boolean f23777b;

    /* renamed from: c */
    public int f23778c;

    public od2(ComponentName componentName) {
        this.f23776a = componentName;
    }

    /* renamed from: a */
    public abstract void mo5437a(Intent intent);

    /* renamed from: b */
    public final void m6563b(int i) {
        if (!this.f23777b) {
            this.f23777b = true;
            this.f23778c = i;
        } else {
            if (this.f23778c == i) {
                return;
            }
            StringBuilder m8299s = ye0.m8299s(i, "Given job ID ", " is different than previous ");
            m8299s.append(this.f23778c);
            throw new IllegalArgumentException(m8299s.toString());
        }
    }

    /* renamed from: c */
    public void mo5438c() {
    }

    /* renamed from: d */
    public void mo5439d() {
    }

    /* renamed from: e */
    public void mo5440e() {
    }
}
