package p000;

import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class z82 extends InputStream {

    /* renamed from: a */
    public final Reader f29275a;

    /* renamed from: b */
    public final CharsetEncoder f29276b;

    /* renamed from: c */
    public final byte[] f29277c;

    /* renamed from: d */
    public CharBuffer f29278d;

    /* renamed from: e */
    public ByteBuffer f29279e;

    /* renamed from: f */
    public boolean f29280f;

    /* renamed from: g */
    public boolean f29281g;

    /* renamed from: h */
    public boolean f29282h;

    public z82(Reader reader, Charset charset) {
        CharsetEncoder newEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        CharsetEncoder onUnmappableCharacter = newEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
        this.f29277c = new byte[1];
        this.f29275a = (Reader) Preconditions.checkNotNull(reader);
        this.f29276b = (CharsetEncoder) Preconditions.checkNotNull(onUnmappableCharacter);
        Preconditions.checkArgument(true, "bufferSize must be positive: %s", 8192);
        onUnmappableCharacter.reset();
        CharBuffer allocate = CharBuffer.allocate(8192);
        this.f29278d = allocate;
        allocate.flip();
        this.f29279e = ByteBuffer.allocate(8192);
    }

    /* renamed from: a */
    public final void m8403a(boolean z) {
        this.f29279e.flip();
        if (z && this.f29279e.remaining() == 0) {
            this.f29279e = ByteBuffer.allocate(this.f29279e.capacity() * 2);
        } else {
            this.f29281g = true;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f29275a.close();
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = this.f29277c;
        if (read(bArr) == 1) {
            return UnsignedBytes.toInt(bArr[0]);
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        if (r2 <= 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:?, code lost:
    
        return -1;
     */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int read(byte[] bArr, int i, int i2) {
        CoderResult encode;
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        if (i2 == 0) {
            return 0;
        }
        boolean z = this.f29280f;
        int i3 = 0;
        while (true) {
            if (this.f29281g) {
                int min = Math.min(i2 - i3, this.f29279e.remaining());
                this.f29279e.get(bArr, i + i3, min);
                i3 += min;
                if (i3 == i2 || this.f29282h) {
                    break;
                }
                this.f29281g = false;
                this.f29279e.clear();
            }
            while (true) {
                if (this.f29282h) {
                    encode = CoderResult.UNDERFLOW;
                } else {
                    CharsetEncoder charsetEncoder = this.f29276b;
                    if (z) {
                        encode = charsetEncoder.flush(this.f29279e);
                    } else {
                        encode = charsetEncoder.encode(this.f29278d, this.f29279e, this.f29280f);
                    }
                }
                if (encode.isOverflow()) {
                    m8403a(true);
                    break;
                }
                if (encode.isUnderflow()) {
                    if (z) {
                        this.f29282h = true;
                        m8403a(false);
                        break;
                    }
                    if (this.f29280f) {
                        z = true;
                    } else {
                        CharBuffer charBuffer = this.f29278d;
                        if (charBuffer.capacity() - charBuffer.limit() == 0) {
                            if (this.f29278d.position() > 0) {
                                this.f29278d.compact().flip();
                            } else {
                                CharBuffer charBuffer2 = this.f29278d;
                                CharBuffer wrap = CharBuffer.wrap(Arrays.copyOf(charBuffer2.array(), charBuffer2.capacity() * 2));
                                wrap.position(charBuffer2.position());
                                wrap.limit(charBuffer2.limit());
                                this.f29278d = wrap;
                            }
                        }
                        int limit = this.f29278d.limit();
                        char[] array = this.f29278d.array();
                        CharBuffer charBuffer3 = this.f29278d;
                        int read = this.f29275a.read(array, limit, charBuffer3.capacity() - charBuffer3.limit());
                        if (read == -1) {
                            this.f29280f = true;
                        } else {
                            this.f29278d.limit(limit + read);
                        }
                    }
                } else if (encode.isError()) {
                    encode.throwException();
                    return 0;
                }
            }
        }
    }
}
