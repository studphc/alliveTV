package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import p000.AbstractC1726qj;
import p000.ro2;

@Metadata(m5568d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001J5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0014\u0010 \u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u0019R\u0014\u0010!\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u0019R\u0014\u0010\"\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\u0019R\u0014\u0010#\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\u0019R\u0014\u0010$\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\u0019R\u0014\u0010%\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\u0019R\u0014\u0010&\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010\u0019R\u0014\u0010'\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010\u0019R\u0014\u0010(\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010\u0019R\u0014\u0010)\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010\u0019R\u0014\u0010*\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010\u0019R\u0014\u0010+\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010\u0019¨\u0006,"}, m5569d2 = {"Lokhttp3/internal/http2/Http2;", "", "", "inbound", "", "streamId", "length", "type", "flags", "", "frameLog", "(ZIIII)Ljava/lang/String;", "", "windowSizeIncrement", "frameLogWindowUpdate", "(ZIIJ)Ljava/lang/String;", "formattedType$okhttp", "(I)Ljava/lang/String;", "formattedType", "formatFlags", "(II)Ljava/lang/String;", "Lokio/ByteString;", "CONNECTION_PREFACE", "Lokio/ByteString;", "INITIAL_MAX_FRAME_SIZE", "I", "TYPE_DATA", "TYPE_HEADERS", "TYPE_PRIORITY", "TYPE_RST_STREAM", "TYPE_SETTINGS", "TYPE_PUSH_PROMISE", "TYPE_PING", "TYPE_GOAWAY", "TYPE_WINDOW_UPDATE", "TYPE_CONTINUATION", "FLAG_NONE", "FLAG_ACK", "FLAG_END_STREAM", "FLAG_END_HEADERS", "FLAG_END_PUSH_PROMISE", "FLAG_PADDED", "FLAG_PRIORITY", "FLAG_COMPRESSED", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Http2 {
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;

    /* renamed from: c */
    public static final String[] f24429c;

    @NotNull
    public static final Http2 INSTANCE = new Object();

    @JvmField
    @NotNull
    public static final ByteString CONNECTION_PREFACE = ByteString.INSTANCE.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: a */
    public static final String[] f24427a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: b */
    public static final String[] f24428b = new String[64];

    /* JADX WARN: Type inference failed for: r3v0, types: [okhttp3.internal.http2.Http2, java.lang.Object] */
    static {
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            Intrinsics.checkNotNullExpressionValue(binaryString, "toBinaryString(it)");
            strArr[i] = ro2.replace$default(_UtilJvmKt.format("%8s", binaryString), ' ', '0', false, 4, (Object) null);
        }
        f24429c = strArr;
        String[] strArr2 = f24428b;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i2 = iArr[0];
        strArr2[i2 | 8] = AbstractC1726qj.m7061q(new StringBuilder(), strArr2[i2], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = iArr2[i3];
            int i5 = iArr[0];
            String[] strArr3 = f24428b;
            int i6 = i5 | i4;
            strArr3[i6] = strArr3[i5] + '|' + strArr3[i4];
            StringBuilder sb = new StringBuilder();
            sb.append(strArr3[i5]);
            sb.append('|');
            strArr3[i6 | 8] = AbstractC1726qj.m7061q(sb, strArr3[i4], "|PADDED");
        }
        int length = f24428b.length;
        for (int i7 = 0; i7 < length; i7++) {
            String[] strArr4 = f24428b;
            if (strArr4[i7] == null) {
                strArr4[i7] = f24429c[i7];
            }
        }
    }

    @NotNull
    public final String formatFlags(int type, int flags) {
        String str;
        if (flags == 0) {
            return "";
        }
        String[] strArr = f24429c;
        if (type != 2 && type != 3) {
            if (type != 4 && type != 6) {
                if (type != 7 && type != 8) {
                    String[] strArr2 = f24428b;
                    if (flags < strArr2.length) {
                        str = strArr2[flags];
                        Intrinsics.checkNotNull(str);
                    } else {
                        str = strArr[flags];
                    }
                    String str2 = str;
                    if (type == 5 && (flags & 4) != 0) {
                        return ro2.replace$default(str2, "HEADERS", "PUSH_PROMISE", false, 4, (Object) null);
                    }
                    if (type == 0 && (flags & 32) != 0) {
                        return ro2.replace$default(str2, "PRIORITY", "COMPRESSED", false, 4, (Object) null);
                    }
                    return str2;
                }
            } else {
                if (flags == 1) {
                    return "ACK";
                }
                return strArr[flags];
            }
        }
        return strArr[flags];
    }

    @NotNull
    public final String formattedType$okhttp(int type) {
        String[] strArr = f24427a;
        if (type < strArr.length) {
            return strArr[type];
        }
        return _UtilJvmKt.format("0x%02x", Integer.valueOf(type));
    }

    @NotNull
    public final String frameLog(boolean inbound, int streamId, int length, int type, int flags) {
        String str;
        String formattedType$okhttp = formattedType$okhttp(type);
        String formatFlags = formatFlags(type, flags);
        if (inbound) {
            str = "<<";
        } else {
            str = ">>";
        }
        return _UtilJvmKt.format("%s 0x%08x %5d %-13s %s", str, Integer.valueOf(streamId), Integer.valueOf(length), formattedType$okhttp, formatFlags);
    }

    @NotNull
    public final String frameLogWindowUpdate(boolean inbound, int streamId, int length, long windowSizeIncrement) {
        String str;
        String formattedType$okhttp = formattedType$okhttp(8);
        if (inbound) {
            str = "<<";
        } else {
            str = ">>";
        }
        return _UtilJvmKt.format("%s 0x%08x %5d %-13s %d", str, Integer.valueOf(streamId), Integer.valueOf(length), formattedType$okhttp, Long.valueOf(windowSizeIncrement));
    }
}
