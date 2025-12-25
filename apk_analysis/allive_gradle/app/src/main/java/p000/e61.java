package p000;

/* loaded from: classes2.dex */
public abstract class e61 {

    /* renamed from: a */
    public static final Integer f16682a;

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
            f16682a = num2;
        }
        num = null;
        if (num != null) {
            num2 = num;
        }
        f16682a = num2;
    }
}
