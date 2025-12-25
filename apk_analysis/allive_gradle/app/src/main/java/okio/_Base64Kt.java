package okio;

import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0011\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u0000*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\" \u0010\r\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\" \u0010\u0011\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\b\u0012\u0004\b\u0010\u0010\f\u001a\u0004\b\u000f\u0010\n¨\u0006\u0012"}, m5569d2 = {"", "", "decodeBase64ToArray", "(Ljava/lang/String;)[B", "map", "encodeBase64", "([B[B)Ljava/lang/String;", "a", "[B", "getBASE64", "()[B", "getBASE64$annotations", "()V", "BASE64", "b", "getBASE64_URL_SAFE", "getBASE64_URL_SAFE$annotations", "BASE64_URL_SAFE", "okio"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class _Base64Kt {

    /* renamed from: a */
    public static final byte[] f24772a;

    /* renamed from: b */
    public static final byte[] f24773b;

    static {
        ByteString.Companion companion = ByteString.Companion;
        f24772a = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        f24773b = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    @Nullable
    public static final byte[] decodeBase64ToArray(@NotNull String str) {
        int i;
        char charAt;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        while (length > 0 && ((charAt = str.charAt(length - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
            length--;
        }
        int i2 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char charAt2 = str.charAt(i6);
            if ('A' <= charAt2 && charAt2 < '[') {
                i = charAt2 - 'A';
            } else if ('a' <= charAt2 && charAt2 < '{') {
                i = charAt2 - 'G';
            } else if ('0' <= charAt2 && charAt2 < ':') {
                i = charAt2 + 4;
            } else if (charAt2 != '+' && charAt2 != '-') {
                if (charAt2 != '/' && charAt2 != '_') {
                    if (charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ' && charAt2 != '\t') {
                        return null;
                    }
                } else {
                    i = 63;
                }
            } else {
                i = 62;
            }
            i4 = (i4 << 6) | i;
            i3++;
            if (i3 % 4 == 0) {
                bArr[i5] = (byte) (i4 >> 16);
                int i7 = i5 + 2;
                bArr[i5 + 1] = (byte) (i4 >> 8);
                i5 += 3;
                bArr[i7] = (byte) i4;
            }
        }
        int i8 = i3 % 4;
        if (i8 == 1) {
            return null;
        }
        if (i8 != 2) {
            if (i8 == 3) {
                int i9 = i4 << 6;
                int i10 = i5 + 1;
                bArr[i5] = (byte) (i9 >> 16);
                i5 += 2;
                bArr[i10] = (byte) (i9 >> 8);
            }
        } else {
            bArr[i5] = (byte) ((i4 << 12) >> 16);
            i5++;
        }
        if (i5 == i2) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, i5);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    @NotNull
    public static final String encodeBase64(@NotNull byte[] bArr, @NotNull byte[] map) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i + 2;
            byte b2 = bArr[i + 1];
            i += 3;
            byte b3 = bArr[i3];
            bArr2[i2] = map[(b & 255) >> 2];
            bArr2[i2 + 1] = map[((b & 3) << 4) | ((b2 & 255) >> 4)];
            int i4 = i2 + 3;
            bArr2[i2 + 2] = map[((b2 & Ascii.f14464SI) << 2) | ((b3 & 255) >> 6)];
            i2 += 4;
            bArr2[i4] = map[b3 & Utf8.REPLACEMENT_BYTE];
        }
        int length2 = bArr.length - length;
        if (length2 != 1) {
            if (length2 == 2) {
                int i5 = i + 1;
                byte b4 = bArr[i];
                byte b5 = bArr[i5];
                bArr2[i2] = map[(b4 & 255) >> 2];
                bArr2[i2 + 1] = map[((b4 & 3) << 4) | ((b5 & 255) >> 4)];
                bArr2[i2 + 2] = map[(b5 & Ascii.f14464SI) << 2];
                bArr2[i2 + 3] = (byte) 61;
            }
        } else {
            byte b6 = bArr[i];
            bArr2[i2] = map[(b6 & 255) >> 2];
            bArr2[i2 + 1] = map[(b6 & 3) << 4];
            byte b7 = (byte) 61;
            bArr2[i2 + 2] = b7;
            bArr2[i2 + 3] = b7;
        }
        return _JvmPlatformKt.toUtf8String(bArr2);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr2 = f24772a;
        }
        return encodeBase64(bArr, bArr2);
    }

    @NotNull
    public static final byte[] getBASE64() {
        return f24772a;
    }

    public static /* synthetic */ void getBASE64$annotations() {
    }

    @NotNull
    public static final byte[] getBASE64_URL_SAFE() {
        return f24773b;
    }

    public static /* synthetic */ void getBASE64_URL_SAFE$annotations() {
    }
}
