package p000;

import com.google.common.collect.AbstractC0870f3;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class ds2 extends AbstractC0870f3 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final Object f16530a;

    /* renamed from: b */
    public final Object f16531b;

    /* renamed from: c */
    public final Object f16532c;

    public ds2(Object obj, Object obj2, Object obj3) {
        this.f16530a = obj;
        this.f16531b = obj2;
        this.f16532c = obj3;
    }

    @Override // com.google.common.collect.Table.Cell
    public final Object getColumnKey() {
        return this.f16531b;
    }

    @Override // com.google.common.collect.Table.Cell
    public final Object getRowKey() {
        return this.f16530a;
    }

    @Override // com.google.common.collect.Table.Cell
    public final Object getValue() {
        return this.f16532c;
    }
}
