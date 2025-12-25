package kotlin.text;

import com.google.android.exoplayer2.C0643C;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0011\u0010\f\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0011"}, m5569d2 = {"Lkotlin/text/Charsets;", "", "Ljava/nio/charset/Charset;", "UTF_8", "Ljava/nio/charset/Charset;", "UTF_16", "UTF_16BE", "UTF_16LE", "US_ASCII", "ISO_8859_1", "UTF32", "()Ljava/nio/charset/Charset;", "UTF_32", "UTF32_LE", "UTF_32LE", "UTF32_BE", "UTF_32BE", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Charsets {

    @NotNull
    public static final Charsets INSTANCE = new Object();

    @JvmField
    @NotNull
    public static final Charset ISO_8859_1;

    @JvmField
    @NotNull
    public static final Charset US_ASCII;

    @JvmField
    @NotNull
    public static final Charset UTF_16;

    @JvmField
    @NotNull
    public static final Charset UTF_16BE;

    @JvmField
    @NotNull
    public static final Charset UTF_16LE;

    @JvmField
    @NotNull
    public static final Charset UTF_8;

    /* renamed from: a */
    public static volatile Charset f21340a;

    /* renamed from: b */
    public static volatile Charset f21341b;

    /* renamed from: c */
    public static volatile Charset f21342c;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.text.Charsets] */
    static {
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-8\")");
        UTF_8 = forName;
        Charset forName2 = Charset.forName(C0643C.UTF16_NAME);
        Intrinsics.checkNotNullExpressionValue(forName2, "forName(\"UTF-16\")");
        UTF_16 = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        Intrinsics.checkNotNullExpressionValue(forName3, "forName(\"UTF-16BE\")");
        UTF_16BE = forName3;
        Charset forName4 = Charset.forName(C0643C.UTF16LE_NAME);
        Intrinsics.checkNotNullExpressionValue(forName4, "forName(\"UTF-16LE\")");
        UTF_16LE = forName4;
        Charset forName5 = Charset.forName(C0643C.ASCII_NAME);
        Intrinsics.checkNotNullExpressionValue(forName5, "forName(\"US-ASCII\")");
        US_ASCII = forName5;
        Charset forName6 = Charset.forName(C0643C.ISO88591_NAME);
        Intrinsics.checkNotNullExpressionValue(forName6, "forName(\"ISO-8859-1\")");
        ISO_8859_1 = forName6;
    }

    @JvmName(name = "UTF32")
    @NotNull
    public final Charset UTF32() {
        Charset charset = f21340a;
        if (charset == null) {
            Charset forName = Charset.forName("UTF-32");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-32\")");
            f21340a = forName;
            return forName;
        }
        return charset;
    }

    @JvmName(name = "UTF32_BE")
    @NotNull
    public final Charset UTF32_BE() {
        Charset charset = f21342c;
        if (charset == null) {
            Charset forName = Charset.forName("UTF-32BE");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-32BE\")");
            f21342c = forName;
            return forName;
        }
        return charset;
    }

    @JvmName(name = "UTF32_LE")
    @NotNull
    public final Charset UTF32_LE() {
        Charset charset = f21341b;
        if (charset == null) {
            Charset forName = Charset.forName("UTF-32LE");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-32LE\")");
            f21341b = forName;
            return forName;
        }
        return charset;
    }
}
