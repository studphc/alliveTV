package p000;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy;
import com.bumptech.glide.util.Util;

/* loaded from: classes.dex */
public final class lk2 implements n62 {

    /* renamed from: a */
    public final le1 f22549a;

    /* renamed from: b */
    public int f22550b;

    /* renamed from: c */
    public Bitmap.Config f22551c;

    public lk2(le1 le1Var) {
        this.f22549a = le1Var;
    }

    @Override // p000.n62
    /* renamed from: a */
    public final void mo5522a() {
        this.f22549a.m4942b(this);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof lk2)) {
            return false;
        }
        lk2 lk2Var = (lk2) obj;
        if (this.f22550b != lk2Var.f22550b || !Util.bothNullOrEqual(this.f22551c, lk2Var.f22551c)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i;
        int i2 = this.f22550b * 31;
        Bitmap.Config config = this.f22551c;
        if (config != null) {
            i = config.hashCode();
        } else {
            i = 0;
        }
        return i2 + i;
    }

    public final String toString() {
        return SizeConfigStrategy.m2329b(this.f22550b, this.f22551c);
    }
}
