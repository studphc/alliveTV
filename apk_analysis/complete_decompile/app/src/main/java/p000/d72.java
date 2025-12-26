package p000;

/* loaded from: classes.dex */
public enum d72 extends e72 {
    public d72() {
        super("NOT_NULL", 3);
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        if (obj != null) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Predicates.notNull()";
    }
}
