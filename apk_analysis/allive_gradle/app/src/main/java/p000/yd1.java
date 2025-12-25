package p000;

import com.google.common.base.Supplier;

/* loaded from: classes.dex */
public abstract class yd1 {

    /* renamed from: a */
    public static final Supplier f28910a;

    static {
        ud1 ud1Var;
        try {
            new Number();
            ud1Var = new ud1(1);
        } catch (Throwable unused) {
            ud1Var = new ud1(3);
        }
        f28910a = ud1Var;
    }

    /* renamed from: a */
    public static td1 m8266a() {
        return (td1) f28910a.get();
    }
}
