package okhttp3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hisona.allive.HttpRequest;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Internal;
import okhttp3.internal._RequestBodyCommonKt;
import okio.BufferedSink;
import okio.ByteString;
import okio.FileSystem;
import okio.GzipSink;
import okio.Okio;
import okio.Path;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000f"}, m5569d2 = {"Lokhttp3/RequestBody;", "", "()V", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "isDuplex", "", "isOneShot", "writeTo", "", "sink", "Lokio/BufferedSink;", "Companion", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public abstract class RequestBody {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5568d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001J\u001f\u0010\b\u001a\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u0005*\u00020\t2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\nJ\u001f\u0010\b\u001a\u00020\u0005*\u00020\u000b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\fJ3\u0010\b\u001a\u00020\u0005*\u00020\r2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0006\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u0005*\u00020\u00122\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0013J'\u0010\u0014\u001a\u00020\u0005*\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0018J!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u001aJ!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0006\u0010\u001bJ5\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0006\u0010\u001cJ!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001d\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0006\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u0005*\u00020\u0005H\u0007¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, m5569d2 = {"Lokhttp3/RequestBody$Companion;", "", "", "Lokhttp3/MediaType;", "contentType", "Lokhttp3/RequestBody;", "create", "(Ljava/lang/String;Lokhttp3/MediaType;)Lokhttp3/RequestBody;", "toRequestBody", "Lokio/ByteString;", "(Lokio/ByteString;Lokhttp3/MediaType;)Lokhttp3/RequestBody;", "Ljava/io/FileDescriptor;", "(Ljava/io/FileDescriptor;Lokhttp3/MediaType;)Lokhttp3/RequestBody;", "", "", TypedValues.CycleType.S_WAVE_OFFSET, "byteCount", "([BLokhttp3/MediaType;II)Lokhttp3/RequestBody;", "Ljava/io/File;", "(Ljava/io/File;Lokhttp3/MediaType;)Lokhttp3/RequestBody;", "asRequestBody", "Lokio/Path;", "Lokio/FileSystem;", "fileSystem", "(Lokio/Path;Lokio/FileSystem;Lokhttp3/MediaType;)Lokhttp3/RequestBody;", FirebaseAnalytics.Param.CONTENT, "(Lokhttp3/MediaType;Ljava/lang/String;)Lokhttp3/RequestBody;", "(Lokhttp3/MediaType;Lokio/ByteString;)Lokhttp3/RequestBody;", "(Lokhttp3/MediaType;[BII)Lokhttp3/RequestBody;", "file", "(Lokhttp3/MediaType;Ljava/io/File;)Lokhttp3/RequestBody;", HttpRequest.ENCODING_GZIP, "(Lokhttp3/RequestBody;)Lokhttp3/RequestBody;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, String str, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        @JvmStatic
        @NotNull
        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmOverloads
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create$default(this, mediaType, content, 0, 0, 12, (Object) null);
        }

        @JvmStatic
        @NotNull
        public final RequestBody gzip(@NotNull final RequestBody requestBody) {
            Intrinsics.checkNotNullParameter(requestBody, "<this>");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$gzip$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return -1L;
                }

                @Override // okhttp3.RequestBody
                @Nullable
                /* renamed from: contentType */
                public MediaType getF24095a() {
                    return RequestBody.this.getF24095a();
                }

                @Override // okhttp3.RequestBody
                public boolean isOneShot() {
                    return RequestBody.this.isOneShot();
                }

                @Override // okhttp3.RequestBody
                public void writeTo(@NotNull BufferedSink sink) {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    BufferedSink buffer = Okio.buffer(new GzipSink(sink));
                    RequestBody.this.writeTo(buffer);
                    buffer.close();
                }
            };
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        @JvmStatic
        @NotNull
        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmOverloads
        public final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] content, int i) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create$default(this, mediaType, content, i, 0, 8, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, FileDescriptor fileDescriptor, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(fileDescriptor, mediaType);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        @JvmOverloads
        public final RequestBody create(@NotNull byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            return create$default(this, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, File file, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        @JvmOverloads
        public final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            return create$default(this, bArr, mediaType, 0, 0, 6, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, Path path, FileSystem fileSystem, MediaType mediaType, int i, Object obj) {
            if ((i & 2) != 0) {
                mediaType = null;
            }
            return companion.create(path, fileSystem, mediaType);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        @JvmOverloads
        public final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType, int i) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            return create$default(this, bArr, mediaType, i, 0, 4, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return companion.create(bArr, mediaType, i, i2);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final RequestBody create(@NotNull String str, @Nullable MediaType mediaType) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Pair<Charset, MediaType> chooseCharset = Internal.chooseCharset(mediaType);
            Charset component1 = chooseCharset.component1();
            MediaType component2 = chooseCharset.component2();
            byte[] bytes = str.getBytes(component1);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return create(bytes, component2, 0, bytes.length);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                i2 = bArr.length;
            }
            return companion.create(mediaType, bArr, i, i2);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final RequestBody create(@NotNull ByteString byteString, @Nullable MediaType mediaType) {
            Intrinsics.checkNotNullParameter(byteString, "<this>");
            return _RequestBodyCommonKt.commonToRequestBody(byteString, mediaType);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final RequestBody create(@NotNull final FileDescriptor fileDescriptor, @Nullable final MediaType mediaType) {
            Intrinsics.checkNotNullParameter(fileDescriptor, "<this>");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$1
                @Override // okhttp3.RequestBody
                @Nullable
                /* renamed from: contentType, reason: from getter */
                public MediaType getF24095a() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public boolean isOneShot() {
                    return true;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(@NotNull BufferedSink sink) {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    FileInputStream fileInputStream = new FileInputStream(fileDescriptor);
                    try {
                        sink.getBuffer().writeAll(Okio.source(fileInputStream));
                        CloseableKt.closeFinally(fileInputStream, null);
                    } finally {
                    }
                }
            };
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        @JvmOverloads
        public final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType, int i, int i2) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            return _RequestBodyCommonKt.commonToRequestBody(bArr, mediaType, i, i2);
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final RequestBody create(@NotNull final File file, @Nullable final MediaType mediaType) {
            Intrinsics.checkNotNullParameter(file, "<this>");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return file.length();
                }

                @Override // okhttp3.RequestBody
                @Nullable
                /* renamed from: contentType, reason: from getter */
                public MediaType getF24095a() {
                    return MediaType.this;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(@NotNull BufferedSink sink) {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    Source source = Okio.source(file);
                    try {
                        sink.writeAll(source);
                        CloseableKt.closeFinally(source, null);
                    } finally {
                    }
                }
            };
        }

        @JvmStatic
        @JvmName(name = "create")
        @NotNull
        public final RequestBody create(@NotNull final Path path, @NotNull final FileSystem fileSystem, @Nullable final MediaType mediaType) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$2
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    Long size = fileSystem.metadata(path).getSize();
                    if (size != null) {
                        return size.longValue();
                    }
                    return -1L;
                }

                @Override // okhttp3.RequestBody
                @Nullable
                /* renamed from: contentType, reason: from getter */
                public MediaType getF24095a() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(@NotNull BufferedSink sink) {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    Source source = fileSystem.source(path);
                    try {
                        sink.writeAll(source);
                        CloseableKt.closeFinally(source, null);
                    } finally {
                    }
                }
            };
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        @NotNull
        public final RequestBody create(@Nullable MediaType contentType, @NotNull String r3) {
            Intrinsics.checkNotNullParameter(r3, "content");
            return create(r3, contentType);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmStatic
        @NotNull
        public final RequestBody create(@Nullable MediaType contentType, @NotNull ByteString r3) {
            Intrinsics.checkNotNullParameter(r3, "content");
            return create(r3, contentType);
        }

        @JvmStatic
        @NotNull
        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @JvmOverloads
        public final RequestBody create(@Nullable MediaType contentType, @NotNull byte[] r3, int r4, int byteCount) {
            Intrinsics.checkNotNullParameter(r3, "content");
            return create(r3, contentType, r4, byteCount);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @ReplaceWith(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
        @JvmStatic
        @NotNull
        public final RequestBody create(@Nullable MediaType contentType, @NotNull File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return create(file, contentType);
        }
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    public static final RequestBody create(@NotNull File file, @Nullable MediaType mediaType) {
        return INSTANCE.create(file, mediaType);
    }

    @JvmStatic
    @NotNull
    public static final RequestBody gzip(@NotNull RequestBody requestBody) {
        return INSTANCE.gzip(requestBody);
    }

    public long contentLength() {
        return _RequestBodyCommonKt.commonContentLength(this);
    }

    @Nullable
    /* renamed from: contentType */
    public abstract MediaType getF24095a();

    public boolean isDuplex() {
        return _RequestBodyCommonKt.commonIsDuplex(this);
    }

    public boolean isOneShot() {
        return _RequestBodyCommonKt.commonIsOneShot(this);
    }

    public abstract void writeTo(@NotNull BufferedSink sink);

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    public static final RequestBody create(@NotNull FileDescriptor fileDescriptor, @Nullable MediaType mediaType) {
        return INSTANCE.create(fileDescriptor, mediaType);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    public static final RequestBody create(@NotNull String str, @Nullable MediaType mediaType) {
        return INSTANCE.create(str, mediaType);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @ReplaceWith(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
    @JvmStatic
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull File file) {
        return INSTANCE.create(mediaType, file);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull String str) {
        return INSTANCE.create(mediaType, str);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    @NotNull
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull ByteString byteString) {
        return INSTANCE.create(mediaType, byteString);
    }

    @JvmStatic
    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmOverloads
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] bArr) {
        return INSTANCE.create(mediaType, bArr);
    }

    @JvmStatic
    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmOverloads
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] bArr, int i) {
        return INSTANCE.create(mediaType, bArr, i);
    }

    @JvmStatic
    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmOverloads
    public static final RequestBody create(@Nullable MediaType mediaType, @NotNull byte[] bArr, int i, int i2) {
        return INSTANCE.create(mediaType, bArr, i, i2);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    public static final RequestBody create(@NotNull ByteString byteString, @Nullable MediaType mediaType) {
        return INSTANCE.create(byteString, mediaType);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    public static final RequestBody create(@NotNull Path path, @NotNull FileSystem fileSystem, @Nullable MediaType mediaType) {
        return INSTANCE.create(path, fileSystem, mediaType);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] bArr) {
        return INSTANCE.create(bArr);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType) {
        return INSTANCE.create(bArr, mediaType);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType, int i) {
        return INSTANCE.create(bArr, mediaType, i);
    }

    @JvmStatic
    @JvmName(name = "create")
    @NotNull
    @JvmOverloads
    public static final RequestBody create(@NotNull byte[] bArr, @Nullable MediaType mediaType, int i, int i2) {
        return INSTANCE.create(bArr, mediaType, i, i2);
    }
}
