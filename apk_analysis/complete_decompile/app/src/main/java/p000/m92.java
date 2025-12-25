package p000;

import com.google.gson.internal.JavaVersion;
import java.lang.reflect.AccessibleObject;

/* loaded from: classes2.dex */
public abstract class m92 {

    /* renamed from: a */
    public static final m92 f22856a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:5:0x001f  */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [m92] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    static {
        ?? r1;
        if (JavaVersion.isJava9OrLater()) {
            try {
                r1 = new k92(AccessibleObject.class.getDeclaredMethod("canAccess", Object.class));
            } catch (NoSuchMethodException unused) {
            }
            if (r1 == 0) {
                r1 = new Object();
            }
            f22856a = r1;
        }
        r1 = 0;
        if (r1 == 0) {
        }
        f22856a = r1;
    }

    /* renamed from: a */
    public abstract boolean mo5514a(AccessibleObject accessibleObject, Object obj);
}
