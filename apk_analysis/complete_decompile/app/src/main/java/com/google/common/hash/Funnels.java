package com.google.common.hash;

import com.google.common.annotations.Beta;
import java.io.OutputStream;
import java.nio.charset.Charset;
import p000.bw0;
import p000.cw0;
import p000.vv0;
import p000.wv0;
import p000.xv0;
import p000.yv0;
import p000.zv0;

@Beta
/* loaded from: classes2.dex */
public final class Funnels {
    public static OutputStream asOutputStream(PrimitiveSink primitiveSink) {
        return new zv0(primitiveSink);
    }

    public static Funnel<byte[]> byteArrayFunnel() {
        return vv0.f27976a;
    }

    public static Funnel<Integer> integerFunnel() {
        return wv0.f28344a;
    }

    public static Funnel<Long> longFunnel() {
        return xv0.f28742a;
    }

    public static <E> Funnel<Iterable<? extends E>> sequentialFunnel(Funnel<E> funnel) {
        return new yv0(funnel);
    }

    public static Funnel<CharSequence> stringFunnel(Charset charset) {
        return new bw0(charset);
    }

    public static Funnel<CharSequence> unencodedCharsFunnel() {
        return cw0.f16146a;
    }
}
