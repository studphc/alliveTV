package kotlin.io;

import com.hisona.allive.HttpRequest;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m5569d2 = {"Lkotlin/io/LineReader;", "", "Ljava/io/InputStream;", "inputStream", "Ljava/nio/charset/Charset;", HttpRequest.PARAM_CHARSET, "", "readLine", "(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/lang/String;", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nConsole.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Console.kt\nkotlin/io/LineReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,299:1\n1#2:300\n*E\n"})
/* loaded from: classes2.dex */
public final class LineReader {

    @NotNull
    public static final LineReader INSTANCE = new Object();

    /* renamed from: a */
    public static CharsetDecoder f21119a;

    /* renamed from: b */
    public static boolean f21120b;

    /* renamed from: c */
    public static final byte[] f21121c;

    /* renamed from: d */
    public static final char[] f21122d;

    /* renamed from: e */
    public static final ByteBuffer f21123e;

    /* renamed from: f */
    public static final CharBuffer f21124f;

    /* renamed from: g */
    public static final StringBuilder f21125g;

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.io.LineReader, java.lang.Object] */
    static {
        byte[] bArr = new byte[32];
        f21121c = bArr;
        char[] cArr = new char[32];
        f21122d = cArr;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(bytes)");
        f21123e = wrap;
        CharBuffer wrap2 = CharBuffer.wrap(cArr);
        Intrinsics.checkNotNullExpressionValue(wrap2, "wrap(chars)");
        f21124f = wrap2;
        f21125g = new StringBuilder();
    }

    /* renamed from: a */
    public static int m5613a(boolean z) {
        while (true) {
            CharsetDecoder charsetDecoder = f21119a;
            CharsetDecoder charsetDecoder2 = null;
            if (charsetDecoder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("decoder");
                charsetDecoder = null;
            }
            ByteBuffer byteBuffer = f21123e;
            CharBuffer charBuffer = f21124f;
            CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, z);
            Intrinsics.checkNotNullExpressionValue(decode, "decoder.decode(byteBuf, charBuf, endOfInput)");
            boolean isError = decode.isError();
            StringBuilder sb = f21125g;
            if (isError) {
                CharsetDecoder charsetDecoder3 = f21119a;
                if (charsetDecoder3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("decoder");
                } else {
                    charsetDecoder2 = charsetDecoder3;
                }
                charsetDecoder2.reset();
                byteBuffer.position(0);
                sb.setLength(0);
                decode.throwException();
            }
            int position = charBuffer.position();
            if (!decode.isOverflow()) {
                return position;
            }
            char[] cArr = f21122d;
            int i = position - 1;
            sb.append(cArr, 0, i);
            charBuffer.position(0);
            charBuffer.limit(32);
            charBuffer.put(cArr[i]);
        }
    }

    /* renamed from: b */
    public static void m5614b(Charset charset) {
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(newDecoder, "charset.newDecoder()");
        f21119a = newDecoder;
        ByteBuffer byteBuffer = f21123e;
        byteBuffer.clear();
        CharBuffer charBuffer = f21124f;
        charBuffer.clear();
        byteBuffer.put((byte) 10);
        byteBuffer.flip();
        CharsetDecoder charsetDecoder = f21119a;
        CharsetDecoder charsetDecoder2 = null;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.decode(byteBuffer, charBuffer, false);
        boolean z = true;
        if (charBuffer.position() != 1 || charBuffer.get(0) != '\n') {
            z = false;
        }
        f21120b = z;
        CharsetDecoder charsetDecoder3 = f21119a;
        if (charsetDecoder3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        } else {
            charsetDecoder2 = charsetDecoder3;
        }
        charsetDecoder2.reset();
        byteBuffer.position(0);
        f21125g.setLength(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x008c, code lost:
    
        if (r0 <= 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008e, code lost:
    
        r9 = kotlin.io.LineReader.f21122d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0094, code lost:
    
        if (r9[r0 - 1] != '\n') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0096, code lost:
    
        r1 = r0 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0098, code lost:
    
        if (r1 <= 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009a, code lost:
    
        r0 = r0 - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a0, code lost:
    
        if (r9[r0] != '\r') goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a3, code lost:
    
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a4, code lost:
    
        r9 = kotlin.io.LineReader.f21125g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00aa, code lost:
    
        if (r9.length() != 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b4, code lost:
    
        return new java.lang.String(kotlin.io.LineReader.f21122d, 0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b5, code lost:
    
        r9.append(kotlin.io.LineReader.f21122d, 0, r0);
        r0 = r9.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "sb.toString()");
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c7, code lost:
    
        if (r9.length() <= 32) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c9, code lost:
    
        r9.setLength(32);
        r9.trimToSize();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cf, code lost:
    
        r9.setLength(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d3, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x005e A[Catch: all -> 0x001a, TryCatch #0 {all -> 0x001a, blocks: (B:3:0x0001, B:5:0x000f, B:9:0x0023, B:54:0x002e, B:61:0x003d, B:63:0x0050, B:64:0x0057, B:25:0x008e, B:27:0x0096, B:29:0x009a, B:33:0x00a4, B:35:0x00ac, B:39:0x00b5, B:41:0x00c9, B:42:0x00cf, B:11:0x005e, B:14:0x0069, B:18:0x0070, B:20:0x0080, B:23:0x0088, B:45:0x00d4, B:66:0x001d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x002e A[SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized String readLine(@NotNull InputStream inputStream, @NotNull Charset charset) {
        int read;
        int m5613a;
        try {
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            Intrinsics.checkNotNullParameter(charset, "charset");
            CharsetDecoder charsetDecoder = f21119a;
            if (charsetDecoder != null) {
                if (!Intrinsics.areEqual(charsetDecoder.charset(), charset)) {
                }
                int i = 0;
                int i2 = 0;
                while (true) {
                    read = inputStream.read();
                    if (read != -1) {
                        CharsetDecoder charsetDecoder2 = null;
                        if (f21125g.length() == 0 && i == 0 && i2 == 0) {
                            return null;
                        }
                        ByteBuffer byteBuffer = f21123e;
                        byteBuffer.limit(i);
                        f21124f.position(i2);
                        m5613a = m5613a(true);
                        CharsetDecoder charsetDecoder3 = f21119a;
                        if (charsetDecoder3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("decoder");
                        } else {
                            charsetDecoder2 = charsetDecoder3;
                        }
                        charsetDecoder2.reset();
                        byteBuffer.position(0);
                    } else {
                        int i3 = i + 1;
                        f21121c[i] = (byte) read;
                        if (read != 10 && i3 != 32 && f21120b) {
                            i = i3;
                        }
                        ByteBuffer byteBuffer2 = f21123e;
                        byteBuffer2.limit(i3);
                        f21124f.position(i2);
                        i2 = m5613a(false);
                        if (i2 > 0 && f21122d[i2 - 1] == '\n') {
                            byteBuffer2.position(0);
                            m5613a = i2;
                            break;
                        }
                        byteBuffer2.compact();
                        int position = byteBuffer2.position();
                        byteBuffer2.position(0);
                        i = position;
                    }
                }
            }
            m5614b(charset);
            int i4 = 0;
            int i22 = 0;
            while (true) {
                read = inputStream.read();
                if (read != -1) {
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
