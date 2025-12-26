package p000;

import com.google.common.math.DoubleMath;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/* renamed from: ig */
/* loaded from: classes2.dex */
public final class C1305ig extends o63 {

    /* renamed from: v */
    public static final C1305ig f18399v = new C1305ig(0);

    /* renamed from: w */
    public static final C1305ig f18400w = new C1305ig(1);

    /* renamed from: u */
    public final /* synthetic */ int f18401u;

    public /* synthetic */ C1305ig(int i) {
        this.f18401u = i;
    }

    @Override // p000.o63
    /* renamed from: H */
    public final double mo5234H(Number number) {
        switch (this.f18401u) {
            case 0:
                return ((BigDecimal) number).doubleValue();
            default:
                return o63.m6463c((BigInteger) number);
        }
    }

    @Override // p000.o63
    /* renamed from: K */
    public final int mo5235K(Number number) {
        switch (this.f18401u) {
            case 0:
                return ((BigDecimal) number).signum();
            default:
                return ((BigInteger) number).signum();
        }
    }

    @Override // p000.o63
    /* renamed from: O */
    public final Number mo5236O(double d, RoundingMode roundingMode) {
        switch (this.f18401u) {
            case 0:
                return new BigDecimal(d);
            default:
                return DoubleMath.roundToBigInteger(d, roundingMode);
        }
    }

    @Override // p000.o63
    /* renamed from: w */
    public final Number mo5237w(Number number, Number number2) {
        switch (this.f18401u) {
            case 0:
                return ((BigDecimal) number).subtract((BigDecimal) number2);
            default:
                return ((BigInteger) number).subtract((BigInteger) number2);
        }
    }
}
