package p000;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

/* loaded from: classes.dex */
public abstract class wa1 {

    /* renamed from: a */
    public final Observer f28116a;

    /* renamed from: b */
    public boolean f28117b;

    /* renamed from: c */
    public int f28118c = -1;

    /* renamed from: d */
    public final /* synthetic */ LiveData f28119d;

    public wa1(LiveData liveData, Observer observer) {
        this.f28119d = liveData;
        this.f28116a = observer;
    }

    /* renamed from: a */
    public final void m8018a(boolean z) {
        int i;
        boolean z2;
        boolean z3;
        if (z == this.f28117b) {
            return;
        }
        this.f28117b = z;
        if (z) {
            i = 1;
        } else {
            i = -1;
        }
        LiveData liveData = this.f28119d;
        int i2 = liveData.f6507c;
        liveData.f6507c = i + i2;
        if (!liveData.f6508d) {
            liveData.f6508d = true;
            while (true) {
                try {
                    int i3 = liveData.f6507c;
                    if (i2 == i3) {
                        break;
                    }
                    if (i2 == 0 && i3 > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (i2 > 0 && i3 == 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z2) {
                        liveData.onActive();
                    } else if (z3) {
                        liveData.onInactive();
                    }
                    i2 = i3;
                } catch (Throwable th) {
                    liveData.f6508d = false;
                    throw th;
                }
            }
            liveData.f6508d = false;
        }
        if (this.f28117b) {
            liveData.m1530c(this);
        }
    }

    /* renamed from: c */
    public boolean mo1532c(LifecycleOwner lifecycleOwner) {
        return false;
    }

    /* renamed from: d */
    public abstract boolean mo1533d();

    /* renamed from: b */
    public void mo1531b() {
    }
}
