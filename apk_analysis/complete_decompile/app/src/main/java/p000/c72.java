package p000;

/* loaded from: classes.dex */
public enum c72 extends e72 {
    public c72() {
        super("IS_NULL", 2);
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        if (obj == null) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Predicates.isNull()";
    }
}
