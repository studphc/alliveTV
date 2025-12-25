package p000;

import com.google.common.hash.Funnel;
import com.google.common.hash.Hashing;
import java.io.Serializable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: jh */
/* loaded from: classes2.dex */
public abstract class EnumC1354jh implements Serializable {

    /* renamed from: a */
    public static final C1269hh f20499a;

    /* renamed from: b */
    public static final /* synthetic */ EnumC1354jh[] f20500b;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC1354jh EF0;

    static {
        EnumC1354jh enumC1354jh = new EnumC1354jh() { // from class: gh
            @Override // p000.EnumC1354jh
            /* renamed from: a */
            public final boolean mo4952a(Object obj, Funnel funnel, int i, C1306ih c1306ih) {
                long m5241a = c1306ih.m5241a();
                long asLong = Hashing.murmur3_128().hashObject(obj, funnel).asLong();
                int i2 = (int) asLong;
                int i3 = (int) (asLong >>> 32);
                for (int i4 = 1; i4 <= i; i4++) {
                    int i5 = (i4 * i3) + i2;
                    if (i5 < 0) {
                        i5 = ~i5;
                    }
                    if (!c1306ih.m5242b(i5 % m5241a)) {
                        return false;
                    }
                }
                return true;
            }

            @Override // p000.EnumC1354jh
            /* renamed from: b */
            public final boolean mo4953b(Object obj, Funnel funnel, int i, C1306ih c1306ih) {
                long m5241a = c1306ih.m5241a();
                long asLong = Hashing.murmur3_128().hashObject(obj, funnel).asLong();
                int i2 = (int) asLong;
                int i3 = (int) (asLong >>> 32);
                boolean z = false;
                for (int i4 = 1; i4 <= i; i4++) {
                    int i5 = (i4 * i3) + i2;
                    if (i5 < 0) {
                        i5 = ~i5;
                    }
                    z |= c1306ih.m5244d(i5 % m5241a);
                }
                return z;
            }
        };
        C1269hh c1269hh = new C1269hh();
        f20499a = c1269hh;
        f20500b = new EnumC1354jh[]{enumC1354jh, c1269hh};
    }

    public static EnumC1354jh valueOf(String str) {
        return (EnumC1354jh) Enum.valueOf(EnumC1354jh.class, str);
    }

    public static EnumC1354jh[] values() {
        return (EnumC1354jh[]) f20500b.clone();
    }

    /* renamed from: a */
    public abstract boolean mo4952a(Object obj, Funnel funnel, int i, C1306ih c1306ih);

    /* renamed from: b */
    public abstract boolean mo4953b(Object obj, Funnel funnel, int i, C1306ih c1306ih);
}
