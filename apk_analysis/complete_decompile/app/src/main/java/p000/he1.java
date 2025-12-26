package p000;

import com.google.common.base.Converter;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class he1 extends Converter implements Serializable {

    /* renamed from: b */
    public static final he1 f18040b = new Converter();
    private static final long serialVersionUID = 1;

    private Object readResolve() {
        return f18040b;
    }

    @Override // com.google.common.base.Converter
    public final Object doBackward(Object obj) {
        return ((Long) obj).toString();
    }

    @Override // com.google.common.base.Converter
    public final Object doForward(Object obj) {
        return Long.decode((String) obj);
    }

    public final String toString() {
        return "Longs.stringConverter()";
    }
}
