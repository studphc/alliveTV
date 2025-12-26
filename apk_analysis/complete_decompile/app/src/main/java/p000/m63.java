package p000;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import okio.BufferedSource;

/* loaded from: classes2.dex */
public final class m63 extends Lambda implements Function2 {

    /* renamed from: b */
    public final /* synthetic */ Ref.BooleanRef f22827b;

    /* renamed from: c */
    public final /* synthetic */ long f22828c;

    /* renamed from: d */
    public final /* synthetic */ Ref.LongRef f22829d;

    /* renamed from: e */
    public final /* synthetic */ BufferedSource f22830e;

    /* renamed from: f */
    public final /* synthetic */ Ref.LongRef f22831f;

    /* renamed from: g */
    public final /* synthetic */ Ref.LongRef f22832g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m63(Ref.BooleanRef booleanRef, long j, Ref.LongRef longRef, BufferedSource bufferedSource, Ref.LongRef longRef2, Ref.LongRef longRef3) {
        super(2);
        this.f22827b = booleanRef;
        this.f22828c = j;
        this.f22829d = longRef;
        this.f22830e = bufferedSource;
        this.f22831f = longRef2;
        this.f22832g = longRef3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        long j;
        int intValue = ((Number) obj).intValue();
        long longValue = ((Number) obj2).longValue();
        if (intValue == 1) {
            Ref.BooleanRef booleanRef = this.f22827b;
            if (!booleanRef.element) {
                booleanRef.element = true;
                if (longValue >= this.f22828c) {
                    Ref.LongRef longRef = this.f22829d;
                    long j2 = longRef.element;
                    BufferedSource bufferedSource = this.f22830e;
                    if (j2 == 4294967295L) {
                        j2 = bufferedSource.readLongLe();
                    }
                    longRef.element = j2;
                    Ref.LongRef longRef2 = this.f22831f;
                    long j3 = 0;
                    if (longRef2.element == 4294967295L) {
                        j = bufferedSource.readLongLe();
                    } else {
                        j = 0;
                    }
                    longRef2.element = j;
                    Ref.LongRef longRef3 = this.f22832g;
                    if (longRef3.element == 4294967295L) {
                        j3 = bufferedSource.readLongLe();
                    }
                    longRef3.element = j3;
                } else {
                    throw new IOException("bad zip: zip64 extra too short");
                }
            } else {
                throw new IOException("bad zip: zip64 extra repeated");
            }
        }
        return Unit.INSTANCE;
    }
}
