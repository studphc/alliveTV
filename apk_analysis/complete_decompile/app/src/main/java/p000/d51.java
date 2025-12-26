package p000;

import com.google.common.base.Converter;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class d51 extends Converter implements Serializable {

    /* renamed from: b */
    public static final d51 f16250b = new Converter();
    private static final long serialVersionUID = 1;

    private Object readResolve() {
        return f16250b;
    }

    @Override // com.google.common.base.Converter
    public final Object doBackward(Object obj) {
        return ((Integer) obj).toString();
    }

    @Override // com.google.common.base.Converter
    public final Object doForward(Object obj) {
        return Integer.decode((String) obj);
    }

    public final String toString() {
        return "Ints.stringConverter()";
    }
}
