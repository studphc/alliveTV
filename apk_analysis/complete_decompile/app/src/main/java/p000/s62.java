package p000;

import androidx.core.util.Predicate;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract /* synthetic */ class s62 {
    /* renamed from: a */
    public static Predicate m7334a(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new r62(predicate, predicate2, 1);
    }

    /* renamed from: b */
    public static Predicate m7335b(Predicate predicate) {
        return new u41(2, predicate);
    }

    /* renamed from: c */
    public static Predicate m7336c(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new r62(predicate, predicate2, 0);
    }

    /* renamed from: d */
    public static Predicate m7337d(Object obj) {
        if (obj == null) {
            return new v41(7);
        }
        return new u41(1, obj);
    }

    /* renamed from: e */
    public static Predicate m7338e(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }
}
