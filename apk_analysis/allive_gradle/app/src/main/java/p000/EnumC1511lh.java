package p000;

import java.util.Comparator;

/* renamed from: lh */
/* loaded from: classes2.dex */
public enum EnumC1511lh implements Comparator {
    f22499c("Booleans.trueFirst()", 1),
    f22500d("Booleans.falseFirst()", -1);


    /* renamed from: a */
    public final int f22502a;

    /* renamed from: b */
    public final String f22503b;

    EnumC1511lh(String str, int i) {
        this.f22502a = i;
        this.f22503b = str;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i;
        Boolean bool = (Boolean) obj2;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int i2 = 0;
        int i3 = this.f22502a;
        if (booleanValue) {
            i = i3;
        } else {
            i = 0;
        }
        if (bool.booleanValue()) {
            i2 = i3;
        }
        return i2 - i;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f22503b;
    }
}
