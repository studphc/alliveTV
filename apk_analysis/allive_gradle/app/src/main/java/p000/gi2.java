package p000;

import com.google.common.base.Converter;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class gi2 extends Converter implements Serializable {

    /* renamed from: b */
    public static final gi2 f17713b = new Converter();
    private static final long serialVersionUID = 1;

    private Object readResolve() {
        return f17713b;
    }

    @Override // com.google.common.base.Converter
    public final Object doBackward(Object obj) {
        return ((Short) obj).toString();
    }

    @Override // com.google.common.base.Converter
    public final Object doForward(Object obj) {
        return Short.decode((String) obj);
    }

    public final String toString() {
        return "Shorts.stringConverter()";
    }
}
