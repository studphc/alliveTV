package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import java.math.BigDecimal;
import java.math.RoundingMode;
import p000.C1305ig;

@GwtIncompatible
/* loaded from: classes2.dex */
public class BigDecimalMath {
    public static double roundToDouble(BigDecimal bigDecimal, RoundingMode roundingMode) {
        return C1305ig.f18399v.m6479G(bigDecimal, roundingMode);
    }
}
