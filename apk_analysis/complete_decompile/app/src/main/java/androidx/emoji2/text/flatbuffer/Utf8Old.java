package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import p000.mi0;
import p000.y03;

/* loaded from: classes.dex */
public class Utf8Old extends Utf8 {

    /* renamed from: b */
    public static final ThreadLocal f4288b;

    static {
        ThreadLocal withInitial;
        withInitial = ThreadLocal.withInitial(new mi0(3));
        f4288b = withInitial;
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer byteBuffer, int i, int i2) {
        CharsetDecoder charsetDecoder = ((y03) f4288b.get()).f28785b;
        charsetDecoder.reset();
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(i);
        duplicate.limit(i + i2);
        try {
            return charsetDecoder.decode(duplicate).toString();
        } catch (CharacterCodingException e) {
            throw new IllegalArgumentException("Bad encoding", e);
        }
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        y03 y03Var = (y03) f4288b.get();
        if (y03Var.f28786c != charSequence) {
            encodedLength(charSequence);
        }
        byteBuffer.put(y03Var.f28787d);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence charSequence) {
        CharBuffer wrap;
        y03 y03Var = (y03) f4288b.get();
        int maxBytesPerChar = (int) (y03Var.f28784a.maxBytesPerChar() * charSequence.length());
        ByteBuffer byteBuffer = y03Var.f28787d;
        if (byteBuffer == null || byteBuffer.capacity() < maxBytesPerChar) {
            y03Var.f28787d = ByteBuffer.allocate(Math.max(128, maxBytesPerChar));
        }
        y03Var.f28787d.clear();
        y03Var.f28786c = charSequence;
        if (charSequence instanceof CharBuffer) {
            wrap = (CharBuffer) charSequence;
        } else {
            wrap = CharBuffer.wrap(charSequence);
        }
        CoderResult encode = y03Var.f28784a.encode(wrap, y03Var.f28787d, true);
        if (encode.isError()) {
            try {
                encode.throwException();
            } catch (CharacterCodingException e) {
                throw new IllegalArgumentException("bad character encoding", e);
            }
        }
        y03Var.f28787d.flip();
        return y03Var.f28787d.remaining();
    }
}
