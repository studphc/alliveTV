package com.google.common.base;

import com.google.android.exoplayer2.C0643C;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.nio.charset.Charset;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public final class Charsets {

    @GwtIncompatible
    public static final Charset US_ASCII = Charset.forName(C0643C.ASCII_NAME);
    public static final Charset ISO_8859_1 = Charset.forName(C0643C.ISO88591_NAME);
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    @GwtIncompatible
    public static final Charset UTF_16BE = Charset.forName("UTF-16BE");

    @GwtIncompatible
    public static final Charset UTF_16LE = Charset.forName(C0643C.UTF16LE_NAME);

    @GwtIncompatible
    public static final Charset UTF_16 = Charset.forName(C0643C.UTF16_NAME);
}
