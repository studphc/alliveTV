package kotlin.io.encoding;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;
import p000.AbstractC1326ip;
import p000.ye0;

@ExperimentalEncodingApi
@SinceKotlin(version = "1.8")
@Metadata(m5568d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0017\u0018\u0000 12\u00020\u0001:\u00011J)\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ;\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ?\u0010\u0013\u001a\u00028\u0000\"\f\b\u0000\u0010\u0012*\u00060\u0010j\u0002`\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\bJ;\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\fJ)\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00172\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0018J;\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0019J'\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001a\u0010\bJ7\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001c\u0010\fJ'\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001e\u0010\u0018J\u0017\u0010\"\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b \u0010!J'\u0010'\u001a\u00020$2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b%\u0010&R\u001a\u0010-\u001a\u00020(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001a\u00100\u001a\u00020(8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b.\u0010*\u001a\u0004\b/\u0010,¨\u00062"}, m5569d2 = {"Lkotlin/io/encoding/Base64;", "", "", FirebaseAnalytics.Param.SOURCE, "", "startIndex", "endIndex", "encodeToByteArray", "([BII)[B", FirebaseAnalytics.Param.DESTINATION, "destinationOffset", "encodeIntoByteArray", "([B[BIII)I", "", "encode", "([BII)Ljava/lang/String;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "encodeToAppendable", "([BLjava/lang/Appendable;II)Ljava/lang/Appendable;", "decode", "decodeIntoByteArray", "", "(Ljava/lang/CharSequence;II)[B", "(Ljava/lang/CharSequence;[BIII)I", "encodeToByteArrayImpl$kotlin_stdlib", "encodeToByteArrayImpl", "encodeIntoByteArrayImpl$kotlin_stdlib", "encodeIntoByteArrayImpl", "charsToBytesImpl$kotlin_stdlib", "charsToBytesImpl", "bytesToStringImpl$kotlin_stdlib", "([B)Ljava/lang/String;", "bytesToStringImpl", "sourceSize", "", "checkSourceBounds$kotlin_stdlib", "(III)V", "checkSourceBounds", "", "a", "Z", "isUrlSafe$kotlin_stdlib", "()Z", "isUrlSafe", "b", "isMimeScheme$kotlin_stdlib", "isMimeScheme", "Default", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public class Base64 {
    public static final int bytesPerGroup = 3;
    public static final int mimeLineLength = 76;
    public static final byte padSymbol = 61;
    public static final int symbolsPerGroup = 4;

    /* renamed from: a, reason: from kotlin metadata */
    public final boolean isUrlSafe;

    /* renamed from: b, reason: from kotlin metadata */
    public final boolean isMimeScheme;

    /* renamed from: Default, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c */
    public static final byte[] f21130c = {Ascii.f14455CR, 10};

    /* renamed from: d */
    public static final Base64 f21131d = new Base64(true, false);

    /* renamed from: e */
    public static final Base64 f21132e = new Base64(false, true);

    @Metadata(m5568d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\r8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u00148\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\r8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0017\u0010\u000f¨\u0006\u0018"}, m5569d2 = {"Lkotlin/io/encoding/Base64$Default;", "Lkotlin/io/encoding/Base64;", "", "mimeLineSeparatorSymbols", "[B", "getMimeLineSeparatorSymbols$kotlin_stdlib", "()[B", "UrlSafe", "Lkotlin/io/encoding/Base64;", "getUrlSafe", "()Lkotlin/io/encoding/Base64;", "Mime", "getMime", "", "bitsPerByte", "I", "bitsPerSymbol", "bytesPerGroup", "mimeGroupsPerLine", "mimeLineLength", "", "padSymbol", "B", "symbolsPerGroup", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* renamed from: kotlin.io.encoding.Base64$Default, reason: from kotlin metadata */
    /* loaded from: classes2.dex */
    public static final class Companion extends Base64 {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super(r2, r2, null);
            boolean z = false;
        }

        @NotNull
        public final Base64 getMime() {
            return Base64.f21132e;
        }

        @NotNull
        public final byte[] getMimeLineSeparatorSymbols$kotlin_stdlib() {
            return Base64.f21130c;
        }

        @NotNull
        public final Base64 getUrlSafe() {
            return Base64.f21131d;
        }
    }

    public /* synthetic */ Base64(boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2);
    }

    /* renamed from: a */
    public static void m5615a(int i, int i2, int i3) {
        if (i2 >= 0 && i2 <= i) {
            int i4 = i2 + i3;
            if (i4 >= 0 && i4 <= i) {
                return;
            }
            StringBuilder m8302v = ye0.m8302v("The destination array does not have enough capacity, destination offset: ", i2, ", destination size: ", i, ", capacity needed: ");
            m8302v.append(i3);
            throw new IndexOutOfBoundsException(m8302v.toString());
        }
        throw new IndexOutOfBoundsException(ye0.m8293m(i2, "destination offset: ", ", destination size: ", i));
    }

    public static /* synthetic */ byte[] decode$default(Base64 base64, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return base64.decode(bArr, i, i2);
    }

    public static /* synthetic */ int decodeIntoByteArray$default(Base64 base64, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
        }
        int i5 = (i4 & 4) != 0 ? 0 : i;
        int i6 = (i4 & 8) != 0 ? 0 : i2;
        if ((i4 & 16) != 0) {
            i3 = bArr.length;
        }
        return base64.decodeIntoByteArray(bArr, bArr2, i5, i6, i3);
    }

    public static /* synthetic */ String encode$default(Base64 base64, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return base64.encode(bArr, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
    }

    public static /* synthetic */ int encodeIntoByteArray$default(Base64 base64, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        int i5;
        int i6;
        if (obj == null) {
            if ((i4 & 4) != 0) {
                i5 = 0;
            } else {
                i5 = i;
            }
            if ((i4 & 8) != 0) {
                i6 = 0;
            } else {
                i6 = i2;
            }
            if ((i4 & 16) != 0) {
                i3 = bArr.length;
            }
            return base64.encodeIntoByteArray(bArr, bArr2, i5, i6, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeIntoByteArray");
    }

    public static /* synthetic */ Appendable encodeToAppendable$default(Base64 base64, byte[] bArr, Appendable appendable, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                i2 = bArr.length;
            }
            return base64.encodeToAppendable(bArr, appendable, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToAppendable");
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(Base64 base64, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return base64.encodeToByteArray(bArr, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToByteArray");
    }

    /* renamed from: b */
    public final int m5616b(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int[] access$getBase64DecodeMap$p;
        boolean z;
        int i4;
        int i5;
        if (this.isUrlSafe) {
            access$getBase64DecodeMap$p = Base64Kt.access$getBase64UrlDecodeMap$p();
        } else {
            access$getBase64DecodeMap$p = Base64Kt.access$getBase64DecodeMap$p();
        }
        int i6 = -8;
        int i7 = i;
        int i8 = -8;
        int i9 = 0;
        int i10 = i2;
        while (true) {
            z = this.isMimeScheme;
            if (i10 >= i3) {
                break;
            }
            if (i8 == i6 && (i5 = i10 + 3) < i3) {
                int i11 = access$getBase64DecodeMap$p[bArr[i10] & 255];
                int i12 = i10 + 4;
                int i13 = (access$getBase64DecodeMap$p[bArr[i10 + 2] & 255] << 6) | (access$getBase64DecodeMap$p[bArr[i10 + 1] & 255] << 12) | (i11 << 18) | access$getBase64DecodeMap$p[bArr[i5] & 255];
                if (i13 >= 0) {
                    bArr2[i7] = (byte) (i13 >> 16);
                    int i14 = i7 + 2;
                    bArr2[i7 + 1] = (byte) (i13 >> 8);
                    i7 += 3;
                    bArr2[i14] = (byte) i13;
                    i10 = i12;
                    i6 = -8;
                }
            }
            int i15 = bArr[i10] & 255;
            int i16 = access$getBase64DecodeMap$p[i15];
            if (i16 < 0) {
                if (i16 == -2) {
                    if (i8 != -8) {
                        if (i8 != -6) {
                            if (i8 != -4) {
                                if (i8 != -2) {
                                    throw new IllegalStateException("Unreachable");
                                }
                            } else {
                                int i17 = i10 + 1;
                                if (z) {
                                    while (i17 < i3) {
                                        if (Base64Kt.access$getBase64DecodeMap$p()[bArr[i17] & 255] != -1) {
                                            break;
                                        }
                                        i17++;
                                    }
                                }
                                if (i17 != i3 && bArr[i17] == 61) {
                                    i10 = i17 + 1;
                                } else {
                                    throw new IllegalArgumentException(ye0.m8291k(i17, "Missing one pad character at index "));
                                }
                            }
                        }
                        i10++;
                    } else {
                        throw new IllegalArgumentException(ye0.m8291k(i10, "Redundant pad character at index "));
                    }
                } else {
                    i4 = -8;
                    if (z) {
                        i10++;
                    } else {
                        StringBuilder sb = new StringBuilder("Invalid symbol '");
                        sb.append((char) i15);
                        sb.append("'(");
                        String num = Integer.toString(i15, AbstractC1326ip.checkRadix(8));
                        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
                        sb.append(num);
                        sb.append(") at index ");
                        sb.append(i10);
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            } else {
                i4 = -8;
                i10++;
                i9 = (i9 << 6) | i16;
                int i18 = i8 + 6;
                if (i18 >= 0) {
                    bArr2[i7] = (byte) (i9 >>> i18);
                    i9 &= (1 << i18) - 1;
                    i8 -= 2;
                    i7++;
                } else {
                    i8 = i18;
                }
            }
            i6 = i4;
        }
        if (i8 != -2) {
            if (z) {
                while (i10 < i3) {
                    if (Base64Kt.access$getBase64DecodeMap$p()[bArr[i10] & 255] != -1) {
                        break;
                    }
                    i10++;
                }
            }
            if (i10 >= i3) {
                return i7 - i;
            }
            int i19 = bArr[i10] & 255;
            StringBuilder sb2 = new StringBuilder("Symbol '");
            sb2.append((char) i19);
            sb2.append("'(");
            String num2 = Integer.toString(i19, AbstractC1326ip.checkRadix(8));
            Intrinsics.checkNotNullExpressionValue(num2, "toString(this, checkRadix(radix))");
            sb2.append(num2);
            sb2.append(") at index ");
            throw new IllegalArgumentException(ye0.m8298r(sb2, " is prohibited after the pad character", i10 - 1));
        }
        throw new IllegalArgumentException("The last unit of input does not have enough bits");
    }

    @NotNull
    public final String bytesToStringImpl$kotlin_stdlib(@NotNull byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        StringBuilder sb = new StringBuilder(source.length);
        for (byte b : source) {
            sb.append((char) b);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
        return sb2;
    }

    /* renamed from: c */
    public final int m5617c(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        if (i3 == 0) {
            return 0;
        }
        if (i3 != 1) {
            if (this.isMimeScheme) {
                while (true) {
                    if (i >= i2) {
                        break;
                    }
                    int i4 = Base64Kt.access$getBase64DecodeMap$p()[bArr[i] & 255];
                    if (i4 < 0) {
                        if (i4 == -2) {
                            i3 -= i2 - i;
                            break;
                        }
                        i3--;
                    }
                    i++;
                }
            } else if (bArr[i2 - 1] == 61) {
                int i5 = i3 - 1;
                if (bArr[i2 - 2] == 61) {
                    i3 -= 2;
                } else {
                    i3 = i5;
                }
            }
            return (int) ((i3 * 6) / 8);
        }
        throw new IllegalArgumentException(ye0.m8293m(i, "Input should have at list 2 symbols for Base64 decoding, startIndex: ", ", endIndex: ", i2));
    }

    @NotNull
    public final byte[] charsToBytesImpl$kotlin_stdlib(@NotNull CharSequence source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        checkSourceBounds$kotlin_stdlib(source.length(), startIndex, endIndex);
        byte[] bArr = new byte[endIndex - startIndex];
        int i = 0;
        while (startIndex < endIndex) {
            char charAt = source.charAt(startIndex);
            if (charAt <= 255) {
                bArr[i] = (byte) charAt;
                i++;
            } else {
                bArr[i] = Utf8.REPLACEMENT_BYTE;
                i++;
            }
            startIndex++;
        }
        return bArr;
    }

    public final void checkSourceBounds$kotlin_stdlib(int sourceSize, int startIndex, int endIndex) {
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(startIndex, endIndex, sourceSize);
    }

    /* renamed from: d */
    public final int m5618d(int i) {
        int i2;
        int i3 = (i + 2) / 3;
        if (this.isMimeScheme) {
            i2 = (i3 - 1) / 19;
        } else {
            i2 = 0;
        }
        int i4 = (i2 * 2) + (i3 * 4);
        if (i4 >= 0) {
            return i4;
        }
        throw new IllegalArgumentException("Input is too big");
    }

    @NotNull
    public final byte[] decode(@NotNull byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        checkSourceBounds$kotlin_stdlib(source.length, startIndex, endIndex);
        int m5617c = m5617c(source, startIndex, endIndex);
        byte[] bArr = new byte[m5617c];
        if (m5616b(source, 0, startIndex, bArr, endIndex) == m5617c) {
            return bArr;
        }
        throw new IllegalStateException("Check failed.");
    }

    public final int decodeIntoByteArray(@NotNull byte[] source, @NotNull byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        checkSourceBounds$kotlin_stdlib(source.length, startIndex, endIndex);
        m5615a(destination.length, destinationOffset, m5617c(source, startIndex, endIndex));
        return m5616b(source, destinationOffset, startIndex, destination, endIndex);
    }

    @NotNull
    public final String encode(@NotNull byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new String(encodeToByteArrayImpl$kotlin_stdlib(source, startIndex, endIndex), Charsets.ISO_8859_1);
    }

    public final int encodeIntoByteArray(@NotNull byte[] source, @NotNull byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        return encodeIntoByteArrayImpl$kotlin_stdlib(source, destination, destinationOffset, startIndex, endIndex);
    }

    public final int encodeIntoByteArrayImpl$kotlin_stdlib(@NotNull byte[] source, @NotNull byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        byte[] access$getBase64EncodeMap$p;
        int i;
        int i2;
        int i3 = startIndex;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        checkSourceBounds$kotlin_stdlib(source.length, i3, endIndex);
        m5615a(destination.length, destinationOffset, m5618d(endIndex - i3));
        if (this.isUrlSafe) {
            access$getBase64EncodeMap$p = Base64Kt.access$getBase64UrlEncodeMap$p();
        } else {
            access$getBase64EncodeMap$p = Base64Kt.access$getBase64EncodeMap$p();
        }
        if (this.isMimeScheme) {
            i = 19;
        } else {
            i = Integer.MAX_VALUE;
        }
        int i4 = destinationOffset;
        while (true) {
            i2 = i3 + 2;
            if (i2 >= endIndex) {
                break;
            }
            int min = Math.min((endIndex - i3) / 3, i);
            for (int i5 = 0; i5 < min; i5++) {
                int i6 = source[i3] & 255;
                int i7 = i3 + 2;
                int i8 = source[i3 + 1] & 255;
                i3 += 3;
                int i9 = (i8 << 8) | (i6 << 16) | (source[i7] & 255);
                destination[i4] = access$getBase64EncodeMap$p[i9 >>> 18];
                destination[i4 + 1] = access$getBase64EncodeMap$p[(i9 >>> 12) & 63];
                int i10 = i4 + 3;
                destination[i4 + 2] = access$getBase64EncodeMap$p[(i9 >>> 6) & 63];
                i4 += 4;
                destination[i10] = access$getBase64EncodeMap$p[i9 & 63];
            }
            if (min == i && i3 != endIndex) {
                int i11 = i4 + 1;
                byte[] bArr = f21130c;
                destination[i4] = bArr[0];
                i4 += 2;
                destination[i11] = bArr[1];
            }
        }
        int i12 = endIndex - i3;
        if (i12 != 1) {
            if (i12 == 2) {
                int i13 = ((source[i3 + 1] & 255) << 2) | ((source[i3] & 255) << 10);
                destination[i4] = access$getBase64EncodeMap$p[i13 >>> 12];
                destination[i4 + 1] = access$getBase64EncodeMap$p[(i13 >>> 6) & 63];
                int i14 = i4 + 3;
                destination[i4 + 2] = access$getBase64EncodeMap$p[i13 & 63];
                i4 += 4;
                destination[i14] = padSymbol;
                i3 = i2;
            }
        } else {
            int i15 = (source[i3] & 255) << 4;
            destination[i4] = access$getBase64EncodeMap$p[i15 >>> 6];
            destination[i4 + 1] = access$getBase64EncodeMap$p[i15 & 63];
            int i16 = i4 + 3;
            destination[i4 + 2] = padSymbol;
            i4 += 4;
            destination[i16] = padSymbol;
            i3++;
        }
        if (i3 == endIndex) {
            return i4 - destinationOffset;
        }
        throw new IllegalStateException("Check failed.");
    }

    @NotNull
    public final <A extends Appendable> A encodeToAppendable(@NotNull byte[] source, @NotNull A destination, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        destination.append(new String(encodeToByteArrayImpl$kotlin_stdlib(source, startIndex, endIndex), Charsets.ISO_8859_1));
        return destination;
    }

    @NotNull
    public final byte[] encodeToByteArray(@NotNull byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        return encodeToByteArrayImpl$kotlin_stdlib(source, startIndex, endIndex);
    }

    @NotNull
    public final byte[] encodeToByteArrayImpl$kotlin_stdlib(@NotNull byte[] source, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter(source, "source");
        checkSourceBounds$kotlin_stdlib(source.length, startIndex, endIndex);
        byte[] bArr = new byte[m5618d(endIndex - startIndex)];
        encodeIntoByteArrayImpl$kotlin_stdlib(source, bArr, 0, startIndex, endIndex);
        return bArr;
    }

    /* renamed from: isMimeScheme$kotlin_stdlib, reason: from getter */
    public final boolean getIsMimeScheme() {
        return this.isMimeScheme;
    }

    /* renamed from: isUrlSafe$kotlin_stdlib, reason: from getter */
    public final boolean getIsUrlSafe() {
        return this.isUrlSafe;
    }

    public Base64(boolean z, boolean z2) {
        this.isUrlSafe = z;
        this.isMimeScheme = z2;
        if (z && z2) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    public static /* synthetic */ byte[] decode$default(Base64 base64, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return base64.decode(charSequence, i, i2);
    }

    public static /* synthetic */ int decodeIntoByteArray$default(Base64 base64, CharSequence charSequence, byte[] bArr, int i, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
        }
        int i5 = (i4 & 4) != 0 ? 0 : i;
        int i6 = (i4 & 8) != 0 ? 0 : i2;
        if ((i4 & 16) != 0) {
            i3 = charSequence.length();
        }
        return base64.decodeIntoByteArray(charSequence, bArr, i5, i6, i3);
    }

    public final int decodeIntoByteArray(@NotNull CharSequence source, @NotNull byte[] destination, int destinationOffset, int startIndex, int endIndex) {
        byte[] charsToBytesImpl$kotlin_stdlib;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (source instanceof String) {
            checkSourceBounds$kotlin_stdlib(((String) source).length(), startIndex, endIndex);
            String substring = ((String) source).substring(startIndex, endIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            Charset charset = Charsets.ISO_8859_1;
            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
            charsToBytesImpl$kotlin_stdlib = substring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(charsToBytesImpl$kotlin_stdlib, "this as java.lang.String).getBytes(charset)");
        } else {
            charsToBytesImpl$kotlin_stdlib = charsToBytesImpl$kotlin_stdlib(source, startIndex, endIndex);
        }
        return decodeIntoByteArray$default(this, charsToBytesImpl$kotlin_stdlib, destination, destinationOffset, 0, 0, 24, (Object) null);
    }

    @NotNull
    public final byte[] decode(@NotNull CharSequence source, int startIndex, int endIndex) {
        byte[] charsToBytesImpl$kotlin_stdlib;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source instanceof String) {
            checkSourceBounds$kotlin_stdlib(((String) source).length(), startIndex, endIndex);
            String substring = ((String) source).substring(startIndex, endIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            Charset charset = Charsets.ISO_8859_1;
            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
            charsToBytesImpl$kotlin_stdlib = substring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(charsToBytesImpl$kotlin_stdlib, "this as java.lang.String).getBytes(charset)");
        } else {
            charsToBytesImpl$kotlin_stdlib = charsToBytesImpl$kotlin_stdlib(source, startIndex, endIndex);
        }
        return decode$default(this, charsToBytesImpl$kotlin_stdlib, 0, 0, 6, (Object) null);
    }
}
