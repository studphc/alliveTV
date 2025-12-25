package okhttp3.internal.ws;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ye0;

@Metadata(m5568d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0015R\u0014\u0010\u001d\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0014\u0010\u001f\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\u0014\u0010 \u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b \u0010\u0015R\u0014\u0010!\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b!\u0010\u0015R\u0014\u0010\"\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\"\u0010\u0015R\u0014\u0010$\u001a\u00020#8\u0000X\u0080T¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020#8\u0000X\u0080T¢\u0006\u0006\n\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b'\u0010\u0015R\u0014\u0010(\u001a\u00020#8\u0000X\u0080T¢\u0006\u0006\n\u0004\b(\u0010%R\u0014\u0010)\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b)\u0010\u0015R\u0014\u0010*\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b*\u0010\u0015R\u0014\u0010+\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b+\u0010\u0015¨\u0006,"}, m5569d2 = {"Lokhttp3/internal/ws/WebSocketProtocol;", "", "Lokio/Buffer$UnsafeCursor;", "cursor", "", "key", "", "toggleMask", "(Lokio/Buffer$UnsafeCursor;[B)V", "", "code", "", "closeCodeExceptionMessage", "(I)Ljava/lang/String;", "validateCloseCode", "(I)V", "acceptHeader", "(Ljava/lang/String;)Ljava/lang/String;", "ACCEPT_MAGIC", "Ljava/lang/String;", "B0_FLAG_FIN", "I", "B0_FLAG_RSV1", "B0_FLAG_RSV2", "B0_FLAG_RSV3", "B0_MASK_OPCODE", "OPCODE_FLAG_CONTROL", "B1_FLAG_MASK", "B1_MASK_LENGTH", "OPCODE_CONTINUATION", "OPCODE_TEXT", "OPCODE_BINARY", "OPCODE_CONTROL_CLOSE", "OPCODE_CONTROL_PING", "OPCODE_CONTROL_PONG", "", "PAYLOAD_BYTE_MAX", "J", "CLOSE_MESSAGE_MAX", "PAYLOAD_SHORT", "PAYLOAD_SHORT_MAX", "PAYLOAD_LONG", "CLOSE_CLIENT_GOING_AWAY", "CLOSE_NO_STATUS_CODE", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class WebSocketProtocol {

    @NotNull
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;

    @NotNull
    public static final WebSocketProtocol INSTANCE = new Object();
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    @NotNull
    public final String acceptHeader(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return ByteString.INSTANCE.encodeUtf8(key + ACCEPT_MAGIC).sha1().base64();
    }

    @Nullable
    public final String closeCodeExceptionMessage(int code) {
        if (code >= 1000 && code < 5000) {
            if ((1004 <= code && code < 1007) || (1015 <= code && code < 3000)) {
                return ye0.m8292l(code, "Code ", " is reserved and may not be used.");
            }
            return null;
        }
        return ye0.m8291k(code, "Code must be in range [1000,5000): ");
    }

    public final void toggleMask(@NotNull Buffer.UnsafeCursor cursor, @NotNull byte[] key) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Intrinsics.checkNotNullParameter(key, "key");
        int length = key.length;
        int i = 0;
        do {
            byte[] bArr = cursor.data;
            int i2 = cursor.start;
            int i3 = cursor.end;
            if (bArr != null) {
                while (i2 < i3) {
                    int i4 = i % length;
                    bArr[i2] = (byte) (bArr[i2] ^ key[i4]);
                    i2++;
                    i = i4 + 1;
                }
            }
        } while (cursor.next() != -1);
    }

    public final void validateCloseCode(int code) {
        String closeCodeExceptionMessage = closeCodeExceptionMessage(code);
        if (closeCodeExceptionMessage == null) {
            return;
        }
        Intrinsics.checkNotNull(closeCodeExceptionMessage);
        throw new IllegalArgumentException(closeCodeExceptionMessage.toString());
    }
}
