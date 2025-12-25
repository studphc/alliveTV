package p000;

import java.util.Map;

/* loaded from: classes.dex */
public enum mg1 extends ng1 {
    public mg1() {
        super("VALUE", 1);
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return ((Map.Entry) obj).getValue();
    }
}
