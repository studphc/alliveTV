package p000;

/* loaded from: classes.dex */
public enum a72 extends e72 {
    public a72() {
        super("ALWAYS_TRUE", 0);
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        return true;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Predicates.alwaysTrue()";
    }
}
