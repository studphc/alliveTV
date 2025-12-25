package p000;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* renamed from: lq */
/* loaded from: classes2.dex */
public final class C1520lq extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ int f22634b;

    /* renamed from: c */
    public final /* synthetic */ int f22635c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1520lq(int i, int i2) {
        super(1);
        this.f22634b = i2;
        this.f22635c = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f22634b) {
            case 0:
                ((Number) obj).intValue();
                throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + this.f22635c + '.');
            default:
                ((Number) obj).intValue();
                throw new IndexOutOfBoundsException("Sequence doesn't contain element at index " + this.f22635c + '.');
        }
    }
}
