package p000;

import java.util.Map;

/* loaded from: classes.dex */
public enum lg1 extends ng1 {
    public lg1() {
        super("KEY", 0);
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return ((Map.Entry) obj).getKey();
    }
}
