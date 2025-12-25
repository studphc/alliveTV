package p000;

import com.google.common.base.Converter;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class af0 extends Converter implements Serializable {

    /* renamed from: b */
    public static final af0 f160b = new Converter();
    private static final long serialVersionUID = 1;

    private Object readResolve() {
        return f160b;
    }

    @Override // com.google.common.base.Converter
    public final Object doBackward(Object obj) {
        return ((Float) obj).toString();
    }

    @Override // com.google.common.base.Converter
    public final Object doForward(Object obj) {
        return Float.valueOf((String) obj);
    }

    public final String toString() {
        return "Floats.stringConverter()";
    }
}
