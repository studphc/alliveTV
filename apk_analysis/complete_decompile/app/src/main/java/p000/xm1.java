package p000;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

/* loaded from: classes.dex */
public final class xm1 implements Observer {

    /* renamed from: a */
    public final LiveData f28627a;

    /* renamed from: b */
    public final Observer f28628b;

    /* renamed from: c */
    public int f28629c = -1;

    public xm1(LiveData liveData, Observer observer) {
        this.f28627a = liveData;
        this.f28628b = observer;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        int i = this.f28629c;
        int i2 = this.f28627a.f6511g;
        if (i != i2) {
            this.f28629c = i2;
            this.f28628b.onChanged(obj);
        }
    }
}
