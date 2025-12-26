package p000;

import com.google.common.base.Converter;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class r50 extends Converter implements Serializable {

    /* renamed from: b */
    public static final r50 f25871b = new Converter();
    private static final long serialVersionUID = 1;

    private Object readResolve() {
        return f25871b;
    }

    @Override // com.google.common.base.Converter
    public final Object doBackward(Object obj) {
        return ((Double) obj).toString();
    }

    @Override // com.google.common.base.Converter
    public final Object doForward(Object obj) {
        return Double.valueOf((String) obj);
    }

    public final String toString() {
        return "Doubles.stringConverter()";
    }
}
