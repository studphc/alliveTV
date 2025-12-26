package p000;

/* loaded from: classes.dex */
public enum b72 extends e72 {
    public b72() {
        super("ALWAYS_FALSE", 1);
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        return false;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "Predicates.alwaysFalse()";
    }
}
