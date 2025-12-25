package okhttp3.internal.http2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.upstream.DataSchemeDataSource;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hisona.allive.HttpRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilCommonKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0014\u0015J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR#\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, m5569d2 = {"Lokhttp3/internal/http2/Hpack;", "", "Lokio/ByteString;", AppMeasurementSdk.ConditionalUserProperty.NAME, "checkLowercase", "(Lokio/ByteString;)Lokio/ByteString;", "", "Lokhttp3/internal/http2/Header;", "a", "[Lokhttp3/internal/http2/Header;", "getSTATIC_HEADER_TABLE", "()[Lokhttp3/internal/http2/Header;", "STATIC_HEADER_TABLE", "", "", "b", "Ljava/util/Map;", "getNAME_TO_FIRST_INDEX", "()Ljava/util/Map;", "NAME_TO_FIRST_INDEX", "Reader", "Writer", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Hpack {

    @NotNull
    public static final Hpack INSTANCE = new Object();

    /* renamed from: a, reason: from kotlin metadata */
    public static final Header[] STATIC_HEADER_TABLE;

    /* renamed from: b, reason: from kotlin metadata */
    public static final Map NAME_TO_FIRST_INDEX;

    @Metadata(m5568d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001c¨\u0006\u001e"}, m5569d2 = {"Lokhttp3/internal/http2/Hpack$Reader;", "", "Lokio/Source;", FirebaseAnalytics.Param.SOURCE, "", "headerTableSizeSetting", "maxDynamicTableByteCount", "<init>", "(Lokio/Source;II)V", "", "Lokhttp3/internal/http2/Header;", "getAndResetHeaderList", "()Ljava/util/List;", "()I", "", "readHeaders", "()V", "firstByte", "prefixMask", "readInt", "(II)I", "Lokio/ByteString;", "readByteString", "()Lokio/ByteString;", "", "dynamicTable", "[Lokhttp3/internal/http2/Header;", "headerCount", "I", "dynamicTableByteCount", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Reader {

        /* renamed from: a */
        public final int f24417a;

        /* renamed from: b */
        public int f24418b;

        /* renamed from: c */
        public final ArrayList f24419c;

        /* renamed from: d */
        public final BufferedSource f24420d;

        @JvmField
        @NotNull
        public Header[] dynamicTable;

        @JvmField
        public int dynamicTableByteCount;

        /* renamed from: e */
        public int f24421e;

        @JvmField
        public int headerCount;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public Reader(@NotNull Source source, int i) {
            this(source, i, 0, 4, null);
            Intrinsics.checkNotNullParameter(source, "source");
        }

        /* renamed from: a */
        public final int m6626a(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i2 = this.f24421e;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    Intrinsics.checkNotNull(header);
                    int i4 = header.hpackSize;
                    i -= i4;
                    this.dynamicTableByteCount -= i4;
                    this.headerCount--;
                    i3++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i2 + 1, headerArr, i2 + 1 + i3, this.headerCount);
                this.f24421e += i3;
            }
            return i3;
        }

        /* renamed from: b */
        public final ByteString m6627b(int i) {
            if (i >= 0) {
                Hpack hpack = Hpack.INSTANCE;
                if (i <= hpack.getSTATIC_HEADER_TABLE().length - 1) {
                    return hpack.getSTATIC_HEADER_TABLE()[i].name;
                }
            }
            int length = this.f24421e + 1 + (i - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (length >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (length < headerArr.length) {
                    Header header = headerArr[length];
                    Intrinsics.checkNotNull(header);
                    return header.name;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        /* renamed from: c */
        public final void m6628c(Header header) {
            this.f24419c.add(header);
            int i = header.hpackSize;
            int i2 = this.f24418b;
            if (i > i2) {
                ArraysKt___ArraysJvmKt.fill$default(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
                this.f24421e = this.dynamicTable.length - 1;
                this.headerCount = 0;
                this.dynamicTableByteCount = 0;
                return;
            }
            m6626a((this.dynamicTableByteCount + i) - i2);
            int i3 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i3 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.f24421e = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i4 = this.f24421e;
            this.f24421e = i4 - 1;
            this.dynamicTable[i4] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i;
        }

        @NotNull
        public final List<Header> getAndResetHeaderList() {
            ArrayList arrayList = this.f24419c;
            List<Header> list = CollectionsKt___CollectionsKt.toList(arrayList);
            arrayList.clear();
            return list;
        }

        /* renamed from: maxDynamicTableByteCount, reason: from getter */
        public final int getF24418b() {
            return this.f24418b;
        }

        @NotNull
        public final ByteString readByteString() {
            boolean z;
            BufferedSource bufferedSource = this.f24420d;
            int and = _UtilCommonKt.and(bufferedSource.readByte(), 255);
            if ((and & 128) == 128) {
                z = true;
            } else {
                z = false;
            }
            long readInt = readInt(and, 127);
            if (z) {
                Buffer buffer = new Buffer();
                Huffman.INSTANCE.decode(bufferedSource, readInt, buffer);
                return buffer.readByteString();
            }
            return bufferedSource.readByteString(readInt);
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x00ea, code lost:
        
            throw new java.io.IOException("Invalid dynamic table size update " + r8.f24418b);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void readHeaders() {
            int readInt;
            while (true) {
                BufferedSource bufferedSource = this.f24420d;
                if (!bufferedSource.exhausted()) {
                    int and = _UtilCommonKt.and(bufferedSource.readByte(), 255);
                    if (and != 128) {
                        int i = and & 128;
                        ArrayList arrayList = this.f24419c;
                        if (i == 128) {
                            readInt = readInt(and, 127);
                            int i2 = readInt - 1;
                            if (i2 >= 0) {
                                Hpack hpack = Hpack.INSTANCE;
                                if (i2 <= hpack.getSTATIC_HEADER_TABLE().length - 1) {
                                    arrayList.add(hpack.getSTATIC_HEADER_TABLE()[i2]);
                                }
                            }
                            int length = this.f24421e + 1 + (i2 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
                            if (length < 0) {
                                break;
                            }
                            Header[] headerArr = this.dynamicTable;
                            if (length >= headerArr.length) {
                                break;
                            }
                            Header header = headerArr[length];
                            Intrinsics.checkNotNull(header);
                            arrayList.add(header);
                        } else if (and == 64) {
                            m6628c(new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
                        } else if ((and & 64) == 64) {
                            m6628c(new Header(m6627b(readInt(and, 63) - 1), readByteString()));
                        } else if ((and & 32) == 32) {
                            int readInt2 = readInt(and, 31);
                            this.f24418b = readInt2;
                            if (readInt2 < 0 || readInt2 > this.f24417a) {
                                break;
                            }
                            int i3 = this.dynamicTableByteCount;
                            if (readInt2 < i3) {
                                if (readInt2 == 0) {
                                    ArraysKt___ArraysJvmKt.fill$default(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
                                    this.f24421e = this.dynamicTable.length - 1;
                                    this.headerCount = 0;
                                    this.dynamicTableByteCount = 0;
                                } else {
                                    m6626a(i3 - readInt2);
                                }
                            }
                        } else if (and != 16 && and != 0) {
                            arrayList.add(new Header(m6627b(readInt(and, 15) - 1), readByteString()));
                        } else {
                            arrayList.add(new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
                        }
                    } else {
                        throw new IOException("index == 0");
                    }
                } else {
                    return;
                }
            }
            throw new IOException(ye0.m8291k(readInt, "Header index too large "));
        }

        public final int readInt(int firstByte, int prefixMask) {
            int i = firstByte & prefixMask;
            if (i < prefixMask) {
                return i;
            }
            int i2 = 0;
            while (true) {
                int and = _UtilCommonKt.and(this.f24420d.readByte(), 255);
                if ((and & 128) != 0) {
                    prefixMask += (and & 127) << i2;
                    i2 += 7;
                } else {
                    return prefixMask + (and << i2);
                }
            }
        }

        @JvmOverloads
        public Reader(@NotNull Source source, int i, int i2) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.f24417a = i;
            this.f24418b = i2;
            this.f24419c = new ArrayList();
            this.f24420d = Okio.buffer(source);
            this.dynamicTable = new Header[8];
            this.f24421e = 7;
        }

        public /* synthetic */ Reader(Source source, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(source, i, (i3 & 4) != 0 ? i : i2);
        }
    }

    @Metadata(m5568d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u001e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010\u001bR\u0016\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001b¨\u0006\""}, m5569d2 = {"Lokhttp3/internal/http2/Hpack$Writer;", "", "", "headerTableSizeSetting", "", "useCompression", "Lokio/Buffer;", "out", "<init>", "(IZLokio/Buffer;)V", "", "Lokhttp3/internal/http2/Header;", "headerBlock", "", "writeHeaders", "(Ljava/util/List;)V", "value", "prefixMask", "bits", "writeInt", "(III)V", "Lokio/ByteString;", DataSchemeDataSource.SCHEME_DATA, "writeByteString", "(Lokio/ByteString;)V", "resizeHeaderTable", "(I)V", "I", "maxDynamicTableByteCount", "", "dynamicTable", "[Lokhttp3/internal/http2/Header;", "headerCount", "dynamicTableByteCount", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Writer {

        /* renamed from: a */
        public final boolean f24422a;

        /* renamed from: b */
        public final Buffer f24423b;

        /* renamed from: c */
        public int f24424c;

        /* renamed from: d */
        public boolean f24425d;

        @JvmField
        @NotNull
        public Header[] dynamicTable;

        @JvmField
        public int dynamicTableByteCount;

        /* renamed from: e */
        public int f24426e;

        @JvmField
        public int headerCount;

        @JvmField
        public int headerTableSizeSetting;

        @JvmField
        public int maxDynamicTableByteCount;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public Writer(int i, @NotNull Buffer out) {
            this(i, false, out, 2, null);
            Intrinsics.checkNotNullParameter(out, "out");
        }

        /* renamed from: a */
        public final void m6629a(int i) {
            int i2;
            if (i > 0) {
                int length = this.dynamicTable.length - 1;
                int i3 = 0;
                while (true) {
                    i2 = this.f24426e;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    Intrinsics.checkNotNull(header);
                    i -= header.hpackSize;
                    int i4 = this.dynamicTableByteCount;
                    Header header2 = this.dynamicTable[length];
                    Intrinsics.checkNotNull(header2);
                    this.dynamicTableByteCount = i4 - header2.hpackSize;
                    this.headerCount--;
                    i3++;
                    length--;
                }
                Header[] headerArr = this.dynamicTable;
                int i5 = i2 + 1;
                System.arraycopy(headerArr, i5, headerArr, i5 + i3, this.headerCount);
                Header[] headerArr2 = this.dynamicTable;
                int i6 = this.f24426e + 1;
                Arrays.fill(headerArr2, i6, i6 + i3, (Object) null);
                this.f24426e += i3;
            }
        }

        /* renamed from: b */
        public final void m6630b(Header header) {
            int i = header.hpackSize;
            int i2 = this.maxDynamicTableByteCount;
            if (i > i2) {
                ArraysKt___ArraysJvmKt.fill$default(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
                this.f24426e = this.dynamicTable.length - 1;
                this.headerCount = 0;
                this.dynamicTableByteCount = 0;
                return;
            }
            m6629a((this.dynamicTableByteCount + i) - i2);
            int i3 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i3 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.f24426e = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i4 = this.f24426e;
            this.f24426e = i4 - 1;
            this.dynamicTable[i4] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i;
        }

        public final void resizeHeaderTable(int headerTableSizeSetting) {
            this.headerTableSizeSetting = headerTableSizeSetting;
            int min = Math.min(headerTableSizeSetting, 16384);
            int i = this.maxDynamicTableByteCount;
            if (i == min) {
                return;
            }
            if (min < i) {
                this.f24424c = Math.min(this.f24424c, min);
            }
            this.f24425d = true;
            this.maxDynamicTableByteCount = min;
            int i2 = this.dynamicTableByteCount;
            if (min < i2) {
                if (min == 0) {
                    ArraysKt___ArraysJvmKt.fill$default(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
                    this.f24426e = this.dynamicTable.length - 1;
                    this.headerCount = 0;
                    this.dynamicTableByteCount = 0;
                    return;
                }
                m6629a(i2 - min);
            }
        }

        public final void writeByteString(@NotNull ByteString data) {
            Intrinsics.checkNotNullParameter(data, "data");
            boolean z = this.f24422a;
            Buffer buffer = this.f24423b;
            if (z) {
                Huffman huffman = Huffman.INSTANCE;
                if (huffman.encodedLength(data) < data.size()) {
                    Buffer buffer2 = new Buffer();
                    huffman.encode(data, buffer2);
                    ByteString readByteString = buffer2.readByteString();
                    writeInt(readByteString.size(), 127, 128);
                    buffer.write(readByteString);
                    return;
                }
            }
            writeInt(data.size(), 127, 0);
            buffer.write(data);
        }

        public final void writeHeaders(@NotNull List<Header> headerBlock) {
            int i;
            int i2;
            Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
            if (this.f24425d) {
                int i3 = this.f24424c;
                if (i3 < this.maxDynamicTableByteCount) {
                    writeInt(i3, 31, 32);
                }
                this.f24425d = false;
                this.f24424c = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = headerBlock.size();
            for (int i4 = 0; i4 < size; i4++) {
                Header header = headerBlock.get(i4);
                ByteString asciiLowercase = header.name.toAsciiLowercase();
                ByteString byteString = header.value;
                Hpack hpack = Hpack.INSTANCE;
                Integer num = hpack.getNAME_TO_FIRST_INDEX().get(asciiLowercase);
                if (num != null) {
                    int intValue = num.intValue();
                    i2 = intValue + 1;
                    if (2 <= i2 && i2 < 8) {
                        if (Intrinsics.areEqual(hpack.getSTATIC_HEADER_TABLE()[intValue].value, byteString)) {
                            i = i2;
                        } else if (Intrinsics.areEqual(hpack.getSTATIC_HEADER_TABLE()[i2].value, byteString)) {
                            i = i2;
                            i2 = intValue + 2;
                        }
                    }
                    i = i2;
                    i2 = -1;
                } else {
                    i = -1;
                    i2 = -1;
                }
                if (i2 == -1) {
                    int i5 = this.f24426e + 1;
                    int length = this.dynamicTable.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        Header header2 = this.dynamicTable[i5];
                        Intrinsics.checkNotNull(header2);
                        if (Intrinsics.areEqual(header2.name, asciiLowercase)) {
                            Header header3 = this.dynamicTable[i5];
                            Intrinsics.checkNotNull(header3);
                            if (Intrinsics.areEqual(header3.value, byteString)) {
                                i2 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (i5 - this.f24426e);
                                break;
                            } else if (i == -1) {
                                i = (i5 - this.f24426e) + Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length;
                            }
                        }
                        i5++;
                    }
                }
                if (i2 != -1) {
                    writeInt(i2, 127, 128);
                } else if (i == -1) {
                    this.f24423b.writeByte(64);
                    writeByteString(asciiLowercase);
                    writeByteString(byteString);
                    m6630b(header);
                } else if (asciiLowercase.startsWith(Header.PSEUDO_PREFIX) && !Intrinsics.areEqual(Header.TARGET_AUTHORITY, asciiLowercase)) {
                    writeInt(i, 15, 0);
                    writeByteString(byteString);
                } else {
                    writeInt(i, 63, 64);
                    writeByteString(byteString);
                    m6630b(header);
                }
            }
        }

        public final void writeInt(int value, int prefixMask, int bits) {
            Buffer buffer = this.f24423b;
            if (value < prefixMask) {
                buffer.writeByte(value | bits);
                return;
            }
            buffer.writeByte(bits | prefixMask);
            int i = value - prefixMask;
            while (i >= 128) {
                buffer.writeByte(128 | (i & 127));
                i >>>= 7;
            }
            buffer.writeByte(i);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public Writer(@NotNull Buffer out) {
            this(0, false, out, 3, null);
            Intrinsics.checkNotNullParameter(out, "out");
        }

        @JvmOverloads
        public Writer(int i, boolean z, @NotNull Buffer out) {
            Intrinsics.checkNotNullParameter(out, "out");
            this.headerTableSizeSetting = i;
            this.f24422a = z;
            this.f24423b = out;
            this.f24424c = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i;
            this.dynamicTable = new Header[8];
            this.f24426e = r2.length - 1;
        }

        public /* synthetic */ Writer(int i, boolean z, Buffer buffer, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 4096 : i, (i2 & 2) != 0 ? true : z, buffer);
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [okhttp3.internal.http2.Hpack, java.lang.Object] */
    static {
        Header header = new Header(Header.TARGET_AUTHORITY, "");
        ByteString byteString = Header.TARGET_METHOD;
        Header header2 = new Header(byteString, HttpRequest.METHOD_GET);
        Header header3 = new Header(byteString, HttpRequest.METHOD_POST);
        ByteString byteString2 = Header.TARGET_PATH;
        Header header4 = new Header(byteString2, "/");
        Header header5 = new Header(byteString2, "/index.html");
        ByteString byteString3 = Header.TARGET_SCHEME;
        Header header6 = new Header(byteString3, "http");
        Header header7 = new Header(byteString3, "https");
        ByteString byteString4 = Header.RESPONSE_STATUS;
        Header[] headerArr = {header, header2, header3, header4, header5, header6, header7, new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header(TypedValues.TransitionType.S_FROM, ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header(FirebaseAnalytics.Param.LOCATION, ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        STATIC_HEADER_TABLE = headerArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(headerArr.length);
        int length = headerArr.length;
        for (int i = 0; i < length; i++) {
            if (!linkedHashMap.containsKey(headerArr[i].name)) {
                linkedHashMap.put(headerArr[i].name, Integer.valueOf(i));
            }
        }
        Map unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap(result)");
        NAME_TO_FIRST_INDEX = unmodifiableMap;
    }

    @NotNull
    public final ByteString checkLowercase(@NotNull ByteString name) {
        Intrinsics.checkNotNullParameter(name, "name");
        int size = name.size();
        for (int i = 0; i < size; i++) {
            byte b = (byte) 65;
            byte b2 = (byte) 90;
            byte b3 = name.getByte(i);
            if (b <= b3 && b3 <= b2) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + name.utf8());
            }
        }
        return name;
    }

    @NotNull
    public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    @NotNull
    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }
}
