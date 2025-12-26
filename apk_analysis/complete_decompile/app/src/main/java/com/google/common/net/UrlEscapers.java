package com.google.common.net;

import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;

@GwtCompatible
/* loaded from: classes2.dex */
public final class UrlEscapers {

    /* renamed from: a */
    public static final PercentEscaper f15193a = new PercentEscaper("-_.*", true);

    /* renamed from: b */
    public static final PercentEscaper f15194b = new PercentEscaper("-._~!$'()*,;&=@:+", false);

    /* renamed from: c */
    public static final PercentEscaper f15195c = new PercentEscaper("-._~!$'()*,;&=@:+/?", false);

    public static Escaper urlFormParameterEscaper() {
        return f15193a;
    }

    public static Escaper urlFragmentEscaper() {
        return f15195c;
    }

    public static Escaper urlPathSegmentEscaper() {
        return f15194b;
    }
}
