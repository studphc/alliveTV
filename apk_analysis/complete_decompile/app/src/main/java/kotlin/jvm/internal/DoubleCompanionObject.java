package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087T¢\u0006\f\n\u0004\b\t\u0010\n\u0012\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087T¢\u0006\f\n\u0004\b\r\u0010\n\u0012\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087T¢\u0006\f\n\u0004\b\u000f\u0010\n\u0012\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087T¢\u0006\f\n\u0004\b\u0011\u0010\n\u0012\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087T¢\u0006\f\n\u0004\b\u0013\u0010\n\u0012\u0004\b\u0014\u0010\fR\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087T¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u0018\u0010\fR\u001a\u0010\u0019\u001a\u00020\u00158\u0006X\u0087T¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u0012\u0004\b\u001a\u0010\f¨\u0006\u001b"}, m5569d2 = {"Lkotlin/jvm/internal/DoubleCompanionObject;", "", "", "getMIN_VALUE", "()D", "getMAX_VALUE", "getPOSITIVE_INFINITY", "getNEGATIVE_INFINITY", "getNaN", "MIN_VALUE", "D", "getMIN_VALUE$annotations", "()V", "MAX_VALUE", "getMAX_VALUE$annotations", "POSITIVE_INFINITY", "getPOSITIVE_INFINITY$annotations", "NEGATIVE_INFINITY", "getNEGATIVE_INFINITY$annotations", "NaN", "getNaN$annotations", "", "SIZE_BYTES", "I", "getSIZE_BYTES$annotations", "SIZE_BITS", "getSIZE_BITS$annotations", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class DoubleCompanionObject {

    @NotNull
    public static final DoubleCompanionObject INSTANCE = new Object();
    public static final double MAX_VALUE = Double.MAX_VALUE;
    public static final double MIN_VALUE = Double.MIN_VALUE;
    public static final double NEGATIVE_INFINITY = Double.NEGATIVE_INFINITY;
    public static final double NaN = Double.NaN;
    public static final double POSITIVE_INFINITY = Double.POSITIVE_INFINITY;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void getMAX_VALUE$annotations() {
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void getMIN_VALUE$annotations() {
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void getNEGATIVE_INFINITY$annotations() {
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void getNaN$annotations() {
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void getPOSITIVE_INFINITY$annotations() {
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void getSIZE_BITS$annotations() {
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void getSIZE_BYTES$annotations() {
    }

    public final double getMAX_VALUE() {
        return Double.MAX_VALUE;
    }

    public final double getMIN_VALUE() {
        return Double.MIN_VALUE;
    }

    public final double getNEGATIVE_INFINITY() {
        return Double.NEGATIVE_INFINITY;
    }

    public final double getNaN() {
        return Double.NaN;
    }

    public final double getPOSITIVE_INFINITY() {
        return Double.POSITIVE_INFINITY;
    }
}
