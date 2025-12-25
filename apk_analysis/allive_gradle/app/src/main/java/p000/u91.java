package p000;

import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.Row;

/* loaded from: classes.dex */
public final class u91 extends ObjectAdapter {

    /* renamed from: d */
    public final ObjectAdapter f27154d;

    /* renamed from: e */
    public int f27155e;

    /* renamed from: f */
    public final ObjectAdapter.DataObserver f27156f;

    public u91(ObjectAdapter objectAdapter) {
        super(objectAdapter.getPresenterSelector());
        this.f27154d = objectAdapter;
        m7683a();
        if (objectAdapter.isImmediateNotifySupported()) {
            this.f27156f = new t91(this);
        } else {
            this.f27156f = new s91(this);
        }
        m7683a();
        objectAdapter.registerObserver(this.f27156f);
    }

    /* renamed from: a */
    public final void m7683a() {
        this.f27155e = -1;
        ObjectAdapter objectAdapter = this.f27154d;
        for (int size = objectAdapter.size() - 1; size >= 0; size--) {
            if (((Row) objectAdapter.get(size)).isRenderedAsRowView()) {
                this.f27155e = size;
                return;
            }
        }
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public final Object get(int i) {
        return this.f27154d.get(i);
    }

    @Override // androidx.leanback.widget.ObjectAdapter
    public final int size() {
        return this.f27155e + 1;
    }
}
