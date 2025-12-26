package p000;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class ae3 implements Iterator {

    /* renamed from: a */
    public int f155a = -1;

    /* renamed from: b */
    public boolean f156b;

    /* renamed from: c */
    public Iterator f157c;

    /* renamed from: d */
    public final /* synthetic */ yd3 f158d;

    public /* synthetic */ ae3(yd3 yd3Var) {
        this.f158d = yd3Var;
    }

    /* renamed from: a */
    public final Iterator m81a() {
        if (this.f157c == null) {
            this.f157c = this.f158d.f28916c.entrySet().iterator();
        }
        return this.f157c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.f155a + 1;
        yd3 yd3Var = this.f158d;
        if (i < yd3Var.f28915b) {
            return true;
        }
        if (!yd3Var.f28916c.isEmpty() && m81a().hasNext()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.f156b = true;
        int i = this.f155a + 1;
        this.f155a = i;
        yd3 yd3Var = this.f158d;
        if (i < yd3Var.f28915b) {
            return (zd3) yd3Var.f28914a[i];
        }
        return (Map.Entry) m81a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f156b) {
            this.f156b = false;
            int i = yd3.f28913g;
            yd3 yd3Var = this.f158d;
            yd3Var.m8274j();
            int i2 = this.f155a;
            if (i2 < yd3Var.f28915b) {
                this.f155a = i2 - 1;
                yd3Var.m8272h(i2);
                return;
            } else {
                m81a().remove();
                return;
            }
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
