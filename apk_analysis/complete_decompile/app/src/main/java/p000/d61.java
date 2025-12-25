package p000;

/* loaded from: classes2.dex */
public abstract class d61 {

    /* renamed from: a */
    public static final Integer f16271a;

    static {
        Integer num;
        Object obj;
        Integer num2 = null;
        try {
            obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Throwable unused) {
        }
        if (obj instanceof Integer) {
            num = (Integer) obj;
            if (num != null && num.intValue() > 0) {
                num2 = num;
            }
            f16271a = num2;
        }
        num = null;
        if (num != null) {
            num2 = num;
        }
        f16271a = num2;
    }
}
