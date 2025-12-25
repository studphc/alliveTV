package p000;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public final class y03 {

    /* renamed from: a */
    public final CharsetEncoder f28784a;

    /* renamed from: b */
    public final CharsetDecoder f28785b;

    /* renamed from: c */
    public CharSequence f28786c = null;

    /* renamed from: d */
    public ByteBuffer f28787d = null;

    public y03() {
        Charset charset = StandardCharsets.UTF_8;
        this.f28784a = charset.newEncoder();
        this.f28785b = charset.newDecoder();
    }
}
