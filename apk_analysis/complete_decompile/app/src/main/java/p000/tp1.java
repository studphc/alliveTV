package p000;

import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class tp1 implements Supplier, Serializable {

    /* renamed from: a */
    public final /* synthetic */ int f26915a;

    /* renamed from: b */
    public final int f26916b;

    public tp1(int i, int i2) {
        this.f26915a = i2;
        switch (i2) {
            case 1:
                p63.m6869m(i, "expectedValuesPerKey");
                this.f26916b = i;
                return;
            case 2:
                p63.m6869m(i, "expectedValuesPerKey");
                this.f26916b = i;
                return;
            default:
                p63.m6869m(i, "expectedValuesPerKey");
                this.f26916b = i;
                return;
        }
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        switch (this.f26915a) {
            case 0:
                return new ArrayList(this.f26916b);
            case 1:
                return new C1484kr(this.f26916b);
            default:
                return new C1484kr(this.f26916b);
        }
    }
}
