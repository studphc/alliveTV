package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.upstream.DataSchemeDataSource;
import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio._Base64Kt;
import okio._JvmPlatformKt;
import okio._UtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ro2;

@Metadata(m5568d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0002\b\b\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0007\u0010\b\u001a\u0014\u0010\t\u001a\u00020\u0000*\u00020\u0000H\u0080\b¢\u0006\u0004\b\t\u0010\b\u001a$\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0080\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0011\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nH\u0080\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\n*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0014\u0010\u0016\u001a\u00020\u0015*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0015*\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0018\u0010\u0017\u001a4\u0010\u001e\u001a\u00020\u001d*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0080\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a4\u0010\u001e\u001a\u00020\u001d*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0080\b¢\u0006\u0004\b\u001e\u0010 \u001a4\u0010$\u001a\u00020#*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0080\b¢\u0006\u0004\b$\u0010%\u001a\u001c\u0010'\u001a\u00020\u001d*\u00020\u00002\u0006\u0010&\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b'\u0010(\u001a\u001c\u0010'\u001a\u00020\u001d*\u00020\u00002\u0006\u0010&\u001a\u00020\u0015H\u0080\b¢\u0006\u0004\b'\u0010)\u001a\u001c\u0010+\u001a\u00020\u001d*\u00020\u00002\u0006\u0010*\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b+\u0010(\u001a\u001c\u0010+\u001a\u00020\u001d*\u00020\u00002\u0006\u0010*\u001a\u00020\u0015H\u0080\b¢\u0006\u0004\b+\u0010)\u001a$\u0010-\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\nH\u0080\b¢\u0006\u0004\b-\u0010.\u001a$\u0010/\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\nH\u0080\b¢\u0006\u0004\b/\u00100\u001a$\u0010/\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\nH\u0080\b¢\u0006\u0004\b/\u0010.\u001a\u001e\u00102\u001a\u00020\u001d*\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u000101H\u0080\b¢\u0006\u0004\b2\u00103\u001a\u0014\u00104\u001a\u00020\n*\u00020\u0000H\u0080\b¢\u0006\u0004\b4\u0010\u0014\u001a\u001c\u00105\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b5\u00106\u001a\u0018\u00108\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u0015H\u0080\b¢\u0006\u0004\b8\u00109\u001a$\u0010:\u001a\u00020\u0000*\u00020\u00152\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0080\b¢\u0006\u0004\b:\u0010;\u001a\u0014\u0010<\u001a\u00020\u0000*\u00020\u0001H\u0080\b¢\u0006\u0004\b<\u0010=\u001a\u0016\u0010>\u001a\u0004\u0018\u00010\u0000*\u00020\u0001H\u0080\b¢\u0006\u0004\b>\u0010=\u001a\u0014\u0010?\u001a\u00020\u0000*\u00020\u0001H\u0080\b¢\u0006\u0004\b?\u0010=\u001a+\u0010B\u001a\u00020#*\u00020\u00002\u0006\u0010A\u001a\u00020@2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0000¢\u0006\u0004\bB\u0010C\u001a\u0014\u0010D\u001a\u00020\u0001*\u00020\u0000H\u0080\b¢\u0006\u0004\bD\u0010\u0003\" \u0010L\u001a\u00020E8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bF\u0010G\u0012\u0004\bJ\u0010K\u001a\u0004\bH\u0010I¨\u0006M"}, m5569d2 = {"Lokio/ByteString;", "", "commonUtf8", "(Lokio/ByteString;)Ljava/lang/String;", "commonBase64", "commonBase64Url", "commonHex", "commonToAsciiLowercase", "(Lokio/ByteString;)Lokio/ByteString;", "commonToAsciiUppercase", "", "beginIndex", "endIndex", "commonSubstring", "(Lokio/ByteString;II)Lokio/ByteString;", "pos", "", "commonGetByte", "(Lokio/ByteString;I)B", "commonGetSize", "(Lokio/ByteString;)I", "", "commonToByteArray", "(Lokio/ByteString;)[B", "commonInternalArray", TypedValues.CycleType.S_WAVE_OFFSET, "other", "otherOffset", "byteCount", "", "commonRangeEquals", "(Lokio/ByteString;ILokio/ByteString;II)Z", "(Lokio/ByteString;I[BII)Z", TypedValues.AttributesType.S_TARGET, "targetOffset", "", "commonCopyInto", "(Lokio/ByteString;I[BII)V", "prefix", "commonStartsWith", "(Lokio/ByteString;Lokio/ByteString;)Z", "(Lokio/ByteString;[B)Z", "suffix", "commonEndsWith", "fromIndex", "commonIndexOf", "(Lokio/ByteString;[BI)I", "commonLastIndexOf", "(Lokio/ByteString;Lokio/ByteString;I)I", "", "commonEquals", "(Lokio/ByteString;Ljava/lang/Object;)Z", "commonHashCode", "commonCompareTo", "(Lokio/ByteString;Lokio/ByteString;)I", DataSchemeDataSource.SCHEME_DATA, "commonOf", "([B)Lokio/ByteString;", "commonToByteString", "([BII)Lokio/ByteString;", "commonEncodeUtf8", "(Ljava/lang/String;)Lokio/ByteString;", "commonDecodeBase64", "commonDecodeHex", "Lokio/Buffer;", "buffer", "commonWrite", "(Lokio/ByteString;Lokio/Buffer;II)V", "commonToString", "", "a", "[C", "getHEX_DIGIT_CHARS", "()[C", "getHEX_DIGIT_CHARS$annotations", "()V", "HEX_DIGIT_CHARS", "okio"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class _ByteStringKt {

    /* renamed from: a */
    public static final char[] f24793a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final int access$codePointIndexToCharIndex(byte[] bArr, int i) {
        int i2;
        byte b;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int length = bArr.length;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        loop0: while (i8 < length) {
            byte b2 = bArr[i8];
            if (b2 >= 0) {
                int i11 = i10 + 1;
                if (i10 != i) {
                    if ((b2 == 10 || b2 == 13 || ((b2 < 0 || b2 >= 32) && (Byte.MAX_VALUE > b2 || b2 >= 160))) && b2 != 65533) {
                        if (b2 < 65536) {
                            i2 = 1;
                        } else {
                            i2 = 2;
                        }
                        i9 += i2;
                        i8++;
                        while (true) {
                            i10 = i11;
                            if (i8 < length && (b = bArr[i8]) >= 0) {
                                i8++;
                                i11 = i10 + 1;
                                if (i10 != i) {
                                    if ((b != 10 && b != 13 && ((b >= 0 && b < 32) || (Byte.MAX_VALUE <= b && b < 160))) || b == 65533) {
                                        break loop0;
                                    }
                                    if (b < 65536) {
                                        i3 = 1;
                                    } else {
                                        i3 = 2;
                                    }
                                    i9 += i3;
                                } else {
                                    return i9;
                                }
                            }
                        }
                    }
                    return -1;
                }
                return i9;
            }
            if ((b2 >> 5) == -2) {
                int i12 = i8 + 1;
                if (length <= i12) {
                    if (i10 == i) {
                        return i9;
                    }
                } else {
                    byte b3 = bArr[i12];
                    if ((b3 & 192) == 128) {
                        int i13 = (b2 << 6) ^ (b3 ^ 3968);
                        if (i13 < 128) {
                            if (i10 == i) {
                                return i9;
                            }
                        } else {
                            i4 = i10 + 1;
                            if (i10 != i) {
                                if ((i13 == 10 || i13 == 13 || ((i13 < 0 || i13 >= 32) && (127 > i13 || i13 >= 160))) && i13 != 65533) {
                                    if (i13 < 65536) {
                                        i7 = 1;
                                    } else {
                                        i7 = 2;
                                    }
                                    i9 += i7;
                                    i8 += 2;
                                    i10 = i4;
                                }
                            } else {
                                return i9;
                            }
                        }
                    } else if (i10 == i) {
                        return i9;
                    }
                }
                return -1;
            }
            if ((b2 >> 4) == -2) {
                int i14 = i8 + 2;
                if (length <= i14) {
                    if (i10 == i) {
                        return i9;
                    }
                } else {
                    byte b4 = bArr[i8 + 1];
                    if ((b4 & 192) == 128) {
                        byte b5 = bArr[i14];
                        if ((b5 & 192) == 128) {
                            int i15 = (b2 << Ascii.f14457FF) ^ ((b5 ^ (-123008)) ^ (b4 << 6));
                            if (i15 < 2048) {
                                if (i10 == i) {
                                    return i9;
                                }
                            } else if (55296 <= i15 && i15 < 57344) {
                                if (i10 == i) {
                                    return i9;
                                }
                            } else {
                                i4 = i10 + 1;
                                if (i10 != i) {
                                    if ((i15 == 10 || i15 == 13 || ((i15 < 0 || i15 >= 32) && (127 > i15 || i15 >= 160))) && i15 != 65533) {
                                        if (i15 < 65536) {
                                            i6 = 1;
                                        } else {
                                            i6 = 2;
                                        }
                                        i9 += i6;
                                        i8 += 3;
                                        i10 = i4;
                                    }
                                } else {
                                    return i9;
                                }
                            }
                        } else if (i10 == i) {
                            return i9;
                        }
                    } else if (i10 == i) {
                        return i9;
                    }
                }
                return -1;
            }
            if ((b2 >> 3) == -2) {
                int i16 = i8 + 3;
                if (length <= i16) {
                    if (i10 == i) {
                        return i9;
                    }
                } else {
                    byte b6 = bArr[i8 + 1];
                    if ((b6 & 192) == 128) {
                        byte b7 = bArr[i8 + 2];
                        if ((b7 & 192) == 128) {
                            byte b8 = bArr[i16];
                            if ((b8 & 192) == 128) {
                                int i17 = (b2 << Ascii.DC2) ^ (((b8 ^ 3678080) ^ (b7 << 6)) ^ (b6 << Ascii.f14457FF));
                                if (i17 > 1114111) {
                                    if (i10 == i) {
                                        return i9;
                                    }
                                } else if (55296 <= i17 && i17 < 57344) {
                                    if (i10 == i) {
                                        return i9;
                                    }
                                } else if (i17 < 65536) {
                                    if (i10 == i) {
                                        return i9;
                                    }
                                } else {
                                    i4 = i10 + 1;
                                    if (i10 != i) {
                                        if ((i17 == 10 || i17 == 13 || ((i17 < 0 || i17 >= 32) && (127 > i17 || i17 >= 160))) && i17 != 65533) {
                                            if (i17 < 65536) {
                                                i5 = 1;
                                            } else {
                                                i5 = 2;
                                            }
                                            i9 += i5;
                                            i8 += 4;
                                            i10 = i4;
                                        }
                                    } else {
                                        return i9;
                                    }
                                }
                            } else if (i10 == i) {
                                return i9;
                            }
                        } else if (i10 == i) {
                            return i9;
                        }
                    } else if (i10 == i) {
                        return i9;
                    }
                }
            } else if (i10 == i) {
                return i9;
            }
            return -1;
        }
        return i9;
    }

    public static final int access$decodeHexDigit(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('a' <= c && c < 'g') {
            return c - 'W';
        }
        if ('A' <= c && c < 'G') {
            return c - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    @NotNull
    public static final String commonBase64(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return _Base64Kt.encodeBase64$default(byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String(), null, 1, null);
    }

    @NotNull
    public static final String commonBase64Url(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return _Base64Kt.encodeBase64(byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String(), _Base64Kt.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(@NotNull ByteString byteString, @NotNull ByteString other) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int size = byteString.size();
        int size2 = other.size();
        int min = Math.min(size, size2);
        for (int i = 0; i < min; i++) {
            int i2 = byteString.getByte(i) & 255;
            int i3 = other.getByte(i) & 255;
            if (i2 != i3) {
                if (i2 < i3) {
                    return -1;
                }
                return 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        if (size < size2) {
            return -1;
        }
        return 1;
    }

    public static final void commonCopyInto(@NotNull ByteString byteString, int i, @NotNull byte[] target, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        ArraysKt___ArraysJvmKt.copyInto(byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String(), target, i2, i, i3 + i);
    }

    @Nullable
    public static final ByteString commonDecodeBase64(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] decodeBase64ToArray = _Base64Kt.decodeBase64ToArray(str);
        if (decodeBase64ToArray != null) {
            return new ByteString(decodeBase64ToArray);
        }
        return null;
    }

    @NotNull
    public static final ByteString commonDecodeHex(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (access$decodeHexDigit(str.charAt(i2 + 1)) + (access$decodeHexDigit(str.charAt(i2)) << 4));
            }
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
    }

    @NotNull
    public static final ByteString commonEncodeUtf8(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final boolean commonEndsWith(@NotNull ByteString byteString, @NotNull ByteString suffix) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return byteString.rangeEquals(byteString.size() - suffix.size(), suffix, 0, suffix.size());
    }

    public static final boolean commonEquals(@NotNull ByteString byteString, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString2 = (ByteString) obj;
            if (byteString2.size() == byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String().length && byteString2.rangeEquals(0, byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String(), 0, byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(@NotNull ByteString byteString, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String()[i];
    }

    public static final int commonGetSize(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String().length;
    }

    public static final int commonHashCode(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int hashCode = byteString.getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int hashCode2 = Arrays.hashCode(byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String());
        byteString.setHashCode$okio(hashCode2);
        return hashCode2;
    }

    @NotNull
    public static final String commonHex(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        char[] cArr = new char[byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String().length * 2];
        int i = 0;
        for (byte b : byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String()) {
            int i2 = i + 1;
            cArr[i] = getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            i += 2;
            cArr[i2] = getHEX_DIGIT_CHARS()[b & Ascii.f14464SI];
        }
        return ro2.concatToString(cArr);
    }

    public static final int commonIndexOf(@NotNull ByteString byteString, @NotNull byte[] other, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String().length - other.length;
        int max = Math.max(i, 0);
        if (max <= length) {
            while (!_UtilKt.arrayRangeEquals(byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String(), max, other, 0, other.length)) {
                if (max != length) {
                    max++;
                } else {
                    return -1;
                }
            }
            return max;
        }
        return -1;
    }

    @NotNull
    public static final byte[] commonInternalArray(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String();
    }

    public static final int commonLastIndexOf(@NotNull ByteString byteString, @NotNull ByteString other, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return byteString.lastIndexOf(other.internalArray$okio(), i);
    }

    @NotNull
    public static final ByteString commonOf(@NotNull byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        byte[] copyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final boolean commonRangeEquals(@NotNull ByteString byteString, int i, @NotNull ByteString other, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return other.rangeEquals(i2, byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String(), i, i3);
    }

    public static final boolean commonStartsWith(@NotNull ByteString byteString, @NotNull ByteString prefix) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return byteString.rangeEquals(0, prefix, 0, prefix.size());
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(byteString, i2);
        if (i >= 0) {
            if (resolveDefaultParameter <= byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String().length) {
                if (resolveDefaultParameter - i >= 0) {
                    if (i == 0 && resolveDefaultParameter == byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String().length) {
                        return byteString;
                    }
                    return new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String(), i, resolveDefaultParameter));
                }
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            throw new IllegalArgumentException(("endIndex > length(" + byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String().length + ')').toString());
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    @NotNull
    public static final ByteString commonToAsciiLowercase(@NotNull ByteString byteString) {
        byte b;
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        for (int i = 0; i < byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String().length; i++) {
            byte b2 = byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String()[i];
            byte b3 = (byte) 65;
            if (b2 >= b3 && b2 <= (b = (byte) 90)) {
                byte[] bArr = byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String();
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                copyOf[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b4 = copyOf[i2];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i2] = (byte) (b4 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    @NotNull
    public static final ByteString commonToAsciiUppercase(@NotNull ByteString byteString) {
        byte b;
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        for (int i = 0; i < byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String().length; i++) {
            byte b2 = byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String()[i];
            byte b3 = (byte) 97;
            if (b2 >= b3 && b2 <= (b = (byte) 122)) {
                byte[] bArr = byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String();
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                copyOf[i] = (byte) (b2 - 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b4 = copyOf[i2];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i2] = (byte) (b4 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        byte[] bArr = byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String();
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public static final ByteString commonToByteString(@NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(bArr, i2);
        _UtilKt.checkOffsetAndCount(bArr.length, i, resolveDefaultParameter);
        return new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(bArr, i, resolveDefaultParameter + i));
    }

    @NotNull
    public static final String commonToString(@NotNull ByteString byteString) {
        ByteString byteString2 = byteString;
        Intrinsics.checkNotNullParameter(byteString2, "<this>");
        if (byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String().length == 0) {
            return "[size=0]";
        }
        int access$codePointIndexToCharIndex = access$codePointIndexToCharIndex(byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String(), 64);
        if (access$codePointIndexToCharIndex == -1) {
            if (byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String().length <= 64) {
                return "[hex=" + byteString.hex() + ']';
            }
            StringBuilder sb = new StringBuilder("[size=");
            sb.append(byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String().length);
            sb.append(" hex=");
            int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(byteString2, 64);
            if (resolveDefaultParameter <= byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String().length) {
                if (resolveDefaultParameter >= 0) {
                    if (resolveDefaultParameter != byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String().length) {
                        byteString2 = new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String(), 0, resolveDefaultParameter));
                    }
                    sb.append(byteString2.hex());
                    sb.append("…]");
                    return sb.toString();
                }
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            throw new IllegalArgumentException(("endIndex > length(" + byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String().length + ')').toString());
        }
        String utf8 = byteString.utf8();
        String substring = utf8.substring(0, access$codePointIndexToCharIndex);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        String replace$default = ro2.replace$default(ro2.replace$default(ro2.replace$default(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
        if (access$codePointIndexToCharIndex < utf8.length()) {
            return "[size=" + byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String().length + " text=" + replace$default + "…]";
        }
        return "[text=" + replace$default + ']';
    }

    @NotNull
    public static final String commonUtf8(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        String utf8 = byteString.getUtf8();
        if (utf8 == null) {
            String utf8String = _JvmPlatformKt.toUtf8String(byteString.internalArray$okio());
            byteString.setUtf8$okio(utf8String);
            return utf8String;
        }
        return utf8;
    }

    public static final void commonWrite(@NotNull ByteString byteString, @NotNull Buffer buffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.write(byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String(), i, i2);
    }

    @NotNull
    public static final char[] getHEX_DIGIT_CHARS() {
        return f24793a;
    }

    public static /* synthetic */ void getHEX_DIGIT_CHARS$annotations() {
    }

    public static final boolean commonEndsWith(@NotNull ByteString byteString, @NotNull byte[] suffix) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return byteString.rangeEquals(byteString.size() - suffix.length, suffix, 0, suffix.length);
    }

    public static final int commonLastIndexOf(@NotNull ByteString byteString, @NotNull byte[] other, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        for (int min = Math.min(_UtilKt.resolveDefaultParameter(byteString, i), byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String().length - other.length); -1 < min; min--) {
            if (_UtilKt.arrayRangeEquals(byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String(), min, other, 0, other.length)) {
                return min;
            }
        }
        return -1;
    }

    public static final boolean commonRangeEquals(@NotNull ByteString byteString, int i, @NotNull byte[] other, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return i >= 0 && i <= byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String().length - i3 && i2 >= 0 && i2 <= other.length - i3 && _UtilKt.arrayRangeEquals(byteString.getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String(), i, other, i2, i3);
    }

    public static final boolean commonStartsWith(@NotNull ByteString byteString, @NotNull byte[] prefix) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return byteString.rangeEquals(0, prefix, 0, prefix.length);
    }
}
