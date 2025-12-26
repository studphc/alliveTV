package okhttp3.internal;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ha0;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0000\u001a\f\u0010\t\u001a\u00020\n*\u00020\u0001H\u0000\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0001H\u0000\u001aG\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f*\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u000e0\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020\u00130\u0011H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\u0016\u0010\u0015\u001a\u00020\u0001*\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0016\u0010\u0015\u001a\u00020\u0001*\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, m5569d2 = {"commonAsResponseBody", "Lokhttp3/ResponseBody;", "Lokio/BufferedSource;", "contentType", "Lokhttp3/MediaType;", "contentLength", "", "commonByteString", "Lokio/ByteString;", "commonBytes", "", "commonClose", "", "commonConsumeSource", ExifInterface.GPS_DIRECTION_TRUE, "", "consumer", "Lkotlin/Function1;", "sizeMapper", "", "(Lokhttp3/ResponseBody;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "commonToResponseBody", "okhttp"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class _ResponseBodyCommonKt {
    @NotNull
    public static final ResponseBody commonAsResponseBody(@NotNull final BufferedSource bufferedSource, @Nullable final MediaType mediaType, final long j) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        return new ResponseBody() { // from class: okhttp3.internal._ResponseBodyCommonKt$commonAsResponseBody$1
            @Override // okhttp3.ResponseBody
            /* renamed from: contentLength, reason: from getter */
            public long getF24154c() {
                return j;
            }

            @Override // okhttp3.ResponseBody
            @Nullable
            /* renamed from: contentType, reason: from getter */
            public MediaType getF24153b() {
                return MediaType.this;
            }

            @Override // okhttp3.ResponseBody
            @NotNull
            /* renamed from: source, reason: from getter */
            public BufferedSource getF24155d() {
                return bufferedSource;
            }
        };
    }

    @NotNull
    public static final ByteString commonByteString(@NotNull ResponseBody responseBody) {
        ByteString byteString;
        Intrinsics.checkNotNullParameter(responseBody, "<this>");
        long f24154c = responseBody.getF24154c();
        if (f24154c <= 2147483647L) {
            BufferedSource f24155d = responseBody.getF24155d();
            Throwable th = null;
            try {
                byteString = f24155d.readByteString();
            } catch (Throwable th2) {
                byteString = null;
                th = th2;
            }
            if (f24155d != null) {
                try {
                    f24155d.close();
                } catch (Throwable th3) {
                    if (th == null) {
                        th = th3;
                    } else {
                        ha0.addSuppressed(th, th3);
                    }
                }
            }
            if (th == null) {
                Intrinsics.checkNotNull(byteString);
                int size = byteString.size();
                if (f24154c != -1 && f24154c != size) {
                    throw new IOException("Content-Length (" + f24154c + ") and stream length (" + size + ") disagree");
                }
                return byteString;
            }
            throw th;
        }
        throw new IOException(ye0.m8294n(f24154c, "Cannot buffer entire body for content length: "));
    }

    @NotNull
    public static final byte[] commonBytes(@NotNull ResponseBody responseBody) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(responseBody, "<this>");
        long f24154c = responseBody.getF24154c();
        if (f24154c <= 2147483647L) {
            BufferedSource f24155d = responseBody.getF24155d();
            Throwable th = null;
            try {
                bArr = f24155d.readByteArray();
            } catch (Throwable th2) {
                bArr = null;
                th = th2;
            }
            if (f24155d != null) {
                try {
                    f24155d.close();
                } catch (Throwable th3) {
                    if (th == null) {
                        th = th3;
                    } else {
                        ha0.addSuppressed(th, th3);
                    }
                }
            }
            if (th == null) {
                Intrinsics.checkNotNull(bArr);
                int length = bArr.length;
                if (f24154c != -1 && f24154c != length) {
                    throw new IOException("Content-Length (" + f24154c + ") and stream length (" + length + ") disagree");
                }
                return bArr;
            }
            throw th;
        }
        throw new IOException(ye0.m8294n(f24154c, "Cannot buffer entire body for content length: "));
    }

    public static final void commonClose(@NotNull ResponseBody responseBody) {
        Intrinsics.checkNotNullParameter(responseBody, "<this>");
        _UtilCommonKt.closeQuietly(responseBody.getF24155d());
    }

    @NotNull
    public static final <T> T commonConsumeSource(@NotNull ResponseBody responseBody, @NotNull Function1<? super BufferedSource, ? extends T> consumer, @NotNull Function1<? super T, Integer> sizeMapper) {
        T t;
        Intrinsics.checkNotNullParameter(responseBody, "<this>");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(sizeMapper, "sizeMapper");
        long f24154c = responseBody.getF24154c();
        if (f24154c <= 2147483647L) {
            BufferedSource f24155d = responseBody.getF24155d();
            Throwable th = null;
            try {
                t = consumer.invoke(f24155d);
            } catch (Throwable th2) {
                th = th2;
                t = (Object) null;
            }
            if (f24155d != null) {
                try {
                    f24155d.close();
                } catch (Throwable th3) {
                    if (th == null) {
                        th = th3;
                    } else {
                        ha0.addSuppressed(th, th3);
                    }
                }
            }
            if (th == null) {
                Intrinsics.checkNotNull(t);
                int intValue = sizeMapper.invoke(t).intValue();
                if (f24154c == -1 || f24154c == intValue) {
                    return t;
                }
                throw new IOException("Content-Length (" + f24154c + ") and stream length (" + intValue + ") disagree");
            }
            throw th;
        }
        throw new IOException(ye0.m8294n(f24154c, "Cannot buffer entire body for content length: "));
    }

    @NotNull
    public static final ResponseBody commonToResponseBody(@NotNull byte[] bArr, @Nullable MediaType mediaType) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ResponseBody.INSTANCE.create(new Buffer().write(bArr), mediaType, bArr.length);
    }

    @NotNull
    public static final ResponseBody commonToResponseBody(@NotNull ByteString byteString, @Nullable MediaType mediaType) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return ResponseBody.INSTANCE.create(new Buffer().write(byteString), mediaType, byteString.size());
    }
}
