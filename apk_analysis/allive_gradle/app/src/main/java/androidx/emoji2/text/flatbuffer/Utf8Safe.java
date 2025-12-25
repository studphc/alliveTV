package androidx.emoji2.text.flatbuffer;

import com.google.android.exoplayer2.extractor.p002ts.PsExtractor;
import java.nio.ByteBuffer;
import p000.yy2;
import p000.z03;

/* loaded from: classes.dex */
public final class Utf8Safe extends Utf8 {
    public static String decodeUtf8Array(byte[] bArr, int i, int i2) {
        boolean z;
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte b = bArr[i];
                if (!yy2.m8332A(b)) {
                    break;
                }
                i++;
                cArr[i4] = (char) b;
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte b2 = bArr[i];
                if (yy2.m8332A(b2)) {
                    int i7 = i5 + 1;
                    cArr[i5] = (char) b2;
                    while (i6 < i3) {
                        byte b3 = bArr[i6];
                        if (!yy2.m8332A(b3)) {
                            break;
                        }
                        i6++;
                        cArr[i7] = (char) b3;
                        i7++;
                    }
                    i5 = i7;
                    i = i6;
                } else {
                    if (b2 < -32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (i6 < i3) {
                            i += 2;
                            yy2.m8372y(b2, bArr[i6], cArr, i5);
                            i5++;
                        } else {
                            throw new IllegalArgumentException("Invalid UTF-8");
                        }
                    } else if (b2 < -16) {
                        if (i6 < i3 - 1) {
                            int i8 = i + 2;
                            i += 3;
                            yy2.m8371x(b2, bArr[i6], bArr[i8], cArr, i5);
                            i5++;
                        } else {
                            throw new IllegalArgumentException("Invalid UTF-8");
                        }
                    } else if (i6 < i3 - 2) {
                        byte b4 = bArr[i6];
                        int i9 = i + 3;
                        byte b5 = bArr[i + 2];
                        i += 4;
                        yy2.m8370w(b2, b4, b5, bArr[i9], cArr, i5);
                        i5 += 2;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    public static String decodeUtf8Buffer(ByteBuffer byteBuffer, int i, int i2) {
        boolean z;
        if ((i | i2 | ((byteBuffer.limit() - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte b = byteBuffer.get(i);
                if (!yy2.m8332A(b)) {
                    break;
                }
                i++;
                cArr[i4] = (char) b;
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte b2 = byteBuffer.get(i);
                if (yy2.m8332A(b2)) {
                    int i7 = i5 + 1;
                    cArr[i5] = (char) b2;
                    while (i6 < i3) {
                        byte b3 = byteBuffer.get(i6);
                        if (!yy2.m8332A(b3)) {
                            break;
                        }
                        i6++;
                        cArr[i7] = (char) b3;
                        i7++;
                    }
                    i5 = i7;
                    i = i6;
                } else {
                    if (b2 < -32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (i6 < i3) {
                            i += 2;
                            yy2.m8372y(b2, byteBuffer.get(i6), cArr, i5);
                            i5++;
                        } else {
                            throw new IllegalArgumentException("Invalid UTF-8");
                        }
                    } else if (b2 < -16) {
                        if (i6 < i3 - 1) {
                            int i8 = i + 2;
                            i += 3;
                            yy2.m8371x(b2, byteBuffer.get(i6), byteBuffer.get(i8), cArr, i5);
                            i5++;
                        } else {
                            throw new IllegalArgumentException("Invalid UTF-8");
                        }
                    } else if (i6 < i3 - 2) {
                        byte b4 = byteBuffer.get(i6);
                        int i9 = i + 3;
                        byte b5 = byteBuffer.get(i + 2);
                        i += 4;
                        yy2.m8370w(b2, b4, b5, byteBuffer.get(i9), cArr, i5);
                        i5 += 2;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer byteBuffer, int i, int i2) {
        if (byteBuffer.hasArray()) {
            return decodeUtf8Array(byteBuffer.array(), byteBuffer.arrayOffset() + i, i2);
        }
        return decodeUtf8Buffer(byteBuffer, i, i2);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int i2;
        char charAt;
        char c = 57343;
        char c2 = 2048;
        int i3 = 0;
        if (byteBuffer.hasArray()) {
            int arrayOffset = byteBuffer.arrayOffset();
            byte[] array = byteBuffer.array();
            int position = byteBuffer.position() + arrayOffset;
            int remaining = byteBuffer.remaining();
            int length = charSequence.length();
            int i4 = remaining + position;
            while (i3 < length) {
                int i5 = i3 + position;
                if (i5 >= i4 || (charAt = charSequence.charAt(i3)) >= 128) {
                    break;
                }
                array[i5] = (byte) charAt;
                i3++;
            }
            if (i3 == length) {
                i = position + length;
            } else {
                i = position + i3;
                while (i3 < length) {
                    char charAt2 = charSequence.charAt(i3);
                    if (charAt2 < 128 && i < i4) {
                        array[i] = (byte) charAt2;
                        i++;
                    } else if (charAt2 < c2 && i <= i4 - 2) {
                        int i6 = i + 1;
                        array[i] = (byte) ((charAt2 >>> 6) | 960);
                        i += 2;
                        array[i6] = (byte) ((charAt2 & '?') | 128);
                    } else if ((charAt2 < 55296 || c < charAt2) && i <= i4 - 3) {
                        array[i] = (byte) ((charAt2 >>> '\f') | 480);
                        int i7 = i + 2;
                        array[i + 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                        i += 3;
                        array[i7] = (byte) ((charAt2 & '?') | 128);
                    } else {
                        if (i <= i4 - 4) {
                            int i8 = i3 + 1;
                            if (i8 != charSequence.length()) {
                                char charAt3 = charSequence.charAt(i8);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    array[i] = (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK);
                                    array[i + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                    int i9 = i + 3;
                                    array[i + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                    i += 4;
                                    array[i9] = (byte) ((codePoint & 63) | 128);
                                    i3 = i8;
                                } else {
                                    i3 = i8;
                                }
                            }
                            throw new z03(i3 - 1, length);
                        }
                        if (55296 <= charAt2 && charAt2 <= 57343 && ((i2 = i3 + 1) == charSequence.length() || !Character.isSurrogatePair(charAt2, charSequence.charAt(i2)))) {
                            throw new z03(i3, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i);
                    }
                    i3++;
                    c = 57343;
                    c2 = 2048;
                }
            }
            byteBuffer.position(i - arrayOffset);
            return;
        }
        int length2 = charSequence.length();
        int position2 = byteBuffer.position();
        while (i3 < length2) {
            try {
                char charAt4 = charSequence.charAt(i3);
                if (charAt4 >= 128) {
                    break;
                }
                byteBuffer.put(position2 + i3, (byte) charAt4);
                i3++;
            } catch (IndexOutOfBoundsException unused) {
            }
        }
        if (i3 == length2) {
            byteBuffer.position(position2 + i3);
            return;
        }
        position2 += i3;
        while (i3 < length2) {
            char charAt5 = charSequence.charAt(i3);
            if (charAt5 < 128) {
                byteBuffer.put(position2, (byte) charAt5);
            } else {
                if (charAt5 < 2048) {
                    int i10 = position2 + 1;
                    try {
                        byteBuffer.put(position2, (byte) ((charAt5 >>> 6) | PsExtractor.AUDIO_STREAM));
                        byteBuffer.put(i10, (byte) ((charAt5 & '?') | 128));
                        position2 = i10;
                    } catch (IndexOutOfBoundsException unused2) {
                        position2 = i10;
                    }
                } else {
                    if (charAt5 >= 55296 && 57343 >= charAt5) {
                        int i11 = i3 + 1;
                        if (i11 != length2) {
                            try {
                                char charAt6 = charSequence.charAt(i11);
                                if (Character.isSurrogatePair(charAt5, charAt6)) {
                                    int codePoint2 = Character.toCodePoint(charAt5, charAt6);
                                    int i12 = position2 + 1;
                                    try {
                                        byteBuffer.put(position2, (byte) ((codePoint2 >>> 18) | PsExtractor.VIDEO_STREAM_MASK));
                                        int i13 = position2 + 2;
                                        try {
                                            byteBuffer.put(i12, (byte) (((codePoint2 >>> 12) & 63) | 128));
                                            position2 += 3;
                                            byteBuffer.put(i13, (byte) (((codePoint2 >>> 6) & 63) | 128));
                                            byteBuffer.put(position2, (byte) ((codePoint2 & 63) | 128));
                                            i3 = i11;
                                        } catch (IndexOutOfBoundsException unused3) {
                                            i3 = i11;
                                            position2 = i13;
                                        }
                                    } catch (IndexOutOfBoundsException unused4) {
                                        position2 = i12;
                                        i3 = i11;
                                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i3) + " at index " + (Math.max(i3, (position2 - byteBuffer.position()) + 1) + byteBuffer.position()));
                                    }
                                } else {
                                    i3 = i11;
                                }
                            } catch (IndexOutOfBoundsException unused5) {
                            }
                        }
                        throw new z03(i3, length2);
                    }
                    int i14 = position2 + 1;
                    try {
                        byteBuffer.put(position2, (byte) ((charAt5 >>> '\f') | 224));
                        position2 += 2;
                        byteBuffer.put(i14, (byte) (((charAt5 >>> 6) & 63) | 128));
                        byteBuffer.put(position2, (byte) ((charAt5 & '?') | 128));
                    } catch (IndexOutOfBoundsException unused6) {
                        position2 = i14;
                    }
                    i3++;
                    position2++;
                }
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i3) + " at index " + (Math.max(i3, (position2 - byteBuffer.position()) + 1) + byteBuffer.position()));
            }
            i3++;
            position2++;
        }
        byteBuffer.position(position2);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new z03(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i3 + 4294967296L));
    }
}
