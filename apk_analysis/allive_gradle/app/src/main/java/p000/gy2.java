package p000;

import com.google.common.reflect.TypeToken;

/* loaded from: classes2.dex */
public enum gy2 extends hy2 {
    public gy2() {
        super("INTERFACE_ONLY", 1);
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        return ((TypeToken) obj).getRawType().isInterface();
    }
}
