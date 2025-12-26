package p000;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import okio.BufferedSource;

/* loaded from: classes2.dex */
public final class n63 extends Lambda implements Function2 {

    /* renamed from: b */
    public final /* synthetic */ BufferedSource f23248b;

    /* renamed from: c */
    public final /* synthetic */ Ref.ObjectRef f23249c;

    /* renamed from: d */
    public final /* synthetic */ Ref.ObjectRef f23250d;

    /* renamed from: e */
    public final /* synthetic */ Ref.ObjectRef f23251e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n63(BufferedSource bufferedSource, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3) {
        super(2);
        this.f23248b = bufferedSource;
        this.f23249c = objectRef;
        this.f23250d = objectRef2;
        this.f23251e = objectRef3;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r12v12, types: [T, java.lang.Long] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        boolean z;
        boolean z2;
        int intValue = ((Number) obj).intValue();
        long longValue = ((Number) obj2).longValue();
        if (intValue == 21589) {
            long j = 1;
            if (longValue >= 1) {
                byte readByte = this.f23248b.readByte();
                boolean z3 = true;
                if ((readByte & 1) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if ((readByte & 2) == 2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if ((readByte & 4) != 4) {
                    z3 = false;
                }
                if (z) {
                    j = 5;
                }
                if (z2) {
                    j += 4;
                }
                if (z3) {
                    j += 4;
                }
                if (longValue >= j) {
                    if (z) {
                        this.f23249c.element = Long.valueOf(r2.readIntLe() * 1000);
                    }
                    if (z2) {
                        this.f23250d.element = Long.valueOf(r2.readIntLe() * 1000);
                    }
                    if (z3) {
                        this.f23251e.element = Long.valueOf(r2.readIntLe() * 1000);
                    }
                } else {
                    throw new IOException("bad zip: extended timestamp extra too short");
                }
            } else {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
        }
        return Unit.INSTANCE;
    }
}
