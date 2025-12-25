package p000;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;

/* renamed from: mw */
/* loaded from: classes.dex */
public final class C1563mw extends Converter implements Serializable {

    /* renamed from: b */
    public static final C1563mw f23141b = new Converter();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return f23141b;
    }

    @Override // com.google.common.base.Converter
    /* renamed from: c */
    public final Converter mo3763c(Converter converter) {
        return (Converter) Preconditions.checkNotNull(converter, "otherConverter");
    }

    public final String toString() {
        return "Converter.identity()";
    }

    @Override // com.google.common.base.Converter
    public final Converter reverse() {
        return this;
    }

    @Override // com.google.common.base.Converter
    public final Object doBackward(Object obj) {
        return obj;
    }

    @Override // com.google.common.base.Converter
    public final Object doForward(Object obj) {
        return obj;
    }
}
