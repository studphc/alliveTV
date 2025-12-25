package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.hisona.allive.HttpRequest;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._SegmentedByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u000eH\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0001H\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001f\u0010\u0012J\u001f\u0010#\u001a\u00020\u00012\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010)\u001a\u00020&2\u0006\u0010%\u001a\u00020 H\u0010¢\u0006\u0004\b'\u0010(J\u000f\u0010,\u001a\u00020 H\u0010¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020\u0003H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00105\u001a\u0002042\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b5\u00106J'\u00105\u001a\u0002042\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020 H\u0010¢\u0006\u0004\b;\u0010<J/\u0010@\u001a\u00020?2\u0006\u00109\u001a\u00020 2\u0006\u0010=\u001a\u00020\u00012\u0006\u0010>\u001a\u00020 2\u0006\u0010:\u001a\u00020 H\u0016¢\u0006\u0004\b@\u0010AJ/\u0010@\u001a\u00020?2\u0006\u00109\u001a\u00020 2\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020 2\u0006\u0010:\u001a\u00020 H\u0016¢\u0006\u0004\b@\u0010BJ/\u0010E\u001a\u0002042\u0006\u00109\u001a\u00020 2\u0006\u0010C\u001a\u00020\u00032\u0006\u0010D\u001a\u00020 2\u0006\u0010:\u001a\u00020 H\u0016¢\u0006\u0004\bE\u0010FJ\u001f\u0010H\u001a\u00020 2\u0006\u0010=\u001a\u00020\u00032\u0006\u0010G\u001a\u00020 H\u0016¢\u0006\u0004\bH\u0010IJ\u001f\u0010J\u001a\u00020 2\u0006\u0010=\u001a\u00020\u00032\u0006\u0010G\u001a\u00020 H\u0016¢\u0006\u0004\bJ\u0010IJ\u000f\u0010L\u001a\u00020\u0003H\u0010¢\u0006\u0004\bK\u0010.J\u001a\u0010N\u001a\u00020?2\b\u0010=\u001a\u0004\u0018\u00010MH\u0096\u0002¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020 H\u0016¢\u0006\u0004\bP\u0010+J\u000f\u0010Q\u001a\u00020\u000eH\u0016¢\u0006\u0004\bQ\u0010\u0012R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u001a\u0010\u0006\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y¨\u0006Z"}, m5569d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "", "", "segments", "", "directory", "<init>", "([[B[I)V", "Ljava/lang/Object;", "writeReplace", "()Ljava/lang/Object;", "Ljava/nio/charset/Charset;", HttpRequest.PARAM_CHARSET, "", TypedValues.Custom.S_STRING, "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "base64", "()Ljava/lang/String;", "hex", "toAsciiLowercase", "()Lokio/ByteString;", "toAsciiUppercase", "algorithm", "digest$okio", "(Ljava/lang/String;)Lokio/ByteString;", "digest", "key", "hmac$okio", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "hmac", "base64Url", "", "beginIndex", "endIndex", "substring", "(II)Lokio/ByteString;", "pos", "", "internalGet$okio", "(I)B", "internalGet", "getSize$okio", "()I", "getSize", "toByteArray", "()[B", "Ljava/nio/ByteBuffer;", "asByteBuffer", "()Ljava/nio/ByteBuffer;", "Ljava/io/OutputStream;", "out", "", "write", "(Ljava/io/OutputStream;)V", "Lokio/Buffer;", "buffer", TypedValues.CycleType.S_WAVE_OFFSET, "byteCount", "write$okio", "(Lokio/Buffer;II)V", "other", "otherOffset", "", "rangeEquals", "(ILokio/ByteString;II)Z", "(I[BII)Z", TypedValues.AttributesType.S_TARGET, "targetOffset", "copyInto", "(I[BII)V", "fromIndex", "indexOf", "([BI)I", "lastIndexOf", "internalArray$okio", "internalArray", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "d", "[[B", "getSegments$okio", "()[[B", "e", "[I", "getDirectory$okio", "()[I", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class SegmentedByteString extends ByteString {

    /* renamed from: d, reason: from kotlin metadata */
    public final transient byte[][] segments;

    /* renamed from: e, reason: from kotlin metadata */
    public final transient int[] directory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(@NotNull byte[][] segments, @NotNull int[] directory) {
        super(ByteString.EMPTY.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String());
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.segments = segments;
        this.directory = directory;
    }

    private final Object writeReplace() {
        return m6671a();
    }

    /* renamed from: a */
    public final ByteString m6671a() {
        return new ByteString(toByteArray());
    }

    @Override // okio.ByteString
    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(asReadOnlyBuffer, "wrap(toByteArray()).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @Override // okio.ByteString
    @NotNull
    public String base64() {
        return m6671a().base64();
    }

    @Override // okio.ByteString
    @NotNull
    public String base64Url() {
        return m6671a().base64Url();
    }

    @Override // okio.ByteString
    public void copyInto(int offset, @NotNull byte[] target, int targetOffset, int byteCount) {
        int i;
        Intrinsics.checkNotNullParameter(target, "target");
        long j = byteCount;
        _UtilKt.checkOffsetAndCount(size(), offset, j);
        _UtilKt.checkOffsetAndCount(target.length, targetOffset, j);
        int i2 = byteCount + offset;
        int segment = _SegmentedByteStringKt.segment(this, offset);
        while (offset < i2) {
            if (segment == 0) {
                i = 0;
            } else {
                i = getDirectory()[segment - 1];
            }
            int i3 = getDirectory()[segment] - i;
            int i4 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i2, i3 + i) - offset;
            int i5 = (offset - i) + i4;
            ArraysKt___ArraysJvmKt.copyInto(getSegments()[segment], target, targetOffset, i5, i5 + min);
            targetOffset += min;
            offset += min;
            segment++;
        }
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString digest$okio(@NotNull String algorithm) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = getSegments().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = getDirectory()[length + i];
            int i4 = getDirectory()[i];
            messageDigest.update(getSegments()[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        byte[] digestBytes = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digestBytes, "digestBytes");
        return new ByteString(digestBytes);
    }

    @Override // okio.ByteString
    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ByteString) {
            ByteString byteString = (ByteString) other;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    /* renamed from: getDirectory$okio, reason: from getter */
    public final int[] getDirectory() {
        return this.directory;
    }

    @NotNull
    /* renamed from: getSegments$okio, reason: from getter */
    public final byte[][] getSegments() {
        return this.segments;
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory()[getSegments().length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode == 0) {
            int length = getSegments().length;
            int i = 0;
            int i2 = 1;
            int i3 = 0;
            while (i < length) {
                int i4 = getDirectory()[length + i];
                int i5 = getDirectory()[i];
                byte[] bArr = getSegments()[i];
                int i6 = (i5 - i3) + i4;
                while (i4 < i6) {
                    i2 = (i2 * 31) + bArr[i4];
                    i4++;
                }
                i++;
                i3 = i5;
            }
            setHashCode$okio(i2);
            return i2;
        }
        return hashCode;
    }

    @Override // okio.ByteString
    @NotNull
    public String hex() {
        return m6671a().hex();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString hmac$okio(@NotNull String algorithm, @NotNull ByteString key) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            int length = getSegments().length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = getDirectory()[length + i];
                int i4 = getDirectory()[i];
                mac.update(getSegments()[i], i3, i4 - i2);
                i++;
                i2 = i4;
            }
            byte[] doFinal = mac.doFinal();
            Intrinsics.checkNotNullExpressionValue(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // okio.ByteString
    public int indexOf(@NotNull byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return m6671a().indexOf(other, fromIndex);
    }

    @Override // okio.ByteString
    @NotNull
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int pos) {
        int i;
        _UtilKt.checkOffsetAndCount(getDirectory()[getSegments().length - 1], pos, 1L);
        int segment = _SegmentedByteStringKt.segment(this, pos);
        if (segment == 0) {
            i = 0;
        } else {
            i = getDirectory()[segment - 1];
        }
        return getSegments()[segment][(pos - i) + getDirectory()[getSegments().length + segment]];
    }

    @Override // okio.ByteString
    public int lastIndexOf(@NotNull byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return m6671a().lastIndexOf(other, fromIndex);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int offset, @NotNull ByteString other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (offset < 0 || offset > size() - byteCount) {
            return false;
        }
        int i = byteCount + offset;
        int segment = _SegmentedByteStringKt.segment(this, offset);
        while (offset < i) {
            int i2 = segment == 0 ? 0 : getDirectory()[segment - 1];
            int i3 = getDirectory()[segment] - i2;
            int i4 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i, i3 + i2) - offset;
            if (!other.rangeEquals(otherOffset, getSegments()[segment], (offset - i2) + i4, min)) {
                return false;
            }
            otherOffset += min;
            offset += min;
            segment++;
        }
        return true;
    }

    @Override // okio.ByteString
    @NotNull
    public String string(@NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return m6671a().string(charset);
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString substring(int beginIndex, int endIndex) {
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(this, endIndex);
        if (beginIndex >= 0) {
            if (resolveDefaultParameter <= size()) {
                int i = resolveDefaultParameter - beginIndex;
                if (i >= 0) {
                    if (beginIndex == 0 && resolveDefaultParameter == size()) {
                        return this;
                    }
                    if (beginIndex == resolveDefaultParameter) {
                        return ByteString.EMPTY;
                    }
                    int segment = _SegmentedByteStringKt.segment(this, beginIndex);
                    int segment2 = _SegmentedByteStringKt.segment(this, resolveDefaultParameter - 1);
                    byte[][] bArr = (byte[][]) ArraysKt___ArraysJvmKt.copyOfRange(getSegments(), segment, segment2 + 1);
                    int[] iArr = new int[bArr.length * 2];
                    int i2 = 0;
                    if (segment <= segment2) {
                        int i3 = segment;
                        int i4 = 0;
                        while (true) {
                            iArr[i4] = Math.min(getDirectory()[i3] - beginIndex, i);
                            int i5 = i4 + 1;
                            iArr[i4 + bArr.length] = getDirectory()[getSegments().length + i3];
                            if (i3 == segment2) {
                                break;
                            }
                            i3++;
                            i4 = i5;
                        }
                    }
                    if (segment != 0) {
                        i2 = getDirectory()[segment - 1];
                    }
                    int length = bArr.length;
                    iArr[length] = (beginIndex - i2) + iArr[length];
                    return new SegmentedByteString(bArr, iArr);
                }
                throw new IllegalArgumentException(ye0.m8293m(resolveDefaultParameter, "endIndex=", " < beginIndex=", beginIndex).toString());
            }
            StringBuilder m8299s = ye0.m8299s(resolveDefaultParameter, "endIndex=", " > length(");
            m8299s.append(size());
            m8299s.append(')');
            throw new IllegalArgumentException(m8299s.toString().toString());
        }
        throw new IllegalArgumentException(ye0.m8292l(beginIndex, "beginIndex=", " < 0").toString());
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString toAsciiLowercase() {
        return m6671a().toAsciiLowercase();
    }

    @Override // okio.ByteString
    @NotNull
    public ByteString toAsciiUppercase() {
        return m6671a().toAsciiUppercase();
    }

    @Override // okio.ByteString
    @NotNull
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = getDirectory()[length + i];
            int i5 = getDirectory()[i];
            int i6 = i5 - i2;
            ArraysKt___ArraysJvmKt.copyInto(getSegments()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    @Override // okio.ByteString
    @NotNull
    public String toString() {
        return m6671a().toString();
    }

    @Override // okio.ByteString
    public void write(@NotNull OutputStream out) {
        Intrinsics.checkNotNullParameter(out, "out");
        int length = getSegments().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = getDirectory()[length + i];
            int i4 = getDirectory()[i];
            out.write(getSegments()[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }

    @Override // okio.ByteString
    public void write$okio(@NotNull Buffer buffer, int offset, int byteCount) {
        int i;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i2 = offset + byteCount;
        int segment = _SegmentedByteStringKt.segment(this, offset);
        while (offset < i2) {
            if (segment == 0) {
                i = 0;
            } else {
                i = getDirectory()[segment - 1];
            }
            int i3 = getDirectory()[segment] - i;
            int i4 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i2, i3 + i) - offset;
            int i5 = (offset - i) + i4;
            Segment segment2 = new Segment(getSegments()[segment], i5, i5 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                Intrinsics.checkNotNull(segment3);
                Segment segment4 = segment3.prev;
                Intrinsics.checkNotNull(segment4);
                segment4.push(segment2);
            }
            offset += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + byteCount);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int offset, @NotNull byte[] other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (offset < 0 || offset > size() - byteCount || otherOffset < 0 || otherOffset > other.length - byteCount) {
            return false;
        }
        int i = byteCount + offset;
        int segment = _SegmentedByteStringKt.segment(this, offset);
        while (offset < i) {
            int i2 = segment == 0 ? 0 : getDirectory()[segment - 1];
            int i3 = getDirectory()[segment] - i2;
            int i4 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i, i3 + i2) - offset;
            if (!_UtilKt.arrayRangeEquals(getSegments()[segment], (offset - i2) + i4, other, otherOffset, min)) {
                return false;
            }
            otherOffset += min;
            offset += min;
            segment++;
        }
        return true;
    }
}
